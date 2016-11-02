package assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BruteForceTest {
	
	public static ArrayList<Term> termsTest = new ArrayList<Term>();

	
	/**
	 * Setup an arraylist of type term in order to test to best predict the results of the tests.
	 */
	@Before
	public void setup(){
		Term the = new Term(11111.0, "the");
		Term ok = new Term(2222.0, "ok");
		Term yes = new Term(3333.0, "yes");
		Term i = new Term(4444.0, "i");
		Term love = new Term(5555.0, "love");
		Term java = new Term(6666.0, "java");
		Term these = new Term(7777.0, "these");
		Term there = new Term(8888.0, "there");
		Term their = new Term(9999.0, "their");
		
		
		termsTest.add(the);
		termsTest.add(ok);
		termsTest.add(yes);
		termsTest.add(i);
		termsTest.add(love);
		termsTest.add(java);
		termsTest.add(these);
		termsTest.add(there);
		termsTest.add(their);
		
	}
	
	
	/**
	 * tests bestMatch method by checking every way of spelling the returns the as best match
	 */
	@Test
	public void testBestMatch(){
		BruteAutocomplete b = new BruteAutocomplete(termsTest);
		assertEquals("the", b.bestMatch("the"));
		assertEquals("the", b.bestMatch("t"));
		assertEquals("the", b .bestMatch("th"));
		//assertEquals("null", b.bestMatch("error"));
	}
	

	/**
	 * Tests the weightOf method
	 */
	@Test
	public void testWeightOf(){
		BruteAutocomplete b = new BruteAutocomplete(termsTest);
		//tests the weight is returned
		assertEquals(6666.0, b.weightOf("java") , 0.001);
		
		//tests if the prefix does not exsist that 0.0 is returned
		assertEquals(0.0, b.weightOf("abcdefg"), 0.001);
		
		//test to see if prefix is not complete word, it searchs for best match and returns weight
		assertEquals(5555.0, b.weightOf("lo"), 0.001);
	}

	/**
	 * Tests matches method
	 */
	@Test
	public void testTopMatches(){
		BruteAutocomplete b = new BruteAutocomplete(termsTest);
		
		//sets up an arraylist of expected results
		ArrayList<String> expectedList1 = new ArrayList<>();
		expectedList1.add("the");
		
		//tests matches for the looking for 1 search
		assertEquals(expectedList1, b.matches("the", 1));
		
		//sets up an arraylist of expected results
		ArrayList<String> expectedList2 = new ArrayList<>();
		expectedList2.add("the");
		expectedList2.add("these");
		expectedList2.add("there");
		expectedList2.add("their");
		
		//test returns 4 matches
		assertEquals(expectedList2, b.matches("the", 4));
		
		//test that it will return the max number of matches if a higher "k" is inserted
		assertEquals(expectedList2, b.matches("the", 10));
		
		//tests that .toLowerCase changes the prefix so that it will search no matter of caps lock
		String theCap = "THE".toLowerCase();
		assertEquals(expectedList2, b.matches(theCap, 4));
		
		//sets up a blank arraylist for expected results
		ArrayList<String> expectedList3 = new ArrayList<>();
		
		//returns blank array is not match is found
		assertEquals(expectedList3, b.matches("tqewvvrevrqev", 10));
		
	}
	

}
