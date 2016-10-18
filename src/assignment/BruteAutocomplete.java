package assignment;

public class BruteAutocomplete implements AutoComplete {
	  
	Term[] terms;
	
	/**
	 * Initializes required data structures from arrays
	 * @param terms Array of terms
	 * @param weights Array of weights
	**/


	@Override
	public String bestMatch(String prefix) {
		String maxTerm = "";
		double maxWeight = -1;
		for (Term t : terms){
			if(t.getWeight() > maxWeight && t.getTerm().startsWith(prefix)){
				maxTerm = t.getTerm();
			}
		}
		return maxTerm;	
	}

	@Override
	public Iterable<String> matches(String prefix, int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double weightOf(String term) {
		// TODO Auto-generated method stub
		return 0;
	}

}
