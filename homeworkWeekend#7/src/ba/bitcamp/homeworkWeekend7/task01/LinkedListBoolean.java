package ba.bitcamp.homeworkWeekend7.task01;

import java.util.NoSuchElementException;

public class LinkedListBoolean {

	/*
	 * Declaring the stack.
	 */
	private Node head;

	/**
	 * Constructor.
	 */
	public LinkedListBoolean() {
		this.head = null;
	}

	/**
	 * Inserts the specified element into list and increases number of elements
	 * in the list.
	 * 
	 * @param value
	 *            - The element to add.
	 */
	public void add(Boolean value) {
		Node temp = new Node(value);
		if (head == null) {
			head = temp;
		} else {

			Node last = getLastNode();
			last.setNext(temp);

		}
	}

	/**
	 * Retrieves the last element in the list.
	 * 
	 * @return Last element in the list.
	 */
	private Node getLastNode() {
		Node temp = head;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Removes element from the list.
	 * 
	 * @param b
	 *            - Element to remove.
	 * @throws NoSuchElementException
	 *             - If there is no inputed element in the list.
	 */
	public void remove(Boolean b) throws NoSuchElementException {
		remove(-1, b);
	}

	/**
	 * Removes element from the list, if the element is after inputed index.
	 * 
	 * @param b
	 *            - Element to remove.
	 * @throws NoSuchElementException
	 *             - If there is no inputed element in the list in inputed
	 *             range.
	 */
	public void remove(int index, Boolean b) throws NoSuchElementException {
		Node temp = get(index + 1);

		if (temp == null) {
			throw new NoSuchElementException();
		} else if (temp == head && temp.getValue().equals(b)) {
			head = head.getNext();
		} else {
			while (!temp.getValue().equals(b)) {
				temp = temp.getNext();
				if (temp == null) {
					throw new NoSuchElementException();
				}
			}
			Node previous = getPreviousNode(temp);
			previous.setNext(temp.getNext());
		}
	}

	/**
	 * Retrieves the node at inputed index.
	 * 
	 * @param index
	 *            - The node to be retrieved.
	 * @return The node at inputed index.
	 * @throws IndexOutOfBoundsException
	 *             - If there is no node in the list with inputed index.
	 */
	private Node get(int index) {
		if (index >= getLength() || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp;
		}
	}

	/**
	 * Retrieves and returns the element that is previous than inputed element.
	 * 
	 * @param node
	 *            - The node in regard to is previous located.
	 * @return Previous node in regard to inputed node.
	 */
	private Node getPreviousNode(Node node) {
		Node temp = head;
		while (temp.getNext() != node) {
			temp = temp.getNext();
		}
		return temp;
	}

	/**
	 * Returns the length of the list.
	 * 
	 * @return Length of the list.
	 */
	public int getLength() {
		return getLength(head);
	}

	/**
	 * Returns the length of the list from the inputed node.
	 * 
	 * @param node
	 *            - Starting node.
	 * @return Length of the list.
	 */
	private int getLength(Node node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + getLength(node.next);
		}
	}

	/**
	 * Checks if the inputed elements is in the list.
	 * 
	 * @param b
	 *            - Element that is needed to be checked.
	 * @return True if there is element in the list, and false if not.
	 */
	public Boolean contains(Boolean b) {
		Node temp = head;
		if (temp.getValue().equals(b)) {
			return true;
		}
		while (temp.getNext() != null) {
			temp = temp.getNext();
			if (temp.getValue().equals(b)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the value of the list are alternating.
	 * 
	 * @return True if the value are alternating and false if not.
	 */
	public Boolean isAlternating() {
		Node temp = head;
		while (temp.getNext() != null) {
			if (temp.getValue().equals(temp.getNext().getValue())) {
				return false;
			} else {
				temp = temp.getNext();
			}
		}
		return true;
	}

	/**
	 * Prints the elements in the list.
	 */
	public String toString() {
		if (head == null) {
			return "The list is empty.";
		}
		return head.toString();
	}

	/**
	 * Inner class.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class Node {

		/*
		 * Declaring node.
		 */
		private Boolean value;
		private Node next;

		/**
		 * Constructor.
		 * 
		 * @param value
		 */
		public Node(Boolean value) {
			this.value = value;
		}

		/**
		 * Prints the node.
		 */
		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " " + next.toString();
		}

		/*
		 * Get and set metods.
		 */
		public Boolean getValue() {
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
