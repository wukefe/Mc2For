/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:50
 * @production RigorousIndexingTransformation : {@link ASTNode} ::= <span class="component">&lt;FunctionCall:String&gt;</span>;

 */
public class RigorousIndexingTransformation extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:283
   */
  public void pp(StringBuffer sb) {
    	sb.append(getFunctionCall());
    }
  /**
   * @declaredat ASTNode:1
   */
  public RigorousIndexingTransformation() {
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
  public RigorousIndexingTransformation(String p0) {
    setFunctionCall(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public RigorousIndexingTransformation(beaver.Symbol p0) {
    setFunctionCall(p0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  protected int numChildren() {
    return 0;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:27
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:33
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:39
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:45
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:51
   */
  public RigorousIndexingTransformation clone() throws CloneNotSupportedException {
    RigorousIndexingTransformation node = (RigorousIndexingTransformation) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:58
   */
  public RigorousIndexingTransformation copy() {
    try {
      RigorousIndexingTransformation node = (RigorousIndexingTransformation) clone();
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
   * @declaredat ASTNode:77
   */
  public RigorousIndexingTransformation fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:86
   */
  public RigorousIndexingTransformation treeCopyNoTransform() {
    RigorousIndexingTransformation tree = (RigorousIndexingTransformation) copy();
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
   * @declaredat ASTNode:106
   */
  public RigorousIndexingTransformation treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:113
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_FunctionCall == ((RigorousIndexingTransformation)node).tokenString_FunctionCall);    
  }
  /**
   * Replaces the lexeme FunctionCall.
   * @param value The new value for the lexeme FunctionCall.
   * @apilevel high-level
   */
  public void setFunctionCall(String value) {
    tokenString_FunctionCall = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FunctionCall;
  /**
   */
  public int FunctionCallstart;
  /**
   */
  public int FunctionCallend;
  /**
   * JastAdd-internal setter for lexeme FunctionCall using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FunctionCall
   * @apilevel internal
   */
  public void setFunctionCall(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFunctionCall is only valid for String lexemes");
    tokenString_FunctionCall = (String)symbol.value;
    FunctionCallstart = symbol.getStart();
    FunctionCallend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FunctionCall.
   * @return The value for the lexeme FunctionCall.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FunctionCall")
  public String getFunctionCall() {
    return tokenString_FunctionCall != null ? tokenString_FunctionCall : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
