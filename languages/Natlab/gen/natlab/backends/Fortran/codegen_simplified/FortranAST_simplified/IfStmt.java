/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:41
 * @production IfStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;Condition:String&gt;</span> <span class="component">IfBlock:{@link StatementSection}</span> <span class="component">[ElseBlock:{@link StatementSection}]</span>;

 */
public class IfStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:226
   */
  public void pp(StringBuffer sb) {
    	sb.append(getIndent());
    	sb.append("IF ("+getCondition()+") THEN\n");
    	getIfBlock().pp(sb);
    	if (hasElseBlock()) {
    		sb.append(getIndent());
    		sb.append("ELSE\n");
    		getElseBlock().pp(sb);
    	}
    	sb.append(getIndent()+"ENDIF");
    }
  /**
   * @declaredat ASTNode:1
   */
  public IfStmt() {
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
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:14
   */
  public IfStmt(String p0, String p1, StatementSection p2, Opt<StatementSection> p3) {
    setIndent(p0);
    setCondition(p1);
    setChild(p2, 0);
    setChild(p3, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IfStmt(beaver.Symbol p0, beaver.Symbol p1, StatementSection p2, Opt<StatementSection> p3) {
    setIndent(p0);
    setCondition(p1);
    setChild(p2, 0);
    setChild(p3, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:29
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:35
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:41
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:47
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:53
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:59
   */
  public IfStmt clone() throws CloneNotSupportedException {
    IfStmt node = (IfStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:66
   */
  public IfStmt copy() {
    try {
      IfStmt node = (IfStmt) clone();
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
   * @declaredat ASTNode:85
   */
  public IfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:94
   */
  public IfStmt treeCopyNoTransform() {
    IfStmt tree = (IfStmt) copy();
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
   * @declaredat ASTNode:114
   */
  public IfStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:121
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((IfStmt)node).tokenString_Indent) && (tokenString_Condition == ((IfStmt)node).tokenString_Condition);    
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
   * Replaces the IfBlock child.
   * @param node The new node to replace the IfBlock child.
   * @apilevel high-level
   */
  public void setIfBlock(StatementSection node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the IfBlock child.
   * @return The current node used as the IfBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="IfBlock")
  public StatementSection getIfBlock() {
    return (StatementSection) getChild(0);
  }
  /**
   * Retrieves the IfBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the IfBlock child.
   * @apilevel low-level
   */
  public StatementSection getIfBlockNoTransform() {
    return (StatementSection) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the ElseBlock child. This is the <code>Opt</code>
   * node containing the child ElseBlock, not the actual child!
   * @param opt The new node to be used as the optional node for the ElseBlock child.
   * @apilevel low-level
   */
  public void setElseBlockOpt(Opt<StatementSection> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) ElseBlock child.
   * @param node The new node to be used as the ElseBlock child.
   * @apilevel high-level
   */
  public void setElseBlock(StatementSection node) {
    getElseBlockOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ElseBlock child exists.
   * @return {@code true} if the optional ElseBlock child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasElseBlock() {
    return getElseBlockOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ElseBlock child.
   * @return The ElseBlock child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public StatementSection getElseBlock() {
    return (StatementSection) getElseBlockOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ElseBlock child. This is the <code>Opt</code> node containing the child ElseBlock, not the actual child!
   * @return The optional node for child the ElseBlock child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ElseBlock")
  public Opt<StatementSection> getElseBlockOpt() {
    return (Opt<StatementSection>) getChild(1);
  }
  /**
   * Retrieves the optional node for child ElseBlock. This is the <code>Opt</code> node containing the child ElseBlock, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ElseBlock.
   * @apilevel low-level
   */
  public Opt<StatementSection> getElseBlockOptNoTransform() {
    return (Opt<StatementSection>) getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
