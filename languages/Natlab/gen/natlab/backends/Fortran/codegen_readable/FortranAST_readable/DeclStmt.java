/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:12
 * @production DeclStmt : {@link ASTNode} ::= <span class="component">&lt;Type:String&gt;</span> <span class="component">[{@link KeywordList}]</span> <span class="component">[{@link ShapeInfo}]</span> <span class="component">{@link VariableList}</span>;

 */
public class DeclStmt extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:82
   */
  public void pp(StringBuffer sb) {
    	sb.append(getType());
    	if (hasKeywordList()) {
    	    sb.append(", ");
    		getKeywordList().pp(sb);
    	}
    	if (hasShapeInfo()) {
    		sb.append(", ");
    		getShapeInfo().pp(sb);
    	}
    	sb.append(" :: ");
    	getVariableList().pp(sb);
    }
  /**
   * @declaredat ASTNode:1
   */
  public DeclStmt() {
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
    children = new ASTNode[3];
    setChild(new Opt(), 0);
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public DeclStmt(String p0, Opt<KeywordList> p1, Opt<ShapeInfo> p2, VariableList p3) {
    setType(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setChild(p3, 2);
  }
  /**
   * @declaredat ASTNode:21
   */
  public DeclStmt(beaver.Symbol p0, Opt<KeywordList> p1, Opt<ShapeInfo> p2, VariableList p3) {
    setType(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setChild(p3, 2);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:30
   */
  protected int numChildren() {
    return 3;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:36
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:42
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:48
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:54
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:60
   */
  public DeclStmt clone() throws CloneNotSupportedException {
    DeclStmt node = (DeclStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public DeclStmt copy() {
    try {
      DeclStmt node = (DeclStmt) clone();
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
   * @declaredat ASTNode:86
   */
  public DeclStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:95
   */
  public DeclStmt treeCopyNoTransform() {
    DeclStmt tree = (DeclStmt) copy();
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
   * @declaredat ASTNode:115
   */
  public DeclStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:122
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Type == ((DeclStmt)node).tokenString_Type);    
  }
  /**
   * Replaces the lexeme Type.
   * @param value The new value for the lexeme Type.
   * @apilevel high-level
   */
  public void setType(String value) {
    tokenString_Type = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Type;
  /**
   */
  public int Typestart;
  /**
   */
  public int Typeend;
  /**
   * JastAdd-internal setter for lexeme Type using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Type
   * @apilevel internal
   */
  public void setType(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setType is only valid for String lexemes");
    tokenString_Type = (String)symbol.value;
    Typestart = symbol.getStart();
    Typeend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Type.
   * @return The value for the lexeme Type.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Type")
  public String getType() {
    return tokenString_Type != null ? tokenString_Type : "";
  }
  /**
   * Replaces the optional node for the KeywordList child. This is the <code>Opt</code>
   * node containing the child KeywordList, not the actual child!
   * @param opt The new node to be used as the optional node for the KeywordList child.
   * @apilevel low-level
   */
  public void setKeywordListOpt(Opt<KeywordList> opt) {
    setChild(opt, 0);
  }
  /**
   * Replaces the (optional) KeywordList child.
   * @param node The new node to be used as the KeywordList child.
   * @apilevel high-level
   */
  public void setKeywordList(KeywordList node) {
    getKeywordListOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional KeywordList child exists.
   * @return {@code true} if the optional KeywordList child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasKeywordList() {
    return getKeywordListOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) KeywordList child.
   * @return The KeywordList child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public KeywordList getKeywordList() {
    return (KeywordList) getKeywordListOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the KeywordList child. This is the <code>Opt</code> node containing the child KeywordList, not the actual child!
   * @return The optional node for child the KeywordList child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="KeywordList")
  public Opt<KeywordList> getKeywordListOpt() {
    return (Opt<KeywordList>) getChild(0);
  }
  /**
   * Retrieves the optional node for child KeywordList. This is the <code>Opt</code> node containing the child KeywordList, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child KeywordList.
   * @apilevel low-level
   */
  public Opt<KeywordList> getKeywordListOptNoTransform() {
    return (Opt<KeywordList>) getChildNoTransform(0);
  }
  /**
   * Replaces the optional node for the ShapeInfo child. This is the <code>Opt</code>
   * node containing the child ShapeInfo, not the actual child!
   * @param opt The new node to be used as the optional node for the ShapeInfo child.
   * @apilevel low-level
   */
  public void setShapeInfoOpt(Opt<ShapeInfo> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) ShapeInfo child.
   * @param node The new node to be used as the ShapeInfo child.
   * @apilevel high-level
   */
  public void setShapeInfo(ShapeInfo node) {
    getShapeInfoOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ShapeInfo child exists.
   * @return {@code true} if the optional ShapeInfo child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasShapeInfo() {
    return getShapeInfoOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ShapeInfo child.
   * @return The ShapeInfo child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ShapeInfo getShapeInfo() {
    return (ShapeInfo) getShapeInfoOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ShapeInfo child. This is the <code>Opt</code> node containing the child ShapeInfo, not the actual child!
   * @return The optional node for child the ShapeInfo child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ShapeInfo")
  public Opt<ShapeInfo> getShapeInfoOpt() {
    return (Opt<ShapeInfo>) getChild(1);
  }
  /**
   * Retrieves the optional node for child ShapeInfo. This is the <code>Opt</code> node containing the child ShapeInfo, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ShapeInfo.
   * @apilevel low-level
   */
  public Opt<ShapeInfo> getShapeInfoOptNoTransform() {
    return (Opt<ShapeInfo>) getChildNoTransform(1);
  }
  /**
   * Replaces the VariableList child.
   * @param node The new node to replace the VariableList child.
   * @apilevel high-level
   */
  public void setVariableList(VariableList node) {
    setChild(node, 2);
  }
  /**
   * Retrieves the VariableList child.
   * @return The current node used as the VariableList child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="VariableList")
  public VariableList getVariableList() {
    return (VariableList) getChild(2);
  }
  /**
   * Retrieves the VariableList child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the VariableList child.
   * @apilevel low-level
   */
  public VariableList getVariableListNoTransform() {
    return (VariableList) getChildNoTransform(2);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
