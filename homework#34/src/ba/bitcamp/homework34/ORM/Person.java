package ba.bitcamp.homework34.ORM;

public class Person extends Model {

	public String findByPk(Integer id) {
		return "SELECT * FROM " + tableName + " WHERE id = " + id + ";";
	}

	public String findByAtribute(String a1, String a2) {
		return "SELECT * FROM " + tableName + " WHERE " + a1 + " = " + a2 + ";";
	}

}
