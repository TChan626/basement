/*===============================================
  class SearchTrials
  -- for comparing runtimes of linear and binary searches

  For a given search query, will run a specified number (heats) of linear 
  and binary searches, thus incurring a runtime measurable in milliseconds.

  Will do the above for a specified number (runs) of randomly chosen targets,
  to account for variations in runtime due to position of target in array.

  setSize var allows for modification of search space.
  ===============================================*/


public class SearchTrials {

    public static void main( String[] args ) {

	long startTime = 0;
	long endTime = 0;
	long timeBin = 0;
	long timeLin = 0;

	long startTimeNS = 0;
	long endTimeNS = 0;
	long timeBinNS = 0;
	long timeLinNS = 0;


	//==============================================================
	// Modify these values to adjust time trials
	int setSize = 10000000;
	int runs = 10; //number of targets to search for
	int heats = 10000; //number of repetitions to perform on each query
	//==============================================================


	Integer[] arr = new Integer[setSize];

	//populate array with evens
	for( int i = 0; i < arr.length; i++ ) {
	    arr[i] = i * 2;
	}


	for( int j = 0; j < runs; j++ ) {

	    // Choose random query. May or may not be present
	    int target = (int)( Math.random() * arr.length * 2);

	    System.out.println( "\n* * * Commencing time trial of linear search... * * *" );
	    System.out.println("Index of target " + target + " in array (lin): " + 
			       LinSearch.linSearch( arr, target ) );

	    //start timer
	    startTime = System.currentTimeMillis();
	    startTimeNS = System.nanoTime();

	    for( int i = 0; i < heats; i++ ) {
		LinSearch.linSearch( arr, target );
	    }
	    //stop timer
	    endTime = System.currentTimeMillis();
	    endTimeNS = System.nanoTime();

	    //calculate time elapsed
	    timeLin += endTime - startTime;
	    timeLinNS += endTimeNS - startTimeNS;


	    System.out.println( "* * * Commencing time trial of binary search... * * *" );
	    System.out.println("Index of target " + target + " in array (bin): " + 
			       BinSearch2.binSearch( arr, target ) );

	    //start timer
	    startTime = System.currentTimeMillis();
	    startTimeNS = System.nanoTime();

	    for( int i = 0; i < heats; i++ ) {
		BinSearch2.binSearch( arr, target );
	    }
	    //stop timer
	    endTime = System.currentTimeMillis();
	    endTimeNS = System.nanoTime();

	    //calculate time elapsed
	    timeBin += endTime - startTime;
	    timeBinNS += endTimeNS - startTimeNS;
	}

	//calculate mean of batch runtimes
	timeLin = timeLin / runs;
	timeBin = timeBin / runs;

	timeLinNS = timeLinNS / runs;
	timeBinNS = timeBinNS / runs;

	System.out.println();
	System.out.println( "~~~~~~~~~~~~~~ RESULTS ~~~~~~~~~~~~~~" );
	System.out.println( "elements in search space: " + setSize );
	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
	System.out.println( "LINEAR SEARCH:" );
	System.out.println( "startTime:\t" + startTime );
	System.out.println( "endTime:\t" + endTime );
	System.out.println( "mean time elapsed: " + timeLin + "ms");
	System.out.println( "mean time elapsed: " + timeLinNS + "ns");
	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
	System.out.println( "BINARY SEARCH:" );
	System.out.println( "startTime:\t" + startTime );
	System.out.println( "endTime:\t" + endTime );
	System.out.println( "mean time elapsed: " + timeBin + "ms");
	System.out.println( "mean time elapsed: " + timeBinNS + "ns");
	System.out.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
    }

}//end class
