/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:52
 * @production ArraySetStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">[{@link RigorousIndexingTransformation}]</span> <span class="component">&lt;lhsVariable:String&gt;</span> <span class="component">&lt;lhsIndex:String&gt;</span> <span class="component">&lt;rhsVariable:String&gt;</span>;

 */
public class ArraySetStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:287
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	if (hasRigorousIndexingTransformation()) {
    		getRigorousIndexingTransformation().pp(sb);
    		return;
    	}
    	sb.append(getlhsVariable()+"("+getlhsIndex()+") = "+getrhsVariable()+";");
    }
  /**
   * @declaredat ASTNode:1
   */
  public ArraySetStmt() {
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
    setChild(new Opt(), 1);
  }
  /**
   * @declaredat ASTNode:15
   */
  public ArraySetStmt(String p0, Opt<RuntimeAllocate> p1, Opt<RigorousIndexingTransformation> p2, String p3, String p4, String p5) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setlhsVariable(p3);
    setlhsIndex(p4);
    setrhsVariable(p5);
  }
  /**
   * @declaredat ASTNode:23
   */
  public ArraySetStmt(beaver.Symbol p0, Opt<RuntimeAllocate> p1, Opt<RigorousIndexingTransformation> p2, beaver.Symbol p3, beaver.Symbol p4, beaver.Symbol p5) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setlhsVariable(p3);
    setlhsIndex(p4);
    setrhsVariable(p5);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:34
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:40
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:46
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:52
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:58
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:64
   */
  public ArraySetStmt clone() throws CloneNotSupportedException {
    ArraySetStmt node = (ArraySetStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:71
   */
  public ArraySetStmt copy() {
    try {
      ArraySetStmt node = (ArraySetStmt) clone();
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
   * @declaredat ASTNode:90
   */
  public ArraySetStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:99
   */
  public ArraySetStmt treeCopyNoTransform() {
    ArraySetStmt tree = (ArraySetStmt) copy();
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
   * @declaredat ASTNode:119
   */
  public ArraySetStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:126
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((ArraySetStmt)node).tokenString_Indent) && (tokenString_lhsVariable == ((ArraySetStmt)node).tokenString_lhsVariable) && (tokenString_lhsIndex == ((ArraySetStmt)node).tokenString_lhsIndex) && (tokenString_rhsVariable == ((ArraySetStmt)node).tokenString_rhsVariable);    
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
   * Replaces the lexeme lhsIndex.
   * @param value The new value for the lexeme lhsIndex.
   * @apilevel high-level
   */
  public void setlhsIndex(String value) {
    tokenString_lhsIndex = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_lhsIndex;
  /**
   */
  public int lhsIndexstart;
  /**
   */
  public int lhsIndexend;
  /**
   * JastAdd-internal setter for lexeme lhsIndex using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme lhsIndex
   * @apilevel internal
   */
  public void setlhsIndex(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setlhsIndex is only valid for String lexemes");
    tokenString_lhsIndex = (String)symbol.value;
    lhsIndexstart = symbol.getStart();
    lhsIndexend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme lhsIndex.
   * @return The value for the lexeme lhsIndex.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="lhsIndex")
  public String getlhsIndex() {
    return tokenString_lhsIndex != null ? tokenString_lhsIndex : "";
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
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
