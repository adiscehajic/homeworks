package ba.bitcamp.homeworkWeekend6.task05;

public class Task05 {

	public static void main(String[] args) {
		System.out.println(getPower(2, 5));
		System.out.println(getPower(-2, 4));
		System.out.println(getPower(-2, -2));
	}

	/**
	 * Calculates number exponent.
	 * 
	 * @param number
	 *            - Number which exponent user want to calculate.
	 * @param exponent
	 *            - Exponent on which user want to calculate number.
	 * @return Value of number on given exponent.
	 */
	public static double getPower(double number, double exponent) {
		if (exponent > 0) {
			if (exponent == 1) {
				return number;
			}
			return number * getPower(number, exponent - 1);
		} else if (exponent < 0) {
			if (exponent == -1) {
				return 1 / number;
			}
			return (1 / number * getPower(number, exponent + 1));
		} else {
			return 1;
		}
	}
}
