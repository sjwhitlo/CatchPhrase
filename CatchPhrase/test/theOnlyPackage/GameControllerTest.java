package theOnlyPackage;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class GameControllerTest {

	/** The Game Controller being tested. */
	private GameController gc;

	@Before
	public void setUp() throws Exception {
		gc = new GameController(new Scanner(new File("./PhraseListTest.txt")));
	}

	@Test
	public void testGameControllerScanner() {
		assertTrue(gc
				.toString()
				.startsWith("Bruce Banner\nTony Stark\nHarry Potter\nLily Potter\nSteve Rogers\nNatasha Romanoff\nJames Potter\nHermione Granger\nGroot\nVoldemort\n"));
		assertEquals(gc.getTeamOne(), 0);
		assertEquals(gc.getTeamTwo(), 0);
	}

	@Test
	public void testGetTeamOneName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTeamTwoName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTeamOne() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetTeamTwo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddTeamOne() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddTeamTwo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSubTeamOne() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSubTeamTwo() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetNextPhrase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSkipPhrase() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetCategory() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSelectCategory() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testWinner() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGameOver() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testToStringCategory() {
		fail("Not yet implemented"); // TODO
	}

}
