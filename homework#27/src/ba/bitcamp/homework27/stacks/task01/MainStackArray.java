package ba.bitcamp.homework27.stacks.task01;

public class MainStackArray {
	public static long timeArray = 0;

	public static void main(String[] args) {

		StackStringArray stack = new StackStringArray();

		System.out.println(stack.push("Bit"));

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			stack.push("Bit");
		}
		System.out.println(stack.push("Camp"));

		long end = System.currentTimeMillis();
		timeArray = end - start;

		System.out
				.printf("Time that is needed to input elements in the array is: %.2f [s]\n",
						(double) (timeArray) / 1000);

		System.out.println(stack.search("Camp"));

	}
}
