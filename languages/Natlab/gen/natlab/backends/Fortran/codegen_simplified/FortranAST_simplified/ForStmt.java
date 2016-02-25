/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:45
 * @production ForStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;LoopVar:String&gt;</span> <span class="component">&lt;LowBoundary:String&gt;</span> <span class="component">[{@link Inc}]</span> <span class="component">&lt;UpperBoundary:String&gt;</span> <span class="component">ForBlock:{@link StatementSection}</span>;

 */
public class ForStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:246
   */
  public void pp(StringBuffer sb) {
    	sb.append(getIndent());
    	sb.append("DO "+getLoopVar()+" = "+getLowBoundary()+" , ");
    	sb.append(getUpperBoundary());
    	if (hasInc()) {
    		sb.append(" , ");
    		getInc().pp(sb);
    	}
    	sb.append("\n");
    	getForBlock().pp(sb);
    	sb.append(getIndent()+"ENDDO");    	
    }
  /**
   * @declaredat ASTNode:1
   */
  public ForStmt() {
    super();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:10
   */
  public void init$Children() {
    children = new ASTNode[2];
    setChild(new Opt(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public ForStmt(String p0, String p1, String p2, Opt<Inc> p3, String p4, StatementSection p5) {
    setIndent(p0);
    setLoopVar(p1);
    setLowBoundary(p2);
    setChild(p3, 0);
    setUpperBoundary(p4);
    setChild(p5, 1);
  }
  /**
   * @declaredat ASTNode:22
   */
  public ForStmt(beaver.Symbol p0, beaver.Symbol p1, beaver.Symbol p2, Opt<Inc> p3, beaver.Symbol p4, StatementSection p5) {
    setIndent(p0);
    setLoopVar(p1);
    setLowBoundary(p2);
    setChild(p3, 0);
    setUpperBoundary(p4);
    setChild(p5, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:33
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:39
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:45
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:51
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:57
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:63
   */
  public ForStmt clone() throws CloneNotSupportedException {
    ForStmt node = (ForStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:70
   */
  public ForStmt copy() {
    try {
      ForStmt node = (ForStmt) clone();
      node.parent = null;
      if(children != null) {
        node.children = (ASTNode[]) children.clone();
      }
      return node;
    } catch (CloneNotSupportedException e) {
      throw new Error("Error: clone not supported for " + getClass().getName());
    }
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @deprecated Please use treeCopy or treeCopyNoTransform instead
   * @declaredat ASTNode:89
   */
  public ForStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:98
   */
  public ForStmt treeCopyNoTransform() {
    ForStmt tree = (ForStmt) copy();
    if (children != null) {
      for (int i = 0; i < children.length; ++i) {
        ASTNode child = (ASTNode) children[i];
        if(child != null) {
          child = child.treeCopyNoTransform();
          tree.setChild(child, i);
        }
      }
    }
    return tree;
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The subtree of this node is traversed to trigger rewrites before copy.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:118
   */
  public ForStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:125
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((ForStmt)node).tokenString_Indent) && (tokenString_LoopVar == ((ForStmt)node).tokenString_LoopVar) && (tokenString_LowBoundary == ((ForStmt)node).tokenString_LowBoundary) && (tokenString_UpperBoundary == ((ForStmt)node).tokenString_UpperBoundary);    
  }
  /**
   * Replaces the lexeme Indent.
   * @param value The new value for the lexeme Indent.
   * @apilevel high-level
   */
  public void setIndent(String value) {
    tokenString_Indent = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Indent;
  /**
   */
  public int Indentstart;
  /**
   */
  public int Indentend;
  /**
   * JastAdd-internal setter for lexeme Indent using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Indent
   * @apilevel internal
   */
  public void setIndent(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setIndent is only valid for String lexemes");
    tokenString_Indent = (String)symbol.value;
    Indentstart = symbol.getStart();
    Indentend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Indent.
   * @return The value for the lexeme Indent.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Indent")
  public String getIndent() {
    return tokenString_Indent != null ? tokenString_Indent : "";
  }
  /**
   * Replaces the lexeme LoopVar.
   * @param value The new value for the lexeme LoopVar.
   * @apilevel high-level
   */
  public void setLoopVar(String value) {
    tokenString_LoopVar = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_LoopVar;
  /**
   */
  public int LoopVarstart;
  /**
   */
  public int LoopVarend;
  /**
   * JastAdd-internal setter for lexeme LoopVar using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme LoopVar
   * @apilevel internal
   */
  public void setLoopVar(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setLoopVar is only valid for String lexemes");
    tokenString_LoopVar = (String)symbol.value;
    LoopVarstart = symbol.getStart();
    LoopVarend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme LoopVar.
   * @return The value for the lexeme LoopVar.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="LoopVar")
  public String getLoopVar() {
    return tokenString_LoopVar != null ? tokenString_LoopVar : "";
  }
  /**
   * Replaces the lexeme LowBoundary.
   * @param value The new value for the lexeme LowBoundary.
   * @apilevel high-level
   */
  public void setLowBoundary(String value) {
    tokenString_LowBoundary = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_LowBoundary;
  /**
   */
  public int LowBoundarystart;
  /**
   */
  public int LowBoundaryend;
  /**
   * JastAdd-internal setter for lexeme LowBoundary using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme LowBoundary
   * @apilevel internal
   */
  public void setLowBoundary(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setLowBoundary is only valid for String lexemes");
    tokenString_LowBoundary = (String)symbol.value;
    LowBoundarystart = symbol.getStart();
    LowBoundaryend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme LowBoundary.
   * @return The value for the lexeme LowBoundary.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="LowBoundary")
  public String getLowBoundary() {
    return tokenString_LowBoundary != null ? tokenString_LowBoundary : "";
  }
  /**
   * Replaces the optional node for the Inc child. This is the <code>Opt</code>
   * node containing the child Inc, not the actual child!
   * @param opt The new node to be used as the optional node for the Inc child.
   * @apilevel low-level
   */
  public void setIncOpt(Opt<Inc> opt) {
    setChild(opt, 0);
  }
  /**
   * Replaces the (optional) Inc child.
   * @param node The new node to be used as the Inc child.
   * @apilevel high-level
   */
  public void setInc(Inc node) {
    getIncOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional Inc child exists.
   * @return {@code true} if the optional Inc child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasInc() {
    return getIncOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) Inc child.
   * @return The Inc child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public Inc getInc() {
    return (Inc) getIncOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the Inc child. This is the <code>Opt</code> node containing the child Inc, not the actual child!
   * @return The optional node for child the Inc child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="Inc")
  public Opt<Inc> getIncOpt() {
    return (Opt<Inc>) getChild(0);
  }
  /**
   * Retrieves the optional node for child Inc. This is the <code>Opt</code> node containing the child Inc, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child Inc.
   * @apilevel low-level
   */
  public Opt<Inc> getIncOptNoTransform() {
    return (Opt<Inc>) getChildNoTransform(0);
  }
  /**
   * Replaces the lexeme UpperBoundary.
   * @param value The new value for the lexeme UpperBoundary.
   * @apilevel high-level
   */
  public void setUpperBoundary(String value) {
    tokenString_UpperBoundary = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_UpperBoundary;
  /**
   */
  public int UpperBoundarystart;
  /**
   */
  public int UpperBoundaryend;
  /**
   * JastAdd-internal setter for lexeme UpperBoundary using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme UpperBoundary
   * @apilevel internal
   */
  public void setUpperBoundary(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setUpperBoundary is only valid for String lexemes");
    tokenString_UpperBoundary = (String)symbol.value;
    UpperBoundarystart = symbol.getStart();
    UpperBoundaryend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme UpperBoundary.
   * @return The value for the lexeme UpperBoundary.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="UpperBoundary")
  public String getUpperBoundary() {
    return tokenString_UpperBoundary != null ? tokenString_UpperBoundary : "";
  }
  /**
   * Replaces the ForBlock child.
   * @param node The new node to replace the ForBlock child.
   * @apilevel high-level
   */
  public void setForBlock(StatementSection node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the ForBlock child.
   * @return The current node used as the ForBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="ForBlock")
  public StatementSection getForBlock() {
    return (StatementSection) getChild(1);
  }
  /**
   * Retrieves the ForBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ForBlock child.
   * @apilevel low-level
   */
  public StatementSection getForBlockNoTransform() {
    return (StatementSection) getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
