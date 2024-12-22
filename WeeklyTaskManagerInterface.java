import java.util.List;

//Interface for managing weekly tasks
public interface WeeklyTaskManagerInterface {
	
	//Retrieves a list of tasks for a specific day
	List<Task> getDayTasks(String dayName);
	
	//Adds a task to a specific day
	void addTaskToDay(String dayName, Task task);
	
	// Removes Task from given day
	void removeTaskFromDay(String dayName, Task task);
	
	// Views all tasks currently in the system
	void viewAllTasks();
}
