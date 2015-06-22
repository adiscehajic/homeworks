package ba.bitcamp.homeworkWeekend5.task03;

import java.util.Random;

import ba.bitcamp.homeworkWeekend5.task01.Character;
import ba.bitcamp.homeworkWeekend5.task02.Goal;

/**
 * Describes the main good guy of the story.
 * 
 * @author Adis Cehajic
 *
 */
public class Protagonist extends Character {

	/*
	 * Declaring properties of protagonist.
	 */
	private Goal goal;
	private Character[] helpers = new Character[3];
	private Character mainEnemy = null;

	private static int helperCount = 0;
	private static int MIN_CHANCE = 0;
	private static int MAX_CHANCE = 100;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of the protagonist.
	 * @param isMale
	 *            - Gender of the protagonist.
	 * @param isCompetent
	 *            - Competence of the protagonist.
	 * @param goal
	 *            - Goal of the protagonist.
	 */
	public Protagonist(String name, boolean isMale, boolean isCompetent,
			Goal goal) {
		super(name, isMale, isCompetent);
		this.goal = goal;
	}

	/**
	 * Prints information about protagonist.
	 */
	public String toString() {
		String s = super.toString();
		s += "Goal: " + goal.getName() + "\n";
		return s;
	}

	/**
	 * Sets the main enemy of the main character.
	 * 
	 * @param enemy
	 */
	public void setMainEnemy(Character enemy) {
		this.mainEnemy = enemy;
	}

	/**
	 * Sets helpers of the main character. Main character can't have more than
	 * three helpers.
	 * 
	 * @param helper
	 */
	public void setHelpers(Character helper) {

		try {
			if (helperCount == helpers.length) {
				throw new IndexOutOfBoundsException();
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Can't have more helpers!");
		}

		helperCount++;

		for (int i = 0; i < helpers.length; i++) {
			if (helpers[i] == null) {
				helpers[i] = helper;
				break;
			}
		}
	}

	/**
	 * Starts a cycle of fighting the main character and attempt to achieve in
	 * its goal.
	 */
	public void attainGoal() {
		int chance = 0;

		// Checks if the main hero is alive and then calculates his chances.
		if (this.isAlive() == true) {
			// If the main character is competent his chances are higher for 40
			if (this.isCompetent() == true) {
				chance += 40;
			}
			// For each competent helper chances are higher for 20
			for (int i = 0; i < helpers.length; i++) {
				if (helpers[i] != null && helpers[i].isCompetent() == true) {
					chance += 20;
				}
			}
			// If the enemy is competent chances are lower for 30
			if (mainEnemy.isCompetent() == true) {
				chance -= 30;
			}
			// If the goal level is hard chances are lower for 20, and if it is
			// impossible chances are 0.
			if (goal.getLevel() == Goal.HARD) {
				chance -= 20;
			} else if (goal.getLevel() == Goal.IMPOSSIBLE) {
				chance -= 100;
			}
		} else {
			System.out.println("The main hero is dead!");
		}

		// Chances can't be higher than 100 and lower than 0.
		if (chance > MAX_CHANCE) {
			chance = MAX_CHANCE;
		} else if (chance < MIN_CHANCE) {
			chance = MIN_CHANCE;
		}

		// If the chances are higher than 50, hero has succeed.
		if (chance >= 50) {
			System.out.printf("Hero has succeed in %s.\n", goal.getName());

			// Finding one random helper and changing his competence to true.
			for (int i = 0; i < helpers.length; i++) {
				int rand = (int) Math.random() * 3 + 1;
				if (helpers[rand] != null
						&& helpers[rand].isCompetent() == false) {
					helpers[rand].setCompetent(true);
				}
			}
		} else {
			System.out.printf("Hero has'nt succeed in %s.\n", goal.getName());
			Random random = new Random();

			// Finding one random helper and killing him.
			for (int i = 0; i < helpers.length; i++) {
				int rand = random.nextInt(3);
				if (helpers[rand] != null && helpers[rand].isAlive() == true) {
					helpers[rand].killCharacter();
					break;
				}
			}

			// Finding one random helper and changing his competence to true.
			for (int i = 0; i < helpers.length; i++) {
				int rand = random.nextInt(3);
				System.out.println(rand);
				if (helpers[rand] != null && helpers[rand].isAlive() == true
						&& helpers[rand].isCompetent() == false) {
					helpers[rand].setCompetent(true);
					break;
				}
			}
		}
	}

	/*
	 * Get and set methods.
	 */
	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public Character[] getHelpers() {
		return helpers;
	}

	public Character getMainEnemy() {
		return mainEnemy;
	}

}
