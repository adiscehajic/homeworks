package ba.bitcamp.homeworkWeekend5.task05;

import ba.bitcamp.homeworkWeekend5.task02.Event;
import ba.bitcamp.homeworkWeekend5.task02.Goal;
import ba.bitcamp.homeworkWeekend5.task03.Protagonist;
import ba.bitcamp.homeworkWeekend5.task01.Character;

public class Main {

	public static void main(String[] args) {

		/*
		 * Shrek and Fiona return from their honeymoon to find they have been
		 * invited by Fiona's parents to a royal ball to celebrate their
		 * marriage, an event Shrek is reluctant to participate in. Fiona talks
		 * him into it, and along with Donkey, they travel to the kingdom of Far
		 * Far Away. They meet Fiona's parents, King Harold and Queen Lillian
		 * and, the former of which is repulsed by Shrek being an ogre. At a
		 * shared meal, Shrek and Harold get into a heated argument over how
		 * Shrek and Fiona will raise their family, and Fiona, disgusted at
		 * Shrek's behavior, locks herself away in her room that evening. Shrek
		 * worries that he has lost his true love, particularly after finding
		 * her childhood diary and reading that she was once infatuated with
		 * Prince Charming.
		 */

		Character fiona = new Character("Princess Fiona", false, true);

		Goal goal = new Goal("Save the princese", Goal.HARD, Event.LOVE, fiona);

		Protagonist shrek = new Protagonist("Shrek", true, true, goal);

		/*
		 * Harold arranges for Shrek and Donkey to join him on a fictitious
		 * hunting trip, which really is a trap to lure the two into the hands
		 * of an assassin, Puss in Boots. However, Puss is unable to defeat
		 * Shrek and, revealing that he was paid by Harold, asks to come along
		 * as a way to make amends. The three sneak into the Fairy Godmother's
		 * potion factory and steal a "Happily Ever After" potion
		 */

		Character donkey = new Character("Donkey", true, false);
		Character puss = new Character("Puss in Boots", true, true);
		Character donkeysWife = new Character("Dragon", false, true);

		Character princeCharming = new Character("Prince Charming", true, false);

		/*
		 * Shrek and Donkey both drink the potion and fall into a deep sleep,
		 * awakening the next morning to discover its effects: Shrek is now a
		 * handsome man, while Donkey has turned into a white stallion. In order
		 * to make the change permanent, Shrek must kiss Fiona by midnight.
		 * However, the Fairy Godmother, having learned of the potion's theft,
		 * intercepts Shrek and sends Prince Charming to pose as him and win her
		 * love.
		 */

		shrek.setHelpers(donkey);
		shrek.setHelpers(puss);
		shrek.setHelpers(donkeysWife);
		shrek.setMainEnemy(princeCharming);

		/*
		 * To ensure that Fiona falls in love with Charming, the Fairy Godmother
		 * tries to put into Fiona's tea a love potion. While the royal ball
		 * begins, several of Shrek's friends band together to free the trio and
		 * create a gigantic gingerbread man, which breaks through the castle's
		 * defenses so Shrek can stop Charming from kissing Fiona. He is too
		 * late to stop them; instead of falling in love with Charming, though,
		 * Fiona knocks him out with a headbutt.
		 */

		shrek.attainGoal();

		/*
		 * As the clock strikes midnight, Shrek and Fiona let the potion's
		 * effects wear off and they revert to their ogre selves, while Donkey
		 * changes back as well.
		 */
		
		System.out.println(shrek);
		System.out.println(donkey);
		System.out.println(puss);
		System.out.println(donkeysWife);
		System.out.println(princeCharming);

	}
}
