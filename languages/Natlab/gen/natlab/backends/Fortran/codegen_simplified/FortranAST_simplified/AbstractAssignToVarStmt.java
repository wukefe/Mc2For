/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:28
 * @production AbstractAssignToVarStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">&lt;TargetVariable:String&gt;</span> <span class="component">&lt;SourceVariable:String&gt;</span>;

 */
public class AbstractAssignToVarStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:148
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	sb.append(getTargetVariable()+" = "+getSourceVariable()+";");
    }
  /**
   * @declaredat ASTNode:1
   */
  public AbstractAssignToVarStmt() {
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
    setChild(new Opt(), 0);
  }
  /**
   * @declaredat ASTNode:14
   */
  public AbstractAssignToVarStmt(String p0, Opt<RuntimeAllocate> p1, String p2, String p3) {
    setIndent(p0);
    setChild(p1, 0);
    setTargetVariable(p2);
    setSourceVariable(p3);
  }
  /**
   * @declaredat ASTNode:20
   */
  public AbstractAssignToVarStmt(beaver.Symbol p0, Opt<RuntimeAllocate> p1, beaver.Symbol p2, beaver.Symbol p3) {
    setIndent(p0);
    setChild(p1, 0);
    setTargetVariable(p2);
    setSourceVariable(p3);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:29
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:35
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:41
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:47
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:53
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:59
   */
  public AbstractAssignToVarStmt clone() throws CloneNotSupportedException {
    AbstractAssignToVarStmt node = (AbstractAssignToVarStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:66
   */
  public AbstractAssignToVarStmt copy() {
    try {
      AbstractAssignToVarStmt node = (AbstractAssignToVarStmt) clone();
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
   * @declaredat ASTNode:85
   */
  public AbstractAssignToVarStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:94
   */
  public AbstractAssignToVarStmt treeCopyNoTransform() {
    AbstractAssignToVarStmt tree = (AbstractAssignToVarStmt) copy();
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
   * @declaredat ASTNode:114
   */
  public AbstractAssignToVarStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:121
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((AbstractAssignToVarStmt)node).tokenString_Indent) && (tokenString_TargetVariable == ((AbstractAssignToVarStmt)node).tokenString_TargetVariable) && (tokenString_SourceVariable == ((AbstractAssignToVarStmt)node).tokenString_SourceVariable);    
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
   * Replaces the lexeme TargetVariable.
   * @param value The new value for the lexeme TargetVariable.
   * @apilevel high-level
   */
  public void setTargetVariable(String value) {
    tokenString_TargetVariable = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_TargetVariable;
  /**
   */
  public int TargetVariablestart;
  /**
   */
  public int TargetVariableend;
  /**
   * JastAdd-internal setter for lexeme TargetVariable using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme TargetVariable
   * @apilevel internal
   */
  public void setTargetVariable(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setTargetVariable is only valid for String lexemes");
    tokenString_TargetVariable = (String)symbol.value;
    TargetVariablestart = symbol.getStart();
    TargetVariableend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme TargetVariable.
   * @return The value for the lexeme TargetVariable.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="TargetVariable")
  public String getTargetVariable() {
    return tokenString_TargetVariable != null ? tokenString_TargetVariable : "";
  }
  /**
   * Replaces the lexeme SourceVariable.
   * @param value The new value for the lexeme SourceVariable.
   * @apilevel high-level
   */
  public void setSourceVariable(String value) {
    tokenString_SourceVariable = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_SourceVariable;
  /**
   */
  public int SourceVariablestart;
  /**
   */
  public int SourceVariableend;
  /**
   * JastAdd-internal setter for lexeme SourceVariable using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme SourceVariable
   * @apilevel internal
   */
  public void setSourceVariable(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setSourceVariable is only valid for String lexemes");
    tokenString_SourceVariable = (String)symbol.value;
    SourceVariablestart = symbol.getStart();
    SourceVariableend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme SourceVariable.
   * @return The value for the lexeme SourceVariable.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="SourceVariable")
  public String getSourceVariable() {
    return tokenString_SourceVariable != null ? tokenString_SourceVariable : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
