package natlab.backends.Fortran.codegen_readable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import natlab.backends.Fortran.codegen_readable.FortranAST_readable.ExtraInlined;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.FAssignStmt;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.FBreakStmt;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.FCommentStmt;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.FSubroutines;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.RuntimeAllocate;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.StatementSection;
import natlab.backends.Fortran.codegen_readable.FortranAST_readable.Subprogram;
import natlab.backends.Fortran.codegen_readable.astCaseHandler.HandleCaseForStmt;
import natlab.backends.Fortran.codegen_readable.astCaseHandler.HandleCaseFunction;
import natlab.backends.Fortran.codegen_readable.astCaseHandler.HandleCaseIfStmt;
import natlab.backends.Fortran.codegen_readable.astCaseHandler.HandleCaseWhileStmt;
import natlab.tame.classes.reference.PrimitiveClassReference;
import natlab.tame.tamerplus.analysis.AnalysisEngine;
import natlab.tame.tir.TIRCommentStmt;
import natlab.tame.valueanalysis.ValueFlowMap;
import natlab.tame.valueanalysis.aggrvalue.AggrValue;
import natlab.tame.valueanalysis.aggrvalue.CellValue;
import natlab.tame.valueanalysis.basicmatrix.BasicMatrixValue;
import natlab.tame.valueanalysis.components.isComplex.isComplexInfoFactory;
import natlab.tame.valueanalysis.components.shape.Shape;
import natlab.tame.valueanalysis.components.shape.ShapeFactory;
import nodecases.AbstractNodeCaseHandler;
import ast.ASTNode;
import ast.AssignStmt;
import ast.BreakStmt;
import ast.ColonExpr;
import ast.EmptyStmt;
import ast.ForStmt;
import ast.Function;
import ast.IfStmt;
import ast.IntLiteralExpr;
import ast.List;
import ast.LiteralExpr;
import ast.MatrixExpr;
import ast.Name;
import ast.NameExpr;
import ast.ParameterizedExpr;
import ast.RangeExpr;
import ast.Row;
import ast.StringLiteralExpr;
import ast.WhileStmt;

public class FortranCodeASTGenerator extends AbstractNodeCaseHandler {
	/*
	 * currently, the access modifier is really not professional, but 
	 * instead of writing a lot of get method, I leave it like this.
	 * TODO split this huge class... 
	 */
	static boolean Debug = false;
	static int tempCounter = 0;
	public int passCounter;
	// this currentOutSet is the out set at the end point of the program.
	private ValueFlowMap<AggrValue<BasicMatrixValue>> currentOutSet;
	public Set<String> remainingVars;
	public String entryPointFile;
	public Set<String> userDefinedFunctions;
	private AnalysisEngine analysisEngine;
	private boolean nocheck;
	public Set<String> allSubprograms;
	public Subprogram subprogram;
	public StringBuffer sb;
	public StringBuffer sbForRuntimeInline;
	public FortranMapping fortranMapping;
	public String functionName;
	public ArrayList<String> inArgs;
	public ArrayList<String> outRes;
	public boolean isInSubroutine;
	// used to back up input argument.
	public Set<String> inputHasChanged;
	public int ifWhileForBlockNest;
	public StatementSection stmtSecForIfWhileForBlock;
	public int indentNum;
	public String standardIndent;
	// ParameterizedExpr can be array index or function call, array index can be nested.
	private int insideArray;
	private boolean leftOfAssign;
	private boolean rightOfAssign;
	public boolean zerosAlloc;
	public boolean colonAlloc;
	public boolean horzcat;
	public boolean vertcat;
	private boolean rhsArrayAssign;
	private String overloadedRelational;
	private String overloadedRelationalFlag; // l means lhs is array, r means rhs is array.
	private boolean needLinearTransform;
	public Set<String> allocatedArrays;
	public boolean forLoopTransform;
	// temporary variables generated in Fortran code generation.
	public Map<String, BasicMatrixValue> fotranTemporaries;
	public boolean mustBeInt;
	public Set<String> forceToInt;
	public Set<String> inputsUsed;
	public Set<String> backupTempArrays;
	// not support nested cell array.
	public Map<String, ArrayList<BasicMatrixValue>> forCellArr;
	public ArrayList<String> declaredCell;
	
	/**
	 * private constructor, called by helper method generateFortran.
	 * @param fNode
	 * @param currentOutSet
	 * @param remainingVars
	 */
	private FortranCodeASTGenerator(
			Function fNode, 
			ValueFlowMap<AggrValue<BasicMatrixValue>> currentOutSet, 
			Set<String> remainingVars, 
			String entryPointFile, 
			Set<String> userDefinedFunctions, 
			AnalysisEngine analysisEngine, 
			boolean nocheck) 
	{
		passCounter = 0;
		this.currentOutSet = currentOutSet;
		this.remainingVars = remainingVars;
		this.entryPointFile = entryPointFile;
		this.nocheck = nocheck;
		this.userDefinedFunctions = userDefinedFunctions;
		this.analysisEngine = analysisEngine;
		allSubprograms = new HashSet<String>();
		subprogram = new Subprogram();
		sb = new StringBuffer();
		sbForRuntimeInline = new StringBuffer();
		fortranMapping = new FortranMapping();
		functionName = "";
		inArgs = new ArrayList<String>();
		outRes = new ArrayList<String>();
		isInSubroutine = false;
		inputHasChanged = new HashSet<String>();
		ifWhileForBlockNest = 0;
		stmtSecForIfWhileForBlock = new StatementSection();
		indentNum = 0;
		standardIndent = "   ";
		insideArray = 0;
		// isArray = false;
		leftOfAssign = false;
		rightOfAssign = false;
		zerosAlloc = false;
		colonAlloc = false;
		horzcat = false;
		vertcat = false;
		rhsArrayAssign = false;
		overloadedRelational = "";
		overloadedRelationalFlag = "";
		needLinearTransform = false;
		allocatedArrays = new HashSet<String>();
		forLoopTransform = false;
		fotranTemporaries = new HashMap<String,BasicMatrixValue>();
		mustBeInt = false;
		forceToInt = new HashSet<String>();
		inputsUsed = new HashSet<String>();
		backupTempArrays = new HashSet<String>();
		forCellArr = new HashMap<String, ArrayList<BasicMatrixValue>>();
		declaredCell = new ArrayList<String>();
		fNode.analyze(this);
	}
	// ******************************ast node override*************************
	@Override
	@SuppressWarnings("rawtypes")
	public void caseASTNode(ASTNode node) {}

	@Override
	public void caseFunction(Function node)	{
		HandleCaseFunction functionStmt = new HandleCaseFunction();
		functionStmt.getFortran(this, node);
    }
	
