package ba.bitcamp.homework28;

public class SortedIntList {

	/*
	 * Declaring list.
	 */
	private Node start;
	private int count;

	/**
	 * Constructor.
	 */
	public SortedIntList() {
		this.start = null;
		this.count = 0;
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
	 * Tests if this list is empty.
	 * 
	 * @return True if and only if this list contains no items; false otherwise.
	 */
	public boolean empty() {
		return start == null;
	}

	/**
	 * Returns the length of the list.
	 * 
	 * @return
	 */
	public int getLength() {
		return count;
	}

	/**
	 * Inserts the element into the list and sorts the list while inserting.
	 * 
	 * @param value
	 *            Element that is inserted.
	 */
	public void add(int value) {
		boolean isLarger = true;

		Node newNode = new Node(value);
		if (start == null) {
			start = newNode;
		} else if (start.getValue() > value) {
			newNode.setNext(start);
			start = newNode;
		} else {
			Node temp = start;
			while (temp.getNext() != null) {
				if (temp.getNext().getValue() >= value) {
					temp = temp.getNext();
					isLarger = false;
					break;
				} else {
					temp = temp.getNext();
				}
			}
			if (!isLarger) {
				Node previous = getPrevious(temp);
				previous.setNext(newNode);
				newNode.setNext(temp);
			} else {
				temp.setNext(newNode);
			}
		}
		count++;
	}

	/**
	 * Returns the node that is previous from inputed.
	 * 
	 * @param node
	 * @return
	 */
	private Node getPrevious(Node node) {
		if (node == start) {
			return null;
		}

		Node temp = start;
		while (temp.getNext() != node) {
			temp = temp.getNext();
		}

		return temp;
	}

	/**
	 * Returns the node that is on inputed index.
	 * 
	 * @param index
	 *            - Index of the searched node.
	 * @return Node that is on inputed index.
	 */
	public int get(int index) {
		if (start == null) {
			return -1;
		} else {
			Node temp = start;

			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			return temp.getValue();
		}
	}

	/**
	 * Converts the list into the array.
	 * 
	 * @return
	 */
	public int[] toArray() {
		int[] array = new int[count];
		for (int i = 0; i < array.length; i++) {
			array[i] = this.get(i);
		}
		return array;
	}

	/**
	 * Inner class.
	 * 
	 * @author adis.cehajic
	 *
	 */
	private class Node {
		private int value;
		private Node next;

		/**
		 * Constructor.
		 * 
		 * @param value
		 */
		public Node(int value) {
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
		public int getValue() {
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
