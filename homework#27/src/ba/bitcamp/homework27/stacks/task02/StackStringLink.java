package ba.bitcamp.homework27.stacks.task02;

import java.util.EmptyStackException;

public class StackStringLink {

	/*
	 * Declaring stack.
	 */
	private Node start;

	/**
	 * Constructor.
	 */
	public StackStringLink() {
		this.start = null;
	}

	/**
	 * Prints the stack.
	 */
	public String toString() {
		if (start == null) {
			return "The stack is empty.";
		}
		return start.toString();
	}

	/**
	 * Tests if this stack is empty.
	 * 
	 * @return True if and only if this stack contains no items; false
	 *         otherwise.
	 */
	public boolean empty() {
		return start == null;
	}

	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param str
	 *            - Item that is pushed.
	 * @return Item that is pushed.
	 */
	public String push(String value) {
		Node temp = new Node(value);
		if (start == null) {
			start = new Node(value);
		} else {
			temp.setNext(start);
			start = temp;
		}
		return value;
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
		if (start == null) {
			throw new EmptyStackException();
		} else {
			return start.getValue();
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
		String temp = start.getValue();
		if (start == null) {
			throw new EmptyStackException();
		} else {
			start = start.getNext();
		}
		return temp;
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
		int index = 1;

		Node temp = start;

		while (!temp.getValue().equals(value)) {
			temp = temp.getNext();
			index++;
			if (temp.getNext() == null) {
				return -1;
			}
		}
		return index;
	}

	/**
	 * Inner class.
	 * 
	 * @author adis.cehajic
	 *
	 */
	private class Node {
		private String value;
		private Node next;

		/**
		 * Constructor.
		 * 
		 * @param value
		 */
		public Node(String value) {
			super();
			this.value = value;
		}

		/**
		 * Prints the node.
		 */
		public String toString() {
			if (next == null) {
				return value;
			}
			return value + ", " + next.toString();
		}

		/*
		 * Get and set methods.
		 */
		public String getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
}
