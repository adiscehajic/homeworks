package ba.bitcamp.homeworkWeekend5.task01;

/**
 * Describes an element in the plot of a story.
 * 
 * @author Adis Cehajic
 *
 */
public abstract class StoryElement {

	private String name;
	
	public StoryElement(String name){
		this.name = name;
	}
	
	public StoryElement(){
		this("STElement");		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return String.format("Name: %s\n", name);
	}
}
