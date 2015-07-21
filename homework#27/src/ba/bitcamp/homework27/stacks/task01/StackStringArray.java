package ba.bitcamp.homework27.stacks.task01;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackStringArray {

	/*
	 * Declaring the stack.
	 */
	private String[] array;

	/**
	 * Constructor.
	 */
	public StackStringArray() {
		this.array = new String[0];
	}

	/**
	 * Prints the elements in the stack.
	 */
	public String toString() {
		return Arrays.toString(array);
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return True if and only if this stack contains no items; false
	 *         otherwise.
	 */
	public boolean empty() {
		return array.length == 0;
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param str
	 *            - Item that is pushed.
	 * @return Item that is pushed.
	 */
	public String push(String str) {
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = str;
		return str;
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return The object at the top of this stack.
	 * @throws EmptyStackException
	 *             - if this stack is empty.
	 */
	public String peek() throws EmptyStackException {
		if (array.length > 0) {
			return array[array.length - 1];
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 * 
	 * @return The object at the top of this stack.
	 * @throws EmptyStackException
	 *             - if this stack is empty.
	 */
	public String pop() throws EmptyStackException {
		if (array.length > 0) {
			String temp = peek();
			array = Arrays.copyOf(array, array.length - 1);
			return temp;
		} else {
			throw new EmptyStackException();
		}
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the
	 * object o occurs as an item in this stack, this method returns the
	 * distance from the top of the stack of the occurrence nearest the top of
	 * the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare o to the items in this stack.
	 * 
	 * @param value
	 *            - The desired string.
	 * @return The 1-based position from the top of the stack where the object
	 *         is located; the return value -1 indicates that the object is not
	 *         on the stack.
	 */
	public int search(String value) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				return i + 1;
			}
		}
		return -1;
	}

}
