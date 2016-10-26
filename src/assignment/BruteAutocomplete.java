package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BruteAutocomplete implements AutoComplete {
	
	Term term;
	
	List<Term> termsList;
	
	String maxTerm;
	String terms;
	double maxWeight = -1.0;
	
	
	
	  public BruteAutocomplete(List<Term> termsList) {
		  this.termsList = termsList;
	  }
	  
	@Override
	public double weightOf(String terms) {
		double termWeight = 0.0;
		for (Term t : termsList) {
			if(t.getWeight() > termWeight && t.getTerm().startsWith(terms)){
				termWeight = t.getWeight();
			}
		}
		return termWeight;
	}

	@Override
	public String bestMatch(String prefix){
		for (Term t : termsList){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
				maxWeight = t.getWeight();
				maxTerm = t.getTerm();
			}
		}
		return maxTerm;
	}
	
	@Override
	public Iterable<String> matches(String prefix, int k) {
		String terms;
		int count = 0;
		ArrayList<String> matches = new ArrayList<String>();
		for (Term t : termsList){
			if(count <= k-1){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
				terms = t.getTerm();
				matches.add(terms);
				count++;
				}
			}
		}
	return matches;
	}

}
