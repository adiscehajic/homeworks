package ba.bitcamp.homework26;

public class LinkedListDouble {

	/*
	 * Declaring variables of the list.
	 */
	private Node start;
	private int count;

	/**
	 * Constructor.
	 */
	public LinkedListDouble() {
		this.start = null;
		this.count = 0;
	}

	/**
	 * Constructor that receives the LinkedListDouble object and copies all
	 * elements in new list.
	 * 
	 * @param list
	 */
	public LinkedListDouble(LinkedListDouble list) {
		Node temp = list.start;
		while (temp.getNext() != null) {
			add(temp.getValue());
			temp = temp.getNext();
		}
		add(temp.getValue());
	}

	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return Number of elements in the list.
	 */
	public int size() {
		return count;
	}

	/**
	 * Inserts the specified element into list and increases number of elements
	 * in the list.
	 * 
	 * @param value
	 *            - The element to add.
	 */
	public void add(Double value) {
		if (start == null) {
			start = new Node(value);
		} else {
			Node temp = getLastNode();
			temp.setNext(new Node(value));
		}
		count++;
	}

	/**
	 * Retrieves the last element in the list.
	 * 
	 * @return Last element in the list.
	 */
	private Node getLastNode() {
		Node temp = start;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Removes element from the list at inputed index and lowers number of
	 * elements in the list.
	 * 
	 * @param index
	 *            - Index of element to remove.
	 * @throws IndexOutOfBoundsException
	 *             - If there is no element in the list with inputed index.
	 */
	public void remove(int index) throws IndexOutOfBoundsException {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			start = start.getNext();
			count--;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			Node previous = getPreviousNode(temp);
			previous.setNext(temp.getNext());
			count--;
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

		Node temp = start;

		while (temp.getNext() != node) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Retrieves the element at inputed index.
	 * 
	 * @param index
	 *            - The element to be retrieved.
	 * @return The element at inputed index.
	 * @throws IndexOutOfBoundsException
	 *             - If there is no element in the list with inputed index.
	 */
	public Double get(int index) throws IndexOutOfBoundsException {
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			return temp.getValue();
		}
	}

	/**
	 * Returns the element that is in the middle of the list and if there is no
	 * middle then returns left member of the middle.
	 * 
	 * @return The element that is in the middle of the list.
	 */
	public Double middle() {
		Node last = start.getNext();
		Node middle = start;

		while (last.getNext() != null) {
			if (last.getNext().getNext() != null) {
				middle = middle.getNext();
				last = last.getNext().getNext();
			} else {
				middle = middle.getNext();
				last = last.getNext();
			}
		}
		return middle.getValue();
	}

	/**
	 * Retrieves the first element in the list.
	 * 
	 * @return First element in the list.
	 */
	public Double getFirst() {
		if (start == null) {
			return null;
		} else {
			return start.getValue();
		}
	}

	/**
	 * Retrieves the last element in the list.
	 * 
	 * @return Last element in the list.
	 */
	public Double getLast() {
		return getLastNode().getValue();
	}

	/**
	 * Deletes the first element in the list.
	 */
	public void deleteFirst() {
		remove(0);
	}

	/**
	 * Deletes the last element in the list.
	 */
	public void deleteLast() {
		remove(count - 1);
	}

	/**
	 * Inserts the element in the list on inputed index.
	 * 
	 * @param value
	 *            - The element to add.
	 * @param index
	 *            - The index on which element needs to be added.
	 * @throws IndexOutOfBoundsException
	 *             - If there is no element in the list with inputed index.
	 */
	public void add(Double value, int index) throws IndexOutOfBoundsException {
		Node newNode = new Node(value);
		if (index >= count || index < 0) {
			throw new IndexOutOfBoundsException();
		} else if (index == 0) {
			newNode.setNext(start);
			start = newNode;
			count++;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}

			Node previous = getPreviousNode(temp);
			previous.setNext(newNode);
			newNode.setNext(temp);
			count++;
		}
	}

	/**
	 * Prints the list.
	 */
	public String toString() {
		if (start == null) {
			return "The list is empty.";
		}
		return start.toString();
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
		private Double value;
		private Node next;

		/**
		 * Constructor.
		 * 
		 * @param value
		 */
		public Node(Double value) {
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
		public Double getValue() {
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
