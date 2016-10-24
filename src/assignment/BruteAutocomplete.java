package assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BruteAutocomplete implements AutoComplete {
	  
	List<Term> termsList;
	
	static ArrayList<String> matches = new ArrayList<String>();
	
	  public BruteAutocomplete(List<Term> termsList) {
		  this.termsList = termsList;

	  }
	  
	@Override
	public double weightOf(String terms) {
		double termWeight = 0.0;
		for (Term t : termsList) {
			if (t.getWeight() > 0 && t.getTerm().startsWith(terms)) {
				termWeight = t.getWeight();
			}
		}
		return termWeight;
	}

	@Override
	public String bestMatch(String prefix) {
		String maxTerm = "";
		double maxWeight = -1.0;
		for (Term t : termsList){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
				maxWeight = t.getWeight();
				maxTerm = t.getTerm();
				System.out.println(maxTerm);
			}
		}
		return maxTerm;
	}
	

	
	@Override
	public Iterable<String> matches(String prefix, int k) {
		//Iterator<Term> it = new Iterator<Term>(k, Term.weightOrder());
		ArrayList<Term> list = new ArrayList<Term>();
		Iterator<Term> it = list.iterator();
		for(Term t : termsList){
			if(t.getTerm().startsWith(prefix)){
				matches.add(t.getTerm());
			}
		}
		
		
		return matches;
		

	}

}

//package assignment;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class BruteAutocomplete implements AutoComplete {
//	  
//	//Term[] term;
//	//Term t;
//	//Client client;
//	
//	Term term;
//	
//	ArrayList<String> matches = new ArrayList<String>();
//	ArrayList<Term> readIn = new ArrayList<>();
//	
//	/**
//	 * Initializes required data structures from arrays
//	 * @param terms Array of terms
//	 * @param weights Array of weights
//	 * @throws IOException 
//	**/
//	
////	  public BruteAutocomplete(String[] terms, double[] weights) {
////			//if (terms == null || weights == null)
////				//throw new NullPointerException("At least one of the Arguements are Null");
////	    term = new Term[terms.length];
////	    for (int i = 0; i < terms.length; i++) {
////	      term[i] = new Term(weights[i], terms[i]);
////	    }
////	  }
//	
//	public BruteAutocomplete() throws IOException
//	{
//		term.readTerms();
//		readIn = term.getArray();
//	}
//
//	@Override
//	public double weightOf(String terms) {
//		double termWeight = 0.0;
//		for (Term t : readIn) {
//			if (t.getWeight() > 0) {
//				termWeight = t.weight;
//			}
//		}
//		return termWeight;
//	}
//
//	@Override
//	public String bestMatch(String prefix) {
//		String maxTerm = "";
//		double maxWeight = -1;
//		for (Term t : readIn){
//			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
//				maxTerm += t.getTerm();
//			}
//		}
//		return maxTerm;	
//	}
//	
//
//	
//	@Override
//	public Iterable<String> matches(String prefix, int k) {
//		//Iterator<Term> it = new Iterator<Term>(k, Term.weightOrder());
//		ArrayList<Term> list = term.getArray();
//		Iterator<Term> it = list.iterator();
//		for(Term t : readIn){
//			if(t.getTerm().startsWith(prefix)){
//				matches.add(t.getTerm());
//			}
//		}
//		
//		
//		return matches;
//		
//
//	}
//
//}
