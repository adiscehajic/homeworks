package ba.bitcamp.homeworkClassesPractice;

public class Train {

	/*
	 * Declaring properties of train.
	 */
	private Locomotive locomotive;
	private Wagon[] wagons;

	/**
	 * Constructor
	 * 
	 * @param locomotive
	 *            - The train locomotive.
	 * @param wagons
	 *            - The train wagons.
	 */
	public Train(Locomotive locomotive, Wagon[] wagons) {
		this.locomotive = locomotive;
		this.wagons = wagons;
	}

	/**
	 * Calculating the area of train.
	 * 
	 * @return The area of train.
	 */
	public double getArea() {

		double area = 0;

		try {
			if (locomotive.getArea() > 0) {
				// Adding the area of locomotive
				area = locomotive.getArea();

				// Adding the areas of all wagons
				for (int i = 0; i < wagons.length; i++) {
					area += wagons[i].getArea();
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("");
		}

		return area;
	}

	/**
	 * Calculating the perimeter of train.
	 * 
	 * @return The perimeter of train.
	 */
	public double getPerimeter() {

		double perimeter = 0;

		try {
			if (locomotive.getPerimeter() > 0) {
				// Adding the perimeter of locomotive
				perimeter = locomotive.getPerimeter();

				// Adding the perimeters of all wagons
				for (int i = 0; i < wagons.length; i++) {
					perimeter += wagons[i].getPerimeter();
				}
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.print("");
		}

		return perimeter;
	}

}
