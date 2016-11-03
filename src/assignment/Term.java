package assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Term Class for AlgorithmsAssignment 1
 * This class reads in a .txt file and saves it to an arrayList
 */

/**
 * @author Ciaran Roche
 * @version 03/11/2016
 */

public class Term implements Comparable<Term>{
		
	public String term;
	public double weight;
	
	public static ArrayList<Term> termsList = new ArrayList<Term>();
	
	private static Scanner scanner;
	
	/**
	 * Term Constructor
	 * @param weight
	 * @param term
	 */
	public Term(double weight ,String term){
		this.weight = weight;
		this.term = term;
	}

	/**
	 * Read in terms method, using scanner
	 * trims each line read,
	 * splits each line
	 * parses double "weight"
	 * saves to arraylist termsList
	 * @throws IOException
	 */
	public static void readTerms() throws IOException{
		File terms = new File("././data/wordList.txt");
		scanner = new Scanner(terms);
		String delims = "[	]";
		while(scanner.hasNextLine()){
			String termDetails = scanner.nextLine();
			termDetails = termDetails.trim();
	
			String[] termTokens = termDetails.split(delims);
			
			Term list = new Term(Double.parseDouble(termTokens[0]), termTokens[1]);
			
			getTermsList().add(list);
		}
			}
	
//	small test just to check every word is saved to list
//	public static void listSize(){
//		for(int i=0; i<getTermsList().size(); i++){
//			System.out.println(i);
//		}
//	}
	
	/**
	 * Getter and setters and toString methods
	 * @return
	 */
	public String getTerm(){
		return term;
	}
	
	public double getWeight(){
		return weight;
	}
	
	public String toString(){
		return String.format("%14.1f\t%s", weight, term);
	}

	public static ArrayList<Term> getTermsList() {
		return termsList;
	}

	public static void setTermsList(ArrayList<Term> termsList) {
		Term.termsList = termsList;
	}

	/** 
	 * methods for compatator
	 */
	@Override
	public int compareTo(Term that) {
		String s1 = this.term;
		String s2 = that.term;
		return s1.compareTo(s2);
	}

}