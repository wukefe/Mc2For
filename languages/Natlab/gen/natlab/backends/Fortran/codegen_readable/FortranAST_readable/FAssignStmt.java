/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:26
 * @production FAssignStmt : {@link Statement} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">&lt;FLHS:String&gt;</span> <span class="component">&lt;FRHS:String&gt;</span> <span class="component">[{@link ExtraInlined}]</span>;

 */
public class FAssignStmt extends Statement implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:146
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) {
    		getRuntimeAllocate().pp(sb);
    	}
    	sb.append(getIndent());
    	if (!getFLHS().equals("")) {
    		sb.append(getFLHS());
    		sb.append(" = ");
    	}
    	sb.append(getFRHS()+";");
    	if (hasExtraInlined()) {
    		sb.append("\n"+getIndent());
    		getExtraInlined().pp(sb);
    	}
    }
  /**
   * @declaredat ASTNode:1
   */
  public FAssignStmt() {
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
  public FAssignStmt(String p0, Opt<RuntimeAllocate> p1, String p2, String p3, Opt<ExtraInlined> p4) {
    setIndent(p0);
    setChild(p1, 0);
    setFLHS(p2);
    setFRHS(p3);
    setChild(p4, 1);
  }
  /**
   * @declaredat ASTNode:22
   */
  public FAssignStmt(beaver.Symbol p0, Opt<RuntimeAllocate> p1, beaver.Symbol p2, beaver.Symbol p3, Opt<ExtraInlined> p4) {
    setIndent(p0);
    setChild(p1, 0);
    setFLHS(p2);
    setFRHS(p3);
    setChild(p4, 1);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:32
   */
  protected int numChildren() {
    return 2;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:38
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:44
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:50
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:56
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:62
   */
  public FAssignStmt clone() throws CloneNotSupportedException {
    FAssignStmt node = (FAssignStmt) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:69
   */
  public FAssignStmt copy() {
    try {
      FAssignStmt node = (FAssignStmt) clone();
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
   * @declaredat ASTNode:88
   */
  public FAssignStmt fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:97
   */
  public FAssignStmt treeCopyNoTransform() {
    FAssignStmt tree = (FAssignStmt) copy();
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
   * @declaredat ASTNode:117
   */
  public FAssignStmt treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:124
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((FAssignStmt)node).tokenString_Indent) && (tokenString_FLHS == ((FAssignStmt)node).tokenString_FLHS) && (tokenString_FRHS == ((FAssignStmt)node).tokenString_FRHS);    
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
   * Replaces the lexeme FLHS.
   * @param value The new value for the lexeme FLHS.
   * @apilevel high-level
   */
  public void setFLHS(String value) {
    tokenString_FLHS = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FLHS;
  /**
   */
  public int FLHSstart;
  /**
   */
  public int FLHSend;
  /**
   * JastAdd-internal setter for lexeme FLHS using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FLHS
   * @apilevel internal
   */
  public void setFLHS(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFLHS is only valid for String lexemes");
    tokenString_FLHS = (String)symbol.value;
    FLHSstart = symbol.getStart();
    FLHSend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FLHS.
   * @return The value for the lexeme FLHS.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FLHS")
  public String getFLHS() {
    return tokenString_FLHS != null ? tokenString_FLHS : "";
  }
  /**
   * Replaces the lexeme FRHS.
   * @param value The new value for the lexeme FRHS.
   * @apilevel high-level
   */
  public void setFRHS(String value) {
    tokenString_FRHS = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FRHS;
  /**
   */
  public int FRHSstart;
  /**
   */
  public int FRHSend;
  /**
   * JastAdd-internal setter for lexeme FRHS using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FRHS
   * @apilevel internal
   */
  public void setFRHS(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFRHS is only valid for String lexemes");
    tokenString_FRHS = (String)symbol.value;
    FRHSstart = symbol.getStart();
    FRHSend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FRHS.
   * @return The value for the lexeme FRHS.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FRHS")
  public String getFRHS() {
    return tokenString_FRHS != null ? tokenString_FRHS : "";
  }
  /**
   * Replaces the optional node for the ExtraInlined child. This is the <code>Opt</code>
   * node containing the child ExtraInlined, not the actual child!
   * @param opt The new node to be used as the optional node for the ExtraInlined child.
   * @apilevel low-level
   */
  public void setExtraInlinedOpt(Opt<ExtraInlined> opt) {
    setChild(opt, 1);
  }
  /**
   * Replaces the (optional) ExtraInlined child.
   * @param node The new node to be used as the ExtraInlined child.
   * @apilevel high-level
   */
  public void setExtraInlined(ExtraInlined node) {
    getExtraInlinedOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ExtraInlined child exists.
   * @return {@code true} if the optional ExtraInlined child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasExtraInlined() {
    return getExtraInlinedOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ExtraInlined child.
   * @return The ExtraInlined child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ExtraInlined getExtraInlined() {
    return (ExtraInlined) getExtraInlinedOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ExtraInlined child. This is the <code>Opt</code> node containing the child ExtraInlined, not the actual child!
   * @return The optional node for child the ExtraInlined child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ExtraInlined")
  public Opt<ExtraInlined> getExtraInlinedOpt() {
    return (Opt<ExtraInlined>) getChild(1);
  }
  /**
   * Retrieves the optional node for child ExtraInlined. This is the <code>Opt</code> node containing the child ExtraInlined, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ExtraInlined.
   * @apilevel low-level
   */
  public Opt<ExtraInlined> getExtraInlinedOptNoTransform() {
    return (Opt<ExtraInlined>) getChildNoTransform(1);
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
