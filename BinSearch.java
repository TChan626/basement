/*==================================================
  class BinSearch -- Implements binary search algorithm on an int array.
  Team CS -- Clyde Bonneville, Thluffy Jones, Upton Sinclair

  Summary of Binary Search Algorithm:
  1. If no items in search range, done.
  2. Compare target to value at middle index of search range
  3. If val == target, done
     else if target < val, recurse on lower half of search range
     else recurse on upper half of search range

  Runtime Classification: O(logn)

  ==================================================*/


public class BinSearch {

    /*==================================================
      int binSearch(int[],int) -- searches an array of ints for target int
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( int[] a, int target ) {
	//uncomment exactly 1 of the 2 stmts below:
	//return binSearchIter( a, target, 0, a.length-1 );
	return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( int[] a, int target, int lo, int hi ) {
	int tPos = -1; //init return var to flag value -1
	int m = (lo + hi) / 2; //init mid pos var

	if (lo > hi) //exit case. If lo & hi have crossed, target not present
	    return tPos; //-1

	if ( a[m] == target ) // target found
	    tPos = m;
	else if ( a[m] > target ) // value at middle index higher than target
	    tPos = binSearchRec( a, target, 0, m-1 ); //n->n/2
	else if ( a[m] < target ) // value at middle index lower than target
	    tPos = binSearchRec( a, target, m+1, hi ); //n->n/2
	
	return tPos;
    }//end binSearchRec, O(logn)


    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	int tPos = -1; //init return var to flag value -1
	int m = (lo + hi) / 2; //init mid pos var

	while( lo <= hi ) { // run until lo & hi cross
	    m = (lo + hi) / 2; //update mid pos var
	    if ( a[m] == target ) // target found
		return m;
	    else if ( a[m] > target ) // value at mid index higher than target
		hi = m - 1; //move hi to index to left of mid, n->n/2
	    else if ( a[m] < target ) // value at mid index lower than target
		lo = m + 1; //move lo to index to right of mid, n->n/2
	}
	return tPos;
    }//end binSearchIter, O(logn)


    //tell whether an array is sorted in ascending order
    private static boolean isSorted( int[] arr ) {

	boolean retBoo = true; //init to true, assume array is sorted

	//Q: Why would a FOREACH loop not suffice here?
	for( int i=0; i < arr.length-1; i++ ) {
	    if ( !( arr[i] < arr[i+1] ) ) {
		return false;
	    }
	}
	return retBoo; //if entire array was traversed, it must be sorted
    }


    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( int[] arr ) {
	String output = "[ "; 

	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	int[] iArr = { 2, 4, 6, 8, 6, 42 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "sorted? -- " + isSorted(iArr2) );

	//search for 6 in array 
	System.out.println( binSearch(iArr,6) );

	//search for 43 in array 
	System.out.println( binSearch(iArr,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	/*==================================================
	==================================================*/

    }//end main()


}//end class BinSearch
