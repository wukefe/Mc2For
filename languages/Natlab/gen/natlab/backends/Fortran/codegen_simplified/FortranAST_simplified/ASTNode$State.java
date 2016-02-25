package natlab.backends.Fortran.codegen_simplified.FortranAST_simplified;

/**
 * @ast class
 * @declaredat ASTNode$State:4
 */
public class ASTNode$State extends java.lang.Object {

  /**
   * @apilevel internal
   */
  public boolean LAST_CYCLE = false;


    
  /**
   * @apilevel internal
   */
  public boolean INTERMEDIATE_VALUE = false;

 
  
  /**
   * @apilevel internal
   */
  public boolean IN_CIRCLE = false;



  /**
   * @apilevel internal
   */
  public int CIRCLE_INDEX = 1;



  /**
   * @apilevel internal
   */
  public boolean CHANGE = false;



  /**
   * @apilevel internal
   */
  public boolean RESET_CYCLE = false;



  /**
   * @apilevel internal
   */
  static public class CircularValue {
    Object value;
    int visited = -1;
  }


  /**
   * @apilevel internal
   */
  public static final int REWRITE_CHANGE = 1;



  /**
   * @apilevel internal
   */
  public static final int REWRITE_NOCHANGE = 2;



  /**
   * @apilevel internal
   */
  public static final int REWRITE_INTERRUPT = 3;



  public int boundariesCrossed = 0;



  // state code
  private int[] stack;



  private int pos;



  public ASTNode$State() {
    stack = new int[64];
    pos = 0;
  }



  private void ensureSize(int size) {
    if(size < stack.length)
      return;
    int[] newStack = new int[stack.length * 2];
    System.arraycopy(stack, 0, newStack, 0, stack.length);
    stack = newStack;
  }



  public void push(int i) {
    ensureSize(pos+1);
    stack[pos++] = i;
  }



  public int pop() {
    return stack[--pos];
  }



  public int peek() {
    return stack[pos-1];
  }

public void reset() {
    IN_CIRCLE = false;
    CIRCLE_INDEX = 1;
    CHANGE = false;
    LAST_CYCLE = false;
    boundariesCrossed = 0;

  }


}
