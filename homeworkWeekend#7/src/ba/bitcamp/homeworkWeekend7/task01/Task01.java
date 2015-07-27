package ba.bitcamp.homeworkWeekend7.task01;

public class Task01 {

	public static void main(String[] args) {

		// Creating list.
		LinkedListBoolean list = new LinkedListBoolean();

		// Printing list.
		System.out.println(list + "\n");

		// Adding elements into the list.
		list.add(true);
		list.add(false);
		list.add(false);
		list.add(true);
		list.add(true);
		list.add(false);
		list.add(true);

		// Printing list.
		System.out.println("Elements of the list are: \n" + list + "\n");

		// Removing element from the list
		list.remove(false);
		list.remove(2, true);

		// Printing list.
		System.out.println("Elements of the list are: \n" + list + "\n");

		// Checking if the list is alternating.
		System.out.println("Is the list alternating? " + list.isAlternating());
	}
}
