/*======================================
  class Recursinator -- an refresher exercise in Java recursion
  * int fact(int n)
  * int fibIt(int n) 
  * int fibRec(int n) 
  * String fenceIt(int n) 
  * String fenceRec(int n) 
  * String commafyIt(int n) 
  * String commafyRec(int n) 
  ======================================*/


public class Recursinator {

    /*******************************************************
     * int fact(int n)
     * @param n number whose factorial is to be computed
     * precond: n >= 0
     * eg: fact(5) -> 120
     *******************************************************/
    public static int fact( int n ) {
	if ( n < 2 ) 
	    return 1;
	else 
	    return n * fact(n-1);
    }


    /*******************************************************
     * int fibIt(int n) returns nth term of Fibonacci sequence
     *     Uses iteratiion.
     * @param n specifies position of term in sequence.
     * precond: 0th, 1st, 2nd terms are 0,1,1
     * eg: fibIt(3) -> 2
     *******************************************************/
    public static int fibIt( int n ) { 
	int retInt = 1;

        if ( n < 2 )
            retInt = n;

	//init first 2 terms of seq
        int b = 1;  int a = 0;

        for( int i = 2; i <= n; i++ ) {
            retInt = b + a; //compute next term in seq
            a = b;   //shift 1-prev to 2-prev
            b = retInt;  //update 1-prev with next term in seq
        }
        return retInt;
    }


    /*******************************************************
     * int fibRec(int n) returns nth term of Fibonacci sequence
     *     Uses recursion.
     * @param n specifies position of term in sequence.
     * precond: 0th, 1st, 2nd terms are 0,1,1
     * eg: fibRec(3) -> 2
     *******************************************************/
    public static int fibRec( int n ) { 

        if ( n < 2 )
            return n;
	else
	    return fibRec(n-1) + fibRec(n-2);
    }


    /*******************************************************
     * String fenceIt(int n) builds a fence with n fenceposts
     * @param n number of |'s in return String
     * precond: n >= 1
     * eg: fenceIt(1) -> "|"
     * eg: fenceIt(2) -> "|---|"
     * eg: fenceIt(3) -> "|---|---|"
     *******************************************************/
    public static String fenceIt( int n ) { 

	String retStr = "|";

	for( int i=0; i<n; i++ ) 
	    retStr += "---|";

	return retStr;
    }


    /*******************************************************
     * String fenceRec(int n) builds a fence with n fenceposts
     * @param n number of |'s in return String
     * precond: n >= 1
     * eg: fenceRec(1) -> "|"
     * eg: fenceRec(2) -> "|---|"
     * eg: fenceRec(3) -> "|---|---|"
     *******************************************************/
    public static String fenceRec( int n ) { 

	if ( n == 1 ) 
	    return "|";
	else 
	    return fenceRec(n-1) + "---|";
    }


    /*******************************************************
     * String commafyIt(int n) returns a String representation of
     *        n with commas inserted where appropriate
     * @param n number in need of commas
     * precond: n >= 0
     * eg: commafyIt(100) -> 100
     * eg: commafyIt(1000) -> 1,000
     * eg: commafyIt(10000000) -> 10,000,000
     *******************************************************/
    public static String commafyIt( int n ) { 

	//convert input int to String
	String retStr = n + "";

	//init counter for number of commas to insert
	int i = retStr.length() / 3;

	//if num digits divisible by 3, one less comma necessary
	if ( retStr.length() % 3 == 0 ) 
	    i--;

	/* Algorithm summary:
	 * Run loop once for each comma, decrementing i each iteration.
	 * i*3 yields num places from right to current comma insertion pt.
	 * Insert commas from L to R.
	 */
	for ( ; i > 0; i-- ) 
	    retStr = retStr.substring( 0, retStr.length() - i*3 ) + "," + 
		retStr.substring( retStr.length() - i*3 );

	return retStr;
    }


    /*******************************************************
     * String commafyRec(int n) returns a String representation of
     *        n with commas inserted where appropriate
     * @param n number in need of commas
     * precond: n >= 0
     * eg: commafyRec(100) -> 100
     * eg: commafyRec(1000) -> 1,000
     * eg: commafyRec(10000000) -> 10,000,000
     *******************************************************/
    public static String commafyRec( int n ) { 
	
	/* Preliminary version. Fails for 1000, 1050, etc.
	String retStr = "";
	if (n < 1000)   retStr += n;
	else   retStr = commafyRec( n / 1000 ) + "," + n % 1000;
	*/

	//BETTER VERSION (handles 1000, 1050, etc):
	String retStr = "";

	if ( n < 1000 )
	    retStr += n;
	else {
	    //turn n into a String
	    String tmp = "" + n; 

	    //overwrite tmp with last 3 chars of tmp
	    tmp = tmp.substring( tmp.length()-3 );

	    //recurse on remaining digits, growing String from R to L
	    retStr = commafyRec( n/1000 ) + "," + tmp;
	}
	return retStr;
    }




