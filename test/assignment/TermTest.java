package assignment;

import static org.junit.Assert.*;

import org.junit.Test;

import static assignment.Fixtures.terms;

public class TermTest {

	//tests creation of termsList object
	@Test
	public void testTermsList() throws Exception {
		Term termsList;

		termsList = new Term();
		assertNotNull(termsList);

	}


	
}
