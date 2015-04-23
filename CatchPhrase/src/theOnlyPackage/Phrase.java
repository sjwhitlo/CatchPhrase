package theOnlyPackage;

/**
 * An object that has a Phrase and topic.
 * 
 * @author Sam Whitlock
 */
public class Phrase {

	/** The phrase. */
	private String phrase;
	/** The topic. */
	private String topic;

	/**
	 * Constructs a Phrase object with the given parameters.
	 * 
	 * @param phrase
	 *            The phrase
	 * @param topic
	 *            The topic
	 */
	public Phrase(String phrase, String topic) {
		this.phrase = phrase;
		this.topic = topic;
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
	 * Returns the topic.
	 * 
	 * @return The topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Returns true if the Phrase is a member of the indicated topic
	 * 
	 * @param string
	 *            The topic to check
	 * @return true if the phrase belongs to the topic
	 */
	public boolean isTopic(String toCheck) {
		return topic.contains(toCheck);
	}
}
