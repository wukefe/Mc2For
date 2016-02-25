/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:25
 * @production AssignLiteralStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">{@link Variable}</span> <span class="component">&lt;Literal:String&gt;</span>;

 */
public class AssignLiteralStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:137
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	getVariable().pp(sb);
    	sb.append(" = "+getLiteral()+";");
    }
  /**
   * @declaredat ASTNode:1
   */
  public AssignLiteralStmt() {
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
  }
  /**
   * @declaredat ASTNode:14
   */
  public AssignLiteralStmt(String p0, Opt<RuntimeAllocate> p1, Variable p2, String p3) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setLiteral(p3);
  }
  /**
   * @declaredat ASTNode:20
   */
  public AssignLiteralStmt(beaver.Symbol p0, Opt<RuntimeAllocate> p1, Variable p2, beaver.Symbol p3) {
    setIndent(p0);
    setChild(p1, 0);
    setChild(p2, 1);
    setLiteral(p3);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:29
   */
  protected int numChildren() {
    return 2;
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
  public AssignLiteralStmt clone() throws CloneNotSupportedException {
    AssignLiteralStmt node = (AssignLiteralStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:66
   */
  public AssignLiteralStmt copy() {
    try {
      AssignLiteralStmt node = (AssignLiteralStmt) clone();
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
  public AssignLiteralStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:94
   */
  public AssignLiteralStmt treeCopyNoTransform() {
    AssignLiteralStmt tree = (AssignLiteralStmt) copy();
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
  public AssignLiteralStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:121
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((AssignLiteralStmt)node).tokenString_Indent) && (tokenString_Literal == ((AssignLiteralStmt)node).tokenString_Literal);    
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
   * Replaces the Variable child.
   * @param node The new node to replace the Variable child.
   * @apilevel high-level
   */
  public void setVariable(Variable node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the Variable child.
   * @return The current node used as the Variable child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="Variable")
  public Variable getVariable() {
    return (Variable) getChild(1);
  }
  /**
   * Retrieves the Variable child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the Variable child.
   * @apilevel low-level
   */
  public Variable getVariableNoTransform() {
    return (Variable) getChildNoTransform(1);
  }
  /**
   * Replaces the lexeme Literal.
   * @param value The new value for the lexeme Literal.
   * @apilevel high-level
   */
  public void setLiteral(String value) {
    tokenString_Literal = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_Literal;
  /**
   */
  public int Literalstart;
  /**
   */
  public int Literalend;
  /**
   * JastAdd-internal setter for lexeme Literal using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme Literal
   * @apilevel internal
   */
  public void setLiteral(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setLiteral is only valid for String lexemes");
    tokenString_Literal = (String)symbol.value;
    Literalstart = symbol.getStart();
    Literalend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme Literal.
   * @return The value for the lexeme Literal.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="Literal")
  public String getLiteral() {
    return tokenString_Literal != null ? tokenString_Literal : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
