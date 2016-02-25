package natlab.backends.Fortran.codegen_simplified.astCaseHandler;

import natlab.backends.Fortran.codegen_simplified.FortranCodeASTGenerator;
import natlab.backends.Fortran.codegen_simplified.FortranAST_simplified.Statement;
import natlab.backends.Fortran.codegen_simplified.FortranAST_simplified.StatementSection;
import natlab.backends.Fortran.codegen_simplified.FortranAST_simplified.WhileStmt;
import natlab.tame.tir.TIRWhileStmt;

public class HandleCaseTIRWhileStmt {
	static boolean Debug = false;
	
	/**
	 * WhileStmt: Statement ::= <Condition> WhileBlock: StatementSection;
	 */
	public Statement getFortran(
			FortranCodeASTGenerator fcg, 
			TIRWhileStmt node) {
		if (Debug) System.out.println("in while statement.");		
		WhileStmt stmt = new WhileStmt();
		String indent = new String();
		for (int i=0; i<fcg.indentNum; i++) {
			indent = indent + fcg.standardIndent;
		}
		stmt.setIndent(indent);
		stmt.setCondition(node.getCondition().getVarName());
		/*
		 * backup this pointer! and make fcg.stmtSecForIFWhileForBlock 
		 * point back after iterate for block.
		 */
		StatementSection backup = fcg.stmtSecForIfWhileForBlock;
		
		fcg.ifWhileForBlockNest++;
		StatementSection whileStmtSec = new StatementSection();
		fcg.stmtSecForIfWhileForBlock = whileStmtSec;
		fcg.indentNum++;
		fcg.iterateStatements(node.getStatements());
		stmt.setWhileBlock(whileStmtSec);
		fcg.indentNum--;
		fcg.ifWhileForBlockNest--;
		
		fcg.stmtSecForIfWhileForBlock = backup;
		
		return stmt;
	}
}
