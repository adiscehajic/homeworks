package ba.bitcamp.homework27.queues.task02;

public class MainQueueLink {

	public static void main(String[] args) {
		
		QueueDoubleLink list = new QueueDoubleLink();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list.add(12.3);
		}

		long end = System.currentTimeMillis();
		
		System.out.printf("Time that is needed to input elements in the list is: %.2f [s]\n", (double)(end - start) / 1000);
				
		System.out.println(list.peek());
		
		System.out.println(list.poll());

	}
}
