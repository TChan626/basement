/*=====================================
  class CandidatePool -- 

  Each CandidatePool object contains the following
  instance variables that you may need to use:
       
  pool
      An ArrayList of only Candidate objects


  You will need to write the following methods:
   
  getCandidatesForPosition( String pos )
      Returns a candidate-only ArrayList containing all
      the Candidates in pool that have position pos.

  getBestCandidate( String pos )
      Returns the Candidte in pool that matches position
      pos with the highest score.
      If there are no candidates for the given position, 
      returns null.

  removeCandidatesForPosition( String pos )
      Removes all the Candidates in the pool that match
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
    ArrayList<Candidate> pool;
    
    public CandidatePool() {
	pool = new ArrayList<Candidate>();
    }

    public void addCandidate( Candidate c ) {
	pool.add(c);
    }

    public String toString() {
	return pool.toString();
    }    
    //=================================



    //YOUR WORK BELOW:
    public ArrayList<Candidate> getCandidatesForPosition( String pos ) {

	ArrayList<Candidate> c = new ArrayList<Candidate>();
	
	for( int i = 0; i < pool.size(); i++ ) 
	    if ( pool.get(i).getPosition().equals(pos) ) 
		c.add( pool.get(i) );

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

	for( int i = 0; i < pool.size(); i++ ) 
	    if ( pool.get(i).getPosition().equals(pos) ) {
		count++;
		pool.remove(i);
	       	i--;
	    }
	return count;
    }


}//end class CandidatePool

    
