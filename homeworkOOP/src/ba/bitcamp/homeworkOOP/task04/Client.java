package ba.bitcamp.homeworkOOP.task04;

import ba.bitcamp.homeworkOOP.task01.Computer;
import ba.bitcamp.homeworkOOP.task02.Network;

public class Client extends Computer implements Connectable {

	/*
	 * Declaring properties of client
	 */
	private Computer connectedToComp;
	private Network connectedToNet;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param macAddress
	 */
	public Client(String name, char[] macAddress) {
		super(name, macAddress);
	}

	/**
	 * Prints information about client.
	 */
	public String toString() {
		return String.format("Client [connectedToComp=%s, connectedToNet=%s]",
				connectedToComp, connectedToNet);
	}

	/**
	 * Checks if the two clients are equal.
	 * 
	 * @param obj
	 * @return
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (connectedToComp == null) {
			if (other.connectedToComp != null)
				return false;
		} else if (!connectedToComp.equals(other.connectedToComp))
			return false;
		if (connectedToNet == null) {
			if (other.connectedToNet != null)
				return false;
		} else if (!connectedToNet.equals(other.connectedToNet))
			return false;
		return true;
	}

	/**
	 * Connects the client computer to inputed computer.
	 * 
	 * @param comp
	 */
	public void connect(Computer comp) {
		try {
			if (connectedToComp != null) {
				throw new IllegalArgumentException();
			} else {
				connectedToComp = comp;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Can't link client that is already linked!");
		}
	}

	/**
	 * Connects the client network to inputed network.
	 * 
	 * @param net
	 */
	public void connect(Network net) {
		try {
			if (connectedToNet != null) {
				throw new IllegalArgumentException();
			} else {
				connectedToNet = net;
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Can't link network that is already linked!");
		}

	}

	/**
	 * Disconnects the client computer and network.
	 */
	public void disconnect() {
		connectedToComp = null;
		connectedToNet = null;
	}

	/*
	 * Get methods
	 */
	public Computer getConnectedToComp() {
		return connectedToComp;
	}

	public Network getConnectedToNet() {
		return connectedToNet;
	}
}
