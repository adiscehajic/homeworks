package ba.bitcamp.homeworkWeekend10.task03;

/**
 * Represents product that has unique code, name and price.
 * 
 * @author Adis Cehajic
 *
 */
public class Product {

	// Declaring properties of product.
	private Integer code;
	private String name;
	private Double price;

	/*
	 * Constructor.
	 */
	public Product(Integer code, String name, Double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	/**
	 * Prints the product information.
	 */
	public String toString() {
		return String.format("(%d) %s - %.2f KM", code, name, price);
	}

	/*
	 * Get and set methods.
	 */
	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
