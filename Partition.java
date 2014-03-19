/*****************************************************
 * class Partition
 * ...for partitioning an array into subarrays
 * SUGGESTED USE: Uncomment the SOPs to watch how the dataset is 
 * being modified...
 *****************************************************/

public class Partition {

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
     * partition(int,int,int[])
     * precond:  Input array contains exactly 2 distinct integer values 
     *           (min & max).
     * postcond: All occurrences of max to the right, 
     *           all occurrences of min to the left.
     *           Returns position of rightmost occurrence of min.
     * eg,
     * int[] b = {1,0,0,1,1,0,1,0}
     * partition(0,1,b) -> 3    ...and b is now {0,0,0,0,1,1,1,1} 
     *****************************************************/
    public static int partition( int min, int max, int[] d ) {
	return partitionHelp( 0, d.length-1, min, max, d );
    }
    public static int partitionHelp(int lo,int hi,int min,int max,int[] d) { 
	while( lo < hi ) {
	    if ( d[lo] == max )
		swap( lo, hi--, d );
	    else
		lo++;
	}
	if ( d[hi] == max )
	    hi--;
	return hi;
    }


    /*****************************************************
     * partition3Vals(int,int,int,int[])
     * precond:  Input array contains exactly 3 distinct 
     *           integer values (min, mid, max).
     * postcond: All occurrences of max to the right, 
     *           all occurrences of min to the left, 
     *           all occurrences of mid in between
     * eg
     * int[] t = {2,1,0,2,0,1,0,2}
     * partition3Vals(0,1,2,t)   ...and t is now {0,0,0,1,1,2,2,2}
     *****************************************************/
    public static void partition3Vals( int min, int mid, int max, int[] d ) { 
	int tmpHi = partition( min, max, d );
	partitionHelp( 0, tmpHi, min, mid, d );
    }


    /*****************************************************
     * partitionNVals(int[])
     * precond:  Input array contains n distinct integer values.
     *           (where n is size of array)
     * postcond: Arranges elements in ascending order
     * eg
     * int[] t = {7,5,0,3,4,1,6,2}
     * partitionNVals(t)    ...and t is now {0,1,2,3,4,5,6,7}
     *****************************************************/
    public static void partitionNVals( int[] d ) { 
	partNHelp( 0, d.length-1, d );
    }
    public static void partNHelp( int lo, int hi, int[] d ) { 
	if ( lo >= hi )
	    return;

	int tmpLo = lo;
	int tmpHi = hi;
	int pivot = d[lo];

	/*	
	System.out.print("\n*** partNHelp called w/ ");
	System.out.print("tmpLo:" + tmpLo);
	System.out.print(", tmpHi:" + tmpHi);
	System.out.print(", pivot:" + pivot + " ***\n");
	*/

	while( tmpLo < tmpHi ) {
	    //	    System.out.println("in while...");
	    while( d[tmpLo] < pivot ) {
		//	System.out.println("tmpLo: " + tmpLo);
		tmpLo++;
	    }
	    while( d[tmpHi] > pivot ) {
		//System.out.println("tmpHi: " + tmpHi);
		tmpHi--;
	    }
	    swap( tmpLo, tmpHi, d );
	    //System.out.println("swapped d[" + tmpLo + "] with d[" + tmpHi + "]:");
	    //printArr(d);
	    //System.out.println("tmpLo: " + tmpLo + "\ttmpHi: " + tmpHi);
	}

	//System.out.println("d[tmpLo]:" + d[tmpLo] + "  pivot:" + pivot);
	d[tmpLo] = pivot;

	partNHelp( lo, tmpLo-1, d );
	partNHelp( tmpLo+1, hi, d );
    }


    //main method for testing
    public static void main( String[] args ) {

	// TESTING PARTITION OF 2 DISTINCT VALUES...
       	int[] arr2 = buildArray( 10, 2 );
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	int p = partition( 0, 1, arr2 );
	System.out.println("arr2 after partition: " );
	printArr(arr2);
	System.out.println("partition returned " + p );

	// TESTING PARTITION OF 3 DISTINCT VALUES...
	int[] arr3 = buildArray( 10, 3 );
	System.out.println("\narr3 init'd to: " );
	printArr(arr3);

	partition3Vals( 0, 1, 2, arr3 );
	System.out.println("arr3 after partition3Vals: " );
	printArr(arr3);
	

	// TESTING PARTITION OF N DISTINCT VALUES...
	//get-it-up-and-running, static test case:
	int [] arrNfixed = {7,5,0,3,4,1,6,2};
	System.out.println("\narrNfixed init'd to: " );
	printArr(arrNfixed);

	partitionNVals( arrNfixed );	
       	System.out.println("arrNfixed after partitionNVals: " );
	printArr(arrNfixed);


	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	partitionNVals( arrN );
	System.out.println("arrN after partitionNVals: " );
	printArr(arrN);


    }//end main

}//end class Partition