/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:34
 * @production FIfStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;FIfCondition:String&gt;</span> <span class="component">FIfBlock:{@link StatementSection}</span> <span class="component">[FElseBlock:{@link StatementSection}]</span>;

 */
public class FIfStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:189
   */
  public void pp(StringBuffer sb) {
    	sb.append(getIndent());
    	sb.append("IF ("+getFIfCondition()+") THEN\n");
    	getFIfBlock().pp(sb);
    	if (hasFElseBlock()) {
    		sb.append(getIndent());
    		sb.append("ELSE\n");
    		getFElseBlock().pp(sb);
    	}
    	sb.append(getIndent()+"ENDIF");
    }
  /**
   * @declaredat ASTNode:1
   */
  public FIfStmt() {
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
  public FIfStmt(String p0, String p1, StatementSection p2, Opt<StatementSection> p3) {
    setIndent(p0);
    setFIfCondition(p1);
    setChild(p2, 0);
    setChild(p3, 1);
  }
  /**
   * @declaredat ASTNode:20
   */
  public FIfStmt(beaver.Symbol p0, beaver.Symbol p1, StatementSection p2, Opt<StatementSection> p3) {
    setIndent(p0);
    setFIfCondition(p1);
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
  public FIfStmt clone() throws CloneNotSupportedException {
    FIfStmt node = (FIfStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:66
   */
  public FIfStmt copy() {
    try {
      FIfStmt node = (FIfStmt) clone();
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
  public FIfStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:94
   */
  public FIfStmt treeCopyNoTransform() {
    FIfStmt tree = (FIfStmt) copy();
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
  public FIfStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:121
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((FIfStmt)node).tokenString_Indent) && (tokenString_FIfCondition == ((FIfStmt)node).tokenString_FIfCondition);    
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
   * Replaces the lexeme FIfCondition.
   * @param value The new value for the lexeme FIfCondition.
   * @apilevel high-level
   */
  public void setFIfCondition(String value) {
    tokenString_FIfCondition = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FIfCondition;
  /**
   */
  public int FIfConditionstart;
  /**
   */
  public int FIfConditionend;
  /**
   * JastAdd-internal setter for lexeme FIfCondition using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FIfCondition
   * @apilevel internal
   */
  public void setFIfCondition(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFIfCondition is only valid for String lexemes");
    tokenString_FIfCondition = (String)symbol.value;
    FIfConditionstart = symbol.getStart();
    FIfConditionend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FIfCondition.
   * @return The value for the lexeme FIfCondition.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FIfCondition")
  public String getFIfCondition() {
    return tokenString_FIfCondition != null ? tokenString_FIfCondition : "";
  }
  /**
   * Replaces the FIfBlock child.
   * @param node The new node to replace the FIfBlock child.
   * @apilevel high-level
   */
  public void setFIfBlock(StatementSection node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FIfBlock child.
   * @return The current node used as the FIfBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FIfBlock")
  public StatementSection getFIfBlock() {
    return (StatementSection) getChild(0);
  }
  /**
   * Retrieves the FIfBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FIfBlock child.
   * @apilevel low-level
   */
  public StatementSection getFIfBlockNoTransform() {
    return (StatementSection) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the FElseBlock child. This is the <code>Opt</code>
   * node containing the child FElseBlock, not the actual child!
   * @param opt The new node to be used as the optional node for the FElseBlock child.
   * @apilevel low-level
   */
  public void setFElseBlockOpt(Opt<StatementSection> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) FElseBlock child.
   * @param node The new node to be used as the FElseBlock child.
   * @apilevel high-level
   */
  public void setFElseBlock(StatementSection node) {
    getFElseBlockOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional FElseBlock child exists.
   * @return {@code true} if the optional FElseBlock child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasFElseBlock() {
    return getFElseBlockOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) FElseBlock child.
   * @return The FElseBlock child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public StatementSection getFElseBlock() {
    return (StatementSection) getFElseBlockOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the FElseBlock child. This is the <code>Opt</code> node containing the child FElseBlock, not the actual child!
   * @return The optional node for child the FElseBlock child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="FElseBlock")
  public Opt<StatementSection> getFElseBlockOpt() {
    return (Opt<StatementSection>) getChild(1);
  }
  /**
   * Retrieves the optional node for child FElseBlock. This is the <code>Opt</code> node containing the child FElseBlock, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child FElseBlock.
   * @apilevel low-level
   */
  public Opt<StatementSection> getFElseBlockOptNoTransform() {
    return (Opt<StatementSection>) getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
