package assignment;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Term implements Comparable<Term>{
		
	public String term;
	public double weight;
	
	static ArrayList<Term> termsList = new ArrayList<Term>();
	
	public String pathname = "././data/wordList.txt";
	private static Scanner scanner;
	
	public Term(){

	}
	
	public Term(double weight, String term){
		if(term == null){
			throw new NullPointerException();
		}
		if(weight < 0){
			throw new IllegalArgumentException();
		}
		this.weight = weight;
		this.term = term;
	}
	
	public static void main(String [] args) throws Exception{
		readTerms();
		System.out.println(termsList);
		//listSize();
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
			
			termsList.add(list);
		}
			}
	
	//small test just to check every word is saved to list
	public static void listSize(){
		for(int i=0; i<termsList.size(); i++){
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
	
	
	
	public static Comparator<Term> WeightOrder(){
		return new WeightOrder();
	}
	
	private static class WeightOrder implements Comparator<Term>{
		@Override
		public int compare(Term a, Term b){
			if (a.weight == b.weight) return 0;
			if (a.weight > b.weight) return -1;
			return 1;
		}
		
	}
	

	@Override
	public int compareTo(Term arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
