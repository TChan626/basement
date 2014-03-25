/*****************************************************
 * interface List
 * Specifies actions a List must be able to perform.
 * Now generically typed. ( T is a placeholder. )
 *****************************************************/

public interface List<T>{ 

    public boolean add( T x ); 

    public T get( int i ); 

    public T set( int i, T x ); 

    public int size(); 
}
