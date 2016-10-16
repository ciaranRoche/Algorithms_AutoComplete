package assignment;

import static org.junit.Assert.*;

import org.junit.Test;

import static assignment.Fixtures.terms;

public class TermsTest {

	//tests creation of termsList object
	@Test
	public void testTermsList() throws Exception {
		Terms termsList;

		termsList = new Terms();
		assertNotNull(termsList);

	}


	
}
