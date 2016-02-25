/* This file was generated with JastAdd2 (http://jastadd.org) version 2.1.9 */
package natlab.backends.Fortran.codegen_readable.FortranAST_readable;

/**
 * @ast node
 * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/FortranIR_readable.ast:2
 * @production Subprogram : {@link ASTNode} ::= <span class="component">{@link ProgramTitle}</span> <span class="component">{@link DeclarationSection}</span> <span class="component">{@link BackupVar}*</span> <span class="component">[{@link GetInput}]</span> <span class="component">{@link StatementSection}</span> <span class="component">&lt;ProgramEnd:String&gt;</span>;

 */
public class Subprogram extends ASTNode<ASTNode> implements Cloneable {
  /**
   * @aspect PrettyPrinter
   * @declaredat /Users/wukefe/Desktop/hobby/mc2for/Mc2ForProject/languages/Natlab/src/natlab/backends/Fortran/codegen_readable/PrettyPrinter.jadd:6
   */
  public void pp(StringBuffer sb) {
		getProgramTitle().pp(sb);
		getDeclarationSection().pp(sb);
		int size = getNumBackupVar();
    	for (int i=0;i<size;i++) {
    		getBackupVar(i).pp(sb);
    	}
    	if (hasGetInput()) {
    		getGetInput().pp(sb);
    	}
		getStatementSection().pp(sb);
		sb.append(getProgramEnd()+"\n");
	}
  /**
   * @declaredat ASTNode:1
   */
  public Subprogram() {
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
    children = new ASTNode[5];
    setChild(new List(), 2);
    setChild(new Opt(), 3);
  }
  /**
   * @declaredat ASTNode:15
   */
  public Subprogram(ProgramTitle p0, DeclarationSection p1, List<BackupVar> p2, Opt<GetInput> p3, StatementSection p4, String p5) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
    setChild(p4, 4);
    setProgramEnd(p5);
  }
  /**
   * @declaredat ASTNode:23
   */
  public Subprogram(ProgramTitle p0, DeclarationSection p1, List<BackupVar> p2, Opt<GetInput> p3, StatementSection p4, beaver.Symbol p5) {
    setChild(p0, 0);
    setChild(p1, 1);
    setChild(p2, 2);
    setChild(p3, 3);
    setChild(p4, 4);
    setProgramEnd(p5);
  }
  /**
   * @apilevel low-level
   * @declaredat ASTNode:34
   */
  protected int numChildren() {
    return 5;
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
  public Subprogram clone() throws CloneNotSupportedException {
    Subprogram node = (Subprogram) super.clone();
    return node;
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:71
   */
  public Subprogram copy() {
    try {
      Subprogram node = (Subprogram) clone();
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
  public Subprogram fullCopy() {
    return treeCopyNoTransform();
  }
  /**
   * Create a deep copy of the AST subtree at this node.
   * The copy is dangling, i.e. has no parent.
   * @return dangling copy of the subtree at this node
   * @apilevel low-level
   * @declaredat ASTNode:99
   */
  public Subprogram treeCopyNoTransform() {
    Subprogram tree = (Subprogram) copy();
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
  public Subprogram treeCopy() {
    doFullTraversal();
    return treeCopyNoTransform();
  }
  /**
   * @apilevel internal
   * @declaredat ASTNode:126
   */
  protected boolean is$Equal(ASTNode node) {
    return super.is$Equal(node)  && (tokenString_ProgramEnd == ((Subprogram)node).tokenString_ProgramEnd);    
  }
  /**
   * Replaces the ProgramTitle child.
   * @param node The new node to replace the ProgramTitle child.
   * @apilevel high-level
   */
  public void setProgramTitle(ProgramTitle node) {
    setChild(node, 0);
  }
  /**
   * Retrieves the ProgramTitle child.
   * @return The current node used as the ProgramTitle child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="ProgramTitle")
  public ProgramTitle getProgramTitle() {
    return (ProgramTitle) getChild(0);
  }
  /**
   * Retrieves the ProgramTitle child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the ProgramTitle child.
   * @apilevel low-level
   */
  public ProgramTitle getProgramTitleNoTransform() {
    return (ProgramTitle) getChildNoTransform(0);
  }
  /**
   * Replaces the DeclarationSection child.
   * @param node The new node to replace the DeclarationSection child.
   * @apilevel high-level
   */
  public void setDeclarationSection(DeclarationSection node) {
    setChild(node, 1);
  }
  /**
   * Retrieves the DeclarationSection child.
   * @return The current node used as the DeclarationSection child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="DeclarationSection")
  public DeclarationSection getDeclarationSection() {
    return (DeclarationSection) getChild(1);
  }
  /**
   * Retrieves the DeclarationSection child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the DeclarationSection child.
   * @apilevel low-level
   */
  public DeclarationSection getDeclarationSectionNoTransform() {
    return (DeclarationSection) getChildNoTransform(1);
  }
  /**
   * Replaces the BackupVar list.
   * @param list The new list node to be used as the BackupVar list.
   * @apilevel high-level
   */
  public void setBackupVarList(List<BackupVar> list) {
    setChild(list, 2);
  }
  /**
   * Retrieves the number of children in the BackupVar list.
   * @return Number of children in the BackupVar list.
   * @apilevel high-level
   */
  public int getNumBackupVar() {
    return getBackupVarList().getNumChild();
  }
  /**
   * Retrieves the number of children in the BackupVar list.
   * Calling this method will not trigger rewrites.
   * @return Number of children in the BackupVar list.
   * @apilevel low-level
   */
  public int getNumBackupVarNoTransform() {
    return getBackupVarListNoTransform().getNumChildNoTransform();
  }
  /**
   * Retrieves the element at index {@code i} in the BackupVar list.
   * @param i Index of the element to return.
   * @return The element at position {@code i} in the BackupVar list.
   * @apilevel high-level
   */
  public BackupVar getBackupVar(int i) {
    return (BackupVar) getBackupVarList().getChild(i);
  }
  /**
   * Check whether the BackupVar list has any children.
   * @return {@code true} if it has at least one child, {@code false} otherwise.
   * @apilevel high-level
   */
  public boolean hasBackupVar() {
    return getBackupVarList().getNumChild() != 0;
  }
  /**
   * Append an element to the BackupVar list.
   * @param node The element to append to the BackupVar list.
   * @apilevel high-level
   */
  public void addBackupVar(BackupVar node) {
    List<BackupVar> list = (parent == null || state == null) ? getBackupVarListNoTransform() : getBackupVarList();
    list.addChild(node);
  }
  /**
   * @apilevel low-level
   */
  public void addBackupVarNoTransform(BackupVar node) {
    List<BackupVar> list = getBackupVarListNoTransform();
    list.addChild(node);
  }
  /**
   * Replaces the BackupVar list element at index {@code i} with the new node {@code node}.
   * @param node The new node to replace the old list element.
   * @param i The list index of the node to be replaced.
   * @apilevel high-level
   */
  public void setBackupVar(BackupVar node, int i) {
    List<BackupVar> list = getBackupVarList();
    list.setChild(node, i);
  }
  /**
   * Retrieves the BackupVar list.
   * @return The node representing the BackupVar list.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.ListChild(name="BackupVar")
  public List<BackupVar> getBackupVarList() {
    List<BackupVar> list = (List<BackupVar>) getChild(2);
    list.getNumChild();
    return list;
  }
  /**
   * Retrieves the BackupVar list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BackupVar list.
   * @apilevel low-level
   */
  public List<BackupVar> getBackupVarListNoTransform() {
    return (List<BackupVar>) getChildNoTransform(2);
  }
  /**
   * Retrieves the BackupVar list.
   * @return The node representing the BackupVar list.
   * @apilevel high-level
   */
  public List<BackupVar> getBackupVars() {
    return getBackupVarList();
  }
  /**
   * Retrieves the BackupVar list.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The node representing the BackupVar list.
   * @apilevel low-level
   */
  public List<BackupVar> getBackupVarsNoTransform() {
    return getBackupVarListNoTransform();
  }
  /**
   * Replaces the optional node for the GetInput child. This is the <code>Opt</code>
   * node containing the child GetInput, not the actual child!
   * @param opt The new node to be used as the optional node for the GetInput child.
   * @apilevel low-level
   */
  public void setGetInputOpt(Opt<GetInput> opt) {
    setChild(opt, 3);
  }
  /**
   * Replaces the (optional) GetInput child.
   * @param node The new node to be used as the GetInput child.
   * @apilevel high-level
   */
  public void setGetInput(GetInput node) {
    getGetInputOpt().setChild(node, 0);
  }
  /**
   * Check whether the optional GetInput child exists.
   * @return {@code true} if the optional GetInput child exists, {@code false} if it does not.
   * @apilevel high-level
   */
  public boolean hasGetInput() {
    return getGetInputOpt().getNumChild() != 0;
  }
  /**
   * Retrieves the (optional) GetInput child.
   * @return The GetInput child, if it exists. Returns {@code null} otherwise.
   * @apilevel low-level
   */
  public GetInput getGetInput() {
    return (GetInput) getGetInputOpt().getChild(0);
  }
  /**
   * Retrieves the optional node for the GetInput child. This is the <code>Opt</code> node containing the child GetInput, not the actual child!
   * @return The optional node for child the GetInput child.
   * @apilevel low-level
   */
  @ASTNodeAnnotation.OptChild(name="GetInput")
  public Opt<GetInput> getGetInputOpt() {
    return (Opt<GetInput>) getChild(3);
  }
  /**
   * Retrieves the optional node for child GetInput. This is the <code>Opt</code> node containing the child GetInput, not the actual child!
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The optional node for child GetInput.
   * @apilevel low-level
   */
  public Opt<GetInput> getGetInputOptNoTransform() {
    return (Opt<GetInput>) getChildNoTransform(3);
  }
  /**
   * Replaces the StatementSection child.
   * @param node The new node to replace the StatementSection child.
   * @apilevel high-level
   */
  public void setStatementSection(StatementSection node) {
    setChild(node, 4);
  }
  /**
   * Retrieves the StatementSection child.
   * @return The current node used as the StatementSection child.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Child(name="StatementSection")
  public StatementSection getStatementSection() {
    return (StatementSection) getChild(4);
  }
  /**
   * Retrieves the StatementSection child.
   * <p><em>This method does not invoke AST transformations.</em></p>
   * @return The current node used as the StatementSection child.
   * @apilevel low-level
   */
  public StatementSection getStatementSectionNoTransform() {
    return (StatementSection) getChildNoTransform(4);
  }
  /**
   * Replaces the lexeme ProgramEnd.
   * @param value The new value for the lexeme ProgramEnd.
   * @apilevel high-level
   */
  public void setProgramEnd(String value) {
    tokenString_ProgramEnd = value;
  }
  /**
   * @apilevel internal
   */
  protected String tokenString_ProgramEnd;
  /**
   */
  public int ProgramEndstart;
  /**
   */
  public int ProgramEndend;
  /**
   * JastAdd-internal setter for lexeme ProgramEnd using the Beaver parser.
   * @param symbol Symbol containing the new value for the lexeme ProgramEnd
   * @apilevel internal
   */
  public void setProgramEnd(beaver.Symbol symbol) {
    if(symbol.value != null && !(symbol.value instanceof String))
    throw new UnsupportedOperationException("setProgramEnd is only valid for String lexemes");
    tokenString_ProgramEnd = (String)symbol.value;
    ProgramEndstart = symbol.getStart();
    ProgramEndend = symbol.getEnd();
  }
  /**
   * Retrieves the value for the lexeme ProgramEnd.
   * @return The value for the lexeme ProgramEnd.
   * @apilevel high-level
   */
  @ASTNodeAnnotation.Token(name="ProgramEnd")
  public String getProgramEnd() {
    return tokenString_ProgramEnd != null ? tokenString_ProgramEnd : "";
  }
  /**
   * @apilevel internal
   */
  public ASTNode rewriteTo() {    return super.rewriteTo();
  }}
