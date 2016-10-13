package assignment;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Terms{
		
	public String term;
	public double weight;
	
	static String[] wikiList;
	static ArrayList<String> list = new ArrayList<String>();
	
	public String pathname = "././data/wordList.txt";
	
	public Terms(){

	}

	/**public static void readTerms() throws FileNotFoundException{
	File wordFile = new File("././data/wordList.txt");
	Scanner inWords = new Scanner(wordFile);
	while(inWords.hasNextLine()){
		String words = inWords.nextLine();
		wikiList.add(words);
		}
	}
	 * @throws Exception **/
	
	public static void main(String [] args) throws Exception{
		readTerms();
		System.out.println(list);
		//readTerms();
	}
	
	/**public static void readTerms(){
		try{
			FileInputStream stream = new FileInputStream("././data/wordList.txt");
			
			DataInputStream in = new DataInputStream(stream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			
			while ((str = br.readLine()) != null){
				list.add(str);
				//System.out.println(str);
				
			}
			in.close();
		}catch (Exception e){
			System.out.println("error" + e.getMessage());
		}
		System.out.println(list);
	}
	
	/**public static void readTerms() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("././data/wordList.txt"));
		String str = null;
		
		ArrayList<String> list = new ArrayList<String>();
		while((str = in.readLine()) != null){
			list.add(str);
		}
		String[] wikiList = list.toArray(new String[list.size()]);
		System.out.println(list);
	}**/
	
	
	public static void readTerms() throws IOException{
		BufferedReader in = null;
		try{
			File file = new File("././data/wordList.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while((line = bufferedReader.readLine()) != null){
				stringBuffer.append(line);
				stringBuffer.append("\n");
				list.add(line);
			}
			fileReader.close();
			System.out.println(stringBuffer.toString());
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
/**
	public static void readTerms() throws Exception{
		File wordList = new File("./data/wordList.txt");
		Scanner inWords = new Scanner(wordList);
		String delims = "[]";
		while(inWords.hasNextLine()){
			String words = inWords.nextLine();
			String[] wordTokens = words.split(delims);
			
			if(wordTokens.length == 2){
				System.out.println("Word: " + wordTokens[0] + ",Weight: " + wordTokens[1]);
				
			}
			
			else{
				inWords.close();
				throw new Exception("Invalid member length: " + wordTokens.length);
			}
			
		}
		inWords.close();
	}
/**
	//@Override
	public List<String> getSubstringList(String subString){
		List<String> returnList = new ArrayList<String>();
		if (subString != null){
			for (String s : wikiList){
				if(s.toLowerCase().contains(subString.toLowerCase()));
				returnList.add(s);
			}
		}
		Collections.sort(returnList);
		return returnList;
	}

	//@Override
	public void addString(String s){
		if (s != null && s.trim().length() > 0)
			wikiList.add(s.trim());
	}**/
}
