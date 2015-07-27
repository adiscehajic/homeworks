package ba.bitcamp.homeworkWeekend7.task03;

import java.util.ArrayList;
import java.util.ListIterator;

public class Task03 {

	public static void main(String[] args) {

		// Creating list.
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Adding elements into the list.
		numbers.add(2);
		numbers.add(4);
		numbers.add(3);
		numbers.add(5);
		numbers.add(2);
		numbers.add(9);
		numbers.add(2);
		numbers.add(5);
		numbers.add(17);

		// Printing the list.
		System.out.println("First list: " + numbers);

		// Creating second list.
		ArrayList<Integer> numbersNew = new ArrayList<Integer>();

		// Creating iterator.
		ListIterator<Integer> iter = numbers.listIterator();

		// Going trough first list, from index 0 and adding every second element
		// into the second list.
		int count = 0;
		while (iter.hasNext()) {
			int number = iter.next();
			if (count % 2 == 0) {
				numbersNew.add(number);
			}
			count++;
		}

		// Restarting the iterator.
		iter = numbers.listIterator();

		// Going trough first list, from index 1 and adding every second element
		// to the elements in the second list.
		count = 0;
		int index = 0;
		while (iter.hasNext()) {
			int number = iter.next();
			if (count % 2 != 0) {
				numbersNew.set(index, number + numbersNew.get(index));
				index++;
			}
			count++;
		}

		// Printing second list.
		System.out.println("Second list: " + numbersNew);

	}
}
