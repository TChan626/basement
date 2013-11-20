public class Rational {

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


    public int compareTo( Rational other ) {

	int thisNumerator, otherNumerator;

	thisNumerator = _numerator * other._denominator;
	otherNumerator = _denominator * other._numerator;

	return thisNumerator - otherNumerator;

    }

    //main method for testing
    public static void main(String[] args) {
	
	Rational r = new Rational( 3, 7 );
	Rational s = new Rational();
	Rational t = new Rational( 8, 5 );

	Rational u = new Rational( 1, 2 );
	Rational v = new Rational( 2, 3 );
	Rational w = new Rational( 8, 12 );
	
	System.out.println("r: " + r );
	System.out.println("s: " +  s );
	System.out.println("t: " +  t );

	System.out.println( r + " represented as a floating pt num: " 
			    + r.floatValue() );

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
		
    }


}//end class Rational
