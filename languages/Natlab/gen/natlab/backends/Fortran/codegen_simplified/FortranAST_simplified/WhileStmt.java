/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:43
 * @production WhileStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;Condition:String&gt;</span> <span class="component">WhileBlock:{@link StatementSection}</span>;

 */
public class WhileStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:238
   */
  public void pp(StringBuffer sb) {
   	 	sb.append(getIndent());
    	sb.append("DO WHILE ("+getCondition()+")");
    	sb.append("\n");
    	getWhileBlock().pp(sb);
    	sb.append(getIndent()+"ENDDO");   	
    }
  /**
   * @declaredat ASTNode:1
   */
  public WhileStmt() {
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
    children = new ASTNode[1];
  }
  /**
   * @declaredat ASTNode:13
   */
  public WhileStmt(String p0, String p1, StatementSection p2) {
    setIndent(p0);
    setCondition(p1);
    setChild(p2, 0);
  }
  /**
   * @declaredat ASTNode:18
   */
  public WhileStmt(beaver.Symbol p0, beaver.Symbol p1, StatementSection p2) {
    setIndent(p0);
    setCondition(p1);
    setChild(p2, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:26
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:32
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:38
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:50
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:56
   */
  public WhileStmt clone() throws CloneNotSupportedException {
    WhileStmt node = (WhileStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:63
   */
  public WhileStmt copy() {
    try {
      WhileStmt node = (WhileStmt) clone();
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
   * @declaredat ASTNode:82
   */
  public WhileStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:91
   */
  public WhileStmt treeCopyNoTransform() {
    WhileStmt tree = (WhileStmt) copy();
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
   * @declaredat ASTNode:111
   */
  public WhileStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:118
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((WhileStmt)node).tokenString_Indent) && (tokenString_Condition == ((WhileStmt)node).tokenString_Condition);    
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
   * Replaces the lexeme Condition.
   * @param value The new value for the lexeme Condition.
   * @apilevel high-level
   */
  public void setCondition(String value) {
    tokenString_Condition = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Condition;
  /**
   */
  public int Conditionstart;
  /**
   */
  public int Conditionend;
  /**
   * JastAdd-internal setter for lexeme Condition using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Condition
   * @apilevel internal
   */
  public void setCondition(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setCondition is only valid for String lexemes");
    tokenString_Condition = (String)symbol.value;
    Conditionstart = symbol.getStart();
    Conditionend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Condition.
   * @return The value for the lexeme Condition.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Condition")
  public String getCondition() {
    return tokenString_Condition != null ? tokenString_Condition : "";
  }
  /**
   * Replaces the WhileBlock child.
   * @param node The new node to replace the WhileBlock child.
   * @apilevel high-level
   */
  public void setWhileBlock(StatementSection node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the WhileBlock child.
   * @return The current node used as the WhileBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="WhileBlock")
  public StatementSection getWhileBlock() {
    return (StatementSection) getChild(0);
  }
  /**
   * Retrieves the WhileBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the WhileBlock child.
   * @apilevel low-level
   */
  public StatementSection getWhileBlockNoTransform() {
    return (StatementSection) getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
