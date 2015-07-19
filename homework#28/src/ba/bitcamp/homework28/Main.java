package ba.bitcamp.homework28;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// Declaring the list.
		SortedIntList list = new SortedIntList();

		// Inserting the numbers into the list.
		System.out.println("Insert positiv numbers: ");

		while (true) {
			try {
				int number = in.nextInt();
				if (number > 0) {
					list.add(number);
				} else {
					break;
				}
			} catch (InputMismatchException ex) {
				System.out.println("Please insert only number!");
				in.nextLine();
			}
		}

		// Printing the list, the array and the number of elements of the list.
		System.out
				.printf("You have entered list: \n%s\nYou have entered array: \n%s\nThe length of the list is: %d\n",
						list, Arrays.toString(list.toArray()), list.getLength());

		in.close();

	}
}
