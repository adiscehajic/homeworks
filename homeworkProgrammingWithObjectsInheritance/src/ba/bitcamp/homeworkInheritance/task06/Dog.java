package ba.bitcamp.homeworkInheritance.task06;

public class Dog extends Pet {

	/*
	 * Declaring properties of dog
	 */
	private String strain;
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 * @param species
	 * @param strain
	 */
	public Dog(String name, int age, String species, String strain) {
		super(name, age, species);
		this.strain = strain;
	}
	
	/**
	 * Prints av av
	 */
	public String toString(){
		return "Av av";
	}

	/*
	 * Get and set method
	 */
	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}
	
}
