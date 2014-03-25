/*****************************************************
 * class LList
 * Implements a linked list of LLNodes.
 * Version 03 is generically typed 
 *   (Each instance of class LList may hold only one type of object.)
 *****************************************************/

public class LList<T> implements List<T> { //your List.java must be in same dir

    //instance vars
    private LLNode<T> _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) {
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    public boolean add( T newVal ) { 
	_head = new LLNode<T>( newVal, _head );	
	_size++;
	return true;
    } 


    public T get( int index ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T retVal;
	LLNode<T> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    } 


    public T set( int index, T newVal ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode<T> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	T oldVal = tmp.getCargo();
	
	//modify target node's cargo
	tmp.setCargo( newVal );
	
	return oldVal;
    } 


    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    //insert a node containing newVal at position index
    public void add( int index, T newVal ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	LLNode<T> newNode = new LLNode<T>( newVal, null );

	//if index==0, insert node before head node
	if ( index == 0 ) 
	    add( newVal );
	else {
	    LLNode<T> tmp = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //insert new node
	    newNode.setNext( tmp.getNext() );
	    tmp.setNext( newNode );

	    //increment size attribute
	    _size++;
	}
    }


    //remove node at pos index, return its cargo
    public T remove( int index ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	T retVal;
	LLNode<T> tmp = _head; //create alias to head

	//if index==0, remove head node
	if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();	    
	}
	else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp = tmp.getNext();

	    //check target node's cargo hold
	    retVal = tmp.getNext().getCargo();

	    //remove target node
	    tmp.setNext( tmp.getNext().getNext() );
	}

	return retVal;
    }


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode<T> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) {

	LList<String> james = new LList<String>();

	System.out.println("initially: " );
	System.out.println( james + "\tsize: " + james.size() );

	james.add("beat");
	System.out.println( james + "\tsize: " + james.size() );

	james.add("a");
	System.out.println( james + "\tsize: " + james.size() );

	james.add("need");
	System.out.println( james + "\tsize: " + james.size() );

	james.add("I");
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james + "\tsize: " + james.size() );

	james.add(0,"whut");
	System.out.println( "...after add(0,whut): " );
	System.out.println( james + "\tsize: " + james.size() );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove last: " 
			    + james.remove( james._size-1) );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james + "\tsize: " + james.size() );
    }

}//end class LList



