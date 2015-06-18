package ba.bitcamp.homeworkClassesPractice;

public class Rectangle {

	/*
	 * Declaring properties of rectangle
	 */
	private double sideA;
	private double sideB;

	/**
	 * Constructor
	 * 
	 * @param sideA
	 *            - First side of rectangle
	 * @param sideB
	 *            - Second side of rectangle
	 */
	public Rectangle(double sideA, double sideB) {
		try {
			// Checking if the inputed value of rectangle sides are higher than
			// zero, if not throwing exception
			if (sideA > 0 && sideB > 0) {
				this.sideA = sideA;
				this.sideB = sideB;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out
					.println("You have inputed negative value or zero for a sides of rectangle! Please input value higher that 0!\n");
		}
	}

	/**
	 * Prints information about rectangle.
	 */
	public String toString() {
		return String
				.format("Side A is: %f\nSide B is: %f\nArea is: %f\nPerimeter is: %f\n",
						sideA, sideB, getArea(), getPerimeter());
	}

	/**
	 * Calculates the area of the rectangle.
	 * 
	 * @return - The area of the rectangle.
	 */
	public double getArea() {
		return sideA * sideB;
	}

	/**
	 * Calculates the perimeter of the rectangle. Perimeter represents the sum
	 * of all lines of the rectangle.
	 * 
	 * @return The perimeter of the rectangle.
	 */
	public double getPerimeter() {
		return 2 * (sideA + sideB);
	}

	/*
	 * Get methods
	 */
	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

}
