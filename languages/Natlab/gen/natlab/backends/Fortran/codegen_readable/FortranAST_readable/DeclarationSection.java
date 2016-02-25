/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:11
 * @production DeclarationSection : {@link ASTNode} ::= <span class="component">{@link DeclStmt}*</span> <span class="component">[{@link DerivedTypeList}]</span>;

 */
public class DeclarationSection extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:60
   */
  public void pp(StringBuffer sb) {
    	int size = getNumDeclStmt();
    	for (int i=0;i<size;i++) {
    		getDeclStmt(i).pp(sb);
    		sb.append("\n");
    	}
    	if (hasDerivedTypeList()) {
    		getDerivedTypeList().pp(sb);
    	}
    }
  /**
   * @declaredat ASTNode:1
   */
  public DeclarationSection() {
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
    setChild(new List(), 0);
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public DeclarationSection(List<DeclStmt> p0, Opt<DerivedTypeList> p1) {
    setChild(p0, 0);
    setChild(p1, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:22
   */
  protected int numChildren() {
    return 2;
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
  public DeclarationSection clone() throws CloneNotSupportedException {
    DeclarationSection node = (DeclarationSection) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:59
   */
  public DeclarationSection copy() {
    try {
      DeclarationSection node = (DeclarationSection) clone();
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
  public DeclarationSection fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:87
   */
  public DeclarationSection treeCopyNoTransform() {
    DeclarationSection tree = (DeclarationSection) copy();
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
  public DeclarationSection treeCopy() {
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
   * Replaces the DeclStmt list.
   * @param list The new list node to be used as the DeclStmt list.
   * @apilevel high-level
   */
  public void setDeclStmtList(List<DeclStmt> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the DeclStmt list.
   * @return Number of children in the DeclStmt list.
   * @apilevel high-level
   */
  public int getNumDeclStmt() {
    return getDeclStmtList().getNumChild();
  }
  /**
   * Retrieves the number of children in the DeclStmt list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the DeclStmt list.
   * @apilevel low-level
   */
  public int getNumDeclStmtNoTransform() {
    return getDeclStmtListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the DeclStmt list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the DeclStmt list.
   * @apilevel high-level
   */
  public DeclStmt getDeclStmt(int i) {
    return (DeclStmt) getDeclStmtList().getChild(i);
  }
  /**
   * Check whether the DeclStmt list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasDeclStmt() {
    return getDeclStmtList().getNumChild() != 0;
  }
  /**
   * Append an element to the DeclStmt list.
   * @param node The element to append to the DeclStmt list.
   * @apilevel high-level
   */
  public void addDeclStmt(DeclStmt node) {
    List<DeclStmt> list = (parent == null || state == null) ? getDeclStmtListNoTransform() : getDeclStmtList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addDeclStmtNoTransform(DeclStmt node) {
    List<DeclStmt> list = getDeclStmtListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the DeclStmt list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setDeclStmt(DeclStmt node, int i) {
    List<DeclStmt> list = getDeclStmtList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the DeclStmt list.
   * @return The node representing the DeclStmt list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="DeclStmt")
  public List<DeclStmt> getDeclStmtList() {
    List<DeclStmt> list = (List<DeclStmt>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the DeclStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the DeclStmt list.
   * @apilevel low-level
   */
  public List<DeclStmt> getDeclStmtListNoTransform() {
    return (List<DeclStmt>) getChildNoTransform(0);
  }
  /**
   * Retrieves the DeclStmt list.
   * @return The node representing the DeclStmt list.
   * @apilevel high-level
   */
  public List<DeclStmt> getDeclStmts() {
    return getDeclStmtList();
  }
  /**
   * Retrieves the DeclStmt list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the DeclStmt list.
   * @apilevel low-level
   */
  public List<DeclStmt> getDeclStmtsNoTransform() {
    return getDeclStmtListNoTransform();
  }
  /**
   * Replaces the optional node for the DerivedTypeList child. This is the <code>Opt</code>
   * node containing the child DerivedTypeList, not the actual child!
   * @param opt The new node to be used as the optional node for the DerivedTypeList child.
   * @apilevel low-level
   */
  public void setDerivedTypeListOpt(Opt<DerivedTypeList> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) DerivedTypeList child.
   * @param node The new node to be used as the DerivedTypeList child.
   * @apilevel high-level
   */
  public void setDerivedTypeList(DerivedTypeList node) {
    getDerivedTypeListOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional DerivedTypeList child exists.
   * @return {@code true} if the optional DerivedTypeList child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasDerivedTypeList() {
    return getDerivedTypeListOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) DerivedTypeList child.
   * @return The DerivedTypeList child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public DerivedTypeList getDerivedTypeList() {
    return (DerivedTypeList) getDerivedTypeListOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the DerivedTypeList child. This is the <code>Opt</code> node containing the child DerivedTypeList, not the actual child!
   * @return The optional node for child the DerivedTypeList child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="DerivedTypeList")
  public Opt<DerivedTypeList> getDerivedTypeListOpt() {
    return (Opt<DerivedTypeList>) getChild(1);
  }
  /**
   * Retrieves the optional node for child DerivedTypeList. This is the <code>Opt</code> node containing the child DerivedTypeList, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child DerivedTypeList.
   * @apilevel low-level
   */
  public Opt<DerivedTypeList> getDerivedTypeListOptNoTransform() {
    return (Opt<DerivedTypeList>) getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
