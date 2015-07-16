package ba.bitcamp.homework27.stacks.task02;

public class MainStackLink {

	public static void main(String[] args) {
		
		StackStringLink stack = new StackStringLink();
		long timeLink = 0;
		
		System.out.println(stack.push("Bit"));
		System.out.println(stack.push("Camp"));
		
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			stack.push("Bit");
		}
		
		long end = System.currentTimeMillis();
		timeLink = end - start;
		System.out.printf("Time that is needed to input elements in the list is: %.2f [s]\n", (double)(timeLink) / 1000);
		
		System.out.println(stack.search("Camp"));

	}
}
