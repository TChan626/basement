public class Rational implements Comparable {

    private int _numerator;
    private int _denominator;


    public Rational() {
	_numerator = 0;
	_denominator = 1;
    }


    public Rational( int n, int d ) {
	_numerator = n;
	if ( d == 0 ) {
	    System.out.println( "Invalid number. " +
				"Setting denominator to 1." );
	    _denominator = 1;
	}
	else {
	    _denominator = d;
	}
    }


    public String toString() {
	return _numerator + " / " + _denominator;
    }


    public double floatValue() {
	return (double)_numerator / _denominator;
    }


    public void multiply( Rational r ) {
	_numerator = this._numerator * r._numerator;
	_denominator = this._denominator + r._denominator;
    }


    public void divide( Rational r ) {
	if ( r._numerator != 0 ) {
	    _numerator = _numerator * r._denominator;
	    _denominator = _denominator * r._numerator;
	}
	else {
	    System.out.println( "Div by 0 error. Values unchanged." );
	}
    }


    public void add( Rational r ) {
	_numerator = _numerator * r._denominator + r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    public void subtract( Rational r ) {
	_numerator = _numerator * r._denominator - r._numerator * _denominator;
	_denominator = _denominator * r._denominator;
    }


    public int gcd() {

	int a, b, x;

	if ( _numerator > _denominator ) {
	    a = _numerator;
	    b = _denominator;
	}
	else {
	    a = _denominator;
	    b = _numerator;
	}

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }


    public void reduce() {
	int g = gcd();
	_numerator = _numerator / g;
	_denominator = _denominator / g;
    }


    public static int gcd( int n, int d ) {

	int a, b, x;

	if ( n > d ) {
	    a = n;
	    b = d;
	}
	else {
	    a = d;
	    b = n;
	}

	while( a % b != 0 ) {
	    x = a;
	    a = b;
	    b = x % b;
	}

	return b;
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Rational
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other have matching attribute values. 
      (which in this case indicates equivalent fractions)
      =============================================*/
    public boolean equals( Object other ) { 

	//First, reduce both fractions.
	//...thus allowing for direct comparison of attributes
	reduce();

	if ( other instanceof Rational ) 
	    ((Rational)other).reduce();
	/* Typecasting necessary because var type of other is Object, 
	   and an Object does not have a reduce() method.
	 */

	//Q: Why is boolean short-circuiting essential below?
	//   ie, What would happen if Java did not do BS-C?
	return this == other //check for aliases
	    || 
	    ( other instanceof Rational
	      && this._numerator == ((Rational)other)._numerator 
	      && this._denominator == ((Rational)other)._denominator );

    }//end equals()


    /*=============================================
      int compareTo(Object) -- tells which of two Rationals is greater
      pre:  
      post: Throws exception if input not an instance of class Rational.
            Returns 0 if calling Rational is equiv to input Rational.
            Returns negative integer if this < other.
            Returns positive integer if this > other.
      =============================================*/
    public int compareTo( Object other ) {

	// If other is not a Rational, throw an exception
	// This will exit the function, generating a runtime error
	if ( ! (other instanceof Rational) )
	    // ClassCastException specified by Java API.
	    // Input String is optional; gives diagnostics info.
	    throw new ClassCastException("\nMy first error message! "
					 + " compareTo() input not a Rational");

	int thisNumerator, otherNumerator;

	thisNumerator = _numerator * ((Rational)other)._denominator;
	otherNumerator = _denominator * ((Rational)other)._numerator;

	return thisNumerator - otherNumerator;
    }


    //main method for testing
    public static void main( String[] args ) {
	
	Rational r = new Rational( 3, 7 );
	Rational s = new Rational();
	Rational t = new Rational( 8, 5 );

	Rational u = new Rational( 1, 2 );
	Rational v = new Rational( 2, 3 );
	Rational w = new Rational( 8, 12 );
	Rational x = new Rational( 8, 12 );
	String y = "yoo";
	
	System.out.println("r: " + r );
	System.out.println("s: " +  s );
	System.out.println("t: " +  t );

	System.out.println( r + " as a floating pt approximation: " 
			    + r.floatValue() );
	System.out.println( s + " as a floating pt approximation: " 
			    + s.floatValue() );
	System.out.println( t + " as a floating pt approximation: " 
			    + t.floatValue() );

	System.out.println( "r > t: " +  r.compareTo(t) );
	System.out.println( "r > s: " +  r.compareTo(s) );
	System.out.println( "s > t: " +  s.compareTo(t) );
	//uncommenting the line below should trigger a runtime error
	//	System.out.println( "s > y: " +  s.compareTo(y) );

	System.out.println( "v.equals(v): " + v.equals(v) );
	System.out.println( "v.equals(w): " + v.equals(w) );
	System.out.println( "w.equals(x): " + w.equals(x) );

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.print( r + " * " + t + " = ");
	r.multiply(t);
	System.out.println(r);

	System.out.print( r + " / " + t + " = ");
	r.divide(t);
	System.out.println(r);

	System.out.print( u + " + " + v + " = ");
	u.add(v);
	System.out.println(u);
	
	System.out.print( u + " - " + v + " = ");
	u.subtract(v);
	System.out.println(u);

	System.out.println("GCD of " + r + " = " + r.gcd() );
	System.out.println("GCD of " + t + " = " + t.gcd() );

	System.out.print( r + " in reduced form = ");
	r.reduce();
	System.out.println(r);

	System.out.println( "\nNow testing static gcd...");
	System.out.println( Rational.gcd(100,9) );
	System.out.println( Rational.gcd(245,25) );
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/		
    }


}//end class Rational


    /*=============================================
       () -- 
      pre:  
      post: 
      =============================================*/
