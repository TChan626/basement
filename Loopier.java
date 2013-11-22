/*==================================================
  class Loopier
  An exercise in basic array work, iterative and recursive repetition.
  ==================================================*/

public class Loopier {
    

    /*==================================================
      int freqFor(int[],int) -- uses FOR loop to search int array for target
      post: returns num of times target occurs in array
      ==================================================*/
    public static int freqFor ( int[] a, int target ) {

	int freq = 0;

	for ( int i = 0; i < a.length; i++ ) 
	    if ( a[i] == target ) 
		freq++;

	return freq;
    }


    /*==================================================
      int freqForEach(int[],int) -- uses FOREACH loop to search int array 
      post: returns num of times target occurs in array
      ==================================================*/
    public static int freqForEach ( int[] a, int target ) {

	int freq = 0;

	for ( int i : a ) 
	    if ( i == target )
		freq++;

	return freq;
    }


    /*==================================================
      int freqWhile(int[],int) -- uses WHILE loop to search int array 
      post: returns num of times target occurs in array
      ==================================================*/
    public static int freqWhile ( int[] a, int target ) {

	int freq = 0;
	int i = 0;

	while ( i < a.length ) {
	    if ( a[i] == target )
		freq++;
	    i++;
	}

	return freq;
    }


    /*==================================================
      int freqRec(int[],int) -- recursively searches for target in array
      post: returns num of times target occurs in array
      ==================================================*/
    public static int freqRec ( int[] a, int target ) {

	return freqRecHelp( a, target, 0 );
    }

    public static int freqRecHelp( int[] a, int target, int pos ) {

	int tPos;

	if ( pos >= a.length )
	    tPos = 0;
	//now, assuming pos is valid index...
	else if ( a[pos] == target ) 
	    tPos = 1 + freqRecHelp( a, target, pos+1 );
	else 
	    tPos = freqRecHelp( a, target, pos+1 );

	return tPos;
    }


    /*==================================================
      int linSearchR(int[],int) -- recursively searches array of ints for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    //hint: you may want to initialize a var outside the method...    
    public static int linSearchR ( int[] a, int target ) {

	// seed recursion, staring at index 0
	return linHelper ( a, target, 0 );
    }

    //linHelper essential shrinks the array by 1 with each call,
    //analyzing the front element each time
    public static int linHelper ( int[] a, int target, int pos ) {

	//if current position is beyond the last index, target not here
	if ( pos == a.length )
	    return -1;

	//if value at current pos == target, victory!
	else if ( target == a[pos] )
	    return pos;

	//if value at curr pos != target, move on to next pos
	else 
	    return linHelper( a, target, pos+1 );
    }

    
    /*==================================================
      int linSearch(String[],String) -- searches an array of Strings for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch ( String[] a, String target ) {

	int tPos = -1;

	if ( a.equals(null) || target.equals(null) )
	    return -2;

	//Q: Why not FOREACH here?
	for( int i=0; i < a.length; i++ ) {

	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	}

	/*==================================================
	//WHILE version:
	int tPos = -1;
	int i = 0;
	while ( i < a.length ) {

	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	}
	==================================================*/

	return tPos;
    }


    //main method for testing
    public static void main ( String[] args ) {

	//TIP: kill & yank the top comment bar down one section 
	//     at a time to test your methods as they develop.

	System.out.println("\nNow testing linSearchR on int array...");

	//declare and initialize an array of ints
	int[] x = { 2, 4, 6, 8, 6, 42 };

	//search for 6 in array x
	System.out.println( linSearchR(x,6) );

	//search for 43 in array x
	System.out.println( linSearchR(x,43) );


	System.out.println("\nNow testing linSearch on String array...");

	//declare and initialize an array of Strings
	String[] y = { "kiwi", "watermelon", "orange", "apple", 
		       "peach", "watermelon" };

	//search for "watermelon" in array y
	System.out.println( linSearch(y,"watermelon") );

	//search for "lychee" in array y
	System.out.println( linSearch(y,"lychee") );


	System.out.println("\nNow testing freq's on int array...");

	//declare and initialize an array of ints
	int[] z = { 1, 5, 3, 5, 1, 5 };

	//compute frequency of 5 in array z
	int q = 5;
	System.out.println( freqFor ( z, q ) );
	System.out.println( freqForEach ( z, q ) );
	System.out.println( freqWhile ( z, q ) );

	//compute frequency of 2 in array z
	int r = 2;
	System.out.println( freqFor(z,r) );
	System.out.println( freqForEach(z,r) );
	System.out.println( freqWhile(z,r) );

	/*==================================================
	==================================================*/
    }//end main()

}//end class Loopier