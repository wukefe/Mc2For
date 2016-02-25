package natlab.backends.Fortran.codegen_simplified;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import natlab.backends.Fortran.codegen_simplified.FortranAST_simplified.StatementSection;
import natlab.backends.Fortran.codegen_simplified.FortranAST_simplified.Subprogram;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRAbstractAssignToListStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRAbstractAssignToVarStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRArrayGetStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRArraySetStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRAssignLiteralStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRCommentStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRForStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRFunction;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRIfStmt;
import natlab.backends.Fortran.codegen_simplified.astCaseHandler.HandleCaseTIRWhileStmt;
import natlab.tame.tir.TIRAbstractAssignToListStmt;
import natlab.tame.tir.TIRAbstractAssignToVarStmt;
import natlab.tame.tir.TIRArrayGetStmt;
import natlab.tame.tir.TIRArraySetStmt;
import natlab.tame.tir.TIRAssignLiteralStmt;
import natlab.tame.tir.TIRCommentStmt;
import natlab.tame.tir.TIRForStmt;
import natlab.tame.tir.TIRFunction;
import natlab.tame.tir.TIRIfStmt;
import natlab.tame.tir.TIRNode;
import natlab.tame.tir.TIRWhileStmt;
import natlab.tame.tir.analysis.TIRAbstractNodeCaseHandler;
import natlab.tame.valueanalysis.ValueAnalysis;
import natlab.tame.valueanalysis.ValueFlowMap;
import natlab.tame.valueanalysis.ValueSet;
import natlab.tame.valueanalysis.aggrvalue.AggrValue;
import natlab.tame.valueanalysis.aggrvalue.CellValue;
import natlab.tame.valueanalysis.basicmatrix.BasicMatrixValue;
import ast.ASTNode;

public class FortranCodeASTGenerator extends TIRAbstractNodeCaseHandler {
	static boolean Debug = false;
	// this currentOutSet is the out set at the end point of the program.
	public ValueFlowMap<AggrValue<BasicMatrixValue>> currentOutSet;
	public int callgraphSize;
	public String entryPointFile;
	// public Set<String> userDefinedFunctions;
	public Set<String> allSubprograms;
	public Subprogram subprogram;
	public StringBuffer buf;
	public StringBuffer buf2;
	public FortranMapping fortranMapping;
	public String functionName;
	public List<String> inArgs;
	public List<String> outRes;
	public boolean isInSubroutine;
	// used to back up input argument.
	public Set<String> inputHasChanged;
	public Set<String> arrayConvert;
	public int ifWhileForBlockNest;
	public StatementSection stmtSecForIfWhileForBlock;
	public int indentNum;
	public String standardIndent;
	/* 
	 * tmpVarAsArrayIndex, 
	 * K: the name of the temporary vector variable, 
	 * V: the range of those variables.
	 */
	public Map<String, ArrayList<String>> tempVectorAsArrayIndex;
	// temporary variables generated during McSAF or Tamer simplification.
	public Set<String> tempVarsBeforeF;
	// temporary variables generated in Fortran code generation.
	public Map<String, BasicMatrixValue> fortranTemporaries;
	// not support nested cell array.
	public Map<String, ArrayList<BasicMatrixValue>> forCellArr;
	public List<String> declaredCell;
	
	/**
	 * private constructor, called by helper method generateFortran.
	 * @param analysis
	 * @param callgraphSize
	 * @param index
	 * @param entryPointFile
	 */
	private FortranCodeASTGenerator(
			ValueAnalysis<AggrValue<BasicMatrixValue>> analysis, 
			int callgraphSize, 
			int index, 
			String entryPointFile, 
			Set<String> userDefinedFunctions) 
	{
		currentOutSet = analysis.getNodeList()
				.get(index).getAnalysis().getCurrentOutSet();
		this.callgraphSize = callgraphSize;
		this.entryPointFile = entryPointFile;
		// this.userDefinedFunctions = userDefinedFunctions;
		allSubprograms = new HashSet<String>();
		fortranMapping = new FortranMapping();
		functionName = "";
		subprogram = new Subprogram();
		inArgs = new ArrayList<String>();
		outRes = new ArrayList<String>();
		isInSubroutine = false;
		inputHasChanged = new HashSet<String>();
		arrayConvert = new HashSet<String>();
		ifWhileForBlockNest = 0;
		stmtSecForIfWhileForBlock = new StatementSection();
		indentNum = 0;
		standardIndent = "   ";
		tempVectorAsArrayIndex = new HashMap<String, ArrayList<String>>();
		tempVarsBeforeF = new HashSet<String>();
		fortranTemporaries = new HashMap<String,BasicMatrixValue>();
		forCellArr = new HashMap<String, ArrayList<BasicMatrixValue>>();
		declaredCell = new ArrayList<String>();
		((TIRNode) analysis.getNodeList()
				.get(index).getFunction().getAst()).tirAnalyze(this);
	}
	
