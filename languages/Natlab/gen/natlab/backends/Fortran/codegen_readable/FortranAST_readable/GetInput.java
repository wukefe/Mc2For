/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:4
 * @production GetInput : {@link ASTNode} ::= <span class="component">&lt;Block:String&gt;</span>;

 */
public class GetInput extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:24
   */
  public void pp(StringBuffer sb) {
    	sb.append(getBlock()+"\n");
    }
  /**
   * @declaredat ASTNode:1
   */
  public GetInput() {
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
  public GetInput(String p0) {
    setBlock(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public GetInput(beaver.Symbol p0) {
    setBlock(p0);
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
  public GetInput clone() throws CloneNotSupportedException {
    GetInput node = (GetInput) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:58
   */
  public GetInput copy() {
    try {
      GetInput node = (GetInput) clone();
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
  public GetInput fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:86
   */
  public GetInput treeCopyNoTransform() {
    GetInput tree = (GetInput) copy();
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
  public GetInput treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:113
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Block == ((GetInput)node).tokenString_Block);    
  }
  /**
   * Replaces the lexeme Block.
   * @param value The new value for the lexeme Block.
   * @apilevel high-level
   */
  public void setBlock(String value) {
    tokenString_Block = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Block;
  /**
   */
  public int Blockstart;
  /**
   */
  public int Blockend;
  /**
   * JastAdd-internal setter for lexeme Block using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Block
   * @apilevel internal
   */
  public void setBlock(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setBlock is only valid for String lexemes");
    tokenString_Block = (String)symbol.value;
    Blockstart = symbol.getStart();
    Blockend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Block.
   * @return The value for the lexeme Block.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Block")
  public String getBlock() {
    return tokenString_Block != null ? tokenString_Block : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
