/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:36
 * @production FWhileStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;FWhileCondition:String&gt;</span> <span class="component">FWhileBlock:{@link StatementSection}</span>;

 */
public class FWhileStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:201
   */
  public void pp(StringBuffer sb) {
   	 	sb.append(getIndent());
    	sb.append("DO WHILE ("+getFWhileCondition()+")");
    	sb.append("\n");
    	getFWhileBlock().pp(sb);
    	sb.append(getIndent()+"ENDDO");   	
    }
  /**
   * @declaredat ASTNode:1
   */
  public FWhileStmt() {
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
  public FWhileStmt(String p0, String p1, StatementSection p2) {
    setIndent(p0);
    setFWhileCondition(p1);
    setChild(p2, 0);
  }
  /**
   * @declaredat ASTNode:18
   */
  public FWhileStmt(beaver.Symbol p0, beaver.Symbol p1, StatementSection p2) {
    setIndent(p0);
    setFWhileCondition(p1);
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
  public FWhileStmt clone() throws CloneNotSupportedException {
    FWhileStmt node = (FWhileStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:63
   */
  public FWhileStmt copy() {
    try {
      FWhileStmt node = (FWhileStmt) clone();
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
  public FWhileStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:91
   */
  public FWhileStmt treeCopyNoTransform() {
    FWhileStmt tree = (FWhileStmt) copy();
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
  public FWhileStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:118
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((FWhileStmt)node).tokenString_Indent) && (tokenString_FWhileCondition == ((FWhileStmt)node).tokenString_FWhileCondition);    
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
   * Replaces the lexeme FWhileCondition.
   * @param value The new value for the lexeme FWhileCondition.
   * @apilevel high-level
   */
  public void setFWhileCondition(String value) {
    tokenString_FWhileCondition = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FWhileCondition;
  /**
   */
  public int FWhileConditionstart;
  /**
   */
  public int FWhileConditionend;
  /**
   * JastAdd-internal setter for lexeme FWhileCondition using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FWhileCondition
   * @apilevel internal
   */
  public void setFWhileCondition(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFWhileCondition is only valid for String lexemes");
    tokenString_FWhileCondition = (String)symbol.value;
    FWhileConditionstart = symbol.getStart();
    FWhileConditionend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FWhileCondition.
   * @return The value for the lexeme FWhileCondition.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FWhileCondition")
  public String getFWhileCondition() {
    return tokenString_FWhileCondition != null ? tokenString_FWhileCondition : "";
  }
  /**
   * Replaces the FWhileBlock child.
   * @param node The new node to replace the FWhileBlock child.
   * @apilevel high-level
   */
  public void setFWhileBlock(StatementSection node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the FWhileBlock child.
   * @return The current node used as the FWhileBlock child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="FWhileBlock")
  public StatementSection getFWhileBlock() {
    return (StatementSection) getChild(0);
  }
  /**
   * Retrieves the FWhileBlock child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the FWhileBlock child.
   * @apilevel low-level
   */
  public StatementSection getFWhileBlockNoTransform() {
    return (StatementSection) getChildNoTransform(0);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