    public static void main( String [] args ) {

	/*============================================
	  Main method for testing. Suggested use:
	  Set up a list of test cases for each function 
	  BEFORE you begin writing each method.
	  Move top comment bar (----) down one line at a time
	  when you're ready to test each line.
	  ============================================*/

	/*--------------------------------------------
	System.out.println( "fact(0) -> " + fact(0) ); // 1
	System.out.println( "fact(1) -> " + fact(1) ); // 1
	System.out.println( "fact(2) -> " + fact(2) ); // 2
	System.out.println( "fact(3) -> " + fact(3) ); // 6
	System.out.println( "fact(4) -> " + fact(4) ); // 24
	System.out.println( "fact(5) -> " + fact(5) ); // 120
	System.out.println( "fact(12) -> " + fact(12) ); // ?
	System.out.println( "fact(13) -> " + fact(13) ); // ?
	System.out.println( "fact(14) -> " + fact(14) ); // ?
	System.out.println( "fact(15) -> " + fact(15) ); // ??? 
	//...Q: What do the results of these last calls tell you?

	System.out.println( "fibIt(0) -> " + fibIt(0) ); // 0
	System.out.println( "fibIt(1) -> " + fibIt(1) ); // 1
	System.out.println( "fibIt(2) -> " + fibIt(2) ); // 1
	System.out.println( "fibIt(3) -> " + fibIt(3) ); // 2
	System.out.println( "fibIt(4) -> " + fibIt(4) ); // 3
	System.out.println( "fibIt(5) -> " + fibIt(5) ); // 5

	System.out.println( "fibRec(0) -> " + fibRec(0) ); // 0
	System.out.println( "fibRec(1) -> " + fibRec(1) ); // 1
	System.out.println( "fibRec(2) -> " + fibRec(2) ); // 1
	System.out.println( "fibRec(3) -> " + fibRec(3) ); // 2
	System.out.println( "fibRec(4) -> " + fibRec(4) ); // 3
	System.out.println( "fibRec(5) -> " + fibRec(5) ); // 5


	System.out.println( "fenceRec(1) -> " + fenceRec(1) ); 
	System.out.println( "fenceRec(2) -> " + fenceRec(2) ); 
	System.out.println( "fenceRec(3) -> " + fenceRec(3) ); 
	System.out.println( "fenceRec(4) -> " + fenceRec(4) ); 
	System.out.println( "fenceRec(5) -> " + fenceRec(5) ); 

	System.out.println( "fenceIt(1) -> " + fenceIt(1) ); 
	System.out.println( "fenceIt(2) -> " + fenceIt(2) ); 
	System.out.println( "fenceIt(3) -> " + fenceIt(3) ); 
	System.out.println( "fenceIt(4) -> " + fenceIt(4) ); 
	System.out.println( "fenceIt(5) -> " + fenceIt(5) ); 

	System.out.println( "commafyIt(1) -> " + commafyIt(1) );
	System.out.println( "commafyIt(123) -> " + commafyIt(123) ); 
	System.out.println( "commafyIt(1234) -> " + commafyIt(1234) ); 
	System.out.println( "commafyIt(12345) -> " + commafyIt(12345) ); 
	System.out.println( "commafyIt(123456) -> " + commafyIt(123456) ); 
	System.out.println( "commafyIt(1234567) -> " + commafyIt(1234567) );

	System.out.println( "commafyIt(100) -> " + commafyIt(100) );
	System.out.println( "commafyIt(1000) -> " + commafyIt(1000) );
	System.out.println( "commafyIt(1500) -> " + commafyIt(1500) );
	System.out.println( "commafyIt(1050) -> " + commafyIt(1050) );
	System.out.println( "commafyIt(1005) -> " + commafyIt(1005) );
	System.out.println( "commafyIt(10000) -> " + commafyIt(10000) );
	System.out.println( "commafyIt(100000) -> " + commafyIt(100000) );
	System.out.println( "commafyIt(1000000) -> " + commafyIt(1000000) );

	System.out.println( "commafyRec(1) -> " + commafyRec(1) );
	System.out.println( "commafyRec(123) -> " + commafyRec(123) ); 
	System.out.println( "commafyRec(1234) -> " + commafyRec(1234) ); 
	System.out.println( "commafyRec(12345) -> " + commafyRec(12345) ); 
	System.out.println( "commafyRec(123456) -> " + commafyRec(123456) ); 
	System.out.println( "commafyRec(1234567) -> " + commafyRec(1234567) );

	System.out.println( "commafyRec(100) -> " + commafyRec(100) );
	System.out.println( "commafyRec(1000) -> " + commafyRec(1000) );
	System.out.println( "commafyRec(1500) -> " + commafyRec(1500) );
	System.out.println( "commafyRec(1050) -> " + commafyRec(1050) );
	System.out.println( "commafyRec(1005) -> " + commafyRec(1005) );
	System.out.println( "commafyRec(10000) -> " + commafyRec(10000) );
	System.out.println( "commafyRec(100000) -> " + commafyRec(100000) );
	System.out.println( "commafyRec(1000000) -> " + commafyRec(1000000) );
	--------------------------------------------*/

    }//end main

}//end class Recursinator
