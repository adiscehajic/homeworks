package ba.bitcamp.homeworkOOP.task02;

import ba.bitcamp.homeworkOOP.task01.Computer;

public abstract class Network {

	/*
	 * Declaring properties of network
	 */
	private String name;
	private Computer[] computers;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of network.
	 */
	public Network(String name) {
		this.name = name;
		this.computers = new Computer[0];
	}

	public abstract void addComputer(Computer pc);

	public abstract void removeComputer(Computer pc);

	/*
	 * Get and set methods
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Computer[] getComputers() {
		return computers;
	}

	public void setComputers(Computer[] computers) {
		this.computers = computers;
	}

}
