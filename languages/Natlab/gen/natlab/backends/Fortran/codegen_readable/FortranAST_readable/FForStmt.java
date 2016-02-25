/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:38
 * @production FForStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;FForCondition:String&gt;</span> <span class="component">FForBlock:{@link StatementSection}</span>;

 */
public class FForStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:209
   */
  public void pp(StringBuffer sb) {
    	sb.append(getIndent());
    	sb.append("DO "+getFForCondition()+"\n");
    	getFForBlock().pp(sb);
    	sb.append(getIndent()+"ENDDO");    	
    }
  /**
   * @declaredat ASTNode:1
   */
  public FForStmt() {
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
  public FForStmt(String p0, String p1, StatementSection p2) {
    setIndent(p0);
    setFForCondition(p1);
    setChild(p2, 0);
  }
  /**
   * @declaredat ASTNode:18
   */
  public FForStmt(beaver.Symbol p0, beaver.Symbol p1, StatementSection p2) {
    setIndent(p0);
    setFForCondition(p1);
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
  public FForStmt clone() throws CloneNotSupportedException {
    FForStmt node = (FForStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:63
   */
  public FForStmt copy() {
    try {
      FForStmt node = (FForStmt) clone();
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
  public FForStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:91
   */
  public FForStmt treeCopyNoTransform() {
    FForStmt tree = (FForStmt) copy();
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
  public FForStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:118
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((FForStmt)node).tokenString_Indent) && (tokenString_FForCondition == ((FForStmt)node).tokenString_FForCondition);    
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
   * Replaces the lexeme FForCondition.
   * @param value The new value for the lexeme FForCondition.
   * @apilevel high-level
   */
  public void setFForCondition(String value) {
    tokenString_FForCondition = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FForCondition;
  /**
   */
  public int FForConditionstart;
  /**
   */
  public int FForConditionend;
  /**
   * JastAdd-internal setter for lexeme FForCondition using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FForCondition
   * @apilevel internal
   */
  public void setFForCondition(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFForCondition is only valid for String lexemes");
    tokenString_FForCondition = (String)symbol.value;
    FForConditionstart = symbol.getStart();
    FForConditionend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FForCondition.
   * @return The value for the lexeme FForCondition.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FForCondition")
  public String getFForCondition() {
    return tokenString_FForCondition != null ? tokenString_FForCondition : "";
  }
  /**
   * Replaces the FForBlock child.
   * @param node The new node to replace the FForBlock child.
   * @apilevel high-level
   */
  public void setFForBlock(StatementSection node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FForBlock child.
   * @return The current node used as the FForBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FForBlock")
  public StatementSection getFForBlock() {
    return (StatementSection) getChild(0);
  }
  /**
   * Retrieves the FForBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FForBlock child.
   * @apilevel low-level
   */
  public StatementSection getFForBlockNoTransform() {
    return (StatementSection) getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
