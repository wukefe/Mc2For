/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol  implements Cloneable, Iterable<T> {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:2
   */
  public void pp(StringBuffer sb) {}
  /**
   * @declaredat ASTNode:1
   */
  public ASTNode() {
    super();
    init$Children();
  }
  /**
   * Initializes the child array to the correct size.
   * Initializes List and Opt nta children.
   * @apilevel internal
   * @ast method
   * @declaredat ASTNode:11
   */
  public void init$Children() {
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:16
   */
  private int childIndex;
  /**
   * @apilevel low-level
   * @declaredat ASTNode:21
   */
  public int getIndexOfChild(ASTNode node) {
    if (node == null) {
      return -1;
    }
    if (node.childIndex < numChildren && node == children[node.childIndex]) {
      return node.childIndex;
    }
    for(int i = 0; children != null && i < children.length; i++) {
      if(children[i] == node) {
        node.childIndex = i;
        return i;
      }
    }
    return -1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:40
   */
  public static final boolean generatedWithCacheCycle = true;
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public static final boolean generatedWithComponentCheck = false;
  /**
   * Parent pointer
   * @apilevel low-level
   * @declaredat ASTNode:50
   */
  protected ASTNode parent;
  /**
   * Child array
   * @apilevel low-level
   * @declaredat ASTNode:56
   */
  protected ASTNode[] children;
  /**
   * @apilevel internal
   * @declaredat ASTNode:62
   */
  protected static ASTNode$State state = new ASTNode$State();
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public final ASTNode$State state() {
    return state;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:74
   */
  public boolean in$Circle = false;
  /**
   * @apilevel internal
   * @declaredat ASTNode:79
   */
  public boolean in$Circle() {
    return in$Circle;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:86
   */
  public void in$Circle(boolean b) {
    in$Circle = b;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:93
   */
  public boolean is$Final = false;
  /**
   * @apilevel internal
   * @declaredat ASTNode:97
   */
  public boolean is$Final() { return is$Final; }
  /**
   * @apilevel internal
   * @declaredat ASTNode:101
   */
  public void is$Final(boolean b) { is$Final = b; }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:106
   */
  public T getChild(int i) {

    ASTNode node = this.getChildNoTransform(i);
    if(node == null) {
      return null;
    }
    if(node.is$Final()) {
      return (T) node;
    }
    if(!node.mayHaveRewrite()) {
      node.is$Final(this.is$Final());
      return (T) node;
    }
    if(!node.in$Circle()) {
      int rewriteState;
      int num = this.state().boundariesCrossed;
      do {
        this.state().push(ASTNode$State.REWRITE_CHANGE);
        ASTNode oldNode = node;
        oldNode.in$Circle(true);
        node = node.rewriteTo();
        if(node != oldNode) {
          this.setChild(node, i);
        }
        oldNode.in$Circle(false);
        rewriteState = this.state().pop();
      } while(rewriteState == ASTNode$State.REWRITE_CHANGE);
      if(rewriteState == ASTNode$State.REWRITE_NOCHANGE && this.is$Final()) {
        node.is$Final(true);
        this.state().boundariesCrossed = num;
      } else {
      }
    } else if(this.is$Final() != node.is$Final()) {
      this.state().boundariesCrossed++;
    } else {
    }
    return (T) node;


  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:149
   */
  public void addChild(T node) {
    setChild(node, getNumChildNoTransform());
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @declaredat ASTNode:156
   */
  public final T getChildNoTransform(int i) {
    if (children == null) {
      return null;
    }
    T child = (T)children[i];
    return child;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:166
   */
  protected int numChildren;
  /**
   * @apilevel low-level
   * @declaredat ASTNode:171
   */
  protected int numChildren() {
    return numChildren;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:178
   */
  public int getNumChild() {
    return numChildren();
  }
  /**
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @apilevel low-level
   * @declaredat ASTNode:186
   */
  public final int getNumChildNoTransform() {
    return numChildren();
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:192
   */
  public void setChild(ASTNode node, int i) {
    if(children == null) {
      children = new ASTNode[(i+1>4 || !(this instanceof List))?i+1:4];
    } else if (i >= children.length) {
      ASTNode c[] = new ASTNode[i << 1];
      System.arraycopy(children, 0, c, 0, children.length);
      children = c;
    }
    children[i] = node;
    if(i >= numChildren) {
      numChildren = i+1;
    }
    if(node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:212
   */
  public void insertChild(ASTNode node, int i) {
    if(children == null) {
      children = new ASTNode[(i+1>4 || !(this instanceof List))?i+1:4];
      children[i] = node;
    } else {
      ASTNode c[] = new ASTNode[children.length + 1];
      System.arraycopy(children, 0, c, 0, i);
      c[i] = node;
      if(i < children.length) {
        System.arraycopy(children, i, c, i+1, children.length-i);
        for(int j = i+1; j < c.length; ++j) {
          if(c[j] != null) {
            c[j].childIndex = j;
          }
        }
      }
      children = c;
    }
    numChildren++;
    if(node != null) {
      node.setParent(this);
      node.childIndex = i;
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:239
   */
  public void removeChild(int i) {
    if(children != null) {
      ASTNode child = (ASTNode) children[i];
      if(child != null) {
        child.parent = null;
        child.childIndex = -1;
      }
      // Adding a check of this instance to make sure its a List, a move of children doesn't make
      // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
      // and siblings are moved one step to the right, with null at the end.
      if (this instanceof List || this instanceof Opt) {
        System.arraycopy(children, i+1, children, i, children.length-i-1);
        children[children.length-1] = null;
        numChildren--;
        // fix child indices
        for(int j = i; j < numChildren; ++j) {
          if(children[j] != null) {
            child = (ASTNode) children[j];
            child.childIndex = j;
          }
        }
      } else {
        children[i] = null;
      }
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:268
   */
  public ASTNode getParent() {
    if(parent != null && ((ASTNode) parent).is$Final() != is$Final()) {
      state().boundariesCrossed++;
    }
    ;
    return (ASTNode) parent;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:278
   */
  public void setParent(ASTNode node) {
    parent = node;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:330
   */
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private int counter = 0;
      public boolean hasNext() {
        return counter < getNumChild();
      }
      public T next() {
        if(hasNext())
          return (T)getChild(counter++);
        else
          return null;
      }
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:350
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:356
   */
  public void flushTreeCache() {
    flushCache();
    if (children == null) {
      return;
    }
    for (int i = 0; i < children.length; i++) {
      if (children[i] != null && ((ASTNode)children[i]).is$Final) {
        ((ASTNode)children[i]).flushTreeCache();
      }
    }
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:370
   */
  public void flushCache() {
    flushAttrAndCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:376
   */
  public void flushAttrAndCollectionCache() {
    flushAttrCache();
    flushCollectionCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:383
   */
  public void flushAttrCache() {
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:388
   */
  public void flushCollectionCache() {
  }
  /**
   * @api internal
   * @declaredat ASTNode:393
   */
  public void flushRewriteCache() {
    in$Circle(false);
    is$Final(false);
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:400
   */
  public ASTNode<T> clone() throws CloneNotSupportedException {
    ASTNode node = (ASTNode) super.clone();
    if (node.is$Final()) {
      node.flushAttrAndCollectionCache();
    }
    node.in$Circle(false);
    // flush rewrites
    node.is$Final(false);
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:413
   */
  public ASTNode<T> copy() {
    try {
      ASTNode node = (ASTNode) clone();
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
   * @declaredat ASTNode:432
   */
  public ASTNode<T> fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:441
   */
  public ASTNode<T> treeCopyNoTransform() {
    ASTNode tree = (ASTNode) copy();
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
   * @declaredat ASTNode:461
   */
  public ASTNode<T> treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * Performs a full traversal of the tree using getChild to trigger rewrites
   * @apilevel low-level
   * @declaredat ASTNode:469
   */
  public void doFullTraversal() {
    for (int i = 0; i < getNumChild(); i++) {
      getChild(i).doFullTraversal();
    }
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:477
   */
  protected boolean is$Equal(ASTNode n1, ASTNode n2) {
    if (n1 == null && n2 == null) return true;
    if (n1 == null || n2 == null) return false;
    return n1.is$Equal(n2);
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:485
   */
  protected boolean is$Equal(ASTNode node) {
    if (getClass() != node.getClass()) {
      return false;
    }
    if (numChildren != node.numChildren) {
      return false;
    }
    for (int i = 0; i < numChildren; i++) {
      if (children[i] == null && node.children[i] != null) {
        return false;
      }
      if (!((ASTNode)children[i]).is$Equal(((ASTNode)node.children[i]))) {
        return false;
      }
    }
    return true;
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    if(state().peek() == ASTNode$State.REWRITE_CHANGE) {
      state().pop();
      state().push(ASTNode$State.REWRITE_NOCHANGE);
    }
    return this;
  }}
