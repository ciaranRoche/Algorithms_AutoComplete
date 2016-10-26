package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
	
	static Term term;
	static BruteAutocomplete brute;
	
	private static String prefix;
	private static int k;
	
	private Scanner input;
	
	private static ArrayList<Term> termsList;

	
	public Client(){
		input = new Scanner(System.in);
		brute = new BruteAutocomplete(termsList);
	}
	

	public static void main(String args[]){
		Client app = new Client();

		try {
			term.readTerms();
		} catch (IOException e) {
			System.out.println(e + "Array failing to pop");
		}
		termsList = term.getTermsList();
		app.run();
	}
	
	public void run(){
		try{
		System.out.println("Please input a prefix in which you want to search for matchs:");
		String inputP = input.nextLine();
	    setPrefix(inputP);
		}catch(Exception e){
			System.out.println(e.getMessage());
			run();
		}
		try{
		System.out.println("Please enter a max search number between 1-10:");
		int inputK = input.nextInt();
		if(inputK > 10){
			System.out.println("Invalid option, please pick a number between 1 and 10:");
			run();
		}else{
		setK(inputK);
		}
		}catch(Exception i){
			System.out.println("Invalid option: " + i.getMessage());
			run();
		System.out.println("----------");
	}
		brute = new BruteAutocomplete(termsList);
		int option = menu();
		while(option != 0){
			switch (option){
			case 1: 
			    System.out.println("\nThe weight for " + getPrefix() + " is: ");
				System.out.println(brute.weightOf(prefix));
				break;
			case 2:
				System.out.println("\nThe best match for " + getPrefix() + " is: ");
				System.out.println(brute.bestMatch(prefix));
				break;
			case 3:
				System.out.println("\nList of matches for " + getPrefix() + " is: ");
				System.out.println(brute.matches(prefix, k));
				//brute.matches(prefix, k);
				break;
			case 4:
				System.out.println(term.getTermsList());
			default:
				System.out.println("Invalid option entered: " + option);
				break;
			}
			System.out.println("\n Press any key to continue.");	
			option = menu();
		}
		System.out.println("Exiting, have a nice day :) \nGoodBye!");		
	}
	
	private int menu(){
		System.out.println("----------");
		System.out.println("Please select the number of the option you want below.");
		System.out.println("   1) Weight of prefix.");
		System.out.println("   2) Best Match of the prefix");
		System.out.println("   3) List of Matchs of the prefix");
		System.out.println("   4) Have a look at the list of words and weights");
		System.out.println("-----------\n   0)Exit");
		int choice = input.nextInt();
		return choice;
	}
	
	public String toString(){
		//return "Prefix:" + prefix + ", Number of wanted matches: " + getK();
		return String.format("%14.1f\t%s", k, prefix);
	}
	
	public static void setPrefix(String prefix){
		Client.prefix = prefix;
	}
	
	public String getPrefix(){
		return prefix;
	}

	public static int getK() {
		return k;
	}

	public static void setK(int k) {
		Client.k = k;
	}

}
