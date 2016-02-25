/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:35
 * @production BuiltinConstantExpr : {@link AbstractAssignToListStmt} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">{@link Variable}*</span> <span class="component">&lt;BuiltinFunc:String&gt;</span>;

 */
public class BuiltinConstantExpr extends AbstractAssignToListStmt implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:197
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	int size = getNumVariable();
    	for (int i=0;i<size;i++) {
    		getVariable(i).pp(sb);
    		if (i<size-1) sb.append(",");
    	}
    	sb.append(" = "+getBuiltinFunc()+";");
    }
  /**
   * @declaredat ASTNode:1
   */
  public BuiltinConstantExpr() {
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
    setChild(new Opt(), 0);
    setChild(new List(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public BuiltinConstantExpr(String p0, Opt<RuntimeAllocate> p1, List<Variable> p2, String p3) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setBuiltinFunc(p3);
  }
  /**
   * @declaredat ASTNode:21
   */
  public BuiltinConstantExpr(beaver.Symbol p0, Opt<RuntimeAllocate> p1, List<Variable> p2, beaver.Symbol p3) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setBuiltinFunc(p3);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:30
   */
  protected int numChildren() {
    return 2;
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
  public BuiltinConstantExpr clone() throws CloneNotSupportedException {
    BuiltinConstantExpr node = (BuiltinConstantExpr) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public BuiltinConstantExpr copy() {
    try {
      BuiltinConstantExpr node = (BuiltinConstantExpr) clone();
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
  public BuiltinConstantExpr fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:95
   */
  public BuiltinConstantExpr treeCopyNoTransform() {
    BuiltinConstantExpr tree = (BuiltinConstantExpr) copy();
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
  public BuiltinConstantExpr treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:122
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((BuiltinConstantExpr)node).tokenString_Indent) && (tokenString_BuiltinFunc == ((BuiltinConstantExpr)node).tokenString_BuiltinFunc);    
  }
  /**
   * Replaces the lexeme Indent.
   * @param value The new value for the lexeme Indent.
   * @apilevel high-level
   */
  public void setIndent(String value) {
    tokenString_Indent = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Indent;
  /**
   */
  public int Indentstart;
  /**
   */
  public int Indentend;
  /**
   * JastAdd-internal setter for lexeme Indent using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Indent
   * @apilevel internal
   */
  public void setIndent(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setIndent is only valid for String lexemes");
    tokenString_Indent = (String)symbol.value;
    Indentstart = symbol.getStart();
    Indentend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Indent.
   * @return The value for the lexeme Indent.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Indent")
  public String getIndent() {
    return tokenString_Indent != null ? tokenString_Indent : "";
  }
  /**
   * Replaces the optional node for the RuntimeAllocate child. This is the <code>Opt</code>
   * node containing the child RuntimeAllocate, not the actual child!
   * @param opt The new node to be used as the optional node for the RuntimeAllocate child.
   * @apilevel low-level
   */
  public void setRuntimeAllocateOpt(Opt<RuntimeAllocate> opt) {
    setChild(opt, 0);
  }
  /**
   * Replaces the (optional) RuntimeAllocate child.
   * @param node The new node to be used as the RuntimeAllocate child.
   * @apilevel high-level
   */
  public void setRuntimeAllocate(RuntimeAllocate node) {
    getRuntimeAllocateOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional RuntimeAllocate child exists.
   * @return {@code true} if the optional RuntimeAllocate child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasRuntimeAllocate() {
    return getRuntimeAllocateOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) RuntimeAllocate child.
   * @return The RuntimeAllocate child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public RuntimeAllocate getRuntimeAllocate() {
    return (RuntimeAllocate) getRuntimeAllocateOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the RuntimeAllocate child. This is the <code>Opt</code> node containing the child RuntimeAllocate, not the actual child!
   * @return The optional node for child the RuntimeAllocate child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="RuntimeAllocate")
  public Opt<RuntimeAllocate> getRuntimeAllocateOpt() {
    return (Opt<RuntimeAllocate>) getChild(0);
  }
  /**
   * Retrieves the optional node for child RuntimeAllocate. This is the <code>Opt</code> node containing the child RuntimeAllocate, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child RuntimeAllocate.
   * @apilevel low-level
   */
  public Opt<RuntimeAllocate> getRuntimeAllocateOptNoTransform() {
    return (Opt<RuntimeAllocate>) getChildNoTransform(0);
  }
  /**
   * Replaces the Variable list.
   * @param list The new list node to be used as the Variable list.
   * @apilevel high-level
   */
  public void setVariableList(List<Variable> list) {
    setChild(list, 1);
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
    List<Variable> list = (List<Variable>) getChild(1);
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
    return (List<Variable>) getChildNoTransform(1);
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
   * Replaces the lexeme BuiltinFunc.
   * @param value The new value for the lexeme BuiltinFunc.
   * @apilevel high-level
   */
  public void setBuiltinFunc(String value) {
    tokenString_BuiltinFunc = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_BuiltinFunc;
  /**
   */
  public int BuiltinFuncstart;
  /**
   */
  public int BuiltinFuncend;
  /**
   * JastAdd-internal setter for lexeme BuiltinFunc using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme BuiltinFunc
   * @apilevel internal
   */
  public void setBuiltinFunc(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setBuiltinFunc is only valid for String lexemes");
    tokenString_BuiltinFunc = (String)symbol.value;
    BuiltinFuncstart = symbol.getStart();
    BuiltinFuncend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme BuiltinFunc.
   * @return The value for the lexeme BuiltinFunc.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="BuiltinFunc")
  public String getBuiltinFunc() {
    return tokenString_BuiltinFunc != null ? tokenString_BuiltinFunc : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
