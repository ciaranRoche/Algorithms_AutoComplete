package assignment;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Terms{
		
	public String term;
	public double weight;
	
	static ArrayList<Terms> termsList = new ArrayList<Terms>();
	
	public String pathname = "././data/wordList.txt";
	private static Scanner inTerms;
	
	public Terms(){

	}
	
	public Terms(double weight, String term){
		this.weight = weight;
		this.term = term;
	}
	
	public static void main(String [] args) throws Exception{
		readTerms();
		System.out.println(termsList);
	}
	
	public static void readTerms() throws IOException{
		File terms = new File("././data/wordList.txt");
		inTerms = new Scanner(terms);
		String delims = "[	]";
		while(inTerms.hasNextLine()){
			String termDetails = inTerms.nextLine();
			termDetails = termDetails.trim();
			
			String[] termTokens = termDetails.split(delims);
			
			System.out.println(termTokens[0] +" "+ termTokens[1]);
			
			Terms list = new Terms(Double.parseDouble(termTokens[0]), termTokens[1]);
			
			termsList.add(list);
		}
			}
	
	public void getTerms(){
		
	}
	
	public String toString(){
		return "weight: " + weight + " term: " + term + "\n";
	}
	
}
