/*****************************************************
 * class Latkes
 * Implements a stack of Strings using an array as underlying container.
 * new in Version 3: typed for generics
 *****************************************************/

public class Latkes<T> implements Stack<T> {

    private T [] _stack;
    private int _stackSize;


    //constructor
    public Latkes() { 
	_stack = ( T[] )new Object[42];
	_stackSize = 0;
    }

    public Latkes( int size ) { 
	_stack = ( T[] )new Object[size];
	_stackSize = 0;
    }


    //means of insertion
    public void push( T s ) { 
	//if necessary, create more storage space
	if ( isFull() ) {
	    T[] temp = ( T[] )new Object[ _stack.length * 2 + 1 ];	
	    for( int i = 0; i < _stack.length; i++ ) {
		temp[i] = _stack[i];
	    }
	    _stack = temp; //old _stack will be devoured by JGC
	}
	//add new element at end of array
	//Q: Why is this more efficient than inserting at front?
	_stack[_stackSize] = s;
	_stackSize++;
    }


    //means of viewing top element without removing
    public T peek( ) { 
	T retVal = null;
	if ( isEmpty() )  return null;
	retVal = _stack[ _stackSize-1 ];
	return retVal;
    }


    //means of removal
    public T pop( ) { 
	T retVal = null;
	if ( isEmpty() )  return null;
	retVal = _stack[ _stackSize---1 ];
	return retVal;
    }


    //chk for emptiness
    public boolean isEmpty() { 
	return _stackSize == 0; 
    }


    //chk for fullness
    public boolean isFull() {
	return _stackSize >= _stack.length; 
    }


    //main method for testing
    public static void main( String[] args ) {

	Latkes<String> tastyStack = new Latkes<String>(10);

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coocoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//joo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//ioo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//hoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//goo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//foo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//eoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//doo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//coo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//boo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	//aoo
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );

	//stack empty by now; SOP(null)
	System.out.println( "peek: " + tastyStack.peek() );
	System.out.println( "pop: " + tastyStack.pop() );
	System.out.println( tastyStack.pop() );
    }

}//end class Latkes