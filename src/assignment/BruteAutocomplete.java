package assignment;

import java.util.ArrayList;
import java.util.Iterator;

public class BruteAutocomplete implements AutoComplete {
	  
	Term[] term;
	Client client;
	
	static ArrayList<String> matches = new ArrayList<String>();
	
	/**
	 * Initializes required data structures from arrays
	 * @param terms Array of terms
	 * @param weights Array of weights
	**/
	
	  public BruteAutocomplete(String[] terms, double[] weights) {
			if (terms == null || weights == null)
				throw new NullPointerException("At least one of the Arguements are Null");
	    term = new Term[terms.length];
	    for (int i = 0; i < terms.length; i++) {
	      term[i] = new Term(weights[i], terms[i]);
	    }
	  }

	@Override
	public double weightOf(String terms) {
		double termWeight = 0.0;
		for (Term t : term) {
			if (t.getWeight() > 0) {
				termWeight = t.weight;
			}
		}
		return termWeight;
	}

	@Override
	public String bestMatch(String prefix) {
		String maxTerm = "";
		double maxWeight = -1;
		for (Term t : term){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(client.getPrefix())){
				maxTerm = t.getTerm();
			}
		}
		return maxTerm;	
	}
	

	
	@Override
	public Iterable<String> matches(String prefix, int k) {
		//Iterator<Term> it = new Iterator<Term>(k, Term.weightOrder());
		ArrayList<Term> list = new ArrayList<Term>();
		Iterator<Term> it = list.iterator();
		for(Term t : term){
			if(t.getTerm().startsWith(client.getPrefix())){
				matches.add(t.getTerm());
			}
		}
		
		
		return matches;
		

	}

}