	@Override
	/**
	 * for comment statements.
	 */
	public void caseEmptyStmt(EmptyStmt node) {
		if (!node.getPrettyPrinted().equals("")) {
			String comment = node.getPrettyPrinted();
			if (Debug) System.out.println(comment);
			FCommentStmt fComment = new FCommentStmt();
			fComment.setIndent(getMoreIndent(0));
			fComment.setFComment(comment.subSequence(1, comment.length()).toString());
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fComment);
			}
			else {
				subprogram.getStatementSection().addStatement(fComment);
			}
		}
	}
	
	@Override
	public void caseAssignStmt(AssignStmt node)	{
		FAssignStmt fAssignStmt = new FAssignStmt();
		fAssignStmt.setIndent(getMoreIndent(0));
		/*
		 * translate matlab function with more than 
		 * one returns to subroutines in fortran.
		 */
		if (node.getLHS() instanceof MatrixExpr) {
			MatrixExpr lhsMatrix = (MatrixExpr)node.getLHS();
			if (lhsMatrix.getChild(0) instanceof List) {
				List lhsList = (List)lhsMatrix.getChild(0);
				if (lhsList.getChild(0) instanceof Row) {
					Row lhsRow = (Row)lhsList.getChild(0);
					if (lhsRow.getChild(0).getNumChild() > 1 
							|| userDefinedFunctions.contains(
							(((NameExpr)((ParameterizedExpr)node.getRHS()).getChild(0))
									.getName().getID()))) {
						FSubroutines fSubroutines = new FSubroutines();
						fSubroutines.setIndent(getMoreIndent(0));
						node.getRHS().analyze(this);
						sb.replace(sb.length()-1, sb.length(), "");
						sb.append(", ");
						for (int i = 0; i < lhsRow.getChild(0).getNumChild(); i++) {
							sb.append(lhsRow.getChild(0).getChild(i).getNodeString());
							if (i < lhsRow.getChild(0).getNumChild() - 1) {
								sb.append(", ");
							}
						}
						sb.append(")");
						if (Debug) System.out.println(sb);
						fSubroutines.setFunctionCall(sb.toString());
						sb.setLength(0);
						if (ifWhileForBlockNest != 0) {
							stmtSecForIfWhileForBlock.addStatement(fSubroutines);
						}
						else {
							subprogram.getStatementSection().addStatement(fSubroutines);
						}
						return;
					}
				}
			}
		}
		/*
		 * for the case where there is user defined function on the rhs of assignment, 
		 * and the lhs of assignment has only one value.  
		 */
		boolean convertUserFuncToSubroutine = false;
		if (node.getRHS() instanceof ParameterizedExpr 
				&& userDefinedFunctions.contains(
						node.getRHS().getChild(0).getPrettyPrinted())) {
			if (Debug) System.out.println(node.getRHS().getChild(0).getPrettyPrinted());
			convertUserFuncToSubroutine = true;
		}
		rightOfAssign = true;
		node.getRHS().analyze(this);
		/*
		 * in case not exceed the maximum length of one line in Fortran,
		 * note that 70 is not the maximum length of one line in Fortran.
		 */
		for (int i = 0; sb.length() > 70 && i < sb.length() / 70 ; i++) {
			sb.insert((i + 1) * 69, "&\n" + getMoreIndent(0) + "&");
		}
		String rhsString = sb.toString();
		fAssignStmt.setFRHS(rhsString);
		sb.setLength(0);
		rightOfAssign = false;
		
		if (node.getRHS() instanceof ParameterizedExpr 
				&& analysisEngine.getTemporaryVariablesRemovalAnalysis()
					.getExprToTempVarTable().get(node.getRHS()) == null) {
			// this means the rhs is either array indexing or function call
			if (remainingVars.contains(
					((NameExpr)node.getRHS().getChild(0)).getName().getID())) {
				// rhs is array index
				// String name = ((NameExpr)node.getRHS().getChild(0)).getName().getID();
				rhsArrayAssign = true;
			}
		}
		needLinearTransform = false; // reset
		leftOfAssign = true;
		node.getLHS().analyze(this);
		leftOfAssign = false;
		rhsArrayAssign = false;
		String lhsName = sb.toString();
		if (lhsName.equals("q"))
			System.out.println("lala");
		boolean specialCase = false;
		if (lhsName.indexOf("(") == -1 
				&& needLinearTransform && node.getRHS() instanceof ParameterizedExpr) {
			if (getMatrixValue(lhsName).getShape().equals(getMatrixValue(
					((Name)analysisEngine.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable().get(node.getRHS()))
							.getID()).getShape().eliminateLeadingOnes())) {
				specialCase = true;
			}
		}
		
		if (lhsName.indexOf("(") == -1 
				&& needLinearTransform 
				&& !specialCase) {
			/*
			 * using a subroutine to perform the array set.
			 */
			FSubroutines fSubroutines = new FSubroutines();
			fSubroutines.setIndent(getMoreIndent(0));
			StringBuffer temp = new StringBuffer();
			temp.append("ARRAY_SET");
			int dim_lhs = getMatrixValue(lhsName).getShape().getDimensions().size();
			temp.append(dim_lhs);
			// go through the indice list of lhs
			for (int i = 0; i < node.getLHS().getChild(1).getNumChild(); i++) {
				if (node.getLHS().getChild(1).getChild(i) instanceof ColonExpr) {
					temp.append("C");
				}
				else if (node.getLHS().getChild(1).getChild(i) instanceof NameExpr) {
					Shape<AggrValue<BasicMatrixValue>> tempShape = getMatrixValue(
							((NameExpr)node.getLHS().getChild(1).getChild(i))
							.getName().getID()).getShape();
					if (tempShape.isScalar()) {
						temp.append("S");
					}
					else {
						// the index is a matrx!
						int dim_index = tempShape.getDimensions().size();
						temp.append(dim_index);
					}
				}
				// TODO other cases.
			}
			if (node.getRHS() instanceof ParameterizedExpr) {
				Shape<AggrValue<BasicMatrixValue>> tempShape = getMatrixValue(
						((Name)analysisEngine.getTemporaryVariablesRemovalAnalysis()
								.getExprToTempVarTable().get(node.getRHS())).getID())
								.getShape();
				if (tempShape.isScalar()) {
					temp.append("S");
				}
				else {
					// the rhs is a matrix!
					int dim_rhs = tempShape.getDimensions().size();
					temp.append(dim_rhs);
				}
			}
			else if (node.getRHS() instanceof LiteralExpr) {
				temp.append("S");
			}
			// TODO other cases.
			allSubprograms.add(temp.toString());
			temp.append("(" + lhsName);
			// go through the indice list of lhs again
			for (int i = 0; i < node.getLHS().getChild(1).getNumChild(); i++) {
				if (node.getLHS().getChild(1).getChild(i) instanceof ColonExpr) {
					// do nothing.
				}
				else if (node.getLHS().getChild(1).getChild(i) instanceof NameExpr) {
					temp.append(", INT(" 
							+ ((NameExpr)node.getLHS().getChild(1).getChild(i)).getName().getID() 
							+ ")");
				}
				// TODO other cases.
			}
			temp.append(", DBLE(" + rhsString + "))");
			fSubroutines.setFunctionCall(temp.toString());
			needLinearTransform = false;
			sb.setLength(0);
			/*
			 * if lhs is parameterizedExpr, it's an array set statement, 
			 * if not and when there is a vector on the rhs, add (:, 1) 
			 * or (1, :) to linearize the lhs.
			 */
			if (lhsName.indexOf("(") == -1 && !getMatrixValue(lhsName).getShape().isScalar()) {
				if (rhsString.indexOf("(:, 1)") != -1) {
					lhsName = lhsName + "(:, 1)";
					fAssignStmt.setFLHS(lhsName);
				}
				else if (rhsString.indexOf("(1, :)") != -1) {
					lhsName = lhsName + "(1, :)";
					fAssignStmt.setFLHS(lhsName);
				}
			}
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fSubroutines);
			}
			else {
				subprogram.getStatementSection().addStatement(fSubroutines);
			}			
		}
		else if (lhsName.isEmpty()) {
			// TODO for the case where there is no return value, i.e. the builtin function disp.
			if (rhsString.substring(0, rhsString.indexOf("(")).equals("disp")) {
				FSubroutines fSubroutines = new FSubroutines();
				fSubroutines.setIndent(getMoreIndent(0));
				fSubroutines.setFunctionCall("PRINT *, " 
						+ rhsString.substring(rhsString.indexOf("(") + 1, rhsString.indexOf(")")));
				if (ifWhileForBlockNest != 0) {
					stmtSecForIfWhileForBlock.addStatement(fSubroutines);
				}
				else {
					subprogram.getStatementSection().addStatement(fSubroutines);
				}
			}
			else if (rhsString.substring(0, rhsString.indexOf("(")).equals("load")) {
				FSubroutines fSubroutines = new FSubroutines();
				fSubroutines.setIndent(getMoreIndent(0));
				StringBuffer sb = new StringBuffer();
				String fileName = rhsString.substring(rhsString.indexOf("(") + 1, rhsString.indexOf(")")).replace("'", "");
				sb.append("OPEN(UNIT = 1, FILE = \"" + fileName + "\");\n");
				String varName = fileName.split("\\.")[0];
				// TODO adding some preprocessing function to get the shape of the file.
				sb.append(getMoreIndent(0) + "CALL file_analyze('" + fileName + "', " + varName + "_r, " + varName + "_c);\n");
				sb.append(getMoreIndent(0) + "ALLOCATE(" + varName + "(" + varName + "_r, " + varName + "_c));\n");
				fotranTemporaries.put(varName + "_r", new BasicMatrixValue(
						null, 
						PrimitiveClassReference.INT32, 
						new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
						null, 
						new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
						.newisComplexInfoFromStr("REAL")
						));
				fotranTemporaries.put(varName + "_c", new BasicMatrixValue(
						null, 
						PrimitiveClassReference.INT32, 
						new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
						null, 
						new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
						.newisComplexInfoFromStr("REAL")
						));
				sb.append(getMoreIndent(0) + "DO row_" + varName + " = 1, SIZE(" + varName + ", 1)\n");
				sb.append(getMoreIndent(1) + "READ(1, *) " + varName + "(row_" + varName + ", :);\n");
				sb.append(getMoreIndent(0) + "END DO\n");
				fSubroutines.setFunctionCall(sb.toString());
				fotranTemporaries.put("row_" + varName, new BasicMatrixValue(
						null, 
						PrimitiveClassReference.INT32, 
						new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
						null, 
						new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
						.newisComplexInfoFromStr("REAL")
						));
				if (ifWhileForBlockNest != 0) {
					stmtSecForIfWhileForBlock.addStatement(fSubroutines);
				}
				else {
					subprogram.getStatementSection().addStatement(fSubroutines);
				}
			}
		}
		else if (convertUserFuncToSubroutine) {
			sb.setLength(0);
			FSubroutines fSubroutines = new FSubroutines();
			fSubroutines.setIndent(getMoreIndent(0));
			fSubroutines.setFunctionCall(rhsString.substring(0, rhsString.length()-1) + ", " + lhsName + ")");
			if (sbForRuntimeInline.length() != 0 && !zerosAlloc) {
				RuntimeAllocate runtimeInline = new RuntimeAllocate();
				runtimeInline.setBlock(sbForRuntimeInline.toString());
				fSubroutines.setRuntimeAllocate(runtimeInline);
				sbForRuntimeInline.setLength(0);
			}
			convertUserFuncToSubroutine = false;
			/*
			 * if lhs is parameterizedExpr, it's an array set statement, 
			 * if not and when there is a vector on the rhs, add (:, 1) 
			 * or (1, :) to linearize the lhs.
			 */
			if (lhsName.indexOf("(") == -1 && !getMatrixValue(lhsName).getShape().isScalar()) {
				if (rhsString.indexOf("(:, 1)") != -1) {
					lhsName = lhsName + "(:, 1)";
					fAssignStmt.setFLHS(lhsName);
				}
				else if (rhsString.indexOf("(1, :)") != -1) {
					lhsName = lhsName + "(1, :)";
					fAssignStmt.setFLHS(lhsName);
				}
			}
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fSubroutines);
			}
			else {
				subprogram.getStatementSection().addStatement(fSubroutines);
			}
		}
		else if (!overloadedRelational.isEmpty()) {
			sbForRuntimeInline.append("IF (ALLOCATED(" + lhsName +")) THEN\n" 
					+ getMoreIndent(1) + "DEALLOCATE(" + lhsName + ");\n" 
					+ getMoreIndent(0) + "END IF\n");
			sbForRuntimeInline.append("ALLOCATE(" + lhsName + "(");
			if (overloadedRelationalFlag.equals("l")) {
				if (node.getRHS().getChild(1).getChild(0) instanceof NameExpr) {
					String tempName = ((NameExpr)node.getRHS().getChild(1)
							.getChild(0)).getName().getID();
					Shape<AggrValue<BasicMatrixValue>> lhsShape = 
							getMatrixValue(tempName).getShape();
					for (int i = 0; i < lhsShape.getDimensions().size(); i++) {
						sbForRuntimeInline.append("SIZE(" + tempName + ", " + (i+1) + ")");
						if (i + 1 < lhsShape.getDimensions().size()) {
							sbForRuntimeInline.append(", ");
						}
					}
				}
				else if (node.getRHS().getChild(1).getChild(0) instanceof ParameterizedExpr) {
					// TODO
				}
			}
			else if (overloadedRelationalFlag.equals("r")) {
				sbForRuntimeInline.append(node.getRHS().getChild(1).getChild(1).getPrettyPrinted());
			}
			sbForRuntimeInline.append("));\n");
			RuntimeAllocate runtimeInline = new RuntimeAllocate();
			runtimeInline.setBlock(sbForRuntimeInline.toString());
			fAssignStmt.setRuntimeAllocate(runtimeInline);
			sbForRuntimeInline.setLength(0);
			fAssignStmt.setFLHS("WHERE " + rhsString + " " + lhsName);
			fAssignStmt.setFRHS(".TRUE.");
			sb.setLength(0);
			overloadedRelational = "";
			overloadedRelationalFlag = "";
			/*
			 * if lhs is parameterizedExpr, it's an array set statement, 
			 * if not and when there is a vector on the rhs, add (:, 1) 
			 * or (1, :) to linearize the lhs.
			 */
			if (lhsName.indexOf("(") == -1 && !getMatrixValue(lhsName).getShape().isScalar()) {
				if (rhsString.indexOf("(:, 1)") != -1) {
					lhsName = lhsName + "(:, 1)";
					fAssignStmt.setFLHS(lhsName);
				}
				else if (rhsString.indexOf("(1, :)") != -1) {
					lhsName = lhsName + "(1, :)";
					fAssignStmt.setFLHS(lhsName);
				}
			}
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fAssignStmt);
			}
			else {
				subprogram.getStatementSection().addStatement(fAssignStmt);
			}
		}
		else if (horzcat && lhsName.indexOf("(") == -1) {
			if (Debug) System.out.println(lhsName + " = " + rhsString);
			String[] rhsArgsArray = rhsString.split("!! ");
			ArrayList<String> rhsArgsList = new ArrayList<String>();
			for (int i = 0; i < rhsArgsArray.length; i++) {
				rhsArgsList.add(rhsArgsArray[i]);
			}
			// if lhs array also appears in the rhs, need to back up the array.
			if (rhsArgsList.contains(lhsName)) {
				sbForRuntimeInline.append(getMoreIndent(0) + "IF (ALLOCATED(" + lhsName + "_bk)) THEN\n" 
						+ getMoreIndent(1) + "DEALLOCATE(" + lhsName + "_bk);\n" 
						+ getMoreIndent(0) + "END IF\n" 
						+ getMoreIndent(0) + lhsName + "_bk = " + lhsName + ";\n");
				backupTempArrays.add(lhsName);
			}
			for (int i = 0; i < rhsArgsList.size(); i++) {
				Shape<AggrValue<BasicMatrixValue>> tempShape;
				if(node.getRHS().getChild(1).getChild(i) instanceof NameExpr) {
					tempShape = getMatrixValue(((NameExpr)node.getRHS()
							.getChild(1).getChild(i)).getName().getID()).getShape();
				}
				else {
					// TODO for parameterized expression.
					tempShape = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getRHS().getChild(1).getChild(i))).getID())
							.getShape();
				}
				if (tempShape != null && tempShape.isScalar()) {
					sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "_2" + (i+1) 
							+ " = 1;\n");
				}
				else if (tempShape != null && tempShape.maybeVector()) {
					sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "_2" + (i+1) 
							+ " = SIZE(" + rhsArgsList.get(i) + ");\n");
				}
				else {
					sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "_2" + (i+1) 
							+ " = SIZE(" + rhsArgsList.get(i) + ", 2);\n");
				}
				fotranTemporaries.put(lhsName + "_2" + (i+1), new BasicMatrixValue(
						null, 
						PrimitiveClassReference.INT32, 
						new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
						null, 
						new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
						.newisComplexInfoFromStr("REAL")
						));
			}
			if (!getMatrixValue(lhsName).getShape().isConstant()) {
				sbForRuntimeInline.append(getMoreIndent(0) + "IF (ALLOCATED(" + lhsName + ")) THEN\n" 
						+ getMoreIndent(1) + "DEALLOCATE(" + lhsName + ");\n" 
						+ getMoreIndent(0) + "END IF\n" 
						+ getMoreIndent(0) + "ALLOCATE(" + lhsName + "(SIZE(" + rhsArgsList.get(0) + ", 1), ");
				for (int i = 0; i < rhsArgsList.size(); i++) {
					Shape<AggrValue<BasicMatrixValue>> tempShape;
					if(node.getRHS().getChild(1).getChild(i) instanceof NameExpr) {
						tempShape = getMatrixValue(((NameExpr)node.getRHS()
								.getChild(1).getChild(i)).getName().getID()).getShape();
					}
					else {
						// TODO for parameterized expression.
						tempShape = getMatrixValue(((Name)analysisEngine
								.getTemporaryVariablesRemovalAnalysis()
								.getExprToTempVarTable()
								.get(node.getRHS().getChild(1).getChild(i))).getID())
								.getShape();
					}
					if (tempShape != null && tempShape.isScalar()) {
						sbForRuntimeInline.append("1");
					}
					else {
						sbForRuntimeInline.append(lhsName + "_2" + (i+1));
					}
					if (i + 1 < rhsArgsList.size()) {
						sbForRuntimeInline.append(" + ");
					}
				}
				sbForRuntimeInline.append("));\n");
			}
			for (int i = 0; i < rhsArgsList.size(); i++) {
				Shape<AggrValue<BasicMatrixValue>> tempShape;
				boolean isName = false;
				if(node.getRHS().getChild(1).getChild(i) instanceof NameExpr) {
					tempShape = getMatrixValue(((NameExpr)node.getRHS()
							.getChild(1).getChild(i)).getName().getID()).getShape();
					isName = true;
				}
				else {
					// TODO for parameterized expression.
					tempShape = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getRHS().getChild(1).getChild(i))).getID())
							.getShape();
				}
				sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "(");
				if (i == 0) {
					if (tempShape != null && tempShape.isScalar()) {
						// if right hand side is a vector;
						sbForRuntimeInline.append("1, 1");
					}
					else if (tempShape != null && tempShape.isRowVector()) {
						sbForRuntimeInline.append("1, 1 : " + lhsName + "_2" + (i+1) + "");
					}
					else {
						sbForRuntimeInline.append(":, 1 : " + lhsName + "_2" + (i+1) + "");
					}
				}
				else {
					if (tempShape != null && tempShape.isScalar()) {
						// if right hand side is a vector;
						sbForRuntimeInline.append(":, " + lhsName + "_2" + i + " + 1");
					}
					else {
						sbForRuntimeInline.append(":, " + lhsName + "_2" + i + " + 1 : " + lhsName 
								+ "_2" + i + " + " + lhsName + "_2" + (i+1) + "");
					}
				}
				sbForRuntimeInline.append(") = ");
				if (rhsArgsList.get(i).equals(lhsName)) {
					if (tempShape.isRowVector()) lhsName = lhsName + "(1, :)";
					sbForRuntimeInline.append(lhsName + "_bk;\n");
				}
				else {
					if (tempShape.isRowVector() && isName) {
						sbForRuntimeInline.append(rhsArgsList.get(i) + "(1, :)" + ";\n");
					}
					else {
						sbForRuntimeInline.append(rhsArgsList.get(i) + ";\n");
					}
				}
			}
			fAssignStmt.setFLHS("! replace " + lhsName);
			fAssignStmt.setFRHS(rhsString + " with above statements.");
			RuntimeAllocate runtimeInline = new RuntimeAllocate();
			runtimeInline.setBlock(sbForRuntimeInline.toString());
			fAssignStmt.setRuntimeAllocate(runtimeInline);
			sbForRuntimeInline.setLength(0);
			sb.setLength(0);
			horzcat = false;
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fAssignStmt);
			}
			else {
				subprogram.getStatementSection().addStatement(fAssignStmt);
			}
		}
		else if (vertcat && lhsName.indexOf("(") == -1) {
			if (Debug) System.out.println(lhsName + " = " + rhsString);
			String[] rhsArgsArray = rhsString.split("!! ");
			ArrayList<String> rhsArgsList = new ArrayList<String>();
			for (int i = 0; i < rhsArgsArray.length; i++) {
				rhsArgsList.add(rhsArgsArray[i]);
			}
			// if lhs array also appears in the rhs, need to back up the array.
			if (rhsArgsList.contains(lhsName)) {
				sbForRuntimeInline.append(getMoreIndent(0) + "IF (ALLOCATED(" + lhsName + "_bk)) THEN\n" 
						+ getMoreIndent(1) + "DEALLOCATE(" + lhsName + "_bk);\n" 
						+ getMoreIndent(0) + "END IF\n" 
						+ getMoreIndent(0) + lhsName + "_bk = " + lhsName + ";\n");
				backupTempArrays.add(lhsName);
			}
			for (int i = 0; i < rhsArgsList.size(); i++) {
				Shape<AggrValue<BasicMatrixValue>> tempShape;
				if(node.getRHS().getChild(1).getChild(i) instanceof NameExpr) {
					tempShape = getMatrixValue(((NameExpr)node.getRHS()
							.getChild(1).getChild(i)).getName().getID()).getShape();
				}
				else {
					// TODO for parameterized expression.
					tempShape = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getRHS().getChild(1).getChild(i))).getID())
							.getShape();
				}
				if (tempShape != null && tempShape.maybeVector()) {
					sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "_1" + (i+1) 
							+ " = 1;\n");
				}
				else {
					sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "_1" + (i+1) 
							+ " = SIZE(" + rhsArgsList.get(i) + ", 1);\n");
				}
				fotranTemporaries.put(lhsName + "_1" + (i+1), new BasicMatrixValue(
						null, 
						PrimitiveClassReference.INT32, 
						new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
						null, 
						new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
						.newisComplexInfoFromStr("REAL")
						));
			}
			if (!getMatrixValue(lhsName).getShape().isConstant()) {
				sbForRuntimeInline.append(getMoreIndent(0) + "IF (ALLOCATED(" + lhsName + ")) THEN\n" 
						+ getMoreIndent(1) + "DEALLOCATE(" + lhsName + ");\n" 
						+ getMoreIndent(0) + "END IF\n" 
						+ getMoreIndent(0) + "ALLOCATE(" + lhsName + "(");
				for (int i = 0; i < rhsArgsList.size(); i++) {
					Shape<AggrValue<BasicMatrixValue>> tempShape;
					if(node.getRHS().getChild(1).getChild(i) instanceof NameExpr) {
						tempShape = getMatrixValue(((NameExpr)node.getRHS()
								.getChild(1).getChild(i)).getName().getID()).getShape();
					}
					else {
						// TODO for parameterized expression.
						tempShape = getMatrixValue(((Name)analysisEngine
								.getTemporaryVariablesRemovalAnalysis()
								.getExprToTempVarTable()
								.get(node.getRHS().getChild(1).getChild(i))).getID())
								.getShape();
					}
					if (tempShape != null && tempShape.maybeVector()) {
						sbForRuntimeInline.append("1");
					}
					else {
						sbForRuntimeInline.append(lhsName + "_1" + (i+1));
					}
					if (i + 1 < rhsArgsList.size()) {
						sbForRuntimeInline.append(" + ");
					}
				}
				if (lhsName.equals(rhsArgsList.get(0))) {
					sbForRuntimeInline.append(", SIZE(" + rhsArgsList.get(0) + "_bk, 2)));\n");
				}
				else {
					sbForRuntimeInline.append(", SIZE(" + rhsArgsList.get(0) + ", 2)));\n");
				}
			}
			for (int i = 0; i < rhsArgsList.size(); i++) {
				Shape<AggrValue<BasicMatrixValue>> tempShape;
				boolean isName = false;
				if(node.getRHS().getChild(1).getChild(i) instanceof NameExpr) {
					tempShape = getMatrixValue(((NameExpr)node.getRHS()
							.getChild(1).getChild(i)).getName().getID()).getShape();
					isName = true;
				}
				else {
					// TODO for parameterized expression.
					tempShape = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getRHS().getChild(1).getChild(i))).getID())
							.getShape();
				}
				sbForRuntimeInline.append(getMoreIndent(0) + lhsName + "(");
				if (i == 0) {
					if (tempShape != null && tempShape.maybeVector()) {
						// if right hand side is a vector;
						sbForRuntimeInline.append("1, :");
					}
					else {
						sbForRuntimeInline.append("1 : " + lhsName + "_1" + (i+1) + ", :");
					}
				}
				else {
					if (tempShape != null && tempShape.maybeVector()) {
						// if right hand side is a vector;
						sbForRuntimeInline.append(lhsName + "_1" + i + " + 1, :");
					}
					else {
						sbForRuntimeInline.append(lhsName + "_1" + i + " + 1 : " + lhsName 
								+ "_1" + i + " + " + lhsName + "_1" + (i+1) + ", :");
					}
				}
				sbForRuntimeInline.append(") = ");
				if (rhsArgsList.get(i).equals(lhsName)) {
					if (tempShape.isRowVector()) lhsName = lhsName + "(1, :)";
					sbForRuntimeInline.append(lhsName + "_bk;\n");
				}
				else {
					if (tempShape.isRowVector() && isName) {
						sbForRuntimeInline.append(rhsArgsList.get(i) + "(1, :)" + ";\n");
					}
					else {
						sbForRuntimeInline.append(rhsArgsList.get(i) + ";\n");
					}
				}
			}
			fAssignStmt.setFLHS("! replace " + lhsName);
			fAssignStmt.setFRHS(rhsString + " with above statements.");
			RuntimeAllocate runtimeInline = new RuntimeAllocate();
			runtimeInline.setBlock(sbForRuntimeInline.toString());
			fAssignStmt.setRuntimeAllocate(runtimeInline);
			sbForRuntimeInline.setLength(0);
			sb.setLength(0);
			vertcat = false;
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fAssignStmt);
			}
			else {
				subprogram.getStatementSection().addStatement(fAssignStmt);
			}
		}
		else if (lhsName.indexOf("(") == -1 
				&& getMatrixValue(lhsName).getShape().isConstant() 
				&& zerosAlloc) {
			fAssignStmt.setFLHS(lhsName);
			fAssignStmt.setFRHS("0");
			zerosAlloc = false;
			sb.setLength(0);
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fAssignStmt);
			}
			else {
				subprogram.getStatementSection().addStatement(fAssignStmt);
			}
		}
		else {
			// if there is runtime abc or allocate, add here.
			if (sbForRuntimeInline.length() != 0 && !zerosAlloc) {
				RuntimeAllocate runtimeInline = new RuntimeAllocate();
				runtimeInline.setBlock(sbForRuntimeInline.toString());
				fAssignStmt.setRuntimeAllocate(runtimeInline);
				sbForRuntimeInline.setLength(0);
			}
			else if (lhsName.indexOf("(") == -1 
					&& !getMatrixValue(lhsName).getShape().isConstant() 
					&& zerosAlloc) {
				sbForRuntimeInline.setLength(0);
				RuntimeAllocate runtimeInline = new RuntimeAllocate();
				sbForRuntimeInline.append("IF (.NOT.ALLOCATED(" 
						+ lhsName
						+ ")) THEN\n" + getMoreIndent(1));
				runtimeInline.setBlock(sbForRuntimeInline.toString());
				fAssignStmt.setRuntimeAllocate(runtimeInline);
				sbForRuntimeInline.setLength(0);
			}
			if (lhsName.indexOf("(") == -1 
					&& getMatrixValue(lhsName).getShape().isRowVector() 
					&& node.getRHS() instanceof ParameterizedExpr 
					&& remainingVars.contains(
							((NameExpr)((ParameterizedExpr)node.getRHS())
									.getChild(0)).getName().getID())) {
				fAssignStmt.setFLHS(lhsName + "(1, :)");
			}
			else if (lhsName.indexOf("(") == -1 
					&& getMatrixValue(lhsName).getShape().isColVector() 
					&& node.getRHS() instanceof ParameterizedExpr 
					&& remainingVars.contains(
							((NameExpr)((ParameterizedExpr)node.getRHS())
									.getChild(0)).getName().getID())) {
				fAssignStmt.setFLHS(lhsName + "(:, 1)");
			}
			else {
				fAssignStmt.setFLHS(lhsName);
			}
			if (lhsName.indexOf("(") == -1 
					&& !getMatrixValue(lhsName).getShape().isConstant() 
					&& zerosAlloc) {
				ExtraInlined extraInlined = new ExtraInlined();
				extraInlined.setBlock("END IF");
				fAssignStmt.setExtraInlined(extraInlined);
				zerosAlloc = false;
			}
			if (rhsString.indexOf("(") == -1 
					&& remainingVars.contains(rhsString) 
					&& getMatrixValue(rhsString).getShape().isRowVector() 
					&& node.getLHS() instanceof ParameterizedExpr 
					&& remainingVars.contains(
							((NameExpr)((ParameterizedExpr)node.getLHS())
									.getChild(0)).getName().getID())) {
				fAssignStmt.setFRHS(rhsString + "(1, :)");
			}
			else if (rhsString.indexOf("(") == -1 
					&& remainingVars.contains(rhsString) 
					&& getMatrixValue(rhsString).getShape().isColVector() 
					&& node.getLHS() instanceof ParameterizedExpr 
					&& remainingVars.contains(
							((NameExpr)((ParameterizedExpr)node.getLHS())
									.getChild(0)).getName().getID())) {
				fAssignStmt.setFRHS(rhsString + "(:, 1)");
			}
			sb.setLength(0);
			/*
			 * if lhs is parameterizedExpr, it's an array set statement, 
			 * if not and when there is a vector on the rhs, add (:, 1) 
			 * or (1, :) to linearize the lhs.
			 */
			if (lhsName.indexOf("(") == -1 && !getMatrixValue(lhsName).getShape().isScalar()) {
				if (rhsString.indexOf("(:, 1)") != -1) {
					lhsName = lhsName + "(:, 1)";
					fAssignStmt.setFLHS(lhsName);
				}
				else if (rhsString.indexOf("(1, :)") != -1) {
					lhsName = lhsName + "(1, :)";
					fAssignStmt.setFLHS(lhsName);
				}
			}
			if (ifWhileForBlockNest != 0) {
				stmtSecForIfWhileForBlock.addStatement(fAssignStmt);
			}
			else {
				subprogram.getStatementSection().addStatement(fAssignStmt);
			}
		}
	}
	
	@Override
	/**
	 * in the readable version of fortran code generation, this is 
	 * one of the most important case handler and also the most 
	 * different part from the simplified version of fortran code 
	 * generation, together with the caseAssignStmt, they two cover 
	 * all the different assignments in simplified version, like 
	 * assignToVar, assignToList and so on.
	 */
	public void caseParameterizedExpr(ParameterizedExpr node) {
		// NameExpr(List), NameExpr is the first child, List is the second child.
		if (Debug) System.out.println("parameterized expr: " 
				+ node + ", has " + node.getNumChild() + " children.");
		String name = ((NameExpr) node.getChild(0)).getName().getID();
		if (remainingVars.contains(name)) {
			if (Debug) System.out.println("this is an array index.");
			/*
			 * first, backup the input, since in matlab, the input arguments 
			 * are passed by value, while in Fortran, the input arguments 
			 * are passed by reference.
			 */
			if (inArgs.contains(name) && leftOfAssign && insideArray == 0) {
				inputHasChanged.add(name);
			}
			/*
			 * TODO note that, need to find a way to distinguish the array 
			 * indexing is on which side. the array indexing on left hand 
			 * side must be inlined with runtime abc and reallocation, while 
			 * the runtime abc of the array indexing on right hand side is 
			 * optional.
			 */
			int numOfIndices = node.getChild(1).getNumChild();
			int numOfDimensions = getMatrixValue(name).getShape().getDimensions().size();
			if (getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR)) {
				// indexing a char string is handled differently from other arrays.
				sb.append(name + "(");
				node.getChild(1).analyze(this);
				sb.append(" : ");
				node.getChild(1).analyze(this);
				// TODO other index situations? like char(1,i) or char(1:i)?
				sb.append(")");
				return;
			}
			else if (numOfIndices < numOfDimensions 
					&& !getMatrixValue(name).getShape().maybeVector()) {
				/*
				 * TODO need linear indexing transformation, 
				 * should follow the same naming convention, and 
				 * add subroutines/functions to the libmc2for.
				 */
				if (Debug) System.err.println("There are/is " + numOfIndices 
						+ " indices for " + numOfDimensions + "dims");
				if (rightOfAssign) {
					// TODO linear indexing appears on the rhs.
					return;
				}
				else if (leftOfAssign) {
					sb.append(name); // note that no indices list.
					needLinearTransform = true;
					return;
				}
			}
			else if (numOfIndices == numOfDimensions 
					&& isNeedLinearTransform(node)) {
				/*
				 * TODO for the case, using matrix as index. 
				 * even "the indexNum equals dimensionNum", // comment of comment, this line is very important
				 * we have to use a user-defined subprogram 
				 * to perform the indexing, since in fortran, 
				 * it doesn't allow indexing with a matrix.
				 */
				if (Debug) System.err.println("using matrix as index.");
				if (rightOfAssign) {
					StringBuffer temp = new StringBuffer();
					temp.append("ARRAY_GET");
					Shape<AggrValue<BasicMatrixValue>> tempShape = 
							getMatrixValue(name).getShape();
					if (tempShape.isScalar()) {
						// TODO scalar can be indexed by 1...
					}
					else {
						int dim_array = tempShape.getDimensions().size();
						temp.append(dim_array);
					}
					// go through the indices list.
					for (int i = 0; i < node.getChild(1).getNumChild(); i++) {
						if (node.getChild(1).getChild(i) instanceof ColonExpr) {
							temp.append("C");
						}
						else if (node.getChild(1).getChild(i) instanceof NameExpr) {
							tempShape = getMatrixValue(((NameExpr)node.getChild(1)
									.getChild(i)).getName().getID()).getShape();
							if (tempShape.isScalar()) {
								temp.append("S");
							}
							else {
								// the index is a matrx!
								int dim_index = tempShape.getDimensions().size();
								temp.append(dim_index);
							}
						}
						else if (node.getChild(1).getChild(i) instanceof ParameterizedExpr) {
							// TODO
							tempShape = getMatrixValue(((Name)analysisEngine
									.getTemporaryVariablesRemovalAnalysis().getExprToTempVarTable()
									.get(node.getChild(1).getChild(i))).getID()).getShape();
							if (tempShape.isScalar()) {
								temp.append("S");
							}
							else {
								// the index is a matrx!
								int dim_index = tempShape.getDimensions().size();
								temp.append(dim_index);
							}
						}
						else if (node.getChild(1).getChild(i) instanceof LiteralExpr) {
							temp.append("S");
						}
					}
					allSubprograms.add(temp.toString());
					sb.append(temp);
					sb.append("(" + name);
					// go through the indices list again.
					for (int i = 0; i < node.getChild(1).getNumChild(); i++) {
						if (i + 1 < node.getChild(1).getNumChild()) {
							sb.append(", ");
						}
						if (node.getChild(1).getChild(i) instanceof ColonExpr) {
							// do nothing.
						}
						else {
							node.getChild(1).getChild(i).analyze(this);
						}
					}
					sb.append(")");
				}
				else if (leftOfAssign) {
					sb.append(name); // note that no indices list.
					needLinearTransform = true;						
				}
				return;
			}
			else if (!getMatrixValue(name).getShape().isConstant() 
					&& rightOfAssign 
					&& !nocheck) {
				/*
				 * TODO add runtime abc.
				 */
				if (Debug) System.out.println("unknown shape array indexing " +
						"on right hand side, need run-time abc.");
				sbForRuntimeInline.append(getMoreIndent(0) + "! add run-time abc.\n");
				insideArray++;
				sbForRuntimeInline.append(getMoreIndent(0) + "IF (");
				StringBuffer backup = new StringBuffer();
				backup.append(sb);
				sb.setLength(0);
				for (int i = 0; i < numOfIndices; i++) {
					if (node.getChild(1).getChild(i) instanceof ColonExpr) {
						// do nothing.
					}
					else if (i + 1 < numOfIndices) {
						/*
						 * not the last index, comparing the ith index with 
						 * the ith dimension size of the array.
						 */
						if (i != 0 && !(node.getChild(1).getChild(i-1) instanceof ColonExpr)) {
							// not the first index.
							sb.append(" .OR. ");
						}
						if (node.getChild(1).getChild(i) instanceof ParameterizedExpr) {
							String tempName = ((NameExpr)((ParameterizedExpr)node.getChild(1).
									getChild(i)).getChild(0)).getName().getID();
							if (tempName.equals("colon")) {
								StringBuffer backup2 = new StringBuffer();
								backup2.append(sb);
								sb.setLength(0);
								node.getChild(1).getChild(i).getChild(1).analyze(this);
								String colonStr = sb.toString();
								String[] args = colonStr.split(", ");
								sb.setLength(0);
								sb.append(backup2);
								sb.append(args[args.length - 1]);
							}
							else {
								node.getChild(1).getChild(i).analyze(this);
							}
						}
						else {
							node.getChild(1).getChild(i).analyze(this);
						}
						sb.append(" .GT. SIZE(" + name + ", " + (i+1) + ")");
					}
					else if (i + 1 == numOfIndices && numOfIndices < numOfDimensions) {
						/*
						 * the last index, comparing the ith index with the size 
						 * of the remaining dimensions of the array. the case 
						 * of the accessed array is not vector is handled above. 
						 * TODO here only handle the case the accessed array is vector.
						 */
						if (i != 0 && !(node.getChild(1).getChild(i-1) instanceof ColonExpr)) {
							// not the first index.
							sb.append(" .OR. ");
						}
						if (node.getChild(1).getChild(i) instanceof ParameterizedExpr) {
							String tempName = ((NameExpr)((ParameterizedExpr)node.getChild(1).
									getChild(i)).getChild(0)).getName().getID();
							if (tempName.equals("colon")) {
								StringBuffer backup2 = new StringBuffer();
								backup2.append(sb);
								sb.setLength(0);
								node.getChild(1).getChild(i).getChild(1).analyze(this);
								String colonStr = sb.toString();
								String[] args = colonStr.split(", ");
								sb.setLength(0);
								sb.append(backup2);
								sb.append(args[args.length - 1]);
							}
							else {
								node.getChild(1).getChild(i).analyze(this);
							}
						}
						else {
							node.getChild(1).getChild(i).analyze(this);
						}
						sb.append(" .GT. SIZE(" + name + ", ");
						if (getMatrixValue(name).getShape().isRowVector()) {
							sb.append("2)");
						}
						else if (getMatrixValue(name).getShape().isColVector()) {
							sb.append("1)");
						}
					}
					else if (i + 1 == numOfIndices) {
						// normal case of the last index for the last dimension.
						if (i != 0 && !(node.getChild(1).getChild(i-1) instanceof ColonExpr)) {
							// not the first index.
							sb.append(" .OR. ");
						}
						if (node.getChild(1).getChild(i) instanceof ParameterizedExpr) {
							String tempName = ((NameExpr)((ParameterizedExpr)node.getChild(1).
									getChild(i)).getChild(0)).getName().getID();
							if (tempName.equals("colon")) {
								StringBuffer backup2 = new StringBuffer();
								backup2.append(sb);
								sb.setLength(0);
								node.getChild(1).getChild(i).getChild(1).analyze(this);
								String colonStr = sb.toString();
								String[] args = colonStr.split(", ");
								sb.setLength(0);
								sb.append(backup2);
								sb.append(args[args.length - 1]);
							}
							else {
								node.getChild(1).getChild(i).analyze(this);
							}
						}
						else {
							node.getChild(1).getChild(i).analyze(this);
						}
						sb.append(" .GT. SIZE(" + name + ", " + (i+1) + ")");
					}
				}
				sb.append(") THEN\n");
				sbForRuntimeInline.append(sb);
				sb.setLength(0);
				sb.append(backup);
				insideArray--;
				sbForRuntimeInline.append(getMoreIndent(1) + "STOP \"INDEX OUT OF BOUND, LABEL: " 
						+ tempCounter + "\";\n" 
						+ getMoreIndent(0) + "END IF\n" + getMoreIndent(0) + "!\n");
				tempCounter++;
			}
			else if (!getMatrixValue(name).getShape().isConstant() 
					&& leftOfAssign) {
				/*
				 * for some cases, although the shape of the accessed array is non-constant, 
				 * we still can avoid inlining unnecessary array bounding checking, i.e., 
				 * if the shape of arr is [?, 3], the indexing arr(:, 3) is for sure in the 
				 * bounds of the array arr.
				 */
				boolean safe = true;
				for (int i = 0; i < numOfIndices; i++) {
					if (node.getChild(1).getChild(i) instanceof NameExpr) {
						safe = false;
					}
					else if (node.getChild(1).getChild(i) instanceof ParameterizedExpr) {
						safe = false;
					}
					else if (node.getChild(1).getChild(i) instanceof ColonExpr) {
						safe = true;
					}
					else if (node.getChild(1).getChild(i) instanceof IntLiteralExpr) {
						int idx = ((IntLiteralExpr)node.getChild(1).getChild(i))
								.getValue().getValue().intValue();
						if (getMatrixValue(name).getShape().getDimensions()
								.get(i).hasIntValue()) {
							int currentDim = getMatrixValue(name).getShape()
									.getDimensions().get(i).getIntValue();
							if (idx >= 1 && idx <= currentDim) {
								safe = true;
							}
							else {
								safe = false;
							}
						}
						else {
							safe = false;
						}
					}
					else {
						safe = false;
					}
					/* if there is one dimension indexing is unsafe, 
					 * we need inlining abc.
					 */
					if (!safe) break;
				}
				if (!safe) {
					/*
					 * add runtime abc and reallocation, also add a back up 
					 * variable for the indexed array variable.
					 */
					if (Debug) System.out.println("unknown shape array indexing " +
							"on left hand side, need run-time abc and reallocation.");
					sbForRuntimeInline.append(getMoreIndent(0) + "! need run-time alloc/abc and realloc.\n");
					backupTempArrays.add(name);
					/*
					 * the name of array is node.getChild(0), 
					 * the index of array is node.getChild(1).getChild(i).
					 * 
					 * currently, for the linear indexing, only support the case 
					 * one index and two dimensional array.
					 */
					insideArray++;
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							// do nothing.
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							// do nothing.
						}
						else {
							sbForRuntimeInline.append(getMoreIndent(0) + name + "_d" + (i+1) 
									+ " = SIZE(" + name + ", " + (i+1) + ");\n");
						}
					}
					sbForRuntimeInline.append(getMoreIndent(0) + "IF (");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							// do nothing.
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isRowVector()) {
							node.getChild(1).getChild(0).analyze(this);
							String indexCurrent = sb.toString();
							sb.setLength(0);
							if (!indexCurrent.equals(":")) {
								indexCurrent = indexCurrent.substring(indexCurrent.indexOf(":") + 1);
								try {
									sbForRuntimeInline.append(Integer.parseInt(indexCurrent) + " > " 
											+ name + "_d" + (i+1));
								} catch (Exception e) {
									sbForRuntimeInline.append("INT(" + indexCurrent + ") > " 
											+ name + "_d" + (i+1));
								}
							}
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							// do nothing.
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isColVector()) {
							node.getChild(1).getChild(0).analyze(this);
							String indexCurrent = sb.toString();
							sb.setLength(0);
							if (!indexCurrent.equals(":")) {
								indexCurrent = indexCurrent.substring(indexCurrent.indexOf(":") + 1);
								try {
									sbForRuntimeInline.append(Integer.parseInt(indexCurrent) + " > " 
											+ name + "_d" + (i+1));
								} catch (Exception e) {
									sbForRuntimeInline.append("INT(" + indexCurrent + ") > " 
											+ name + "_d" + (i+1));
								}
							}
						}
						else {
							node.getChild(1).getChild(i).analyze(this);
							String indexCurrent = sb.toString();
							sb.setLength(0);
							if (!indexCurrent.equals(":")) {
								indexCurrent = indexCurrent.substring(indexCurrent.indexOf(":") + 1);
								try {
									sbForRuntimeInline.append(Integer.parseInt(indexCurrent) + " > " 
											+ name + "_d" + (i+1));
								} catch (Exception e) {
									sbForRuntimeInline.append("INT(" + indexCurrent + ") > " 
											+ name + "_d" + (i+1));
								}
							}
							if (i + 1 < numOfDimensions 
									&& !indexCurrent.equals(":") 
									&& !node.getChild(1).getChild(i+1).getPrettyPrinted().equals(":")) {
								sbForRuntimeInline.append(" .OR. ");
							}
						}
					}
					sbForRuntimeInline.append(") THEN\n");
					sbForRuntimeInline.append(getMoreIndent(1) + "IF (ALLOCATED(" 
							+ name + "_bk)) THEN\n");
					sbForRuntimeInline.append(getMoreIndent(2) + "DEALLOCATE(" + name 
							+ "_bk" + ");\n");
					sbForRuntimeInline.append(getMoreIndent(1) + "END IF\n");
					sbForRuntimeInline.append(getMoreIndent(1) + "ALLOCATE(" + name + "_bk(");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							sbForRuntimeInline.append("1");
							
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							sbForRuntimeInline.append("1");
						}
						else {
							sbForRuntimeInline.append(name + "_d" + (i+1));
						}
						if (i + 1 < numOfDimensions) {
							sbForRuntimeInline.append(", ");
						}
					}
					sbForRuntimeInline.append("));\n");
					sbForRuntimeInline.append(getMoreIndent(1) + name + "_bk = " + name + ";\n");
					sbForRuntimeInline.append(getMoreIndent(1) + "DEALLOCATE(" + name + ");\n");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							// do nothing.
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isRowVector()) {
							node.getChild(1).getChild(0).analyze(this);
							String indexCurrent = sb.toString();
							sb.setLength(0);
							if (!indexCurrent.equals(":")) {
								indexCurrent = indexCurrent.substring(indexCurrent.indexOf(":") + 1);
								try {
									sbForRuntimeInline.append(getMoreIndent(1) + name 
											+ "_d" + (i+1) + "max = MAX(" + name + "_d" + (i+1) + ", " 
											+ Integer.parseInt(indexCurrent) + ");\n");
								} catch (Exception e) {
									sbForRuntimeInline.append(getMoreIndent(1) + name 
											+ "_d" + (i+1) + "max = MAX(" + name + "_d" + (i+1) + ", INT(" 
											+ indexCurrent + "));\n");
								}
							}
							else {
								sbForRuntimeInline.append(getMoreIndent(1) + name 
										+ "_d" + (i+1) + "max = " + name + "_d" + (i+1) + ";\n");
							}
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							// do nothing.
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isColVector()) {
							node.getChild(1).getChild(0).analyze(this);
							String indexCurrent = sb.toString();
							sb.setLength(0);
							if (!indexCurrent.equals(":")) {
								indexCurrent = indexCurrent.substring(indexCurrent.indexOf(":") + 1);
								try {
									sbForRuntimeInline.append(getMoreIndent(1) + name 
											+ "_d" + (i+1) + "max = MAX(" + name + "_d" + (i+1) + ", " 
											+ Integer.parseInt(indexCurrent) + ");\n");
								} catch (Exception e) {
									sbForRuntimeInline.append(getMoreIndent(1) + name 
											+ "_d" + (i+1) + "max = MAX(" + name + "_d" + (i+1) + ", INT(" 
											+ indexCurrent + "));\n");
								}
							}
							else {
								sbForRuntimeInline.append(getMoreIndent(1) + name 
										+ "_d" + (i+1) + "max = " + name + "_d" + (i+1) + ";\n");
							}
						}
						else {
							node.getChild(1).getChild(i).analyze(this);
							String indexCurrent = sb.toString();
							sb.setLength(0);
							if (!indexCurrent.equals(":")) {
								indexCurrent = indexCurrent.substring(indexCurrent.indexOf(":") + 1);
								try {
									sbForRuntimeInline.append(getMoreIndent(1) + name 
											+ "_d" + (i+1) + "max = MAX(" + name + "_d" + (i+1) + ", " 
											+ Integer.parseInt(indexCurrent) + ");\n");
								} catch (Exception e) {
									sbForRuntimeInline.append(getMoreIndent(1) + name 
											+ "_d" + (i+1) + "max = MAX(" + name + "_d" + (i+1) + ", INT(" 
											+ indexCurrent + "));\n");
								}
							}
							else {
								sbForRuntimeInline.append(getMoreIndent(1) + name 
										+ "_d" + (i+1) + "max = " + name + "_d" + (i+1) + ";\n");
							}
						}
					}
					sbForRuntimeInline.append(getMoreIndent(1) + "ALLOCATE(" + name + "(");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							sbForRuntimeInline.append("1");
							
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							sbForRuntimeInline.append("1");
						}
						else {
							sbForRuntimeInline.append(name + "_d" + (i+1) + "max");
						}
						if (i + 1 < numOfDimensions) {
							sbForRuntimeInline.append(", ");
						}
					}
					sbForRuntimeInline.append("));\n");
					sbForRuntimeInline.append(getMoreIndent(1) + name + "(");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							sbForRuntimeInline.append("1");
							
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							sbForRuntimeInline.append("1");
						}
						else {
							sbForRuntimeInline.append("1:" + name + "_d" + (i+1));
						}
						if (i + 1 < numOfDimensions) {
							sbForRuntimeInline.append(", ");
						}
					}
					sbForRuntimeInline.append(") = " + name + "_bk(");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							sbForRuntimeInline.append("1");
							
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							sbForRuntimeInline.append("1");
						}
						else {
							sbForRuntimeInline.append("1:" + name + "_d" + (i+1));
						}
						if (i + 1 < numOfDimensions) {
							sbForRuntimeInline.append(", ");
						}
					}
					sbForRuntimeInline.append(");\n");
					sbForRuntimeInline.append(getMoreIndent(0) + "END IF\n");
					sbForRuntimeInline.append(getMoreIndent(0) + "!\n");
					for (int i = 0; i < numOfDimensions; i++) {
						if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 0 
								&& getMatrixValue(name).getShape().isRowVector()) {
							// do nothing.
							
						}
						else if (numOfIndices == 1 
								&& numOfDimensions == 2 
								&& i == 1 
								&& getMatrixValue(name).getShape().isColVector()) {
							// do nothing.
						}
						else {
							fotranTemporaries.put(name + "_d" + (i+1), new BasicMatrixValue(
									null, 
									PrimitiveClassReference.INT32, 
									new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
									null, 
									new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
									.newisComplexInfoFromStr("REAL")
									));
							fotranTemporaries.put(name + "_d" + (i+1) + "max", new BasicMatrixValue(
									null, 
									PrimitiveClassReference.INT32, 
									new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
									null, 
									new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
									.newisComplexInfoFromStr("REAL")
									));
						}
					}
					insideArray--;
				}
			}
			/*
			 * since we already know the name is the array's name, we 
			 * don't need to call analyze on node.getChild(0), and 
			 * this also separate the cases of the array have indices 
			 * and the arrays don't have indices. (the array has a 
			 * index list won't call caseNameExpr, and in caseNameExpr 
			 * we can add hacks to convert 2 ranks to 1 rank in Fortran.)
			 */
			sb.append(name + "(");
			insideArray++;
			/*
			 * add rigorous array indexing transformation.
			 */
			if (node.getChild(1) instanceof List 
					&& getMatrixValue(name).getShape().getDimensions().size() 
						!= ((List)node.getChild(1)).getNumChild() 
					&& getMatrixValue(name).getShape().isColVector()) {
				node.getChild(1).analyze(this);
				/*
				 * TODO this is a hack for n-by-1 vector linear indexing,
				 * won't work for multidimensional matrix linear indexing.
				 */ 
				sb.append(", 1");
			}
			else if (node.getChild(1) instanceof List 
					&& getMatrixValue(name).getShape().getDimensions().size() 
						!= ((List)node.getChild(1)).getNumChild() 
					&& getMatrixValue(name).getShape().isRowVector()) {
				/*
				 * TODO this is a hack for 1-by-n vector linear indexing,
				 * won't work for multidimensional matrix linear indexing.
				 */
				sb.append("1, ");
				node.getChild(1).analyze(this);
			}
			else {
				node.getChild(1).analyze(this);
			}
			insideArray--;
			sb.append(")");
		}
		else {
			/*
			 * for those numerous matlab built-in functions which 
			 * don't have directly mapping intrinsic fortran 
			 * functions, we leave the same "hole" in the generated 
			 * fortran code. By saying the same "hole", I mean 
			 * the same function signature in C++ jargon. We need 
			 * to build a separate Mc2For lib which is full of 
			 * user-defined functions in fortran, and those 
			 * functions have the same function signatures with 
			 * the built-in function calls in input matlab code.
			 * 
			 * this solution make the code generation framework 
			 * concise and not need to be updated when there comes 
			 * a new matlab built-in function. the only thing we 
			 * need to do is making a user-defined function by 
			 * ourselves or "find" one, and then update the Mc2For 
			 * lib. shipped with Mc2For, we should at least 
			 * provide a significant number of user-defined fortran 
			 * functions to "fill" the "hole" of those commonly 
			 * used matlab built-in functions, like ones, zeros...
			 * 
			 * There are a lot of tutorials online about how to 
			 * make user-defined fortran lib and update lib.
			 * 
			 * actually, we can still make some function mappings 
			 * inlined, like .\ (left division), which can be 
			 * replaced by swapping operands and then use right 
			 * division, and : (colon operator), which can be 
			 * replaced by using implied DO loop in an array
			 * constructor.
			 */
			if (Debug) System.out.println("this is a function call");
			int inputNum = node.getChild(1).getNumChild();
			if (userDefinedFunctions.contains(name) 
					&& !(node.getParent() instanceof AssignStmt)) {
				/*
				 * convert user defined one-return-value function to 
				 * subroutine call in fortran, and replace the original 
				 * function with one temporary variable, i.e. check 
				 * out the benchmark diff.
				 * 
				 * add a subroutine call to the statement list, and 
				 * replace the whole parameterizedExpr with the 
				 * temporary variable.
				 */
				if (Debug) System.out.println("user defined one-return-value function:" + name);
				StringBuffer sb_bk = new StringBuffer();
				sb_bk.append(sb);
				sb.setLength(0);
				FSubroutines tempSubroutine = new FSubroutines();
				String tempName = name + "_tmp" + tempCounter;
				if (passCounter > 0) {
					tempCounter++;
				}
				// add temp variable to the variable list.
				BasicMatrixValue exprValue = getMatrixValue(((Name)analysisEngine
						.getTemporaryVariablesRemovalAnalysis()
						.getExprToTempVarTable()
						.get(node)).getID());
				// TODO add class, range, isComplex.
				if (passCounter > 0) {
					fotranTemporaries.put(tempName, new BasicMatrixValue(
							exprValue.getSymbolic(), 
							exprValue.getMatlabClass(), 
							exprValue.getShape(), 
							exprValue.getRangeValue(), 
							exprValue.getisComplexInfo()
							));
				}
				sb.append(getMoreIndent(0) + name + "(");
				for (int i = 0; i < inputNum; i++) {
					// TODO fix this double conversion.
					sb.append("DBLE(");
					node.getChild(1).getChild(i).analyze(this);
					sb.append("), ");
				}
				sb.append(tempName + ")");
				tempSubroutine.setFunctionCall(sb.toString());
				sb.setLength(0);
				sb.append(sb_bk + tempName);
				allSubprograms.add(name);
				subprogram.getStatementSection().addStatement(tempSubroutine);
				return;
			}
			/*
			 * deal with storage allocation builtin, zeros and ones.
			 * TODO does rand and randn count?
			 */
			if (name.equals("zeros")) {
				zerosAlloc = true;
			}
			/*
			 * functions with only one input or operand.
			 */
			if (inputNum == 0) {
				// for some constant.
				if (name.equals("pi")) {
					sb.append("3.14159265359");
				}
				else if (name.equals("i")) {
					sb.append("COMPLEX(0, 1)");
				}
				else if (name.equals("true")) {
					sb.append(".TRUE.");
				}
				else if (name.equals("false")) {
					sb.append(".FALSE.");
				}
				else {
					// no directly-mapping functions, leave the hole.
					sb.append(name + "()");
				}
			}
			else if (inputNum == 1) {
				/*
				 * overloaded functions have the highest priority.
				 */
				if (fortranMapping.isFortranOverloadingInlineSet(name)) {
					// getting the mclass of the input of the builtins
					BasicMatrixValue value = null;
					if (node.getChild(1).getChild(0) instanceof LiteralExpr) {
						if (node.getChild(1).getChild(0) instanceof IntLiteralExpr) {
							int number = ((IntLiteralExpr)node.getChild(1).getChild(0))
									.getValue().getValue().intValue();
							if (number == 0) {
								sb.append("0");
							}
							else {
								sb.append("1");
							}
						}
						else {
							sb.append("1");
						}
					}
					else if (node.getChild(1).getChild(0) instanceof NameExpr) {
						value = getMatrixValue(((NameExpr)node.getChild(1).getChild(0))
								.getName().getID());
					}
					else if (node.getChild(1).getChild(0) instanceof ParameterizedExpr) {
						value = getMatrixValue(((Name)analysisEngine
								.getTemporaryVariablesRemovalAnalysis()
								.getExprToTempVarTable()
								.get(node.getChild(1).getChild(0))).getID());
					}
					if (name.equals("any")) {
						sb.append("ANY(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append(")");
						if (value != null // if value is null, means that the input is literal and already been handled.
								&& value.getMatlabClass().equals(PrimitiveClassReference.LOGICAL)) {
							// do nothing
						}
						else if (value != null) {
							// calling user defined fortran module
							allSubprograms.add("any");
						}
					}
					else if (name.equals("all")) {
						sb.append("ALL(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append(")");
						if (value != null // if value is null, means that the input is literal and already been handled.
								&& value.getMatlabClass().equals(PrimitiveClassReference.LOGICAL)) {
							// do nothing
						}
						else if (value != null) {
							// calling user defined fortran module
							allSubprograms.add("all");
						}
					}
				}
				else if (fortranMapping.isFortranUnOperator(name)) {
					sb.append(fortranMapping.getFortranUnOpMapping(name));
					node.getChild(1).getChild(0).analyze(this);
				}
				else if (fortranMapping.isFortranDirectBuiltin(name)) {
					if (name.equals("min") || name.equals("max")) {
						if (name.equals("min")) sb.append("MIN(");
						else sb.append("MAX(");
						// in matlab, min or max can take in vector as input.
						if (node.getChild(1) instanceof List 
								&& node.getChild(1).getChild(0) instanceof ParameterizedExpr) {
							int num = node.getChild(1).getChild(0).getChild(1).getNumChild();
							for (int i = 0; i < num; i++) {
								if (num > 2 && i + 2 < num) {
									if (name.equals("min")) sb.append("MIN(");
									else sb.append("MAX(");
								}
								node.getChild(1).getChild(0).getChild(1).getChild(i).analyze(this);
								if (num > 2 && (i+1)%2 == 0) {
									sb.append(")");
								}
								if (i + 1 < num) {
									sb.append(", ");
								}
							}
						}
						sb.append(")");
					}
					else if (name.equals("transpose")) {
						/*
						 * for transpose, we need to make a separate variable to fill 
						 * the gap of the fact that we translate vector in matlab to 
						 * 1-by-n or n-by-1 array in fortran, while apply transpose on 
						 * those arrays in fortran, the return value is still 
						 * 2-dimensional, which means we have to linearize them to 
						 * map matlab.
						 */
						Shape<AggrValue<BasicMatrixValue>> tempShape;
						if (node.getChild(1).getChild(0) instanceof ParameterizedExpr) {
							 tempShape = getMatrixValue(((Name)analysisEngine
									 .getTemporaryVariablesRemovalAnalysis()
									 .getExprToTempVarTable()
									 .get(node.getChild(1).getChild(0))).getID())
									 .getShape();
						}
						else if (node.getChild(1).getChild(0) instanceof NameExpr) {
							tempShape = getMatrixValue(((NameExpr)node.getChild(1)
									.getChild(0)).getName().getID()).getShape();
						}
						// TODO someone may use transpose on literals...
						else {
							tempShape = null;
						}
						if (tempShape != null && tempShape.isScalar()) {
							node.getChild(1).getChild(0).analyze(this);
						}
						else {
							/*
							 * add a separate variable here.
							 */
							StringBuffer backupSB = new StringBuffer();
							backupSB.append(sb);
							sb.setLength(0);
							sb.append("TRANSPOSE(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(")");
							FAssignStmt separateAssign = new FAssignStmt();
							separateAssign.setFLHS(getMoreIndent(0) + "transpose_temp" + tempCounter);
							separateAssign.setFRHS(sb.toString());
							if (ifWhileForBlockNest != 0) {
								stmtSecForIfWhileForBlock.addStatement(separateAssign);
							}
							else {
								subprogram.getStatementSection().addStatement(separateAssign);
							}
							sb.setLength(0);
							sb.append(backupSB);
							sb.append("transpose_temp" + tempCounter);
							if (tempShape.isRowVector()) {
								sb.append("(:, 1)");
							}
							else if (tempShape.isColVector()) {
								sb.append("(1, :)");
							}
							fotranTemporaries.put("transpose_temp" + tempCounter, new BasicMatrixValue(
									null, 
									PrimitiveClassReference.DOUBLE, 
									new ShapeFactory<AggrValue<BasicMatrixValue>>().newShapeFromInputString("?*?"), 
									null, 
									new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
									.newisComplexInfoFromStr("REAL")
									));
							if (passCounter > 0) {
								tempCounter++;
							}
						}
					}
					else {
						sb.append(fortranMapping.getFortranDirectBuiltinMapping(name));
						sb.append("(");
						if (name.equals("sqrt")) sb.append("DBLE(");
						node.getChild(1).getChild(0).analyze(this);
						if (name.equals("sqrt")) sb.append(")");
						sb.append(")");
					}				
				}
				else if (fortranMapping.isFortranEasilyTransformed(name)) {
					if (Debug) System.out.println("******transformed function name: "+name+"******");
					if (name.equals("vertcat")) {
						if (node.getChild(1).getChild(0) instanceof StringLiteralExpr) {
							node.getChild(1).getChild(0).analyze(this);
						}
						else if (node.getChild(1).getChild(0) instanceof NameExpr 
								&& getMatrixValue(((NameExpr)node.getChild(1).getChild(0)).getName()
										.getID()).getMatlabClass().equals(PrimitiveClassReference.CHAR)) {
							node.getChild(1).getChild(0).analyze(this);
						}
						else {
							// TODO
						}
					}
					else if (name.equals("mean")) {
						if (node.getChild(1).getChild(0) instanceof NameExpr 
								&& getMatrixValue(((NameExpr)node.getChild(1).getChild(0))
										.getName().getID()).getShape().getDimensions().size() > 2) {
							sb.append("(SUM(");
							node.getChild(1).analyze(this);
							sb.append(", 1) / SIZE(");
							node.getChild(1).analyze(this);
							sb.append(", 1))");
						}
						else if (node.getChild(1).getChild(0) instanceof NameExpr) {
							sb.append("(SUM(");
							sb.append(((NameExpr)node.getChild(1).getChild(0)).getName().getID());
							sb.append(") / SIZE(");
							sb.append(((NameExpr)node.getChild(1).getChild(0)).getName().getID());
							sb.append("))");
						}
						else if (node.getChild(1).getChild(0) instanceof ParameterizedExpr) {
							sb.append("(SUM(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(") / SIZE(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append("))");
						}
						// TODO other cases, like LiteralExpr?
						else {
							sb.append("(SUM(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(") / SIZE(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append("))");
						}
					}
				}
				else {
					// no directly-mapping functions, leave the hole.
					sb.append(name + "(");
					node.getChild(1).analyze(this);
					sb.append(")");
					if (!name.equals("disp") && !name.equals("load")) 
						allSubprograms.add(name);
				}
			}
			/*
			 * functions with two inputs or operands.
			 */
			else if (inputNum == 2) {
				/*
				 * determine which operator or function to inline 
				 * depends on the shape of the oprands. both the 
				 * overloading and the inlining need this info.
				 */
				Shape<AggrValue<BasicMatrixValue>> shapeOp1;
				Shape<AggrValue<BasicMatrixValue>> shapeOp2;
				if (node.getChild(1).getChild(0) instanceof LiteralExpr 
						&& node.getChild(1).getChild(1) instanceof ParameterizedExpr) {
					shapeOp1 = new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape();
					shapeOp2 = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getChild(1).getChild(1))).getID())
							.getShape();
				}
				else if (node.getChild(1).getChild(0) instanceof LiteralExpr 
						&& node.getChild(1).getChild(1) instanceof NameExpr) {
					shapeOp1 = new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape();
					shapeOp2 = getMatrixValue(((NameExpr)node.getChild(1)
							.getChild(1)).getName().getID()).getShape();
				}
				else if (node.getChild(1).getChild(0) instanceof LiteralExpr 
						&& node.getChild(1).getChild(1) instanceof LiteralExpr) {
					shapeOp1 = new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape();
					shapeOp2 = new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape();
				}
				else if (node.getChild(1).getChild(0) instanceof ParameterizedExpr 
						&& node.getChild(1).getChild(1) instanceof LiteralExpr) {
					shapeOp1 = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getChild(1).getChild(0))).getID())
							.getShape();
					shapeOp2 = new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape();
				}
				else if (node.getChild(1).getChild(0) instanceof NameExpr 
						&& node.getChild(1).getChild(1) instanceof LiteralExpr) {
					shapeOp1 = getMatrixValue(((NameExpr)node.getChild(1)
							.getChild(0)).getName().getID()).getShape();
					shapeOp2 = new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape();
				}
				else if (node.getChild(1).getChild(0) instanceof ParameterizedExpr 
						&& node.getChild(1).getChild(1) instanceof ParameterizedExpr) {
					shapeOp1 = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getChild(1).getChild(0))).getID())
							.getShape();
					shapeOp2 = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getChild(1).getChild(1))).getID())
							.getShape();
				}
				else if (node.getChild(1).getChild(0) instanceof ParameterizedExpr 
						&& node.getChild(1).getChild(1) instanceof NameExpr) {
					shapeOp1 = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getChild(1).getChild(0))).getID())
							.getShape();
					shapeOp2 = getMatrixValue(((NameExpr)node.getChild(1)
							.getChild(1)).getName().getID()).getShape();
				}
				else if (node.getChild(1).getChild(0) instanceof NameExpr 
						&& node.getChild(1).getChild(1) instanceof ParameterizedExpr) {
					shapeOp1 = getMatrixValue(((NameExpr)node.getChild(1)
							.getChild(0)).getName().getID()).getShape();
					shapeOp2 = getMatrixValue(((Name)analysisEngine
							.getTemporaryVariablesRemovalAnalysis()
							.getExprToTempVarTable()
							.get(node.getChild(1).getChild(1))).getID())
							.getShape();
				}
				else {
					// at least one of the operands is literal, which means it's a scalar.
					shapeOp1 = getMatrixValue(((NameExpr)node.getChild(1)
							.getChild(0)).getName().getID()).getShape();
					shapeOp2 = getMatrixValue(((NameExpr)node.getChild(1)
							.getChild(1)).getName().getID()).getShape();
				}
				/*
				 * overloaded functions have the highest priority.
				 */
				if (fortranMapping.isFortranOverloadingInlineSet(name)) {
					if (name.equals("mtimes")) {
						if (shapeOp1.isRowVector() && shapeOp2.isColVector()) {
							// TODO use DOT_PRODUCT
							sb.append("DOT_PRODUCT(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(", ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(")");
						}
						else if (shapeOp1.isScalar() || shapeOp2.isScalar()) {
							// use * operator
							sb.append("(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(" * ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(")");
						}
						else {
							// TODO use MATMUL, sometimes should make a shadow var.
							sb.append("MATMUL(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(", ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(")");
						}
					}
					else if (name.equals("mrdivide")) {
						if (shapeOp1.isRowVector() && shapeOp2.isColVector()) {
							// TODO calling user defined fortran module.
						}
						else if (!shapeOp1.isConstant() && !shapeOp2.isConstant()) {
							// TODO calling user defined fortran module.
						}
						else {
							// use / operator
							sb.append("(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(" / ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(")");
						}
					}
					else if (name.equals("mldivide")) {
						if (shapeOp1.isRowVector() && shapeOp2.isColVector()) {
							// TODO calling user defined fortran module.
						}
						else if (!shapeOp1.isConstant() && !shapeOp2.isConstant()) {
							// TODO calling user defined fortran module.
						}
						else {
							// swap the operands and then use / operator
							sb.append("(");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(" / ");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(")");
						}
					}
					else if (name.equals("mpower")) {
						if (shapeOp1.isRowVector() && shapeOp2.isColVector()) {
							// TODO calling user defined fortran module.
						}
						else if (!shapeOp1.isConstant() && !shapeOp2.isConstant()) {
							// TODO calling user defined fortran module.
						}
						else {
							// use ** operator
							sb.append("(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(" ** ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(")");
						}
					}
					else if (name.equals("lt") 
							|| name.equals("le") 
							|| name.equals("gt") 
							|| name.equals("ge") 
							|| name.equals("eq") 
							|| name.equals("ne")) {
						if (!shapeOp1.isScalar() && shapeOp2.isScalar()) {
							// TODO
							overloadedRelational = name;
							overloadedRelationalFlag = "l";
						}
						else if (shapeOp1.isScalar() && !shapeOp2.isScalar()) {
							// TODO
							overloadedRelational = name;
							overloadedRelationalFlag = "r";
						}
						sb.append("(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append(" " + fortranMapping.getFortranBinOpMapping(name) + " ");
						node.getChild(1).getChild(1).analyze(this);
						sb.append(")");
					}
				}
				else if (fortranMapping.isFortranBinOperator(name)) {
					sb.append("(");
					node.getChild(1).getChild(0).analyze(this);
					sb.append(" " + fortranMapping.getFortranBinOpMapping(name) + " ");
					node.getChild(1).getChild(1).analyze(this);
					sb.append(")");
				}
				else if (fortranMapping.isFortranDirectBuiltin(name)) {
					if (name.equals("mod")) {
						// TODO the best fix should be checking the mclass of the operands.
						sb.append("MODULO");
						sb.append("(DBLE(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append("), DBLE(");
						node.getChild(1).getChild(1).analyze(this);
						sb.append("))");
					}
					else if (name.equals("size")) {
						// check whether the input is char string.
						if (node.getChild(1).getChild(0) instanceof NameExpr 
								&& getMatrixValue(((NameExpr)node.getChild(1)
										.getChild(0)).getName().getID()).getMatlabClass()
										.equals(PrimitiveClassReference.CHAR)) {
								// map it to LEN
							sb.append("LEN(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(")");
						}
						else {
							sb.append("SIZE");
							sb.append("(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(", ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append(")");
						}
					}
					else {
						sb.append(fortranMapping.getFortranDirectBuiltinMapping(name));
						sb.append("(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append(", ");
						node.getChild(1).getChild(1).analyze(this);
						sb.append(")");
					}
				}
				else if (fortranMapping.isFortranEasilyTransformed(name)) {
					if (Debug) System.out.println("******transformed function name: "+name+"******");
					if (name.equals("colon")) {
						if (insideArray > 0) {
							/*
							 * back up the StringBuffer, test whether the start and end are integers.
							 */
							StringBuffer sb_bk = new StringBuffer();
							sb_bk.append(sb);
							sb.setLength(0);
							try {
								node.getChild(1).getChild(0).analyze(this);
								int start = Integer.parseInt(sb.toString());
								sb.setLength(0);
								sb.append(sb_bk);
								sb.append(start);
								
							} catch (Exception e) {
								sb.setLength(0);
								sb.append(sb_bk);
								sb.append("INT(");
								node.getChild(1).getChild(0).analyze(this);
								sb.append(")");
							}
							sb.append(":");
							sb_bk.setLength(0);
							sb_bk.append(sb);
							sb.setLength(0);
							try {
								node.getChild(1).getChild(1).analyze(this);
								int end = Integer.parseInt(sb.toString());
								sb.setLength(0);
								sb.append(sb_bk);
								sb.append(end);
								
							} catch (Exception e) {
								sb.setLength(0);
								sb.append(sb_bk);
								sb.append("INT(");
								node.getChild(1).getChild(1).analyze(this);
								sb.append(")");
							}
						}
						else {
							sb.append("[(FI, FI=INT(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append("),INT(");
							node.getChild(1).getChild(1).analyze(this);
							sb.append("))]");
							fotranTemporaries.put("FI", new BasicMatrixValue(
									null, 
									PrimitiveClassReference.INT32, 
									new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
									null, 
									new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
									.newisComplexInfoFromStr("REAL")
									));
							if (rightOfAssign) {
								colonAlloc = true;
							}
						}
					}
					else if (name.equals("ldivide")) {
						sb.append("(");
						node.getChild(1).getChild(1).analyze(this);
						sb.append(" / ");
						node.getChild(1).getChild(0).analyze(this);
						sb.append(")");
					}
					else if (name.equals("randn")) {
						FSubroutines fSubroutines = new FSubroutines();
						fSubroutines.setIndent(getMoreIndent(0));
						RuntimeAllocate runtimeAlloc = new RuntimeAllocate();
						StringBuffer backBuff = new StringBuffer();
						backBuff.append(sb);
						sb.setLength(0);
						sb.append("INT(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append("), INT(");
						node.getChild(1).getChild(1).analyze(this);
						sb.append(")");
						runtimeAlloc.setBlock(getMoreIndent(0) + "IF (.NOT.ALLOCATED(rand_temp" 
								+ tempCounter + ")) THEN\n"  + getMoreIndent(1) 
								+ "ALLOCATE(rand_temp" + tempCounter + "(" + sb + "));\n" 
								+ getMoreIndent(0) + "END IF\n");
						fSubroutines.setRuntimeAllocate(runtimeAlloc);
						sb.setLength(0);
						sb.append(backBuff);
						fSubroutines.setFunctionCall("RANDOM_NUMBER(rand_temp" + tempCounter + ")");
						fotranTemporaries.put("rand_temp" + tempCounter, new BasicMatrixValue(
								null, 
								PrimitiveClassReference.DOUBLE, 
								new ShapeFactory<AggrValue<BasicMatrixValue>>().newShapeFromInputString("?*?"), 
								null, 
								new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
								.newisComplexInfoFromStr("REAL")
								));
						if (ifWhileForBlockNest != 0) {
							stmtSecForIfWhileForBlock.addStatement(fSubroutines);
						}
						else {
							subprogram.getStatementSection().addStatement(fSubroutines);
						}
						sb.append("rand_temp" + tempCounter);
						if (passCounter > 0) {
							tempCounter++;
						}
					}
					else if (name.equals("horzcat")) {
						if (node.getChild(1).getChild(0) instanceof StringLiteralExpr 
								&& node.getChild(1).getChild(1) instanceof StringLiteralExpr) {
							node.getChild(1).getChild(0).analyze(this);
							sb.append(" // ");
							node.getChild(1).getChild(1).analyze(this);
						}
						else if (node.getChild(1).getChild(0) instanceof NameExpr 
								&& getMatrixValue(((NameExpr)node.getChild(1).getChild(0)).getName()
										.getID()).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
								&& node.getChild(1).getChild(1) instanceof NameExpr 
								&& getMatrixValue(((NameExpr)node.getChild(1).getChild(1)).getName()
										.getID()).getMatlabClass().equals(PrimitiveClassReference.CHAR)) {
							node.getChild(1).getChild(0).analyze(this);
							sb.append(" // ");
							node.getChild(1).getChild(1).analyze(this);
						}
						else if (shapeOp1.isScalar() && shapeOp2.isScalar()) {
							rhsArrayAssign = true;
							sb.append("[");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(", ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append("]");
						}
						else {
							rhsArrayAssign = true;
							horzcat = true;
							node.getChild(1).getChild(0).analyze(this);
							sb.append("!! "); // used as delimiter
							node.getChild(1).getChild(1).analyze(this);
						}
					}
					else if (name.equals("vertcat")) {
						if (shapeOp1.isScalar() && shapeOp2.isScalar()) {
							// using RESHAPE function in fortran to make multidimensional array.
							sb.append("RESHAPE(SOURCE = (/");
							node.getChild(1).getChild(0).analyze(this);
							sb.append(", ");
							node.getChild(1).getChild(1).analyze(this);
							sb.append("/), SHAPE = (/2, 1/))");
						}
						else {
							rhsArrayAssign = true;
							vertcat = true;
							node.getChild(1).getChild(0).analyze(this);
							sb.append("!! "); // used as delimiter
							node.getChild(1).getChild(1).analyze(this);
						}
					}
				}
				else {
					// no directly-mapping functions, also leave the hole.
					sb.append(name + "(");
					node.getChild(1).getChild(0).analyze(this);
					sb.append(", ");
					node.getChild(1).getChild(1).analyze(this);
					sb.append(")");
					allSubprograms.add(name);
				}
			}
			/*
			 * functions with more than two inputs, leave the hole.
			 */
			else {
				if (fortranMapping.isFortranEasilyTransformed(name)) {
					if (name.equals("colon")) {
						if (insideArray > 0) {
							// TODO
						}
						else {
							sb.append("[(FI, FI=INT(");
							node.getChild(1).getChild(0).analyze(this);
							sb.append("),INT(");
							node.getChild(1).getChild(2).analyze(this);
							sb.append("),INT(");
							node.getChild(1).getChild(1).analyze(this);
							sb.append("))]");
							fotranTemporaries.put("FI", new BasicMatrixValue(
									null, 
									PrimitiveClassReference.INT32, 
									new ShapeFactory<AggrValue<BasicMatrixValue>>().getScalarShape(), 
									null, 
									new isComplexInfoFactory<AggrValue<BasicMatrixValue>>()
									.newisComplexInfoFromStr("REAL")
									));
							if (rightOfAssign) {
								colonAlloc = true;
							}
						}							
					}
					else if (name.equals("horzcat")) {
						if (node.getChild(1).getChild(0) instanceof StringLiteralExpr 
								|| (node.getChild(1).getChild(0) instanceof NameExpr 
										&& getMatrixValue(((NameExpr)node.getChild(1)
												.getChild(0)).getName().getID()).getMatlabClass()
												.equals(PrimitiveClassReference.CHAR))) {
							for (int i = 0; i < inputNum; i++) {
								node.getChild(1).getChild(i).analyze(this);
								if (i < inputNum - 1) {
									sb.append(" // ");
								}
							}
						}
						else {
							rhsArrayAssign = true;
							sb.append("[");
							for (int i = 0; i < inputNum; i++) {
								node.getChild(1).getChild(i).analyze(this);
								if (i < inputNum - 1) {
									sb.append(", ");
								}
							}
							sb.append("]");
						}
					}
					else if (name.equals("vertcat")) {
						rhsArrayAssign = true;
						vertcat = true;
						// TODO what if the inputs are all scalars.
						for (int i = 0; i < inputNum; i++) {
							node.getChild(1).getChild(i).analyze(this);
							if (i < inputNum - 1) {
								sb.append("!! "); // used as delimiter
							}
						}
					}
				}
				else {
					sb.append(name + "(");
					StringBuffer sb_bk = new StringBuffer();
					for (int i = 0; i < inputNum; i++) {
						sb_bk.append(sb);
						sb.setLength(0);
						try {
							node.getChild(1).getChild(i).analyze(this);
							int intArg = Integer.parseInt(sb.toString());
							sb.setLength(0);
							sb.append(sb_bk);
							if (userDefinedFunctions.contains(name)) {
								sb.append("DBLE(" + intArg + ")");
							}
							else {
								sb.append(intArg);
							}
						} catch (Exception e) {
							sb.setLength(0);
							sb.append(sb_bk);
							node.getChild(1).getChild(i).analyze(this);
						}
						if (i < inputNum - 1) {
							sb.append(", ");
						}
						sb_bk.setLength(0);
					}
					sb.append(")");
					allSubprograms.add(name);						
				}
			}
		}		
	}
	
	@Override
	public void caseName(Name node) {
		// what is the difference from cseNameExpr?
		System.err.println(node.getID());
	}
	
	@Override
	public void caseNameExpr(NameExpr node) {
		String name = node.getName().getID();
		if (Debug) System.out.println("nameExpr:" + name);
		if (remainingVars.contains(name)) {
			if (Debug) System.out.println(name+" is a variable.");
			if (inArgs.contains(name) && leftOfAssign && insideArray == 0) {
				inputHasChanged.add(name);
			}
			if (mustBeInt) forceToInt.add(name);
			if (!functionName.equals(entryPointFile) 
					&& !isInSubroutine 
					&& outRes.contains(name)) {
				sb.append(functionName);
			}
			else if (functionName.equals(entryPointFile) && inArgs.contains(name)) {
				inputsUsed.add(name);
				sb.append(name);
			}
			else {
				if (!getMatrixValue(name).getShape().isConstant() 
						&& !(node.getParent() instanceof AssignStmt) 
						&& leftOfAssign 
						&& !horzcat // TODO double check this later
						&& !vertcat 
						&& colonAlloc 
						&& !allocatedArrays.contains(name)) {
					allocatedArrays.add(name);
					/*
					 * well, this is one option to add runtime allocate, we can also 
					 * add runtime allocate in assignment statement.
					 */
					sbForRuntimeInline.append("! seems need runtime allocate before assigning.\n");
					AssignStmt reference = (AssignStmt)node.getParent().getParent()
							.getParent().getParent().getParent();
					StringBuffer backBuffer = new StringBuffer(sb);
					sb.setLength(0);
					leftOfAssign = false;
					rightOfAssign = true;
					reference.getRHS().analyze(this);
					rightOfAssign = false;
					leftOfAssign = true;
					String rhsString = sb.toString();
					sb.setLength(0);
					sb.append(backBuffer);
					if (getMatrixValue(name).getShape().isRowVector()) {
						sbForRuntimeInline.append(getMoreIndent(0) 
								+ "IF (.NOT.ALLOCATED(" + name + ")) THEN\n" 
								+ getMoreIndent(1) + "ALLOCATE(" + name + "(1, SIZE(" + rhsString + ")));\n" 
								+ getMoreIndent(0) + "END IF\n");
					}
					else if (getMatrixValue(name).getShape().isColVector()) {
						sbForRuntimeInline.append(getMoreIndent(0) 
								+ "IF (.NOT.ALLOCATED(" + name + ")) THEN\n" 
								+ getMoreIndent(1) + "ALLOCATE(" + name + "(SIZE(" + rhsString + "), 1));\n" 
								+ getMoreIndent(0) + "END IF\n");
					}
				}
				/*
				 * hack to convert 2 ranks array to 1 rank vector in Fortran, 
				 * only add these trailings when both sides of the assignment
				 * are arrays.
				 */
				// for lhs.
				if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR)
						&& getMatrixValue(name).getShape().isRowVector() 
						&& getMatrixValue(name).getShape().isConstant() 
						&& leftOfAssign 
						&& insideArray == 0 
						&& rhsArrayAssign) {
					sb.append(name + "(1, :)");
				}
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
						&& getMatrixValue(name).getShape().isColVector() 
						&& getMatrixValue(name).getShape().isConstant() 
						&& leftOfAssign 
						&& insideArray == 0 
						&& rhsArrayAssign) {
					sb.append(name + "(:, 1)");
				}
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR)
						&& getMatrixValue(name).getShape().isRowVector() 
						&& leftOfAssign 
						&& insideArray == 0 
						&& !horzcat // TODO double check this later.
						&& !vertcat 
						&& colonAlloc) {
					sb.append(name + "(1, :)");
					colonAlloc = false;
				}
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
						&& getMatrixValue(name).getShape().isColVector() 
						&& leftOfAssign 
						&& insideArray == 0 
						&& !horzcat // TODO double check this later.
						&& !vertcat 
						&& colonAlloc) {
					sb.append(name + "(:, 1)");
					colonAlloc = false;
				}
				// for rhs.
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
						&& getMatrixValue(name).getShape().isRowVector() 
						&& getMatrixValue(name).getShape().isConstant() 
						&& rightOfAssign 
						&& insideArray == 0 
						&& node.getParent().getParent() instanceof ParameterizedExpr 
						&& !((NameExpr)((ParameterizedExpr)(node.getParent()
								.getParent())).getChild(0)).getName().getID().equals("transpose")) {
					sb.append(name + "(1, :)");
					rhsArrayAssign = true;
				}
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
						&& getMatrixValue(name).getShape().isColVector() 
						&& getMatrixValue(name).getShape().isConstant() 
						&& rightOfAssign 
						&& insideArray == 0 
						&& node.getParent().getParent() instanceof ParameterizedExpr 
						&& !((NameExpr)((ParameterizedExpr)(node.getParent()
								.getParent())).getChild(0)).getName().getID().equals("transpose")) {
					sb.append(name + "(:, 1)");
					rhsArrayAssign = true;
				}
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
						&& getMatrixValue(name).getShape().isRowVector() 
						&& rightOfAssign 
						&& insideArray == 0 
						&& node.getParent().getParent() instanceof ParameterizedExpr 
						&& !((NameExpr)((ParameterizedExpr)(node.getParent()
								.getParent())).getChild(0)).getName().getID().equals("transpose") 
						&& !((NameExpr)((ParameterizedExpr)(node.getParent()
								.getParent())).getChild(0)).getName().getID().equals("mtimes")) {
					sb.append(name + "(1, :)");
					rhsArrayAssign = true;
				}
				else if (!getMatrixValue(name).getMatlabClass().equals(PrimitiveClassReference.CHAR) 
						&& getMatrixValue(name).getShape().isColVector() 
						&& rightOfAssign 
						&& insideArray == 0 
						&& node.getParent().getParent() instanceof ParameterizedExpr 
						&& !((NameExpr)((ParameterizedExpr)(node.getParent()
								.getParent())).getChild(0)).getName().getID().equals("transpose") 
						&& !((NameExpr)((ParameterizedExpr)(node.getParent()
								.getParent())).getChild(0)).getName().getID().equals("mtimes")) {
					sb.append(name + "(:, 1)");
					rhsArrayAssign = true;
				}
				else {
					if (forceToInt.contains(name) && rightOfAssign && insideArray == 0) {
						sb.append("DBLE(" + name + ")");
					}
					else {
						sb.append(name);
					}
				}
			}
			
		}
		else {
			if (Debug) System.out.println(name+" is a function name.");
			sb.append(name);
		}
	}
	
	@Override
	public void caseLiteralExpr(LiteralExpr node) {
		if (Debug) System.out.println("liter: "+node.getPrettyPrinted());
		sb.append(node.getPrettyPrinted());
	}
	
	@Override
	public void caseForStmt(ForStmt node) {
		HandleCaseForStmt forStmt = new HandleCaseForStmt();
		if(ifWhileForBlockNest!=0) 
			stmtSecForIfWhileForBlock.addStatement(forStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(forStmt.getFortran(this, node));
    }
	
	@Override
	public void caseRangeExpr(RangeExpr node) {
		if (node.getNumChild() == 3) {
			if (Debug) System.out.println("has increment.");
			/*
			 * start
			 */
			if (!forLoopTransform 
					&& node.getChild(0) instanceof NameExpr 
					&& !forceToInt.contains(((NameExpr)node.getChild(0)).getName().getID())
					&& !getMatrixValue(((NameExpr)node.getChild(0)).getName().getID())
					.getMatlabClass().equals(PrimitiveClassReference.INT32)) {
				sb.append("INT(");
				node.getChild(0).analyze(this);
				sb.append(")");
			}
			else if (!forLoopTransform 
						&& node.getChild(0) instanceof ParameterizedExpr) {
				/*
				 * back up the StringBuffer, test whether the step is integer.
				 */
				StringBuffer sb_bk = new StringBuffer();
				sb_bk.append(sb);
				sb.setLength(0);
				try {
					node.getChild(0).analyze(this);
					int step = Integer.parseInt(sb.toString());
					sb.setLength(0);
					sb.append(sb_bk);
					sb.append(step);
				} catch (Exception e) {
					sb.setLength(0);
					sb.append(sb_bk);
					sb.append("INT(");
					node.getChild(0).analyze(this);
					sb.append(")");
				}
			}
			else {
				node.getChild(0).analyze(this);
			}
			sb.append(", ");
			/*
			 * end
			 */
			if (!forLoopTransform 
					&& node.getChild(2) instanceof NameExpr 
					&& !forceToInt.contains(((NameExpr)node.getChild(2)).getName().getID())
					&& !getMatrixValue(((NameExpr)node.getChild(2)).getName().getID())
					.getMatlabClass().equals(PrimitiveClassReference.INT32)) {
				sb.append("INT(");
				node.getChild(2).analyze(this);
				sb.append(")");
			}
			else if (!forLoopTransform 
						&& node.getChild(2) instanceof ParameterizedExpr) {
				/*
				 * back up the StringBuffer, test whether the step is integer.
				 */
				StringBuffer sb_bk = new StringBuffer();
				sb_bk.append(sb);
				sb.setLength(0);
				try {
					node.getChild(2).analyze(this);
					int step = Integer.parseInt(sb.toString());
					sb.setLength(0);
					sb.append(sb_bk);
					sb.append(step);
				} catch (Exception e) {
					sb.setLength(0);
					sb.append(sb_bk);
					sb.append("INT(");
					node.getChild(2).analyze(this);
					sb.append(")");
				}
			}
			else {
				node.getChild(2).analyze(this);
			}
			/*
			 * step
			 */
			if (node.getChild(1).getNumChild() != 0) {
				sb.append(", ");
				if (!forLoopTransform 
						&& node.getChild(1).getChild(0) instanceof NameExpr 
						&& !forceToInt.contains(((NameExpr)node.getChild(1).getChild(0)).getName().getID())
						&& !getMatrixValue(((NameExpr)node.getChild(1).getChild(0)).getName().getID())
						.getMatlabClass().equals(PrimitiveClassReference.INT32)) {
					sb.append("INT(");
					node.getChild(1).getChild(0).analyze(this);
					sb.append(")");
				}
				else if (!forLoopTransform 
							&& node.getChild(1).getChild(0) instanceof ParameterizedExpr) {
					/*
					 * back up the StringBuffer, test whether the step is integer.
					 */
					StringBuffer sb_bk = new StringBuffer();
					sb_bk.append(sb);
					sb.setLength(0);
					try {
						node.getChild(1).getChild(0).analyze(this);
						int step = Integer.parseInt(sb.toString());
						sb.setLength(0);
						sb.append(sb_bk);
						sb.append(step);
					} catch (Exception e) {
						sb.setLength(0);
						sb.append(sb_bk);
						sb.append("INT(");
						node.getChild(1).getChild(0).analyze(this);
						sb.append(")");
					}
				}
				else {
					node.getChild(1).getChild(0).analyze(this);
				}
			}
		}
		else {
			System.err.println("how does this happen?");
			System.exit(0);
		}
	}
	
	@Override
	public void caseIfStmt(IfStmt node) {
		HandleCaseIfStmt ifStmt = new HandleCaseIfStmt();
		if (ifWhileForBlockNest!=0) 
			stmtSecForIfWhileForBlock.addStatement(ifStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(ifStmt.getFortran(this, node));
	}
	
	@Override
	public void caseWhileStmt(WhileStmt node) {
		HandleCaseWhileStmt whileStmt = new HandleCaseWhileStmt();
		if (ifWhileForBlockNest!=0) 
			stmtSecForIfWhileForBlock.addStatement(whileStmt.getFortran(this, node));
		else 
			subprogram.getStatementSection().addStatement(whileStmt.getFortran(this, node));
	}
	
	@Override
	public void caseBreakStmt(BreakStmt node) {
		// TODO add an exit statment.
		FBreakStmt breakStmt = new FBreakStmt();
		breakStmt.setIndent(getMoreIndent(0));
		breakStmt.setFBreak("EXIT;");
		if (ifWhileForBlockNest != 0) {
			stmtSecForIfWhileForBlock.addStatement(breakStmt);
		}
		else {
			subprogram.getStatementSection().addStatement(breakStmt);
		}
	}
	
	@Override
	public void caseMatrixExpr(MatrixExpr node) {
		for (int i=0; i<node.getNumChild(); i++) {
			node.getChild(i).analyze(this);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public void caseList(List node) {
		for (int i=0; i<node.getNumChild(); i++) {
			if (Debug) System.out.println(node.getNumChild());
			if (!(node.getChild(i) instanceof EmptyStmt)) {
				if (node.getChild(i) instanceof NameExpr 
						&& insideArray > 0 
						&& !forceToInt.contains(((NameExpr)node.getChild(i)).getName().getID())
						&& !getMatrixValue(((NameExpr)node.getChild(i)).getName().getID())
						.getMatlabClass().equals(PrimitiveClassReference.INT32)) {
					if (Debug) System.out.println("I am a variable index!");
					sb.append("INT(");
					node.getChild(i).analyze(this);
					sb.append(")");
				}
				else if (node.getChild(i) instanceof ParameterizedExpr 
						&& !((NameExpr) node.getChild(i).getChild(0)).getName().getID().equals("colon") 
						&& insideArray > 0) {
					if (Debug) System.out.println("I am a variable index!");
					sb.append("INT(");
					node.getChild(i).analyze(this);
					sb.append(")");
				}
				else {
					node.getChild(i).analyze(this);
				}
				if (insideArray > 0 && i < node.getNumChild()-1) sb.append(", ");
			}
			else {
				// for comment statements, which are instances of EmpyStmt.
				node.getChild(i).analyze(this);
			}
		}
	}
	
	@Override
	public void caseColonExpr(ColonExpr node) {
		sb.append(":");
	}
	
	@Override
	public void caseRow(Row node) {
		node.getElementList().analyze(this);
	}
	
	// ******************************helper methods****************************
	public static Subprogram generateFortran(
			Function fNode, 
			ValueFlowMap<AggrValue<BasicMatrixValue>> currentOutSet, 
			Set<String> remainingVars, 
			String entryPointFile, 
			Set<String> userDefinedFunctions, 
			AnalysisEngine analysisEngine, 
			boolean nocheck) 
	{
		return new FortranCodeASTGenerator(
				fNode, 
				currentOutSet, 
				remainingVars, 
				entryPointFile, 
				userDefinedFunctions, 
				analysisEngine, 
				nocheck).subprogram;
	}

	public void iterateStatements(ast.List<ast.Stmt> stmts) {
		for (ast.Stmt stmt : stmts) {
			if (!(stmt instanceof TIRCommentStmt))
				stmt.analyze(this);
			else 
				stmt.analyze(this);
		}
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
		return (BasicMatrixValue) currentOutSet.get(variable).getSingleton();
	}
	
	public boolean isCell(String variable) {
		if (currentOutSet.get(variable).getSingleton() instanceof CellValue) 
			return true;
		else 
			return false;
	}
	
	public boolean hasSingleton(String variable) {
		if (currentOutSet.get(variable).getSingleton() == null) 
			return false;
		else 
			return true;
	}
	
	public String getMoreIndent(int n) {
		String res = "";
		n += indentNum;
		while (n > 0) {
			res += standardIndent;
			n--;
		}
		return res;
	}
	
	public boolean isNeedLinearTransform(ParameterizedExpr node) {
		// no need to check whether the node is array indexing again.
		for (int i = 0; i < node.getChild(1).getNumChild(); i++) {
			if (node.getChild(1).getChild(i) instanceof NameExpr) {
				Shape<AggrValue<BasicMatrixValue>> shapeOfIndex = getMatrixValue(
						((NameExpr)node.getChild(1).getChild(i))
						.getName().getID()).getShape();
				if (!shapeOfIndex.isScalar() && node.getChild(0) instanceof NameExpr 
						&& getMatrixValue(((NameExpr)node.getChild(0)).getName()
								.getID()).getShape().getDimensions().get(i).equalsOne()) {
					return true;
				}
				else if (!shapeOfIndex.isScalar() && !shapeOfIndex.maybeVector()) {
					return true;
				}
			}
			else if (node.getChild(1).getChild(i) instanceof ParameterizedExpr) {
				Shape<AggrValue<BasicMatrixValue>> shapeOfIndex = getMatrixValue(
						((Name)analysisEngine.getTemporaryVariablesRemovalAnalysis()
								.getExprToTempVarTable().get(node.getChild(1)
										.getChild(i))).getID()).getShape();
				if (!shapeOfIndex.isScalar() && node.getChild(0) instanceof NameExpr 
						&& getMatrixValue(((NameExpr)node.getChild(0)).getName()
								.getID()).getShape().getDimensions().get(i).equalsOne()) {
					return true;
				}
				else if (!shapeOfIndex.isScalar() && !shapeOfIndex.maybeVector()) {
					return true;
				}
			}
			// TODO other cases.
		}
		return false;
	}
}
