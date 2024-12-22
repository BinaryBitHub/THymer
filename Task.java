import java.time.LocalDate;
import java.util.List;

public class Task {
	
	// Class Attributes
	private String Title; // Title of the task
	private String Description; // Description of the task
	private LocalDate dueDate ; // Date task is due 
	private List<String> steps; // A list of steps to breakdown the task and add to the week / day
	
	// Constructor 
	
	public Task(String title, String description, LocalDate dueDate, List<String> steps) {
		this.Title = title;
		this.Description = description;
		this.dueDate = dueDate;
		this.steps = steps;
		
	}
	
	// Getters for Attributes
	
	public String getTitle()
	{
		return Title;
	}
	
	public String getDescription() 
	{
		return Description;
	}
	
	public LocalDate getdueDate() 
	{
		return dueDate;
	}
	
	public List<String> getSteps() 
	{
		return steps;
	}
	
	// method to add a step to the list
	public void addStep(String step) {
		if(step == null || step.isEmpty()) { // Checks to make sure step exists (does not = null or is not empty).
			throw new IllegalArgumentException("Step can not be empty!"); // Throws exception if true
		}
		steps.add(step); // adds step to steps list
	}
	
	// method to remove a step in the list
	public void removeStep(int index) {
		if(index < 0 || index >= steps.size()) { // checks to see if index is out of bounds 
			throw new IllegalArgumentException("Cannot find step index to remove!"); // Throws exception if true
		}
		steps.remove(index); // Removes step by index 
	}
	
	//Method to Update a step
	public void updateStep(int index, String newStep) {
		if(index < 0 || index >= steps.size()) { // checks to see if index is out of bounds 
			throw new IllegalArgumentException("Cannot find step index to update!"); // Throws exception if true
		}
		if(newStep == null || newStep.isEmpty()) {
			throw new IllegalArgumentException("Step can not be empty!"); // Throws exception if true
		}
		steps.set(index, newStep); // Updates step
	}
	
	 @Override
	public String toString() {
		 return "Task{" + "title='" + Title + '\'' + ", description='" + Description + '\'' + ", dueDate=" + dueDate + ", steps=" + steps + '}';
	        
	    }
}
