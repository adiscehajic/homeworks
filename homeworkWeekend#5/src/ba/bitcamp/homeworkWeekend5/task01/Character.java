package ba.bitcamp.homeworkWeekend5.task01;

/**
 * Describes one of the characters in the plot of a story.
 * 
 * @author Adis Cehajic
 *
 */
public class Character extends StoryElement {

	/*
	 * Declaring properties of character
	 */
	private boolean isMale;
	private boolean isAlive;
	private boolean isCompetent;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of the character.
	 * @param isMale
	 *            - Gender of the character.
	 * @param isCompetent
	 *            - Competence of the character.
	 */
	public Character(String name, boolean isMale, boolean isCompetent) {
		super(name);
		this.isMale = isMale;
		this.isAlive = true;
		this.isCompetent = isCompetent;
	}

	/**
	 * Kills the character - changes isAlive to false.
	 */
	public void killCharacter() {
		isAlive = false;
	}

	/**
	 * If the competence of the character is false, changes it to true.
	 */
	public void setCompetent() {
		isCompetent = true;
	}

	/**
	 * Prints the information about character.
	 */
	public String toString() {
		String s = super.toString();
		s += "Is male: " + isMale + "\n";
		s += "Is alive: " + isAlive + "\n";
		s += "Is compatent: " + isCompetent + "\n";
		return s;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isCompetent() {
		return isCompetent;
	}

	public void setCompetent(boolean isCompetent) {
		this.isCompetent = isCompetent;
	}

}
