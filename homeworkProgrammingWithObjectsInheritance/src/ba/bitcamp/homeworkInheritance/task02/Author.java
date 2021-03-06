package ba.bitcamp.homeworkInheritance.task02;

public class Author {

	/*
	 * Declaring properties of author.
	 */
	private String name;
	private String mail;
	private boolean isMale;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            - Name of the author.
	 * @param mail
	 *            - Mail of the author.
	 * @param isMale
	 *            - Is the author male or female.
	 */
	public Author(String name, String mail, boolean isMale) {
		super();
		this.name = name;
		this.mail = mail;
		this.isMale = isMale;
	}

	/**
	 * Printing information about author.
	 */
	public String toString() {
		return String.format("Name: %s\nMail: %s\nIs male: %b\n", name, mail,
				isMale);
	}

	/**
	 * Checks if the two authors are equal.
	 * 
	 * @param a
	 *            - Author with whom user compares first author.
	 * @return True if the author are aqual.
	 */
	public boolean equals(Author a) {
		return this.name.equals(a.name) && this.mail.equals(a.mail)
				&& this.isMale == a.isMale;
	}

	/*
	 * Get and set methods
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

}
