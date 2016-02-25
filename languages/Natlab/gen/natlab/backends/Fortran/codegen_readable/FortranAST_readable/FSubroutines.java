/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:30
 * @production FSubroutines : {@link FAssignStmt} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">&lt;FunctionCall:String&gt;</span>;

 */
public class FSubroutines extends FAssignStmt implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:170
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	if (getFunctionCall().indexOf("PRINT") != -1) {
    		sb.append(getFunctionCall()+";");
    	}
    	else if (getFunctionCall().indexOf("READ") != -1) {
    		sb.append(getFunctionCall());
    	}
    	else {
    		sb.append("CALL "+getFunctionCall()+";");
    	}
    }
  /**
   * @declaredat ASTNode:1
   */
  public FSubroutines() {
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
  public FSubroutines(String p0, String p1, Opt<ExtraInlined> p2, String p3, Opt<RuntimeAllocate> p4, String p5) {
    setFLHS(p0);
    setFRHS(p1);
    setChild(p2, 0);
    setIndent(p3);
    setChild(p4, 1);
    setFunctionCall(p5);
  }
  /**
   * @declaredat ASTNode:23
   */
  public FSubroutines(beaver.Symbol p0, beaver.Symbol p1, Opt<ExtraInlined> p2, beaver.Symbol p3, Opt<RuntimeAllocate> p4, beaver.Symbol p5) {
    setFLHS(p0);
    setFRHS(p1);
    setChild(p2, 0);
    setIndent(p3);
    setChild(p4, 1);
    setFunctionCall(p5);
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
  public FSubroutines clone() throws CloneNotSupportedException {
    FSubroutines node = (FSubroutines) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:71
   */
  public FSubroutines copy() {
    try {
      FSubroutines node = (FSubroutines) clone();
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
  public FSubroutines fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:99
   */
  public FSubroutines treeCopyNoTransform() {
    FSubroutines tree = (FSubroutines) copy();
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
  public FSubroutines treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:126
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_FLHS == ((FSubroutines)node).tokenString_FLHS) && (tokenString_FRHS == ((FSubroutines)node).tokenString_FRHS) && (tokenString_Indent == ((FSubroutines)node).tokenString_Indent) && (tokenString_FunctionCall == ((FSubroutines)node).tokenString_FunctionCall);    
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
    setChild(opt, 0);
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
    return (Opt<ExtraInlined>) getChild(0);
  }
  /**
   * Retrieves the optional node for child ExtraInlined. This is the <code>Opt</code> node containing the child ExtraInlined, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ExtraInlined.
   * @apilevel low-level
   */
  public Opt<ExtraInlined> getExtraInlinedOptNoTransform() {
    return (Opt<ExtraInlined>) getChildNoTransform(0);
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
    setChild(opt, 1);
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
    return (Opt<RuntimeAllocate>) getChild(1);
  }
  /**
   * Retrieves the optional node for child RuntimeAllocate. This is the <code>Opt</code> node containing the child RuntimeAllocate, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child RuntimeAllocate.
   * @apilevel low-level
   */
  public Opt<RuntimeAllocate> getRuntimeAllocateOptNoTransform() {
    return (Opt<RuntimeAllocate>) getChildNoTransform(1);
  }
  /**
   * Replaces the lexeme FunctionCall.
   * @param value The new value for the lexeme FunctionCall.
   * @apilevel high-level
   */
  public void setFunctionCall(String value) {
    tokenString_FunctionCall = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FunctionCall;
  /**
   */
  public int FunctionCallstart;
  /**
   */
  public int FunctionCallend;
  /**
   * JastAdd-internal setter for lexeme FunctionCall using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FunctionCall
   * @apilevel internal
   */
  public void setFunctionCall(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFunctionCall is only valid for String lexemes");
    tokenString_FunctionCall = (String)symbol.value;
    FunctionCallstart = symbol.getStart();
    FunctionCallend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FunctionCall.
   * @return The value for the lexeme FunctionCall.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FunctionCall")
  public String getFunctionCall() {
    return tokenString_FunctionCall != null ? tokenString_FunctionCall : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
