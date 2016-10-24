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
	}
	

	public static void main(String args[]){
		Client app = new Client();
		try {
			term.readTerms();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
		}
		//System.out.println(termsList);
		brute = new BruteAutocomplete(termsList);
		brute.bestMatch(prefix);
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
//package assignment;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Client {
//	
//	private String prefix;
//	private int k;
//	
//	//Term term2;
//	//ArrayList<Term> list;// = term2.getArray();
////	
//	BruteAutocomplete brute;
////	static Term term;
//
//	
//	public Client() throws IOException{
//		brute = new BruteAutocomplete();
//		
//	}
//	
//	public static void main(String[] args) throws IOException{
//		//term.readTerms();
//		Client client = new Client();
//		
//		client.run();
//		//System.out.println("k: " + k + ", prefix: "+prefix);
//		//System.out.println(list);
//		//brute.bestMatch(prefix);
//	}
//	
//	public void run() throws IOException{
//		//term2.readTerms();
//		//list = term2.getArray();
//		Scanner scanner = new Scanner(System.in);
//		try{
//		System.out.println("Please input a prefix in which you want to search for matchs:");
//		String inputP = scanner.nextLine();
//		//prefix = inputP;
//		brute.bestMatch(inputP);
//	    //setPrefix(inputP);
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//			run();
//		}
//		try{
//		System.out.println("Please enter a max search number between 1-10:");
//		int inputK = scanner.nextInt();
//		if(inputK > 10){
//			System.out.println("Invalid option, please pick a number between 1 and 10:");
//			run();
//		}else{
//		//setK(inputK);
//			k = inputK;
//		}
//		}catch(Exception i){
//			System.out.println("Invalid option: " + i.getMessage());
//			run();
//		}
//	}
//	
//	public String toString(){
//		//return "Prefix:" + prefix + ", Number of wanted matches: " + getK();
//		return String.format("%14.1f\t%s", k, prefix);
//	}
////	
////	public void setPrefix(String prefix){
////		this.prefix = prefix;
////	}
////	
////	public String getPrefix(){
////		return prefix;
////	}
////
////	public int getK() {
////		return k;
////	}
////
////	public void setK(int k) {
////		this.k = k;
////	}
//
//}
