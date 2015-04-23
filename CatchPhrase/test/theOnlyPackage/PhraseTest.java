package theOnlyPackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhraseTest {

	/** The Phrase being tested. */
	private Phrase p1;
	
	@Before
	public void setUp() throws Exception {
		p1 = new Phrase("\"I am Groot!\"", "MCU Everything");
	}

	@Test
	public void testPhrase() {
		assertTrue(p1.getCategory().equals("MCU Everything"));
		assertTrue(p1.getPhrase().equals("\"I am Groot!\""));
	}

	@Test
	public void testGetPhrase() {
		assertTrue(p1.getPhrase().equals("\"I am Groot!\""));
		assertFalse(p1.getPhrase().equals("Groot"));
	}

	@Test
	public void testGetCategory() {
		assertTrue(p1.getCategory().equals("MCU Everything"));
		assertFalse(p1.getCategory().equals("MCU"));
		assertFalse(p1.getCategory().equals("Everything"));
	}

	@Test
	public void testIsCategory() {
		assertTrue(p1.isCategory("Everything"));
		assertTrue(p1.isCategory("MCU"));
		assertTrue(p1.isCategory("Every"));
		assertFalse(p1.isCategory("Harry Potter"));
	}

}
