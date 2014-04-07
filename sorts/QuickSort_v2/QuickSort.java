/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in-place
 *
 * Version 2 -- Handles duplicate values
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
 *
 * 3. Approach to handling duplicate values in array:
 * When moving markers inward, 3 possible scenarios:
 * A) duplicate val is equal to pivot val
 * B) duplicate val belongs in upper range
 * C) duplicate val belongs in lower range
 * Case A: slide one marker inward and perform a swap
 * Case B: slide upper marker inward 1 pos, swap, move 1 more pos 
 * Case C: slide lower marker inward 1 pos, swap, move 1 more pos 
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
	    
	    if ( d[tmpLo] != d[tmpHi] )
		swap( tmpLo, tmpHi, d );

	    //dupe vals found at markers
	    else if ( tmpLo < tmpHi ) { 
		//extra chk for Lo<Hi bc of double marker moves below

		int dupe = d[tmpHi];

		//if dupe is pivot val, put in lower range
		if ( dupe == pivot ) {
		    swap( ++tmpLo, tmpHi, d );
		}
		else if ( dupe > pivot ) {
		    //slide upper marker inward 1 pos, then swap
		    swap( tmpLo, --tmpHi, d );
		    //slide upper marker inward again to get past 2nd dupe val
		    tmpHi--;
		}
		else { //dupe < pivot
		    swap( ++tmpLo, tmpHi, d );
		    tmpLo++;
		}
	    }
	}//end big while

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

	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-kk,C-y) 
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
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after partitionNVals: " );
	printArr(arrMatey);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-kk,C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
