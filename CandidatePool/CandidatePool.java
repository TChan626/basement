/*=====================================
  class CandidatePool -- 

  Each CandidatePool object contains the following
  instance variables that you may need to use:
       
  _pool
      An ArrayList of only Candidate objects


  You will need to write the following methods:
   
  getCandidatesForPosition( String pos )
      Returns a candidate-only ArrayList containing all
      the Candidates in _pool that have position pos.

  getBestCandidate( String pos )
      Returns the Candidte in _pool that matches position
      pos with the highest score.
      If there are no candidates for the given position, 
      returns null.

  removeCandidatesForPosition( String pos )
      Removes all the Candidates in the _pool that match
      position pos.
      Returns number of candidates removed.
  =====================================*/

//We usually leave this out because Java does this automatically:
import java.io.*; 
//...but this is not automatically performed (util pkg contains ArrayList):
import java.util.*;


public class CandidatePool {
    
    //=================================
    //DO NOT MODIFY THIS CODE BLOCK
    ArrayList<Candidate> _pool;
    
    public CandidatePool() {
	_pool = new ArrayList<Candidate>();
    }

    public void addCandidate( Candidate c ) {
	_pool.add(c);
    }

    public String toString() {
	return _pool.toString();
    }    
    //=================================



    //YOUR WORK BELOW:
    public ArrayList<Candidate> getCandidatesForPosition( String pos ) {

	ArrayList<Candidate> c = new ArrayList<Candidate>();
	
	for( int i = 0; i < _pool.size(); i++ ) 
	    if ( _pool.get(i).getPosition().equals(pos) ) 
		c.add( _pool.get(i) );

	return c;
    }


    public Candidate getBestCandidate( String pos ) { 

	ArrayList<Candidate> c;
	c = getCandidatesForPosition(pos);

	if ( c.size() == 0 )
	    return null;

	int id = 0;
	double maxScore = c.get(id).getInterviewScore();

	for( int i = 1; i < c.size(); i++ ) {
	    
	    if ( c.get(i).getInterviewScore() > maxScore ) {
		id = i;
		maxScore = c.get(id).getInterviewScore();
	    }
	}
	return c.get(id);
    }


    public int removeCandidatesForPosition( String pos ) {
	int count = 0;

	for( int i = 0; i < _pool.size(); i++ ) 
	    if ( _pool.get(i).getPosition().equals(pos) ) {
		count++;
		_pool.remove(i);
	       	i--;
	    }
	return count;
    }


}//end class CandidatePool

    
