package assignment;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class TermTest {

	Term term;
	
	
	//tests creation of termsList object
	@Test
	public void testTermsList() throws Exception {
		Term termsList;
		termsList = new Term(0, null);
		assertNotNull(termsList);
	}
	
	@Test
	public  void testGetTerm(){
		Term t = new Term(1234, "the");
		assertEquals("the", t.getTerm());
	}

	
}
