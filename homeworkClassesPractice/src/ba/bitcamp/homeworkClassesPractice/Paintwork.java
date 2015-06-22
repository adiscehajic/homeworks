package ba.bitcamp.homeworkClassesPractice;

public class Paintwork {

	public static void main(String[] args) {

		// Declaring the amount of paint needed for one meter and one square
		// meter
		double paintPerMeter = 0.05;
		double paintPerSquareMeter = 0.25;

		// Creating parts of the train
		Rectangle platform = new Rectangle(10, 4);
		Circle wheel = new Circle(1.5);
		Square cabine = new Square(4);
		Circle window = new Circle(0.5);
		Rectangle chimney = new Rectangle(0.5, 1);

		// Creating locomotive
		Locomotive locomotiveOne = new Locomotive(platform, wheel, cabine,
				window, chimney);

		// Creating wagons
		Wagon wagonOne = new Wagon(platform, wheel);
		Wagon wagonTwo = new Wagon(platform, wheel);

		// Creating an array of wagons
		Wagon[] wagons = { wagonOne, wagonTwo, wagonOne };

		// Creating the train
		Train trainOne = new Train(locomotiveOne, wagons);

		// Printing the information about amount of needed paint
		System.out.println("Paint needed for painting train lines is: "
				+ getPaintPerMeter(paintPerMeter, trainOne.getPerimeter()));
		System.out.println("Paint needed for painting train area is: "
				+ getPaintPerSquareMeter(paintPerSquareMeter,
						trainOne.getArea()));

	}

	/**
	 * Calculates how much paint is needed to paint one meter.
	 * 
	 * @param paintPerMeter
	 *            - Amount of paint needed to paint one meter.
	 * @param amountPerMeter
	 *            - Amount of meters that need to be painted.
	 * @return Amount of paint needed to paint inputed amount of meter.
	 */
	public static double getPaintPerMeter(double paintPerMeter,
			double amountPerMeter) {

		return paintPerMeter * amountPerMeter;

	}

	/**
	 * Calculates how much paint is needed to paint one square meter.
	 * 
	 * @param paintPerSquareMeter
	 *            - Amount of paint needed to paint one square meter.
	 * @param amountPerMeter
	 *            - Amount of square meters that need to be painted.
	 * @return Amount of paint needed to paint inputed amount of square meter.
	 */
	public static double getPaintPerSquareMeter(double paintPerSquareMeter,
			double amountPerMeter) {

		return paintPerSquareMeter * amountPerMeter;

	}

}
