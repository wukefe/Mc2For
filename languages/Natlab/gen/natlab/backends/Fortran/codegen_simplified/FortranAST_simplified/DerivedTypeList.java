/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:17
 * @production DerivedTypeList : {@link ASTNode} ::= <span class="component">{@link DerivedType}*</span>;

 */
public class DerivedTypeList extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:64
   */
  public void pp(StringBuffer sb) {
    	int size = getNumDerivedType();
    	for (int i=0;i<size;i++) {
    		getDerivedType(i).pp(sb);
    	}
    }
  /**
   * @declaredat ASTNode:1
   */
  public DerivedTypeList() {
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
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public DerivedTypeList(List<DerivedType> p0) {
    setChild(p0, 0);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:20
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:26
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:32
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:38
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:44
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:50
   */
  public DerivedTypeList clone() throws CloneNotSupportedException {
    DerivedTypeList node = (DerivedTypeList) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:57
   */
  public DerivedTypeList copy() {
    try {
      DerivedTypeList node = (DerivedTypeList) clone();
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
   * @declaredat ASTNode:76
   */
  public DerivedTypeList fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:85
   */
  public DerivedTypeList treeCopyNoTransform() {
    DerivedTypeList tree = (DerivedTypeList) copy();
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
   * @declaredat ASTNode:105
   */
  public DerivedTypeList treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:112
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) ;    
  }
  /**
   * Replaces the DerivedType list.
   * @param list The new list node to be used as the DerivedType list.
   * @apilevel high-level
   */
  public void setDerivedTypeList(List<DerivedType> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the DerivedType list.
   * @return Number of children in the DerivedType list.
   * @apilevel high-level
   */
  public int getNumDerivedType() {
    return getDerivedTypeList().getNumChild();
  }
  /**
   * Retrieves the number of children in the DerivedType list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the DerivedType list.
   * @apilevel low-level
   */
  public int getNumDerivedTypeNoTransform() {
    return getDerivedTypeListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the DerivedType list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the DerivedType list.
   * @apilevel high-level
   */
  public DerivedType getDerivedType(int i) {
    return (DerivedType) getDerivedTypeList().getChild(i);
  }
  /**
   * Check whether the DerivedType list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDerivedType() {
    return getDerivedTypeList().getNumChild() != 0;
  }
  /**
   * Append an element to the DerivedType list.
   * @param node The element to append to the DerivedType list.
   * @apilevel high-level
   */
  public void addDerivedType(DerivedType node) {
    List<DerivedType> list = (parent == null || state == null) ? getDerivedTypeListNoTransform() : getDerivedTypeList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addDerivedTypeNoTransform(DerivedType node) {
    List<DerivedType> list = getDerivedTypeListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the DerivedType list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDerivedType(DerivedType node, int i) {
    List<DerivedType> list = getDerivedTypeList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the DerivedType list.
   * @return The node representing the DerivedType list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="DerivedType")
  public List<DerivedType> getDerivedTypeList() {
    List<DerivedType> list = (List<DerivedType>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the DerivedType list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the DerivedType list.
   * @apilevel low-level
   */
  public List<DerivedType> getDerivedTypeListNoTransform() {
    return (List<DerivedType>) getChildNoTransform(0);
  }
  /**
   * Retrieves the DerivedType list.
   * @return The node representing the DerivedType list.
   * @apilevel high-level
   */
  public List<DerivedType> getDerivedTypes() {
    return getDerivedTypeList();
  }
  /**
   * Retrieves the DerivedType list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the DerivedType list.
   * @apilevel low-level
   */
  public List<DerivedType> getDerivedTypesNoTransform() {
    return getDerivedTypeListNoTransform();
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
