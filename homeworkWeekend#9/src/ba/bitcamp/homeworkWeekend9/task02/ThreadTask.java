package ba.bitcamp.homeworkWeekend9.task02;

public class ThreadTask {

	public static void main(String[] args) {
		// Declaring threads.
		Thread t1 = new Thread(new MyThread("first"));
		Thread t2 = new Thread(new MyThread("second"));
		Thread t3 = new Thread(new MyThread("third"));
		// Starting first thread.
		t1.start();

		try {
			// Waiting first thread to finish.
			t1.join();
			// Starting second thread.
			t2.start();
			// Waiting second thread to finish.
			t2.join();
			// Starting third thread.
			t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inner class implements Runnable interface that has run method. It has constructor that receives string variable
	 * that can determine how will run method work.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private static class MyThread implements Runnable {

		// Declaring string variable.
		private String name;

		/**
		 * Constructor that receives string variable.
		 * 
		 * @param thread
		 *            - String variable.
		 */
		public MyThread(String name) {
			this.name = name;
		}

		/**
		 * Determines how will thread work.
		 */
		public void run() {
			// If the name of the thread is first it prints number after 200[ms] in the range from 1 to 10.
			if (name.equals("first")) {
				for (int i = 1; i <= 10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// If the name of the thread is second it prints after one second word "BitCamp" 4 times.
			} else if (name.equals("second")) {
				for (int i = 1; i <= 4; i++) {
					System.out.println("BitCamp");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// If the name of the thread is third it prints random number in the range from 1 to 5 after 700[ms].
			} else if (name.equals("third")) {
				for (int i = 1; i <= 5; i++) {
					System.out.println((int) (Math.random() * 4 + 1));
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}

	}
}
