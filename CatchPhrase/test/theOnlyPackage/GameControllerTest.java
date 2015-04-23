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
		assertTrue(gc.getTeamOneName().equals("Team One"));
	}

	@Test
	public void testGetTeamTwoName() {
		assertTrue(gc.getTeamTwoName().equals("Team Two"));
	}

	@Test
	public void testGetTeamOne() {
		assertEquals(gc.getTeamOne(), 0);
	}

	@Test
	public void testGetTeamTwo() {
		assertEquals(gc.getTeamTwo(), 0);
	}

	@Test
	public void testAddTeamOne() {
		assertEquals(gc.getTeamOne(), 0);
		gc.addTeamOne();
		assertEquals(gc.getTeamOne(), 1);
	}

	@Test
	public void testAddTeamTwo() {
		assertEquals(gc.getTeamTwo(), 0);
		gc.addTeamTwo();
		assertEquals(gc.getTeamTwo(), 1);
	}

	@Test
	public void testSubTeamOne() {
		assertEquals(gc.getTeamOne(), 0);
		gc.subTeamOne();
		assertEquals(gc.getTeamOne(), -1);
	}

	@Test
	public void testSubTeamTwo() {
		assertEquals(gc.getTeamTwo(), 0);
		gc.subTeamTwo();
		assertEquals(gc.getTeamTwo(), -1);
	}

	@Test
	public void testGetNextPhrase() {
		gc.selectCategory(2);
		assertTrue(gc.getNextPhrase().equals("Groot"));
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
