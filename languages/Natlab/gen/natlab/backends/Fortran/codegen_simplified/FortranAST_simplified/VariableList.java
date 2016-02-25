/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:13
 * @production VariableList : {@link ASTNode} ::= <span class="component">{@link Variable}*</span>;

 */
public class VariableList extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:105
   */
  public void pp(StringBuffer sb) {
    	int size = getNumVariable();
        for (int i=0;i<size;i++) {
        	getVariable(i).pp(sb);
        	if (i<size-1) sb.append(", ");
        }
    }
  /**
   * @declaredat ASTNode:1
   */
  public VariableList() {
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
  public VariableList(List<Variable> p0) {
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
  public VariableList clone() throws CloneNotSupportedException {
    VariableList node = (VariableList) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:57
   */
  public VariableList copy() {
    try {
      VariableList node = (VariableList) clone();
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
  public VariableList fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:85
   */
  public VariableList treeCopyNoTransform() {
    VariableList tree = (VariableList) copy();
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
  public VariableList treeCopy() {
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
   * Replaces the Variable list.
   * @param list The new list node to be used as the Variable list.
   * @apilevel high-level
   */
  public void setVariableList(List<Variable> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Variable list.
   * @return Number of children in the Variable list.
   * @apilevel high-level
   */
  public int getNumVariable() {
    return getVariableList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Variable list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Variable list.
   * @apilevel low-level
   */
  public int getNumVariableNoTransform() {
    return getVariableListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Variable list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Variable list.
   * @apilevel high-level
   */
  public Variable getVariable(int i) {
    return (Variable) getVariableList().getChild(i);
  }
  /**
   * Check whether the Variable list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasVariable() {
    return getVariableList().getNumChild() != 0;
  }
  /**
   * Append an element to the Variable list.
   * @param node The element to append to the Variable list.
   * @apilevel high-level
   */
  public void addVariable(Variable node) {
    List<Variable> list = (parent == null || state == null) ? getVariableListNoTransform() : getVariableList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addVariableNoTransform(Variable node) {
    List<Variable> list = getVariableListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Variable list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setVariable(Variable node, int i) {
    List<Variable> list = getVariableList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Variable list.
   * @return The node representing the Variable list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Variable")
  public List<Variable> getVariableList() {
    List<Variable> list = (List<Variable>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Variable list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Variable list.
   * @apilevel low-level
   */
  public List<Variable> getVariableListNoTransform() {
    return (List<Variable>) getChildNoTransform(0);
  }
  /**
   * Retrieves the Variable list.
   * @return The node representing the Variable list.
   * @apilevel high-level
   */
  public List<Variable> getVariables() {
    return getVariableList();
  }
  /**
   * Retrieves the Variable list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Variable list.
   * @apilevel low-level
   */
  public List<Variable> getVariablesNoTransform() {
    return getVariableListNoTransform();
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
