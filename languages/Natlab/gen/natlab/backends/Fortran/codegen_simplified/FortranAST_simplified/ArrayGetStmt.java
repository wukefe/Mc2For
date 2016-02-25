/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:48
 * @production ArrayGetStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">[{@link RigorousIndexingTransformation}]</span> <span class="component">&lt;lhsVariable:String&gt;</span> <span class="component">[{@link lhsIndex}]</span> <span class="component">&lt;rhsVariable:String&gt;</span> <span class="component">&lt;rhsIndex:String&gt;</span>;

 */
public class ArrayGetStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:263
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	if (hasRigorousIndexingTransformation()) {
    		getRigorousIndexingTransformation().pp(sb);
    		return;
    	}
    	sb.append(getlhsVariable());
    	if (haslhsIndex()) {
    		sb.append("(");
    		getlhsIndex().pp(sb);
    		sb.append(")");
    	}
    	sb.append(" = "+getrhsVariable()+"("+getrhsIndex()+");");
    }
  /**
   * @declaredat ASTNode:1
   */
  public ArrayGetStmt() {
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
    setChild(new Opt(), 2);
  }
  /**
   * @declaredat ASTNode:16
   */
  public ArrayGetStmt(String p0, Opt<RuntimeAllocate> p1, Opt<RigorousIndexingTransformation> p2, String p3, Opt<lhsIndex> p4, String p5, String p6) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setlhsVariable(p3);
    setChild(p4, 2);
    setrhsVariable(p5);
    setrhsIndex(p6);
  }
  /**
   * @declaredat ASTNode:25
   */
  public ArrayGetStmt(beaver.Symbol p0, Opt<RuntimeAllocate> p1, Opt<RigorousIndexingTransformation> p2, beaver.Symbol p3, Opt<lhsIndex> p4, beaver.Symbol p5, beaver.Symbol p6) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setlhsVariable(p3);
    setChild(p4, 2);
    setrhsVariable(p5);
    setrhsIndex(p6);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:37
   */
  protected int numChildren() {
    return 3;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:43
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:49
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:55
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:61
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public ArrayGetStmt clone() throws CloneNotSupportedException {
    ArrayGetStmt node = (ArrayGetStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:74
   */
  public ArrayGetStmt copy() {
    try {
      ArrayGetStmt node = (ArrayGetStmt) clone();
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
   * @declaredat ASTNode:93
   */
  public ArrayGetStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:102
   */
  public ArrayGetStmt treeCopyNoTransform() {
    ArrayGetStmt tree = (ArrayGetStmt) copy();
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
   * @declaredat ASTNode:122
   */
  public ArrayGetStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:129
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((ArrayGetStmt)node).tokenString_Indent) && (tokenString_lhsVariable == ((ArrayGetStmt)node).tokenString_lhsVariable) && (tokenString_rhsVariable == ((ArrayGetStmt)node).tokenString_rhsVariable) && (tokenString_rhsIndex == ((ArrayGetStmt)node).tokenString_rhsIndex);    
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
   * Replaces the optional node for the RigorousIndexingTransformation child. This is the <code>Opt</code>
   * node containing the child RigorousIndexingTransformation, not the actual child!
   * @param opt The new node to be used as the optional node for the RigorousIndexingTransformation child.
   * @apilevel low-level
   */
  public void setRigorousIndexingTransformationOpt(Opt<RigorousIndexingTransformation> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) RigorousIndexingTransformation child.
   * @param node The new node to be used as the RigorousIndexingTransformation child.
   * @apilevel high-level
   */
  public void setRigorousIndexingTransformation(RigorousIndexingTransformation node) {
    getRigorousIndexingTransformationOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional RigorousIndexingTransformation child exists.
   * @return {@code true} if the optional RigorousIndexingTransformation child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasRigorousIndexingTransformation() {
    return getRigorousIndexingTransformationOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) RigorousIndexingTransformation child.
   * @return The RigorousIndexingTransformation child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public RigorousIndexingTransformation getRigorousIndexingTransformation() {
    return (RigorousIndexingTransformation) getRigorousIndexingTransformationOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the RigorousIndexingTransformation child. This is the <code>Opt</code> node containing the child RigorousIndexingTransformation, not the actual child!
   * @return The optional node for child the RigorousIndexingTransformation child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="RigorousIndexingTransformation")
  public Opt<RigorousIndexingTransformation> getRigorousIndexingTransformationOpt() {
    return (Opt<RigorousIndexingTransformation>) getChild(1);
  }
  /**
   * Retrieves the optional node for child RigorousIndexingTransformation. This is the <code>Opt</code> node containing the child RigorousIndexingTransformation, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child RigorousIndexingTransformation.
   * @apilevel low-level
   */
  public Opt<RigorousIndexingTransformation> getRigorousIndexingTransformationOptNoTransform() {
    return (Opt<RigorousIndexingTransformation>) getChildNoTransform(1);
  }
  /**
   * Replaces the lexeme lhsVariable.
   * @param value The new value for the lexeme lhsVariable.
   * @apilevel high-level
   */
  public void setlhsVariable(String value) {
    tokenString_lhsVariable = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_lhsVariable;
  /**
   */
  public int lhsVariablestart;
  /**
   */
  public int lhsVariableend;
  /**
   * JastAdd-internal setter for lexeme lhsVariable using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme lhsVariable
   * @apilevel internal
   */
  public void setlhsVariable(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setlhsVariable is only valid for String lexemes");
    tokenString_lhsVariable = (String)symbol.value;
    lhsVariablestart = symbol.getStart();
    lhsVariableend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme lhsVariable.
   * @return The value for the lexeme lhsVariable.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="lhsVariable")
  public String getlhsVariable() {
    return tokenString_lhsVariable != null ? tokenString_lhsVariable : "";
  }
  /**
   * Replaces the optional node for the lhsIndex child. This is the <code>Opt</code>
   * node containing the child lhsIndex, not the actual child!
   * @param opt The new node to be used as the optional node for the lhsIndex child.
   * @apilevel low-level
   */
  public void setlhsIndexOpt(Opt<lhsIndex> opt) {
    setChild(opt, 2);
  }
  /**
   * Replaces the (optional) lhsIndex child.
   * @param node The new node to be used as the lhsIndex child.
   * @apilevel high-level
   */
  public void setlhsIndex(lhsIndex node) {
    getlhsIndexOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional lhsIndex child exists.
   * @return {@code true} if the optional lhsIndex child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean haslhsIndex() {
    return getlhsIndexOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) lhsIndex child.
   * @return The lhsIndex child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public lhsIndex getlhsIndex() {
    return (lhsIndex) getlhsIndexOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the lhsIndex child. This is the <code>Opt</code> node containing the child lhsIndex, not the actual child!
   * @return The optional node for child the lhsIndex child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="lhsIndex")
  public Opt<lhsIndex> getlhsIndexOpt() {
    return (Opt<lhsIndex>) getChild(2);
  }
  /**
   * Retrieves the optional node for child lhsIndex. This is the <code>Opt</code> node containing the child lhsIndex, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child lhsIndex.
   * @apilevel low-level
   */
  public Opt<lhsIndex> getlhsIndexOptNoTransform() {
    return (Opt<lhsIndex>) getChildNoTransform(2);
  }
  /**
   * Replaces the lexeme rhsVariable.
   * @param value The new value for the lexeme rhsVariable.
   * @apilevel high-level
   */
  public void setrhsVariable(String value) {
    tokenString_rhsVariable = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_rhsVariable;
  /**
   */
  public int rhsVariablestart;
  /**
   */
  public int rhsVariableend;
  /**
   * JastAdd-internal setter for lexeme rhsVariable using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme rhsVariable
   * @apilevel internal
   */
  public void setrhsVariable(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setrhsVariable is only valid for String lexemes");
    tokenString_rhsVariable = (String)symbol.value;
    rhsVariablestart = symbol.getStart();
    rhsVariableend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme rhsVariable.
   * @return The value for the lexeme rhsVariable.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="rhsVariable")
  public String getrhsVariable() {
    return tokenString_rhsVariable != null ? tokenString_rhsVariable : "";
  }
  /**
   * Replaces the lexeme rhsIndex.
   * @param value The new value for the lexeme rhsIndex.
   * @apilevel high-level
   */
  public void setrhsIndex(String value) {
    tokenString_rhsIndex = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_rhsIndex;
  /**
   */
  public int rhsIndexstart;
  /**
   */
  public int rhsIndexend;
  /**
   * JastAdd-internal setter for lexeme rhsIndex using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme rhsIndex
   * @apilevel internal
   */
  public void setrhsIndex(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setrhsIndex is only valid for String lexemes");
    tokenString_rhsIndex = (String)symbol.value;
    rhsIndexstart = symbol.getStart();
    rhsIndexend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme rhsIndex.
   * @return The value for the lexeme rhsIndex.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="rhsIndex")
  public String getrhsIndex() {
    return tokenString_rhsIndex != null ? tokenString_rhsIndex : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
