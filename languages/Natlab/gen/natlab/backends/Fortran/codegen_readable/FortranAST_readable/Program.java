/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:1
 * @production Program : {@link ASTNode} ::= <span class="component">{@link Subprogram}*</span>;

 */
public class Program extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:4
   */
  public void pp(StringBuffer sb) {}
  /**
   * @declaredat ASTNode:1
   */
  public Program() {
    super();
    is$Final(true);
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
    children = new ASTNode[1];
    setChild(new List(), 0);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Program(List<Subprogram> p0) {
    setChild(p0, 0);
    is$Final(true);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:28
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:34
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:40
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:46
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:52
   */
  public Program clone() throws CloneNotSupportedException {
    Program node = (Program) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:59
   */
  public Program copy() {
    try {
      Program node = (Program) clone();
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
   * @declaredat ASTNode:78
   */
  public Program fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:87
   */
  public Program treeCopyNoTransform() {
    Program tree = (Program) copy();
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
   * @declaredat ASTNode:107
   */
  public Program treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:114
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node) ;    
  }
  /**
   * Replaces the Subprogram list.
   * @param list The new list node to be used as the Subprogram list.
   * @apilevel high-level
   */
  public void setSubprogramList(List<Subprogram> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Subprogram list.
   * @return Number of children in the Subprogram list.
   * @apilevel high-level
   */
  public int getNumSubprogram() {
    return getSubprogramList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Subprogram list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Subprogram list.
   * @apilevel low-level
   */
  public int getNumSubprogramNoTransform() {
    return getSubprogramListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Subprogram list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Subprogram list.
   * @apilevel high-level
   */
  public Subprogram getSubprogram(int i) {
    return (Subprogram) getSubprogramList().getChild(i);
  }
  /**
   * Check whether the Subprogram list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasSubprogram() {
    return getSubprogramList().getNumChild() != 0;
  }
  /**
   * Append an element to the Subprogram list.
   * @param node The element to append to the Subprogram list.
   * @apilevel high-level
   */
  public void addSubprogram(Subprogram node) {
    List<Subprogram> list = (parent == null || state == null) ? getSubprogramListNoTransform() : getSubprogramList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addSubprogramNoTransform(Subprogram node) {
    List<Subprogram> list = getSubprogramListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Subprogram list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setSubprogram(Subprogram node, int i) {
    List<Subprogram> list = getSubprogramList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Subprogram list.
   * @return The node representing the Subprogram list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Subprogram")
  public List<Subprogram> getSubprogramList() {
    List<Subprogram> list = (List<Subprogram>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Subprogram list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Subprogram list.
   * @apilevel low-level
   */
  public List<Subprogram> getSubprogramListNoTransform() {
    return (List<Subprogram>) getChildNoTransform(0);
  }
  /**
   * Retrieves the Subprogram list.
   * @return The node representing the Subprogram list.
   * @apilevel high-level
   */
  public List<Subprogram> getSubprograms() {
    return getSubprogramList();
  }
  /**
   * Retrieves the Subprogram list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Subprogram list.
   * @apilevel low-level
   */
  public List<Subprogram> getSubprogramsNoTransform() {
    return getSubprogramListNoTransform();
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
