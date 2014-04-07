/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in-place
 *
 * Version 1 -- Assumes unique values in array.
 * 
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
 * if len(arr)==1, return arr
 * else
 *   a) select pivot fr dataset
 *   b) partition arr around pivot into lower, upper
 *   c) return { QSort(lower), pivot, Qsort(upper) }
 *
 * 2a. Worst pivot choice and associated runtime: 
 * If pivot is max or min of dataset -> O(n*n)
 *
 * 2b. Best pivot choice and associated runtime:
 * Ideally, median of dataset, but this is impractical.
 * Assuming a well-shuffled dataset, val at first or last position 
 * can be used since it will effectively be a random val.
 * Amortized over many recursive calls, a random pivot choice will still
 * yield O(nlogn) runtime
 *****************************************************/

public class QuickSort {

    //--------------v  HELPER METHODS  v--------------
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    public static int[] buildArray( int size, int numVals ) {
	int[] retArr = new int[size];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( numVals * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] d ) { 
	qsHelp( 0, d.length-1, d );
    }
    public static void qsHelp( int lo, int hi, int[] d ) { 

	if ( lo >= hi )
	    return;

	int tmpLo = lo; 
	int tmpHi = hi;
	int pivot = d[lo];

	while( tmpLo < tmpHi ) {
	    //first, slide markers in as far as possible without swaps
	    while( d[tmpLo] < pivot )  tmpLo++;
	    while( d[tmpHi] > pivot )  tmpHi--;
	    
	    swap( tmpLo, tmpHi, d );
	}

	//pivot has been floating around... plant it where it belongs
	d[tmpLo] = pivot;

	//recurse on lower and upper ranges
	qsHelp( lo, tmpLo-1, d );
	qsHelp( tmpLo+1, hi, d );

    }//end qsHelp



    //main method for testing
    public static void main( String[] args ) {

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	qsort( arr1 );	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);


	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN );
	System.out.println("arrN after partitionNVals: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-kk,C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
