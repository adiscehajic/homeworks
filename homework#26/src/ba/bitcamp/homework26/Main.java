package ba.bitcamp.homework26;

public class Main {

	public static void main(String[] args) {

		// Creating list.
		LinkedListDouble list = new LinkedListDouble();

		// Printing list.
		System.out.println(list);

		// Adding elements to the list.
		list.add(135.0);
		list.add(5.0);
		list.add(3.0);
		list.add(5.0);
		list.add(15.0);
		list.add(3.0);
		list.add(5.0);
		list.add(175.0);

		// Printing list.
		System.out.println(list);

		// Printing size of list.
		System.out.println("Number of elements is: " + list.size());

		// Removing elements at index 3 and 2.
		list.remove(3);
		list.remove(2);

		// Printing list.
		System.out.println(list);

		// Printing element at index 0.
		System.out.println("Element at index 0 is: " + list.get(0));

		// Printing middle element.
		System.out.println("Middle element is: " + list.middle());

		// Printing first and last element of the list.
		System.out.println("First element is: " + list.getFirst());
		System.out.println("Last element is: " + list.getLast());

		// Deleting first and last element of the list.
		list.deleteFirst();
		list.deleteLast();

		// Printing list and size of the list.
		System.out.println(list);
		System.out.println("Number of elements is: " + list.size());

		// Adding element at index 3.
		list.add(25.0, 3);

		// Printing list and size of the list.
		System.out.println(list);
		System.out.println("Number of elements is: " + list.size());

		// Creating new list and adding all elements of the first list to the
		// new list.
		LinkedListDouble list2 = new LinkedListDouble(list);

		System.out.println();

		// Printing list and size of the list.
		System.out.println(list2);
		System.out.println("Number of elements is: " + list2.size());
	}
}
