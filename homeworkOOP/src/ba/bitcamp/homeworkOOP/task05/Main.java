package ba.bitcamp.homeworkOOP.task05;

import java.util.Arrays;

import ba.bitcamp.homeworkOOP.task01.Computer;
import ba.bitcamp.homeworkOOP.task03.Server;
import ba.bitcamp.homeworkOOP.task04.Client;
import ba.bitcamp.homeworkOOP.task08.BusNetwork;
import ba.bitcamp.homeworkOOP.task09.StarNetwork;

public class Main {

	public static void main(String[] args) {

		// Creating MAC addresses
		char[] macAddressOne = { '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C' };
		char[] macAddressTwo = { '2', 'B', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C' };
		char[] macAddressThree = { '2', 'B', '3', '4', '5', 'C', '7', '5', 'D',
				'A', 'B', 'C' };

		// Creating clients
		Client clientOne = new Client("Test", macAddressOne);
		Client clientTwo = new Client("Test2", macAddressTwo);
		Client clientThree = new Client("Test3", macAddressOne);

		// Creating server
		Server serverOne = new Server("Server one", macAddressThree, 2);

		// Printing created server
		System.out.println(serverOne);

		// Creating an array of computers that is needed for network.
		Computer[] computers = new Computer[2];
		computers[0] = clientOne;
		computers[1] = clientTwo;

		// Printing an array of computers. Shows that not one client is linked.
		System.out.println(Arrays.toString(computers));

		System.out.println();

		// Creating BusNetwork and linking clients
		BusNetwork bs = new BusNetwork("Bus Network");
		bs.addComputer(clientOne);
		bs.addComputer(clientTwo);
		bs.removeComputer(clientTwo);

		// Printing BusNetwork and seeing that network is not functional.
		System.out.println(bs);

		// Adding client on the network.
		bs.addComputer(clientTwo);

		// Printing BusNetwork and seeing that network is functional.
		System.out.println(bs);

		// Creating StarNetwork and linking clients
		StarNetwork sn = new StarNetwork("Star Network", serverOne);
		sn.addComputer(clientOne);
		sn.addComputer(clientTwo);

		// Printing StarNetwork and seeing that network is functional.
		System.out.println(sn);

		// Adding client
		sn.addComputer(clientThree);

		// Printing StarNetwork and seeing that network is not functional.
		System.out.println(sn);

		// Printing an array of computers. Shows that how clients are linked.
		System.out.println(Arrays.toString(computers));

	}

}
