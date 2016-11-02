package assignment;

import java.util.Comparator;

public class TermByTermComparator implements Comparator<Term> {

	@Override
	public int compare(Term s1, Term s2) {
		return s1.term.compareToIgnoreCase(s2.term);
	}
	

}
