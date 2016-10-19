package assignment;

import java.util.Scanner;

public class Client {
	
	private static String prefix;
	private static int k;

	
	public Client(String prefix, int k){
		Client.prefix = prefix;
		Client.k = k;
	}
	
	public static void main(String[] args){
		run();
		System.out.println("k: " + k + ", prefix: "+prefix);
	}
	
	public static void run(){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.println("Please input a prefix in which you want to search for matchs:");
		String inputP = scanner.nextLine();
	    setPrefix(inputP);
		}catch(Exception e){
			System.out.println(e.getMessage());
			run();
		}
		try{
		System.out.println("Please enter a max search number between 1-10:");
		int inputK = scanner.nextInt();
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
