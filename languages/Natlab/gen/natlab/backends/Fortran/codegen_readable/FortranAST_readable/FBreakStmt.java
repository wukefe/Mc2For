/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:32
 * @production FBreakStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;FBreak:String&gt;</span>;

 */
public class FBreakStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:184
   */
  public void pp(StringBuffer sb) {
    	sb.append(getIndent());
    	sb.append(getFBreak());
    }
  /**
   * @declaredat ASTNode:1
   */
  public FBreakStmt() {
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
  }
  /**
   * @declaredat ASTNode:12
   */
  public FBreakStmt(String p0, String p1) {
    setIndent(p0);
    setFBreak(p1);
  }
  /**
   * @declaredat ASTNode:16
   */
  public FBreakStmt(beaver.Symbol p0, beaver.Symbol p1) {
    setIndent(p0);
    setFBreak(p1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:23
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:29
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:35
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:41
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:47
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:53
   */
  public FBreakStmt clone() throws CloneNotSupportedException {
    FBreakStmt node = (FBreakStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:60
   */
  public FBreakStmt copy() {
    try {
      FBreakStmt node = (FBreakStmt) clone();
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
   * @declaredat ASTNode:79
   */
  public FBreakStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:88
   */
  public FBreakStmt treeCopyNoTransform() {
    FBreakStmt tree = (FBreakStmt) copy();
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
   * @declaredat ASTNode:108
   */
  public FBreakStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:115
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((FBreakStmt)node).tokenString_Indent) && (tokenString_FBreak == ((FBreakStmt)node).tokenString_FBreak);    
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
   * Replaces the lexeme FBreak.
   * @param value The new value for the lexeme FBreak.
   * @apilevel high-level
   */
  public void setFBreak(String value) {
    tokenString_FBreak = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FBreak;
  /**
   */
  public int FBreakstart;
  /**
   */
  public int FBreakend;
  /**
   * JastAdd-internal setter for lexeme FBreak using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FBreak
   * @apilevel internal
   */
  public void setFBreak(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFBreak is only valid for String lexemes");
    tokenString_FBreak = (String)symbol.value;
    FBreakstart = symbol.getStart();
    FBreakend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FBreak.
   * @return The value for the lexeme FBreak.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FBreak")
  public String getFBreak() {
    return tokenString_FBreak != null ? tokenString_FBreak : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
