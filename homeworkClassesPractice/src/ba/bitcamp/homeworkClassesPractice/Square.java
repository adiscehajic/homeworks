package ba.bitcamp.homeworkClassesPractice;

public class Square {

	/*
	 * Declaring properties of square.
	 */
	private double sideA;

	/**
	 * Constructor
	 * 
	 * @param sideA
	 *            - Side of the square.
	 */
	public Square(double sideA) {
		try {
			// Checking if the inputed value of square side is higher than
			// zero, if not throwing exception
			if (sideA > 0) {
				this.sideA = sideA;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out
					.println("You have inputed negative value or zero for a side of square! Please input value higher that 0!\n");
		}
	}

	/**
	 * Prints information about circle.
	 */
	public String toString() {
		return String.format("Side A is: %f\nArea is: %f\nPerimeter is: %f\n",
				sideA, getArea(), getPerimeter());
	}

	/**
	 * Calculates the area of the square.
	 * 
	 * @return - The area of the square.
	 */
	public double getArea() {
		return Math.pow(sideA, 2);
	}

	/**
	 * Calculates the perimeter of the square. Perimeter represents the sum of
	 * all lines of the square.
	 * 
	 * @return The perimeter of the square.
	 */
	public double getPerimeter() {
		return 4 * sideA;
	}

	/*
	 * Get method
	 */
	public double getSideA() {
		return sideA;
	}

}
