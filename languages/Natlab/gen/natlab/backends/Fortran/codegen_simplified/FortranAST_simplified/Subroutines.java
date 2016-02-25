/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:38
 * @production Subroutines : {@link AbstractAssignToListStmt} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">&lt;FuncName:String&gt;</span> <span class="component">&lt;InputArgsList:String&gt;</span> <span class="component">&lt;OutputArgsList:String&gt;</span>;

 */
public class Subroutines extends AbstractAssignToListStmt implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:214
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	sb.append("CALL "+getFuncName()+"("+getInputArgsList()+", "+getOutputArgsList()+");");
    }
  /**
   * @declaredat ASTNode:1
   */
  public Subroutines() {
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
  public Subroutines(String p0, Opt<RuntimeAllocate> p1, String p2, String p3, String p4) {
    setIndent(p0);
    setChild(p1, 0);
    setFuncName(p2);
    setInputArgsList(p3);
    setOutputArgsList(p4);
  }
  /**
   * @declaredat ASTNode:21
   */
  public Subroutines(beaver.Symbol p0, Opt<RuntimeAllocate> p1, beaver.Symbol p2, beaver.Symbol p3, beaver.Symbol p4) {
    setIndent(p0);
    setChild(p1, 0);
    setFuncName(p2);
    setInputArgsList(p3);
    setOutputArgsList(p4);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:31
   */
  protected int numChildren() {
    return 1;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:37
   */
  public boolean mayHaveRewrite() {
    return false;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:43
   */
  public void flushAttrCache() {
    super.flushAttrCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:49
   */
  public void flushCollectionCache() {
    super.flushCollectionCache();
  }
  /**
   * @api internal
   * @declaredat ASTNode:55
   */
  public void flushRewriteCache() {
    super.flushRewriteCache();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:61
   */
  public Subroutines clone() throws CloneNotSupportedException {
    Subroutines node = (Subroutines) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:68
   */
  public Subroutines copy() {
    try {
      Subroutines node = (Subroutines) clone();
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
   * @declaredat ASTNode:87
   */
  public Subroutines fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:96
   */
  public Subroutines treeCopyNoTransform() {
    Subroutines tree = (Subroutines) copy();
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
   * @declaredat ASTNode:116
   */
  public Subroutines treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:123
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((Subroutines)node).tokenString_Indent) && (tokenString_FuncName == ((Subroutines)node).tokenString_FuncName) && (tokenString_InputArgsList == ((Subroutines)node).tokenString_InputArgsList) && (tokenString_OutputArgsList == ((Subroutines)node).tokenString_OutputArgsList);    
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
   * Replaces the lexeme FuncName.
   * @param value The new value for the lexeme FuncName.
   * @apilevel high-level
   */
  public void setFuncName(String value) {
    tokenString_FuncName = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_FuncName;
  /**
   */
  public int FuncNamestart;
  /**
   */
  public int FuncNameend;
  /**
   * JastAdd-internal setter for lexeme FuncName using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme FuncName
   * @apilevel internal
   */
  public void setFuncName(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setFuncName is only valid for String lexemes");
    tokenString_FuncName = (String)symbol.value;
    FuncNamestart = symbol.getStart();
    FuncNameend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme FuncName.
   * @return The value for the lexeme FuncName.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="FuncName")
  public String getFuncName() {
    return tokenString_FuncName != null ? tokenString_FuncName : "";
  }
  /**
   * Replaces the lexeme InputArgsList.
   * @param value The new value for the lexeme InputArgsList.
   * @apilevel high-level
   */
  public void setInputArgsList(String value) {
    tokenString_InputArgsList = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_InputArgsList;
  /**
   */
  public int InputArgsListstart;
  /**
   */
  public int InputArgsListend;
  /**
   * JastAdd-internal setter for lexeme InputArgsList using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme InputArgsList
   * @apilevel internal
   */
  public void setInputArgsList(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setInputArgsList is only valid for String lexemes");
    tokenString_InputArgsList = (String)symbol.value;
    InputArgsListstart = symbol.getStart();
    InputArgsListend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme InputArgsList.
   * @return The value for the lexeme InputArgsList.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="InputArgsList")
  public String getInputArgsList() {
    return tokenString_InputArgsList != null ? tokenString_InputArgsList : "";
  }
  /**
   * Replaces the lexeme OutputArgsList.
   * @param value The new value for the lexeme OutputArgsList.
   * @apilevel high-level
   */
  public void setOutputArgsList(String value) {
    tokenString_OutputArgsList = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_OutputArgsList;
  /**
   */
  public int OutputArgsListstart;
  /**
   */
  public int OutputArgsListend;
  /**
   * JastAdd-internal setter for lexeme OutputArgsList using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme OutputArgsList
   * @apilevel internal
   */
  public void setOutputArgsList(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setOutputArgsList is only valid for String lexemes");
    tokenString_OutputArgsList = (String)symbol.value;
    OutputArgsListstart = symbol.getStart();
    OutputArgsListend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme OutputArgsList.
   * @return The value for the lexeme OutputArgsList.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="OutputArgsList")
  public String getOutputArgsList() {
    return tokenString_OutputArgsList != null ? tokenString_OutputArgsList : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
