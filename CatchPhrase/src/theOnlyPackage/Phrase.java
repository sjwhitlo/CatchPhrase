package theOnlyPackage;

/**
 * An object that has a Phrase and category.
 * 
 * @author Sam Whitlock
 */
public class Phrase {

	/** The phrase. */
	private String phrase;
	/** The category. */
	private String category;

	/**
	 * Constructs a Phrase object with the given parameters.
	 * 
	 * @param phrase
	 *            The phrase
	 * @param category
	 *            The category
	 */
	public Phrase(String phrase, String category) {
		this.phrase = phrase;
		this.category = category;
	}

	/**
	 * Returns the phrase.
	 * 
	 * @return The phrase
	 */
	public String getPhrase() {
		return phrase;
	}

	/**
	 * Returns the category.
	 * 
	 * @return The category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns true if the Phrase is a member of the indicated category
	 * 
	 * @param string
	 *            The category to check
	 * @return true if the phrase belongs to the category
	 */
	public boolean isCategory(String toCheck) {
		return category.contains(toCheck);
	}
}
