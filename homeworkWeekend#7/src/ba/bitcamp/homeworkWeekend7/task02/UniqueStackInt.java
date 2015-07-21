package ba.bitcamp.homeworkWeekend7.task02;

import java.util.EmptyStackException;

public class UniqueStackInt {

	/*
	 * Declaring stack.
	 */
	private Node start;

	/**
	 * Constructor.
	 */
	public UniqueStackInt() {
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
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param str
	 *            - Item that is pushed.
	 * @return Item that is pushed.
	 */
	public Integer push(Integer value) {
		Node temp = new Node(value);
		if (start == null) {
			start = new Node(value);
		} else {
			if (!contains(value)) {
				temp.setNext(start);
				start = temp;
			}
		}
		return value;
	}

	/**
	 * Checks if the inputed elements is in the list.
	 * 
	 * @param b
	 *            - Element that is needed to be checked.
	 * @return True if there is element in the list, and false if not.
	 */
	public Boolean contains(Integer value) {
		Node temp = start;
		if (temp.getValue().equals(value)) {
			return true;
		}
		while (temp.getNext() != null) {
			temp = temp.getNext();
			if (temp.getValue().equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 * 
	 * @return The object at the top of this stack.
	 * @throws EmptyStackException
	 *             - if this stack is empty.
	 */
	public Integer pop() throws EmptyStackException {
		Integer temp = start.getValue();
		if (start == null) {
			throw new EmptyStackException();
		} else {
			start = start.getNext();
		}
		return temp;
	}

	/**
	 * Checks if the elements of the stack are increasing from the top to the
	 * bottom.
	 * 
	 * @return True if they are and false otherwise.
	 */
	public Boolean isIncreasing() {
		Node temp = start;
		while (temp.getNext() != null) {
			if (temp.getValue() > temp.getNext().getValue()) {
				return false;
			}
			temp = temp.getNext();
		}
		return true;
	}

	/**
	 * Inner class.
	 * 
	 * @author adis.cehajic
	 *
	 */
	private class Node {
		private Integer value;
		private Node next;

		/**
		 * Constructor.
		 * 
		 * @param value
		 */
		public Node(Integer value) {
			super();
			this.value = value;
		}

		/**
		 * Prints the node.
		 */
		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + ", " + next.toString();
		}

		/*
		 * Get and set methods.
		 */
		public Integer getValue() {
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
