
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class WeeklyTaskManager implements WeeklyTaskManagerInterface  {
	
	// Attributes
	private LinkedHashMap<String, List<Task>> days;
	
	// Constructor
	public WeeklyTaskManager() {
		// Create HashMap object
		days = new LinkedHashMap<>();
		
		// HashMap Keys and Values
		// ArrayList to store an array of inputed values
		days.put("Monday", new ArrayList<>());
		days.put("Tuesday", new ArrayList<>());
		days.put("Wednesday", new ArrayList<>());
		days.put("Thursday", new ArrayList<>());
		days.put("Friday", new ArrayList<>());
		days.put("Saturday", new ArrayList<>());
		days.put("Sunday", new ArrayList<>());
		
	}
	
	// Method to retrieve day Tasks
	public List<Task> getDayTasks(String dayName) {
		
		if(days.containsKey(dayName)) {
			return days.get(dayName);
		}
		else {
			throw new IllegalArgumentException("Invalid day name" + dayName);
		}
	}
	
	// method to add task 
	public void addTaskToDay(String dayName, Task task) {
		if(days.containsKey(dayName)) { // checks if day is created in map
			days.get(dayName).add(task); // if true then method will add the task to the day
			
		}
		
		else {
			throw new IllegalArgumentException("Invalid day name" + dayName); // if false then  program throws an exception to exit gracefully
		}
		
	}
	
	// method to remove task
	public void removeTaskFromDay(String dayName, Task task) {
		if(days.containsKey(dayName)) { // checks if day is created in map
			days.get(dayName).remove(task); // if true method will remove task by day
		}
		else {
			throw new IllegalArgumentException("Invalid day name" + dayName);
		}
	}
	
	public void viewAllTasks() {
		// Iterate over each day in the map's key set
		for(String day : days.keySet()) {
			// Retrieve the list of tasks for the current day
			List<Task> tasks = days.get(day);
			 // Print the day name as a header
			System.out.println("Tasks for " + day + ":");
			
			// Check if the list of tasks for the day is empty
			if(tasks.isEmpty()) {
				System.out.println("No tasks for given day...");
				
			}
			//If there are tasks, iterate over each task in the list
			else { 
				for(Task task : tasks) {
					//Print the title of each task
					System.out.println(task.getTitle());
					
				}
			}
		}System.out.println(); // Add an extra line for readability after displaying all tasks
	}
	
	
}
