package assignment;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Term{
		
	public String term;
	public double weight;
	
	public static ArrayList<Term> termsList = new ArrayList<Term>();
	
	private static Scanner scanner;
	
	public Term(double weight ,String term){
		this.weight = weight;
		this.term = term;
	}

	public static void readTerms() throws IOException{
		File terms = new File("././data/wordList.txt");
		scanner = new Scanner(terms);
		String delims = "[	]";
		while(scanner.hasNextLine()){
			String termDetails = scanner.nextLine();
			termDetails = termDetails.trim();
			
			String[] termTokens = termDetails.split(delims);
			
			//System.out.println(termTokens[0] +" "+ termTokens[1]);
			
			Term list = new Term(Double.parseDouble(termTokens[0]), termTokens[1]);
			
			getTermsList().add(list);
		}
			}
	
	//small test just to check every word is saved to list
	public static void listSize(){
		for(int i=0; i<getTermsList().size(); i++){
			System.out.println(i);
		}
	}
	
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

}