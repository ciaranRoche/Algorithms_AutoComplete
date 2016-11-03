package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * BruteAutoComplete Class for AlgorithmsAssignment 1
 * The class implements AutoComplete Interface
 */

/**
 * @author Ciaran Roche
 * @version 03/11/2016
 */

public class BruteAutocomplete implements AutoComplete {
	
	Term term;
	
	List<Term> termsList;
	
	String maxTerm;
	String terms;
	double maxWeight = -1.0;
	
	
	/**
	 * BruteAutocomplete constructor
	 * @param termsList
	 */
	  public BruteAutocomplete(List<Term> termsList) {
		  this.termsList = termsList;
	  }
	  
	 /**
	  * weight of method
	  * declares termWeight as 0.0
	  * searches every "t" type of term in termsList
	  * if weight is greater then termweight, and the term start with string term,
	  * termweight is set to that weight and returned, 
	  * otherwise termweight of 0.0 is returned
	  */
	@Override
	public double weightOf(String terms) {
		double termWeight = 0.0;
		for (Term t : termsList) {
			if(t.getWeight() > termWeight && t.getTerm().toLowerCase().startsWith(terms)){
				termWeight = t.getWeight();
			}
		}
		return termWeight;
	}
	
	/**
	 * bestMatch method
	 * searches through termslist, for the biggest weight
	 * returns biggest weight or null if no match is found
	 */
	@Override
	public String bestMatch(String prefix){
		for (Term t : termsList){
			if(t.getWeight() > maxWeight && t.getTerm().toLowerCase().startsWith(prefix)){
				maxWeight = t.getWeight();
				maxTerm = t.getTerm();
			}
		}
		return maxTerm;
	}
	
	/**
	 * matches method
	 * searches termList for all matches to prefix
	 * for "k" saves results to an arraylist of type string and returns arraylist
	 */
	@Override
	public Iterable<String> matches(String prefix, int k) {
		String terms;
		int count = 0;
		ArrayList<String> matches = new ArrayList<String>();
		for (Term t : termsList){
			if(count <= k-1){
			if(t.getWeight() > maxWeight && t.getTerm().toLowerCase().startsWith(prefix)){
				terms = t.getTerm();
				matches.add(terms);
				count++;
				}
			}
		}
	return matches;
	}

}
