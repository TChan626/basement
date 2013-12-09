/*==================================================
  class SuperArray version 5.0
  Wrapper class for array. Facilitates 
  *  resizing 
  *  expansion 
  *  read/write capability on elements
  *  adding an element to end of array
  *  adding an element at specified index
  *  removing an element at specified index
  ...and now SuperArray complies with the specifications of the 
  List interface. (List.java must be in same dir as this file)
  ==================================================*/

public class SuperArray<T> implements List<T> {

    private T[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values


    //default constructor
    //initializes 10-item array
    public SuperArray() { 
	_data = (T[])new Object[10];
	_lastPos = 0;
	_size = 0;	
    }


    //output array in [a,b,c] format
    //eg, for Object[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() { 
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of this instance of SuperArray 
    private void expand() { 
	T[] temp = (T[])new Object[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor method -- return value at specified index
    public T get( int index ) {
	return _data[index];
    }


    //mutator method -- set index to newItem, return old value at index
    public T set( int index, T newItem ) {
	T temp = _data[index];
	_data[index] = newItem;
	return temp;
    }


    //adds an item after the last item
    //always returns true
    public boolean add( T newItem ) { 
	//first expand if necessary
	if ( _size >= _data.length )
		expand(); 
	_data[_lastPos] = newItem;
	_lastPos++;
	_size++;
	return true;
    }


    //inserts an item at index    
    public void add( int index, T newItem ) { 
	//first expand if necessary
	if ( _size >= _data.length )
		expand();
	if ( index == _lastPos ) 
	    add(newItem);
	else {
	    for( int i = _size; i > index; i-- ) {
		_data[i] = _data[i-1]; //each slot gets value of left neighbor
	    } 
	    _data[index] = newItem;
	    _lastPos++;
	    _size++;
	}
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    //returns removed value
    public T remove( int index ) { 
	T retItem = _data[index];
	for( int i = index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_data[_size-1] = null;
	_size--;
	_lastPos--;
	return retItem;
    }


    //return number of meaningful items in _data
    public int size() {
	return _size;
    }


    public static void main( String[] args ) {

	SuperArray<Integer> mayfield = new SuperArray<Integer>();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	/*===========================================
	===========================================*/
    }//end main()

}//end class SuperArray