	// ******************************ast node override*************************
	@Override
	@SuppressWarnings("rawtypes")
	public void caseASTNode(ASTNode node) {}
	
	@Override
	public void caseTIRFunction(TIRFunction node) {
		HandleCaseTIRFunction functionStmt = 
				new HandleCaseTIRFunction();
		functionStmt.getFortran(this, node);
	}
	
	@Override
	public void caseTIRCommentStmt(TIRCommentStmt node) {
		HandleCaseTIRCommentStmt commentStmt = 
				new HandleCaseTIRCommentStmt();
		if (ifWhileForBlockNest!=0) 
			stmtSecForIfWhileForBlock.addStatement(
					commentStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(
					commentStmt.getFortran(this, node));
	}
	
	@Override
	public void caseTIRAssignLiteralStmt(TIRAssignLiteralStmt node) {
		/*
		 * insert constant variable replacement check.
		 */
		String targetName = node.getTargetName().getVarName();
		if (hasSingleton(targetName) 
				&& getMatrixValue(targetName).hasConstant() 
				&& !outRes.contains(targetName) 
				&& !inArgs.contains(targetName) 
				&& node.getTargetName().tmpVar) {
			tempVarsBeforeF.add(targetName);
			if (Debug) System.out.println(targetName 
					+ " has a constant value and safe to be replaced.");
		}
		else {
			HandleCaseTIRAssignLiteralStmt assignLiteralStmt = 
					new HandleCaseTIRAssignLiteralStmt();
			if (ifWhileForBlockNest != 0) 
				stmtSecForIfWhileForBlock.addStatement(
						assignLiteralStmt.getFortran(this, node));
			else 
				subprogram.getStatementSection().addStatement(
						assignLiteralStmt.getFortran(this, node));		
		}
	}
	
	@Override
	public void caseTIRAbstractAssignToVarStmt(TIRAbstractAssignToVarStmt node) {
		/*
		 * insert constant variable replacement check.
		 */
		String targetName = node.getTargetName().getVarName();
		if (!isCell(targetName) && hasSingleton(targetName) 
				&& getMatrixValue(targetName).hasConstant() 
				&& !this.outRes.contains(targetName) 
				&& node.getTargetName().tmpVar) {
			tempVarsBeforeF.add(targetName);
			if (Debug) System.out.println(targetName 
					+ " has a constant value and safe to be replaced.");
		}
		else {
			HandleCaseTIRAbstractAssignToVarStmt abstractAssignToVarStmt = 
					new HandleCaseTIRAbstractAssignToVarStmt();
			if (ifWhileForBlockNest != 0) 
				stmtSecForIfWhileForBlock.addStatement(
						abstractAssignToVarStmt.getFortran(this, node));
			else 
				subprogram.getStatementSection().addStatement(
						abstractAssignToVarStmt.getFortran(this, node));
		}
	}

	@Override
	public void caseTIRAbstractAssignToListStmt(TIRAbstractAssignToListStmt node) {
		/*
		 * insert constant variable replacement check.
		 * p.s. need to check whether the expression is io expression,
		 * because io expression doesn't have target variable
		 *
		 * one more problem, for this case, the lhs is a list of variable.
		 * And because node.getTargetName().getVarName() can only return 
		 * the first variable, we need use node.getTargets().asNameList().
		 */
		if (HandleCaseTIRAbstractAssignToListStmt
				.getRHSCaseNumber(this, node) != 6) {
			String targetName = node.getTargetName().getVarName();
			if(!isCell(targetName) && hasSingleton(targetName) 
					&& getMatrixValue(targetName).hasConstant() 
					&& !outRes.contains(targetName) 
					&& node.getTargetName().tmpVar) {
				tempVarsBeforeF.add(targetName);
				if (Debug) System.out.println(targetName 
						+ " has a constant value and safe to be replaced.");
			}
			else {
				HandleCaseTIRAbstractAssignToListStmt abstractAssignToListStmt = 
						new HandleCaseTIRAbstractAssignToListStmt();
				if (ifWhileForBlockNest != 0) 
					stmtSecForIfWhileForBlock.addStatement(
							abstractAssignToListStmt.getFortran(this, node));
				else 
					subprogram.getStatementSection().addStatement(
						abstractAssignToListStmt.getFortran(this, node));
			}
		}
		else {
			HandleCaseTIRAbstractAssignToListStmt abstractAssignToListStmt = 
					new HandleCaseTIRAbstractAssignToListStmt();
			if (ifWhileForBlockNest != 0) 
				stmtSecForIfWhileForBlock.addStatement(
						abstractAssignToListStmt.getFortran(this, node));
			else 
				subprogram.getStatementSection().addStatement(
					abstractAssignToListStmt.getFortran(this, node));
		}
	}
	
	@Override
	public void caseTIRIfStmt(TIRIfStmt node) {
		HandleCaseTIRIfStmt ifStmt = new HandleCaseTIRIfStmt();
		if (ifWhileForBlockNest != 0) 
			stmtSecForIfWhileForBlock.addStatement(
					ifStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(
					ifStmt.getFortran(this, node));
	}
	
	@Override
	public void caseTIRWhileStmt(TIRWhileStmt node) {
		HandleCaseTIRWhileStmt whileStmt = new HandleCaseTIRWhileStmt();
		if (ifWhileForBlockNest != 0) 
			stmtSecForIfWhileForBlock.addStatement(
					whileStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(
					whileStmt.getFortran(this, node));
	}
	
	@Override
	public void caseTIRForStmt(TIRForStmt node) {
		HandleCaseTIRForStmt forStmt = new HandleCaseTIRForStmt();
		if(ifWhileForBlockNest != 0) 
			stmtSecForIfWhileForBlock.addStatement(
					forStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(
					forStmt.getFortran(this, node));
	}
	
	@Override
	public void caseTIRArrayGetStmt(TIRArrayGetStmt node) {
		HandleCaseTIRArrayGetStmt arrGetStmt = new HandleCaseTIRArrayGetStmt();
		if(ifWhileForBlockNest != 0) 
			stmtSecForIfWhileForBlock.addStatement(
					arrGetStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(
					arrGetStmt.getFortran(this, node));
	}
	
	@Override
	public void caseTIRArraySetStmt(TIRArraySetStmt node) {
		HandleCaseTIRArraySetStmt arrSetStmt = new HandleCaseTIRArraySetStmt();
		if (ifWhileForBlockNest != 0) 
			stmtSecForIfWhileForBlock.addStatement(
					arrSetStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(
					arrSetStmt.getFortran(this, node));
	}
	
	// ******************************helper methods****************************
	public static Subprogram generateFortran(
			ValueAnalysis<AggrValue<BasicMatrixValue>> analysis, 
			int callgraphSize, 
			int index, 
			String entryPointFile, 
			Set<String> userDefinedFunctions) {
		return new FortranCodeASTGenerator(
				analysis, 
				callgraphSize, 
				index, 
				entryPointFile, 
				userDefinedFunctions).subprogram;
	}

	public void iterateStatements(ast.List<ast.Stmt> stmts) {
		for (ast.Stmt stmt : stmts) {
			((TIRNode)stmt).tirAnalyze(this);
		}
	}
	
	public boolean hasArrayAsInput() {
		boolean result = false;
		for (String inArg : inArgs) {
			if (!getMatrixValue(inArg).getShape().isScalar()) 
				result = true;
		}
		return result;
	}
	
	public ValueFlowMap<AggrValue<BasicMatrixValue>> getCurrentOutSet() {
		return currentOutSet;
	}
	
	public BasicMatrixValue getMatrixValue(String variable) {
		if (variable.indexOf("_copy") != -1) {
			int index = variable.indexOf("_copy");
			String originalVar = variable.substring(0, index);
			return (BasicMatrixValue) currentOutSet.get(originalVar).getSingleton();
		}
		else 
			return (BasicMatrixValue) currentOutSet.get(variable).getSingleton();
	}
	
	public boolean isCell(String variable) {
		if (currentOutSet.get(variable).getSingleton() instanceof CellValue) {
			return true;
		}
		else return false;
	}
	
	public boolean hasSingleton(String variable) {
		if (currentOutSet.get(variable).getSingleton() == null) 
			return false;
		else return true;
	}
	
	@SuppressWarnings("rawtypes")
	public ValueSet getValueSet(String variable) {
		return currentOutSet.get(variable);
	}
}
