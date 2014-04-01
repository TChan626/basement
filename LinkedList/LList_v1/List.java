/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *****************************************************/

public interface List { 

    public boolean add( String x ); 

    public String get( int i ); 

    public String set( int i, String x ); 

    public int size(); 
}
