/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:36
 * @production IOOperationExpr : {@link AbstractAssignToListStmt} ::= <span class="component">&lt;Indent:String&gt;</span> <span class="component">[{@link RuntimeAllocate}]</span> <span class="component">&lt;IOOperator:String&gt;</span> <span class="component">&lt;ArgsList:String&gt;</span>;

 */
public class IOOperationExpr extends AbstractAssignToListStmt implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:208
   */
  public void pp(StringBuffer sb) {
    	if (hasRuntimeAllocate()) getRuntimeAllocate().pp(sb);
    	sb.append(getIndent());
    	sb.append(getIOOperator()+getArgsList()+";");
    }
  /**
   * @declaredat ASTNode:1
   */
  public IOOperationExpr() {
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
  public IOOperationExpr(String p0, Opt<RuntimeAllocate> p1, String p2, String p3) {
    setIndent(p0);
    setChild(p1, 0);
    setIOOperator(p2);
    setArgsList(p3);
  }
  /**
   * @declaredat ASTNode:20
   */
  public IOOperationExpr(beaver.Symbol p0, Opt<RuntimeAllocate> p1, beaver.Symbol p2, beaver.Symbol p3) {
    setIndent(p0);
    setChild(p1, 0);
    setIOOperator(p2);
    setArgsList(p3);
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
  public IOOperationExpr clone() throws CloneNotSupportedException {
    IOOperationExpr node = (IOOperationExpr) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:66
   */
  public IOOperationExpr copy() {
    try {
      IOOperationExpr node = (IOOperationExpr) clone();
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
  public IOOperationExpr fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:94
   */
  public IOOperationExpr treeCopyNoTransform() {
    IOOperationExpr tree = (IOOperationExpr) copy();
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
  public IOOperationExpr treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:121
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_Indent == ((IOOperationExpr)node).tokenString_Indent) && (tokenString_IOOperator == ((IOOperationExpr)node).tokenString_IOOperator) && (tokenString_ArgsList == ((IOOperationExpr)node).tokenString_ArgsList);    
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
   * Replaces the lexeme IOOperator.
   * @param value The new value for the lexeme IOOperator.
   * @apilevel high-level
   */
  public void setIOOperator(String value) {
    tokenString_IOOperator = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_IOOperator;
  /**
   */
  public int IOOperatorstart;
  /**
   */
  public int IOOperatorend;
  /**
   * JastAdd-internal setter for lexeme IOOperator using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme IOOperator
   * @apilevel internal
   */
  public void setIOOperator(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setIOOperator is only valid for String lexemes");
    tokenString_IOOperator = (String)symbol.value;
    IOOperatorstart = symbol.getStart();
    IOOperatorend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme IOOperator.
   * @return The value for the lexeme IOOperator.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="IOOperator")
  public String getIOOperator() {
    return tokenString_IOOperator != null ? tokenString_IOOperator : "";
  }
  /**
   * Replaces the lexeme ArgsList.
   * @param value The new value for the lexeme ArgsList.
   * @apilevel high-level
   */
  public void setArgsList(String value) {
    tokenString_ArgsList = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_ArgsList;
  /**
   */
  public int ArgsListstart;
  /**
   */
  public int ArgsListend;
  /**
   * JastAdd-internal setter for lexeme ArgsList using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ArgsList
   * @apilevel internal
   */
  public void setArgsList(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setArgsList is only valid for String lexemes");
    tokenString_ArgsList = (String)symbol.value;
    ArgsListstart = symbol.getStart();
    ArgsListend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ArgsList.
   * @return The value for the lexeme ArgsList.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ArgsList")
  public String getArgsList() {
    return tokenString_ArgsList != null ? tokenString_ArgsList : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
