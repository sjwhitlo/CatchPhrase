package theOnlyPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This Class contains all of the methods needed to control a game of Catch
 * Phrase.
 * 
 * @author Sam Whitlock
 */
public class GameController {

	/** Team One's name. */
	private static final String TEAM_ONE_NAME = "Team One";
	/** Team Two's name. */
	private static final String TEAM_TWO_NAME = "Team Two";
	/** The number of points that are played to. */
	private static final int TOTAL_POINTS = 7;
	/** Team One's points. */
	private int teamOne;
	/** Team Two's points. */
	private int teamTwo;
	/** The ArrayList of Categories. */
	private ArrayList<String> categories;
	/** The ArrayList that holds the phrases. */
	private ArrayList<Phrase> phrases;
	/** The selected topic. */
	private int selectedCategory;
	/** The number of turns made. */
	private int turns;

	/**
	 * The generic, default constructor with the default file.
	 * 
	 * @throws FileNotFoundException
	 *             Won't happen unless the default file is not in the src
	 *             folder.
	 */
	public GameController() throws FileNotFoundException {
		this(new Scanner(new File("./PhraseList.txt")));
	}

	/**
	 * The specialized constructor, which accepts a file as a parameter. If the
	 * file is not found, a FileNotFoundException is thrown.
	 * 
	 * @param f
	 *            The file to be read in
	 * @throws FileNotFoundException
	 *             If the file is not found
	 */
	public GameController(Scanner f) throws FileNotFoundException {
		teamOne = 0;
		teamTwo = 0;
		categories = new ArrayList<String>();
		phrases = new ArrayList<Phrase>();
		selectedCategory = -1;
		turns = 0;

		// If the file is not null
		if (f != null) {
			f.useDelimiter("[&\n]");
			// Read in the file
			// While the file has more lines
			while (f.hasNext()) {
				String line = f.nextLine();
				// Add the first section (Topics)
				if (line.isEmpty()) {
					break;
				}
				// Add the Topic
				categories.add(line);
			}
			// While the file has more lines
			while (f.hasNext()) {
				// Temp phrase variable
				String phrase = f.next();
				// Temp category variable
				String category = f.next();
				phrases.add(new Phrase(phrase, category));
			}
		}
	}

	/**
	 * Returns Team One's name.
	 * 
	 * @return Team One's name
	 */
	public String getTeamOneName() {
		return TEAM_ONE_NAME;
	}

	/**
	 * Returns Team Two's name.
	 * 
	 * @return Team Two's name
	 */
	public String getTeamTwoName() {
		return TEAM_TWO_NAME;
	}

	/**
	 * Returns the number of points that team one has.
	 * 
	 * @return The number of points that team one has
	 */
	public int getTeamOne() {
		return teamOne;
	}

	/**
	 * Returns the number of points that team two has.
	 * 
	 * @return The number of points that team two has
	 */
	public int getTeamTwo() {
		return teamTwo;
	}

	/**
	 * Adds a point to team one's score.
	 */
	public void addTeamOne() {
		teamOne++;
	}

	/**
	 * Adds a point to team two's score.
	 */
	public void addTeamTwo() {
		teamTwo++;
	}

	/**
	 * Removes a point from team one's score.
	 */
	public void subTeamOne() {
		teamOne--;
	}

	/**
	 * Removes a point from team two's score.
	 */
	public void subTeamTwo() {
		teamTwo--;
	}

	/**
	 * Returns the next phrase. If the list has been used one time through, the
	 * order is randomized.
	 * 
	 * @return The next phrase
	 */
	public String getNextPhrase() {
		// If the number of turns is equal to the size of the list, randomize it
		if (turns % phrases.size() == 0) {
			Collections.shuffle(phrases);
		}
		// While the front element does not contain the topic, put it at the
		// back
		while (!phrases.get(0).isCategory(categories.get(selectedCategory))) {
			// Increment turns
			turns++;
			// Move the element to the back
			phrases.add(phrases.remove(0));
		}
		// Get the element at the front of the list
		String toReturn = phrases.get(0).getPhrase();
		// Move the element to the back
		phrases.add(phrases.remove(0));
		// Return the Phrase
		return toReturn;
	}

	/**
	 * Skips the next phrase.
	 */
	public void skipPhrase() {
		// While the front element does not contain the topic, put it at the
		// back
		while (!phrases.get(0).isCategory(categories.get(selectedCategory))) {
			// Increment turns
			turns++;
			// Move the element to the back
			phrases.add(phrases.remove(0));
		}
	}

	/**
	 * Returns the selected category. If no category is selected (the number is
	 * out of bounds) the message "No category selected." is returned.
	 * 
	 * @return The category selected
	 */
	public String getCategory() {
		if (selectedCategory < 0 || selectedCategory >= categories.size()) {
			return "No category selected.";
		} else {
			return categories.get(selectedCategory);
		}
	}

	/**
	 * Selects the category based on the input. If </code>toSelect</code> is
	 * less than 0, the first category is selected. If </code>toSelect</code> is
	 * greater than the size, the last category is selected. And if
	 * </code>toSelect</code> is equal to size, a random category is selected.
	 * Otherwise, the selected category is the one chosen.
	 * 
	 * @param toSelect
	 *            The category being selected
	 */
	public void selectCategory(int toSelect) {
		if (selectedCategory < 0) {
			// Bound too low, topic set to 0
			selectedCategory = 0;
		} else if (selectedCategory >= categories.size()
				|| selectedCategory == categories.size() - 1) {
			// Topic set to random
			selectedCategory = (int) (Math.random() * categories.size());
		} else {
			selectedCategory = toSelect;
		}
	}

	/**
	 * Returns the winning team's name.
	 * 
	 * @return The winning team's name
	 */
	public String winner() {
		if (teamOne > teamTwo) {
			return TEAM_ONE_NAME;
		} else {
			return TEAM_TWO_NAME;
		}
	}

	/**
	 * Returns true if the game is over.
	 * 
	 * @return true if the game is over
	 */
	public boolean gameOver() {
		return (teamOne >= TOTAL_POINTS || teamTwo >= TOTAL_POINTS);
	}

	/**
	 * Returns a String representing all of the items in the list.
	 * 
	 * @return A String representing all of the items in the list
	 */
	public String toString() {
		String toReturn = "";
		for (int i = 0; i < phrases.size(); i++) {
			toReturn += phrases.get(0).getPhrase() + "\n";
			phrases.add(phrases.remove(0));
		}
		return toReturn;
	}

	/**
	 * Returns a String representing all of the items in the selected category.
	 * 
	 * @return A String representing all of the items in the selected category
	 */
	public String toStringCategory() {
		String toReturn = "";
		for (int i = 0; i < phrases.size(); i++) {
			if (phrases.get(0).isCategory(categories.get(selectedCategory))) {
				toReturn += phrases.get(0) + "\n";
			}
			phrases.add(phrases.remove(0));
		}
		return toReturn;
	}
}