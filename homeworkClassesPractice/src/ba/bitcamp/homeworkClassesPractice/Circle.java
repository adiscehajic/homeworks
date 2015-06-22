package ba.bitcamp.homeworkClassesPractice;

public class Circle {

	/*
	 * Declaring properties of the circle.
	 */
	private double radius;

	/**
	 * Constructor
	 * 
	 * @param radius
	 *            - The circle radius.
	 */
	public Circle(double radius) {
		try {
			// Checking if the inputed value of circle radius is higher than
			// zero, if not throwing exception
			if (radius > 0) {
				this.radius = radius;
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out
					.println("You have inputed negative value or zero for circle radius! Please input value higher that 0!\n");
		}

	}

	/**
	 * Prints information about circle.
	 */
	public String toString() {
		return String.format("Radius of circle is: %f\n", radius);
	}

	/**
	 * Calculates the area of the circle.
	 * 
	 * @return - The area of the circle.
	 */
	public double getArea() {
		return Math.pow(radius, 2) * Math.PI;
	}

	/**
	 * Calculates the perimeter of the circle. Perimeter represents the line of
	 * the circle.
	 * 
	 * @return The perimeter of the circle.
	 */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

}
