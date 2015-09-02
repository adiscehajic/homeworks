package ba.bitcamp.homework34.ORM;

public abstract class Model {

	protected String tableName;
	
	public abstract String findByPk(Integer id);

	public abstract String findByAtribute(String a1, String a2);

}
