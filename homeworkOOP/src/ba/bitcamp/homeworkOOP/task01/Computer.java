package ba.bitcamp.homeworkOOP.task01;

public abstract class Computer {

	/*
	 * Declaration of properties of computer.
	 */
	private String name;
	private MACAddress macAddress;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            - Name of the computer.
	 * @param mac
	 *            - MAC address of the computer.
	 */
	public Computer(String name, char[] macAddress) {
		super();
		this.name = name;
		this.macAddress = new MACAddress(macAddress);
	}

	public Computer() {
		this("", null);
	}

	/**
	 * Inner class MACAddress
	 * 
	 * @author adis.cehajic
	 *
	 */
	public class MACAddress {

		private char[] address = new char[12];

		public MACAddress(char[] address) {
			try {
				if (address.length == 12) {
					this.address = address;
				} else {
					throw new IndexOutOfBoundsException();
				}
			} catch (IndexOutOfBoundsException e) {
				System.out
						.println("You have'nt inputed right format of MAC address!");
			}
		}

		/**
		 * Prints the MAC address.
		 */
		public String toString() {
			String s = "";
			// COnvertin an array of characters into a string and putting :
			// after each second character.
			for (int i = 0; i < address.length; i++) {
				if (i < address.length - 1 && i % 2 != 0) {
					s += address[i] + ":";
				} else {
					s += address[i];
				}
			}

			return s;
		}
	}

	/**
	 * Prints information about computer.
	 */
	public String toString() {
		return String.format("Name: %s\nMAC address: %s\n", name, macAddress);
	}

	/**
	 * Checks if the two computers are equal.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		if (macAddress == null) {
			if (other.macAddress != null)
				return false;
		} else if (!macAddress.equals(other.macAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * Get methods
	 */
	public String getName() {
		return name;
	}

	public MACAddress getMacAddress() {
		return macAddress;
	}

}
