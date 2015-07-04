package ba.bitcamp.homework21.task04;

import javax.swing.JOptionPane;

/**
 * Task#4 - Only windows
 * 
 * Using only JOptionPane class to create a GUI application that asks the user
 * to enter a number. Then asks the user whether he wants to enter another
 * number. If she says no, then throw out the sum of all the numbers up to that.
 * If he says he will then go back to the first step and so on. If the user goes
 * "Cancel" then just close the application, and if you pressed the "Cancel"
 * button when entering numbers, then print the sum, and if you enter the wrong
 * value (e.g. letters) then throw an error and exit the program.
 * 
 * @author Adis Cehajic
 *
 */
public class Task04 {

	public static void main(String[] args) {

		// Declaring variables.
		int number;
		int choice;
		int sum = 0;

		try {
			// Opening input dialog and inputing number
			String str = JOptionPane.showInputDialog("Input number: ");

			// If nothing is inputed exiting the program.
			if (str.equals(null)) {
				System.exit(0);
			}

			// Adding values to the variables.
			number = Integer.parseInt(str);
			sum += number;

			// Opening confirm dialog and asking user if he want to input
			// another number.
			choice = JOptionPane.showConfirmDialog(null,
					"Would you like to input another number?");
			// If is option NO selected printing sum of all inputed numbers and
			// exiting program.
			if (choice == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, sum);
				System.exit(0);
				// If is option CANCEL selected exiting program.
			} else if (choice == JOptionPane.CANCEL_OPTION) {
				System.exit(0);
			}
			// If the inputed value is not number catching exceptions and
			// exiting program.
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Inputed wrong number format!");
			System.exit(0);
		} catch (NullPointerException ek) {
			System.exit(0);
		}

		try {
			// Repeating the input until user selects YES option.
			do {
				// Opening input dialog and inputing number
				String str2 = JOptionPane.showInputDialog("Input number: ");

				// If nothing is inputed throwing exception.
				if (str2.equals(null)) {
					throw new NullPointerException();
				}

				// Adding values to the variables.
				number = Integer.parseInt(str2);
				sum += number;

				// Opening confirm dialog and asking user if he want to input
				// another number.
				choice = JOptionPane.showConfirmDialog(null,
						"Would you like to input another number?");
				// If is option NO selected printing sum of all inputed numbers
				// and
				// exiting program.
				if (choice == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, sum);
					System.exit(0);
					// If is option CANCEL selected printing sum of all inputed
					// numbers and exiting program.
				} else if (choice == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, sum);
					System.exit(0);
				}
			} while (choice == JOptionPane.YES_OPTION);
			// If the inputed value is not number catching exceptions, printing
			// sum and exiting program.
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Inputed wrong number format!");
			System.exit(0);
		} catch (NullPointerException ek) {
			JOptionPane.showMessageDialog(null, sum);
			System.exit(0);
		}
	}
}
