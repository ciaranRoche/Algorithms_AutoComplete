package assignment;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class TermComparator {
	
	private static Scanner scanner;
	
	static TreeSet<Term> termSet = new TreeSet<Term>(new TermByTermComparator());
	
	public static void readTerms() throws IOException{
		File terms = new File("././data/wordList.txt");
		scanner = new Scanner(terms);
		String delims = "[	]";
		while(scanner.hasNextLine()){
			String termDetails = scanner.nextLine();
			termDetails = termDetails.trim();
	
			String[] termTokens = termDetails.split(delims);
			
			Term list = new Term(Double.parseDouble(termTokens[0]), termTokens[1]);
			
			termSet.add(list);
		}
			}
	
	
	public TreeSet<Term> getTermSet(){
		return termSet;
	}

}
