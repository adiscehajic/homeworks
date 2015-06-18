package ba.bitcamp.homeworkClassesPractice;

/*
 * The locomotive is represented by platform, two wheels, cabin, two windows and a chimney.
 */
public class Locomotive {

	/*
	 * Declaring properties of locomotive
	 */
	private Rectangle platform;
	private Circle wheels;
	private Square cabin;
	private Circle windows;
	private Rectangle chimney;

	/**
	 * Constructor
	 * 
	 * @param platform
	 *            - The Platform of the locomotive.
	 * @param wheels
	 *            - The wheels of the locomotive.
	 * @param cabin
	 *            - The cabin of the locomotive.
	 * @param windows
	 *            - The Windows of the locomotive.
	 * @param chimney
	 *            - The chimney of the locomotive.
	 */
	public Locomotive(Rectangle platform, Circle wheels, Square cabin,
			Circle windows, Rectangle chimney) {
		this.platform = platform;
		this.wheels = wheels;
		this.cabin = cabin;
		this.windows = windows;
		this.chimney = chimney;
	}

	/**
	 * Calculating the area of the locomotive.
	 * <p>
	 * The area is calculated by adding up the areas of all locomotive parts
	 * except the windows, which must be subtracted.
	 * 
	 * @return The area of the locomotive.
	 */
	public double getArea() {
		double area = 0;
		try {
			// Checking if the inputed value of square side and the areas of
			// rectangle and circle are higher than zero and calculating area,
			// if not throwing exception
			if (platform.getArea() > 0 && wheels.getArea() > 0
					&& cabin.getSideA() > 0 && chimney.getArea() > 0
					&& windows.getArea() > 0) {

				area = platform.getArea() + 2 * wheels.getArea()
						+ cabin.getArea() + chimney.getArea() - 2
						* windows.getArea();
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("");
		}
		return area;
	}

	/**
	 * Calculating the perimeter of the locomotive. Perimeter represents the sum
	 * of all lines of the locomotive.
	 * <p>
	 * The perimeter is calculated by adding up the perimeters of all locomotive
	 * parts.
	 * 
	 * @return The perimeter of the locomotive.
	 */
	public double getPerimeter() {

		double perimeter = 0;
		try {
			// Checking if the inputed value of rectangle and square sides and
			// the perimeter of circle are higher than zero and calculating
			// perimeter, if not throwing exception
			if ((platform.getSideA() > 0 && platform.getSideB() > 0)
					&& wheels.getPerimeter() > 0 && cabin.getSideA() > 0
					&& (chimney.getSideA() > 0 && chimney.getSideB() > 0)
					&& windows.getPerimeter() > 0) {

				perimeter = platform.getPerimeter() + 2 * wheels.getPerimeter()
						+ cabin.getPerimeter() + chimney.getPerimeter() + 2
						* windows.getPerimeter();
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("");
		}

		return perimeter;
	}

}
