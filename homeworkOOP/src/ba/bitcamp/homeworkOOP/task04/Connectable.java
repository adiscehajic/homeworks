package ba.bitcamp.homeworkOOP.task04;

import ba.bitcamp.homeworkOOP.task01.Computer;
import ba.bitcamp.homeworkOOP.task02.Network;

public interface Connectable {

	public void connect(Computer c);

	public void connect(Network n);

	public void disconnect();

}
