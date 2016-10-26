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
				//System.out.println(termWeight);
			}
		}
		return termWeight;
	}

	@Override
	public String bestMatch(String prefix){
		//String maxTerm = "";
		//double maxWeight = -1.0;
		for (Term t : termsList){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
				maxWeight = t.getWeight();
				maxTerm = t.getTerm();
				//System.out.println(maxTerm);
			}
		}
		return maxTerm;
	}
	
	@Override
	public Iterable<String> matches(String prefix, int k) {
		String terms;
		for (Term t : termsList){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
				terms = t.getTerm();
				System.out.println(terms);
				}
		}
	return null;
	}

	
//	@Override
//	public Iterable<String> matches(String prefix, int k) {
//		//Iterator<Term> it = new Iterator<Term>(k, Term.weightOrder());
//		ArrayList<Term> list = new ArrayList<Term>();
//		Iterator<Term> it = list.iterator();
//		for(Term t : termsList){
//			if(t.getTerm().startsWith(prefix)){
//				//it = t.getTerm();
//				matches.add(t.getTerm());
//			}
//		}
//		
//		
//		return matches;
//		
//
//	}
}
