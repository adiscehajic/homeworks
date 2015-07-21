package ba.bitcamp.homework27.queues.task02;

public class QueueDoubleLink {

	private Node start;
	private Node finish;

	public QueueDoubleLink() {
		this.start = null;
		this.finish = null;
	}

	/**
	 * Inserts the specified element into this queue if it is possible to do so
	 * immediately without violating capacity restrictions.
	 * 
	 * @param value
	 *            The element to add.
	 * @return True if the element was added to this queue, else false.
	 */
	public boolean add(Double value) {
		Node temp = new Node(value);
		if (start == null) {
			start = temp;
			finish = temp;
		} else if (start == finish) {
			temp.setPrevious(start);
			finish = temp;
			start.setNext(finish);
		} else {
			finish.setNext(temp);
			temp.setPrevious(finish);
			finish = temp;
		}
		return true;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return The head of this queue, or null if this queue is empty.
	 */
	public Double peek() {
		if (start == null) {
			return null;
		} else {
			return start.getValue();
		}
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * 
	 * @return The head of this queue, or null if this queue is empty.
	 */
	public Double poll() {
		Double temp = 0.0;
		if (peek() != null) {
			temp = start.getValue();
			start = start.getNext();
			return temp;
		}
		return null;
	}

	/**
	 * Prints the list.
	 */
	public String toString() {
		if (start == null) {
			return "List is empty.";
		}
		return start.toString();
	}

	private class Node {
		private Double value;
		private Node next;
		private Node previous;

		public Node(Double value) {
			this.value = value;
		}

		public String toString() {
			if (next == null) {
				return value + "";
			}
			return value + " " + next.toString();
		}

		public Double getValue() {
			return value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

	}

}
