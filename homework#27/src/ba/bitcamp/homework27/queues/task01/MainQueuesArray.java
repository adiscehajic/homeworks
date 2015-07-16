package ba.bitcamp.homework27.queues.task01;

public class MainQueuesArray {

	public static void main(String[] args) {
		
		QueueDoubleArray queue = new QueueDoubleArray();
		
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			queue.add(12.3);
		}

		long end = System.currentTimeMillis();
		
		System.out
				.printf("Time that is needed to input elements in the array is: %.2f [s]",
						(double) (end - start) / 1000);
		
		
	}
}
