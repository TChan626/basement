/*==================================================
  class LinSearch
  ==================================================*/

public class LinSearch {


    /*==================================================
      int linSearch(Comparable[],Comparable) -- searches an array of 
      Comparables for target
      post: returns index of first occurrence of target, or
            returns -1 if target not found
      ==================================================*/
    public static int linSearch ( Comparable[] a, Comparable target ) {

	int tPos = -1;
	int i = 0;

	while ( i < a.length ) {
	    if ( a[i].equals(target) ) {
		tPos = i;
		break;
	    }
	    i++;
	}
	return tPos;
    }


    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( Object[] arr ) {
	String output = "[ "; 

	for( Object o : arr )
	    output += o + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on int array...");

	//Declare an array of Comparables and initialize it using ints 
	//   Each int will be autoboxed to class Integer, 
	//   which implements Comparable.
	Comparable[] iArr = { 2, 4, 6, 8, 6, 42 };
	printArray( iArr );

	//search for 6 in array 
	System.out.println( linSearch(iArr,6) );

	//search for 43 in array 
	System.out.println( linSearch(iArr,43) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	System.out.println("\nNow testing linSearch on Comparable arrays...");


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on String array...");

	//declare and initialize an array of Strings
	String[] sArr = { "kiwi", "watermelon", "orange", "apple", 
		       "peach", "watermelon" };
	printArray( sArr );

	//search for "watermelon" in array
	System.out.println( linSearch(sArr,"watermelon") );

	//search for "lychee" in array
	System.out.println( linSearch(sArr,"lychee") );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Binary array...");

	//declare Binary array
	Binary[] bArr = new Binary[10];
	printArray( bArr ); //should show array of nulls

	//initialize Binary array
	//Q: Why would a FOREACH loop not do the job here?
	for( int i = 0; i < bArr.length; i++ ) {
	    bArr[i] = new Binary( (int)(100 * Math.random()) );
	}
	printArray( bArr ); //should now show Binary numbers

	//search for the value in slot 3 in array
	System.out.println( "Searching for " + bArr[3] + "..." );
	System.out.println( linSearch(bArr, bArr[3] ) );

	//search for 101 in array
	System.out.println( linSearch(bArr, new Binary(5) ) );

	//search for 100000000 in array
	System.out.println( linSearch(bArr, new Binary(256)) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Hexadecimal array...");

	//declare Hexadecimal array
	Hexadecimal[] hArr = new Hexadecimal[10];
	printArray( hArr ); //should show array of nulls

	//initialize Hexadecimal array
	//Q: Why would a FOREACH loop not do the job here?
	for( int i = 0; i < hArr.length; i++ ) {
	    hArr[i] = new Hexadecimal( (int)(100 * Math.random()) );
	}
	printArray( hArr ); //should now show Hexadecimal numbers

	//search for the value in slot 3 in array
	System.out.println( "Searching for " + hArr[3] + "..." );
	System.out.println( linSearch(hArr, hArr[3] ) );

	//search for 5 in array
	System.out.println( linSearch(hArr, new Hexadecimal(5) ) );

	//search for 100 in array
	System.out.println( linSearch(hArr, new Hexadecimal(256)) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing linSearch on Rational array...");

	//declare Rational array
	Rational[] rArr = new Rational[10];
	printArray( rArr ); //should show array of nulls

	//initialize Rational array
	//Q: Why would a FOREACH loop not do the job here?
	for( int i = 0; i < rArr.length; i++ ) {
	    rArr[i] = new Rational( (int)(100 * Math.random()), 
				    (int)(100 * Math.random()) );
	}
	printArray( rArr ); //should now show Rational numbers

	//search for the value in slot 3 in array
	System.out.println( "Searching for " + rArr[3] + "..." );
	System.out.println( linSearch(rArr, rArr[3] ) );

	//search for 5 in array
	System.out.println( linSearch(rArr, new Rational(5,1) ) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


	/*==================================================
	==================================================*/
    }//end main()

}//end class LinSearch
