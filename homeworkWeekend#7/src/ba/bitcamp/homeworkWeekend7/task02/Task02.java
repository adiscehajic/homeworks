package ba.bitcamp.homeworkWeekend7.task02;

public class Task02 {

	public static void main(String[] args) {

		// Creating stack.
		UniqueStackInt stack = new UniqueStackInt();

		// Putting elements into the stack.
		System.out.println(stack.push(35));
		System.out.println(stack.push(10));
		System.out.println(stack.push(31));

		// Checking if the stack is increasing.
		System.out.println(stack.isIncreasing());

		// Deleting elements from the stack.
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// Printing the stack.
		System.out.println(stack);

	}
}
