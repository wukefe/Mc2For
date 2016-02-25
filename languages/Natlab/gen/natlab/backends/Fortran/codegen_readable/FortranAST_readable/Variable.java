/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:16
 * @production Variable : {@link ASTNode} ::= <span class="component">&lt;Name:String&gt;</span>;

 */
public class Variable extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:122
   */
  public void pp(StringBuffer sb) {
    	sb.append(getName());
    }
  /**
   * @declaredat ASTNode:1
   */
  public Variable() {
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
  public Variable(String p0) {
    setName(p0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Variable(beaver.Symbol p0) {
    setName(p0);
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
  public Variable clone() throws CloneNotSupportedException {
    Variable node = (Variable) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:58
   */
  public Variable copy() {
    try {
      Variable node = (Variable) clone();
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
  public Variable fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:86
   */
  public Variable treeCopyNoTransform() {
    Variable tree = (Variable) copy();
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
  public Variable treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:113
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Name == ((Variable)node).tokenString_Name);    
  }
  /**
   * Replaces the lexeme Name.
   * @param value The new value for the lexeme Name.
   * @apilevel high-level
   */
  public void setName(String value) {
    tokenString_Name = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Name;
  /**
   */
  public int Namestart;
  /**
   */
  public int Nameend;
  /**
   * JastAdd-internal setter for lexeme Name using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Name
   * @apilevel internal
   */
  public void setName(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setName is only valid for String lexemes");
    tokenString_Name = (String)symbol.value;
    Namestart = symbol.getStart();
    Nameend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Name.
   * @return The value for the lexeme Name.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Name")
  public String getName() {
    return tokenString_Name != null ? tokenString_Name : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
