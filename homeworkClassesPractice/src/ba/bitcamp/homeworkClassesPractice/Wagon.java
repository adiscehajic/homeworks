package ba.bitcamp.homeworkClassesPractice;

/*
 * The wagon is represented by platform and two wheels.
 */
public class Wagon {

	/*
	 * Declaring properties of wagon
	 */
	private Rectangle platform;
	private Circle wheels;

	/**
	 * Constructor
	 * 
	 * @param platform
	 *            - The platform of the wagon.
	 * @param wheels
	 *            - The wheels of the wagon.
	 */
	public Wagon(Rectangle platform, Circle wheels) {
		this.platform = platform;
		this.wheels = wheels;
	}

	/**
	 * Calculating the area of the wagon.
	 * <p>
	 * The area is calculated by adding up the areas of all wagon parts.
	 * 
	 * @return The area of the wagon.
	 */
	public double getArea() {
		double area = 0;
		try {
			// Checking if the values of rectangle and circle areas are higher
			// than zero and calculating area, if not throwing exception
			if (platform.getArea() > 0 && wheels.getArea() > 0) {
				area = platform.getArea() + 2 * wheels.getArea();
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("");
		}
		return area;
	}

	/**
	 * Calculates the parimeter of the wagon. Perimeter represents the sum of
	 * all lines of the wagon.
	 * <p>
	 * The perimeter is calculated by adding up the perimeters of all wagon
	 * parts.
	 * 
	 * @return The perimeter of the wagon.
	 */
	public double getPerimeter() {
		double perimeter = 0;
		try {
			// Checking if the inputed value of rectangle sides and
			// the perimeter of circle are higher than zero and calculating
			// perimeter, if not throwing exception
			if ((platform.getSideA() > 0 && platform.getSideB() > 0)
					&& wheels.getPerimeter() > 0) {
				perimeter = platform.getPerimeter() + 2 * wheels.getPerimeter();
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("");
		}

		return perimeter;
	}
}
