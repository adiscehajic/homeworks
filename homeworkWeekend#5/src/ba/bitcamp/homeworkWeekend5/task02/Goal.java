package ba.bitcamp.homeworkWeekend5.task02;

import ba.bitcamp.homeworkWeekend5.task01.StoryElement;
import ba.bitcamp.homeworkWeekend5.task01.Character;

/**
 * Describes the goal of a single character in the plot of a story.
 * 
 * @author Adis Cehajic
 *
 */
public class Goal extends StoryElement {

	public static final int EASY = 1;
	public static final int HARD = 2;
	public static final int IMPOSSIBLE = 3;

	/*
	 * Declaring properties of goal
	 */
	private int level;
	private String event;
	private Character character;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of the goal.
	 * @param level
	 *            - Level of the goal.
	 * @param event
	 *            - What needs to happened.
	 * @param fiona
	 *            - To whom or with whom will event happened.
	 */
	public Goal(String name, int level, String event, Character fiona) {
		super(name);
		this.level = level;
		this.event = event;
		this.character = fiona;
	}

	/*
	 * Get and set methods.
	 */
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

}
