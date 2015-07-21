package ba.bitcamp.homework27.queues.task01;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueDoubleArray {

	private Double[] array;

	public QueueDoubleArray() {
		this.array = new Double[0];
	}

	public String toString() {
		return Arrays.toString(array);
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
		array = Arrays.copyOf(array, array.length + 1);
		array[array.length - 1] = value;
		return true;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null
	 * if this queue is empty.
	 * 
	 * @return The head of this queue, or null if this queue is empty.
	 */
	public Double peek() {
		if (array.length > 0) {
			return array[0];
		} else {
			return null;
		}
	}

	/**
	 * Retrieves and removes the head of this queue, or returns null if this
	 * queue is empty.
	 * 
	 * @return The head of this queue, or null if this queue is empty.
	 */
	public Double poll() {
		if (array.length > 0) {
			Double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;
		}
		return null;
	}

	/**
	 * Retrieves, but does not remove, the head of this queue. This method
	 * differs from peek only in that it throws an exception if this queue is
	 * empty.
	 * 
	 * @return The head of this queue.
	 * @throws NoSuchElementException
	 *             - If this queue is empty.
	 */
	public Double element() throws NoSuchElementException {
		if (array.length > 0) {
			return array[0];
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Retrieves and removes the head of this queue. This method differs from
	 * poll only in that it throws an exception if this queue is empty.
	 * 
	 * @return The head of this queue.
	 * @throws NoSuchElementException
	 *             - If this queue is empty.
	 */
	public Double remove() throws NoSuchElementException {
		if (array.length > 0) {
			Double temp = array[0];
			array = Arrays.copyOfRange(array, 1, array.length);
			return temp;
		}
		throw new NoSuchElementException();
	}
}
