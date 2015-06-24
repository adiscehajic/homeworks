package ba.bitcamp.homeworkOOP.task03;

import ba.bitcamp.homeworkOOP.task01.Computer;

public class Server extends Computer {

	private int maxComputers;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of the server.
	 * @param mac
	 *            - MAC address of the server.
	 * @param maxComputers
	 *            - Max number of computers on the server.
	 */
	public Server(String name, char[] mac, int maxComputers) {
		super(name, mac);
		this.maxComputers = maxComputers;
	}

	/**
	 * Prints information about server.
	 */
	public String toString() {
		String s = super.toString();
		s += "Max num of computers: " + maxComputers + "\n";
		return s;
	}

	/*
	 * Get method
	 */
	public int getMaxComputers() {
		return maxComputers;
	}

	/**
	 * Checks if the two servers are equal.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		if (maxComputers != other.maxComputers)
			return false;
		return true;
	}

}
