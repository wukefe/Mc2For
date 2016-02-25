/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:23
 * @production CommentStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">&lt;Comment:String&gt;</span>;

 */
public class CommentStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:129
   */
  public void pp(StringBuffer sb) {
    	if (getComment()!=null) {
    		sb.append(getIndent());
    		sb.append("!");
    		sb.append(getComment());
    	}
    }
  /**
   * @declaredat ASTNode:1
   */
  public CommentStmt() {
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
  public CommentStmt(String p0, String p1) {
    setIndent(p0);
    setComment(p1);
  }
  /**
   * @declaredat ASTNode:16
   */
  public CommentStmt(beaver.Symbol p0, beaver.Symbol p1) {
    setIndent(p0);
    setComment(p1);
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
  public CommentStmt clone() throws CloneNotSupportedException {
    CommentStmt node = (CommentStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:60
   */
  public CommentStmt copy() {
    try {
      CommentStmt node = (CommentStmt) clone();
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
  public CommentStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:88
   */
  public CommentStmt treeCopyNoTransform() {
    CommentStmt tree = (CommentStmt) copy();
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
  public CommentStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:115
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((CommentStmt)node).tokenString_Indent) && (tokenString_Comment == ((CommentStmt)node).tokenString_Comment);    
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
   * Replaces the lexeme Comment.
   * @param value The new value for the lexeme Comment.
   * @apilevel high-level
   */
  public void setComment(String value) {
    tokenString_Comment = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Comment;
  /**
   */
  public int Commentstart;
  /**
   */
  public int Commentend;
  /**
   * JastAdd-internal setter for lexeme Comment using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Comment
   * @apilevel internal
   */
  public void setComment(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setComment is only valid for String lexemes");
    tokenString_Comment = (String)symbol.value;
    Commentstart = symbol.getStart();
    Commentend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Comment.
   * @return The value for the lexeme Comment.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Comment")
  public String getComment() {
    return tokenString_Comment != null ? tokenString_Comment : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
