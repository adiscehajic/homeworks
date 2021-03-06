package ba.bitcamp.homeworkOOP.task09;

import ba.bitcamp.homeworkOOP.task01.Computer;
import ba.bitcamp.homeworkOOP.task02.Network;
import ba.bitcamp.homeworkOOP.task03.Server;
import ba.bitcamp.homeworkOOP.task04.Client;
import ba.bitcamp.homeworkOOP.task06.Functionable;
import ba.bitcamp.homeworkOOP.task07.ArrayManipulation;

public class StarNetwork extends Network implements Functionable {

	/*
	 * Creating properties of star-network
	 */
	private Server server;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of network.
	 * @param server
	 *            - Server of the network.
	 */
	public StarNetwork(String name, Server server) {
		super(name);
		this.server = server;
	}

	/**
	 * Prints information about network.
	 */
	public String toString() {
		return String.format(
				"Number of computers: %d\nIs network functional? %b\n",
				getComputers().length, isFunctioning());
	}

	/**
	 * Add computer in the computer array network.
	 * 
	 * @param pc
	 *            - Computer that user want to add.
	 */
	public void addComputer(Computer pc) {

		Client c = (Client) pc;

		// Creating the new array that is equal to array of network computers
		// increased for one.
		Computer[] added = ArrayManipulation.extendArray(getComputers());

		// Adding new computer on the last position in the array.
		added[added.length - 1] = c;

		// Connecting the new computer to the server.
		c.connect(this.server);

		setComputers(added);

	}

	/**
	 * Remove computer from the computer array network.
	 * 
	 * @param pc
	 *            - Computer that user want to remove.
	 */
	public void removeComputer(Computer pc) {

		Client c = (Client) pc;

		int counter = 0;

		// Finding computer in the array and replacing him with value null and
		// calculating if there is not computer that user want to remove in the
		// array.
		for (int i = 0; i < getComputers().length; i++) {
			if (c.equals(getComputers()[i])) {
				c.disconnect();
				getComputers()[i] = null;
				counter++;
			}
		}

		// If there is no inputed computer in the array throwing exception.
		try {
			if (counter == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println("There is no such computer on network!");
		}

		Computer[] removed = null;

		// Finding which element is null and removing him from array.
		for (int i = 0; i < getComputers().length; i++) {
			if (getComputers()[i] == null) {
				removed = ArrayManipulation.shrinkArray(getComputers(), i);
			}
		}
		setComputers(removed);
	}

	/**
	 * Checks if the network is functional.
	 */
	public boolean isFunctioning() {

		int counter = 0;

		// Calculating how many computers are linked on the server.
		for (int i = 0; i < getComputers().length; i++) {
			Client c = (Client) getComputers()[i];
			if (c.getConnectedToComp() == this.server) {
				counter++;
			}
		}

		// If there is linked on server more computers more than it is allowed,
		// network is not functional.
		if (counter > server.getMaxComputers()) {
			return false;
		}
		return true;
	}

}
