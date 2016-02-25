/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:13
 * @production KeywordList : {@link ASTNode} ::= <span class="component">{@link Keyword}*</span>;

 */
public class KeywordList extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:96
   */
  public void pp(StringBuffer sb) {
    	int size = getNumKeyword();
        for (int i=0;i<size;i++) {
        	getKeyword(i).pp(sb);
        	if(i<size-1) sb.append(", ");
        }
    }
  /**
   * @declaredat ASTNode:1
   */
  public KeywordList() {
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
  public KeywordList(List<Keyword> p0) {
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
  public KeywordList clone() throws CloneNotSupportedException {
    KeywordList node = (KeywordList) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:57
   */
  public KeywordList copy() {
    try {
      KeywordList node = (KeywordList) clone();
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
  public KeywordList fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:85
   */
  public KeywordList treeCopyNoTransform() {
    KeywordList tree = (KeywordList) copy();
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
  public KeywordList treeCopy() {
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
   * Replaces the Keyword list.
   * @param list The new list node to be used as the Keyword list.
   * @apilevel high-level
   */
  public void setKeywordList(List<Keyword> list) {
    setChild(list, 0);
  }
  /**
   * Retrieves the number of children in the Keyword list.
   * @return Number of children in the Keyword list.
   * @apilevel high-level
   */
  public int getNumKeyword() {
    return getKeywordList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Keyword list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Keyword list.
   * @apilevel low-level
   */
  public int getNumKeywordNoTransform() {
    return getKeywordListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Keyword list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Keyword list.
   * @apilevel high-level
   */
  public Keyword getKeyword(int i) {
    return (Keyword) getKeywordList().getChild(i);
  }
  /**
   * Check whether the Keyword list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasKeyword() {
    return getKeywordList().getNumChild() != 0;
  }
  /**
   * Append an element to the Keyword list.
   * @param node The element to append to the Keyword list.
   * @apilevel high-level
   */
  public void addKeyword(Keyword node) {
    List<Keyword> list = (parent == null || state == null) ? getKeywordListNoTransform() : getKeywordList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addKeywordNoTransform(Keyword node) {
    List<Keyword> list = getKeywordListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Keyword list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setKeyword(Keyword node, int i) {
    List<Keyword> list = getKeywordList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Keyword list.
   * @return The node representing the Keyword list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Keyword")
  public List<Keyword> getKeywordList() {
    List<Keyword> list = (List<Keyword>) getChild(0);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Keyword list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Keyword list.
   * @apilevel low-level
   */
  public List<Keyword> getKeywordListNoTransform() {
    return (List<Keyword>) getChildNoTransform(0);
  }
  /**
   * Retrieves the Keyword list.
   * @return The node representing the Keyword list.
   * @apilevel high-level
   */
  public List<Keyword> getKeywords() {
    return getKeywordList();
  }
  /**
   * Retrieves the Keyword list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Keyword list.
   * @apilevel low-level
   */
  public List<Keyword> getKeywordsNoTransform() {
    return getKeywordListNoTransform();
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
