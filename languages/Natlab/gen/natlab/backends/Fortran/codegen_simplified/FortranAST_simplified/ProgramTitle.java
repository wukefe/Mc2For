/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/FortranIR_simplified.ast:5
 * @production ProgramTitle : {@link ASTNode} ::= <span class="component">&lt;ProgramType:String&gt;</span> <span class="component">&lt;ProgramName:String&gt;</span> <span class="component">[{@link ProgramParameterList}]</span> <span class="component">{@link Module}*</span>;

 */
public class ProgramTitle extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_simplified/PrettyPrinter.jadd:21
   */
  public void pp(StringBuffer sb) {
	    sb.append(getProgramType()+" "+getProgramName());
	    if (hasProgramParameterList()) {
	    	sb.append("(");
	    	getProgramParameterList().pp(sb);
	    	sb.append(")");
	    }
	    int size = getNumModule();
	    if (size>0) {
		    for (int i=0;i<size;i++) {
		    	getModule(i).pp(sb);
	    	}
	    }
	    sb.append("\nIMPLICIT NONE\n");
	}
  /**
   * @declaredat ASTNode:1
   */
  public ProgramTitle() {
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
  public ProgramTitle(String p0, String p1, Opt<ProgramParameterList> p2, List<Module> p3) {
    setProgramType(p0);
    setProgramName(p1);
    setChild(p2, 0);
    setChild(p3, 1);
  }
  /**
   * @declaredat ASTNode:21
   */
  public ProgramTitle(beaver.Symbol p0, beaver.Symbol p1, Opt<ProgramParameterList> p2, List<Module> p3) {
    setProgramType(p0);
    setProgramName(p1);
    setChild(p2, 0);
    setChild(p3, 1);
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
  public ProgramTitle clone() throws CloneNotSupportedException {
    ProgramTitle node = (ProgramTitle) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:67
   */
  public ProgramTitle copy() {
    try {
      ProgramTitle node = (ProgramTitle) clone();
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
  public ProgramTitle fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:95
   */
  public ProgramTitle treeCopyNoTransform() {
    ProgramTitle tree = (ProgramTitle) copy();
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
  public ProgramTitle treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:122
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_ProgramType == ((ProgramTitle)node).tokenString_ProgramType) && (tokenString_ProgramName == ((ProgramTitle)node).tokenString_ProgramName);    
  }
  /**
   * Replaces the lexeme ProgramType.
   * @param value The new value for the lexeme ProgramType.
   * @apilevel high-level
   */
  public void setProgramType(String value) {
    tokenString_ProgramType = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_ProgramType;
  /**
   */
  public int ProgramTypestart;
  /**
   */
  public int ProgramTypeend;
  /**
   * JastAdd-internal setter for lexeme ProgramType using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ProgramType
   * @apilevel internal
   */
  public void setProgramType(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setProgramType is only valid for String lexemes");
    tokenString_ProgramType = (String)symbol.value;
    ProgramTypestart = symbol.getStart();
    ProgramTypeend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ProgramType.
   * @return The value for the lexeme ProgramType.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ProgramType")
  public String getProgramType() {
    return tokenString_ProgramType != null ? tokenString_ProgramType : "";
  }
  /**
   * Replaces the lexeme ProgramName.
   * @param value The new value for the lexeme ProgramName.
   * @apilevel high-level
   */
  public void setProgramName(String value) {
    tokenString_ProgramName = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_ProgramName;
  /**
   */
  public int ProgramNamestart;
  /**
   */
  public int ProgramNameend;
  /**
   * JastAdd-internal setter for lexeme ProgramName using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ProgramName
   * @apilevel internal
   */
  public void setProgramName(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setProgramName is only valid for String lexemes");
    tokenString_ProgramName = (String)symbol.value;
    ProgramNamestart = symbol.getStart();
    ProgramNameend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ProgramName.
   * @return The value for the lexeme ProgramName.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ProgramName")
  public String getProgramName() {
    return tokenString_ProgramName != null ? tokenString_ProgramName : "";
  }
  /**
   * Replaces the optional node for the ProgramParameterList child. This is the <code>Opt</code>
   * node containing the child ProgramParameterList, not the actual child!
   * @param opt The new node to be used as the optional node for the ProgramParameterList child.
   * @apilevel low-level
   */
  public void setProgramParameterListOpt(Opt<ProgramParameterList> opt) {
    setChild(opt, 0);
  }
  /**
   * Replaces the (optional) ProgramParameterList child.
   * @param node The new node to be used as the ProgramParameterList child.
   * @apilevel high-level
   */
  public void setProgramParameterList(ProgramParameterList node) {
    getProgramParameterListOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional ProgramParameterList child exists.
   * @return {@code true} if the optional ProgramParameterList child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasProgramParameterList() {
    return getProgramParameterListOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) ProgramParameterList child.
   * @return The ProgramParameterList child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public ProgramParameterList getProgramParameterList() {
    return (ProgramParameterList) getProgramParameterListOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the ProgramParameterList child. This is the <code>Opt</code> node containing the child ProgramParameterList, not the actual child!
   * @return The optional node for child the ProgramParameterList child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="ProgramParameterList")
  public Opt<ProgramParameterList> getProgramParameterListOpt() {
    return (Opt<ProgramParameterList>) getChild(0);
  }
  /**
   * Retrieves the optional node for child ProgramParameterList. This is the <code>Opt</code> node containing the child ProgramParameterList, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child ProgramParameterList.
   * @apilevel low-level
   */
  public Opt<ProgramParameterList> getProgramParameterListOptNoTransform() {
    return (Opt<ProgramParameterList>) getChildNoTransform(0);
  }
  /**
   * Replaces the Module list.
   * @param list The new list node to be used as the Module list.
   * @apilevel high-level
   */
  public void setModuleList(List<Module> list) {
    setChild(list, 1);
  }
  /**
   * Retrieves the number of children in the Module list.
   * @return Number of children in the Module list.
   * @apilevel high-level
   */
  public int getNumModule() {
    return getModuleList().getNumChild();
  }
  /**
   * Retrieves the number of children in the Module list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the Module list.
   * @apilevel low-level
   */
  public int getNumModuleNoTransform() {
    return getModuleListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the Module list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the Module list.
   * @apilevel high-level
   */
  public Module getModule(int i) {
    return (Module) getModuleList().getChild(i);
  }
  /**
   * Check whether the Module list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasModule() {
    return getModuleList().getNumChild() != 0;
  }
  /**
   * Append an element to the Module list.
   * @param node The element to append to the Module list.
   * @apilevel high-level
   */
  public void addModule(Module node) {
    List<Module> list = (parent == null || state == null) ? getModuleListNoTransform() : getModuleList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addModuleNoTransform(Module node) {
    List<Module> list = getModuleListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the Module list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setModule(Module node, int i) {
    List<Module> list = getModuleList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the Module list.
   * @return The node representing the Module list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="Module")
  public List<Module> getModuleList() {
    List<Module> list = (List<Module>) getChild(1);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the Module list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Module list.
   * @apilevel low-level
   */
  public List<Module> getModuleListNoTransform() {
    return (List<Module>) getChildNoTransform(1);
  }
  /**
   * Retrieves the Module list.
   * @return The node representing the Module list.
   * @apilevel high-level
   */
  public List<Module> getModules() {
    return getModuleList();
  }
  /**
   * Retrieves the Module list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the Module list.
   * @apilevel low-level
   */
  public List<Module> getModulesNoTransform() {
    return getModuleListNoTransform();
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
