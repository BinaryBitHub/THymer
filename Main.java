//Author: BinaryBithub
//Purpose: To help manage and schedule time.
//Name: THymer


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // instantiate GUI
        GUI gui = new GUI();
        gui.createGUI();

        // instantiate WeeklyTaskManager 
        WeeklyTaskManager weeklyTaskManager = new WeeklyTaskManager();

        // Menu 
        boolean runMenu = true;
        Scanner userInput = new Scanner(System.in);

        while (runMenu) {
            // Display menu options
            System.out.println("Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Exit");
            System.out.print("Selected: ");
            String day;
            // Get user's choice
            if (userInput.hasNextInt()) {
                int selected = userInput.nextInt();
                userInput.nextLine(); // Consume newline 

                switch (selected) {
                    case 1:
                        // Add task
                    	do
                    	{
                        System.out.println("Enter day of the week to add task to (e.g. 'Monday', 'Tuesday', 'Friday'): ");
                        day = userInput.nextLine();
                        
                    	}
                    	// To make sure input of day name is valid
                    	while(!day.equals("Monday") && !day.equals("Tuesday")  && !day.equals("Wednesday")  && !day.equals("Thursday") && !day.equals("Friday")&& !day.equals("Saturday")&& !day.equals("Sunday"));
                    	
                    	// User Input
                        System.out.println("Enter title of the task: "); // Enter Title
                        String title = userInput.nextLine();
                    	
                        System.out.println("Enter description of the task: "); // Enter Description
                        String description = userInput.nextLine();
                        
                        // To start out and run while loop
                        LocalDate dueDate = null;
                        boolean validDate = false;
                        
                        // yyyy-mm-dd date validation 
                        while(!validDate) {
                        System.out.println("Enter due date (yyyy-mm-dd): "); // Enter date (must be in given order due to Local Date requirements)
                        String dateInput = userInput.nextLine();
                        try {
                        	dueDate = LocalDate.parse(dateInput);
                        	validDate = true; // if true the loop exits succesfully
                        }
                        
                        catch(DateTimeParseException e){
                        	System.out.println("Invalid date format. Please enter the date in yyyy-mm-dd format."); // if input is inavalid it will rerun ensuring program doesnt crash
                        }
                        
                        }
                        List<String> steps = new ArrayList<>();
                        Task newTask = new Task(title, description, dueDate, steps); 
                        
                        // Try catch block to ensure proper handling of invalid input or exceptions
                        try {
                        	
                        	// Call the WeeklyTaskManager method to add a new task to the specified day
                            weeklyTaskManager.addTaskToDay(day, newTask);
                            System.out.println("Task added successfully!");
                            gui.updateTasks(weeklyTaskManager); // update gui after adding a task
                        } catch (IllegalArgumentException e) {
                        	// If an exception occurs (e.g. invalid day name) print an error message
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2:
                        // Remove task
                        System.out.println("Enter day of the week to remove task from: ");
                        String dayOfTask = userInput.nextLine();// Read user input for the day

                        System.out.println("Enter task title to remove: ");
                        String taskTitleToRemove = userInput.nextLine(); // Read user input for the task title to remove
                        
                     // Retrieve the list of tasks for the specified day
                        List<Task> tasks = weeklyTaskManager.getDayTasks(dayOfTask);
                     // Initialize a variable to store the task to be removed
                        Task taskToRemove = null;

                        for (Task forTask : tasks) {
                            if (forTask.getTitle().equalsIgnoreCase(taskTitleToRemove)) {
                                taskToRemove = forTask; // Store the matching task
                                break;// Exit the loop once the task is found
                            }
                        }
                        
                     // Check if the task to be removed was found
                        if (taskToRemove != null) {
                        	// Remove the task from the WeeklyTaskManager
                            weeklyTaskManager.removeTaskFromDay(dayOfTask, taskToRemove);
                            gui.updateTasks(weeklyTaskManager); // update gui after adding a task
                            System.out.println("Task removed successfully!");
                        } else {
                            System.out.println("Task does not exist.");
                        }
                        break;

                    case 3:
                        // View all tasks
                        weeklyTaskManager.viewAllTasks();
                        break;

                    case 4:
                        // Exit loop
                    	gui.close();
                        runMenu = false;
                        
                        System.out.println("Program exited.");
                        
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                userInput.next(); // Consume the invalid input
            }
        }

        userInput.close();
    }
}
/*	OUTPUT
 * -----------------------------------------------------
 * Menu:
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit
Selected: 1
Enter day of the week to add task to (e.g. 'Monday', 'Tuesday', 'Friday'): 
Monday
Enter title of the task: 
Test
Enter description of the task: 
test
Enter due date (yyyy-mm-dd): 
1111-11-11
Task added successfully!
Menu:
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit
Selected: 1
Enter day of the week to add task to (e.g. 'Monday', 'Tuesday', 'Friday'): 
Wrong day test
Enter day of the week to add task to (e.g. 'Monday', 'Tuesday', 'Friday'): 
Monday
Enter title of the task: 
222
Enter description of the task: 
111
Enter due date (yyyy-mm-dd): 
1111-11-11
Task added successfully!
Menu:
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit
Selected: 1
Enter day of the week to add task to (e.g. 'Monday', 'Tuesday', 'Friday'): 
Thursday
Enter title of the task: 
Code
Enter description of the task: 
code
Enter due date (yyyy-mm-dd): 
June 11 2026
Invalid date format. Please enter the date in yyyy-mm-dd format.
Enter due date (yyyy-mm-dd): 
1111-11-11
Task added successfully!
Menu:
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit
Selected: 2
Enter day of the week to remove task from: 
Monday
Enter task title to remove: 
Test
Task removed successfully!
Menu:
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit
Selected: 3
Tasks for Monday:
222
Tasks for Tuesday:
No tasks for given day...
Tasks for Wednesday:
No tasks for given day...
Tasks for Thursday:
Code
Tasks for Friday:
No tasks for given day...
Tasks for Saturday:
No tasks for given day...
Tasks for Sunday:
No tasks for given day...

Menu:
1. Add Task
2. Remove Task
3. View All Tasks
4. Exit
Selected: 4
Program exited.
 * 
 * Note GUI output not given in text must run program for GUI.
 * 
 * 
 */
