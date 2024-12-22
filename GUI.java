import javax.swing.JFrame;    // For creating the main window (frame)
import javax.swing.JPanel;    // For creating the panel to hold components
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JLabel;    // For creating labels for the days of the week
import java.awt.GridLayout;   // For laying out components in a grid 
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Color;

public class GUI {
	// Global variables
	private JFrame frame;
	private HashMap<String, JTextArea> dayTextAreas;
	ImageIcon icon;
	// make frame
	public void createGUI() {
        // Create frame
        frame = new JFrame("Week");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 300);
        
        
        icon = new ImageIcon("assets/icons/ThymerPic.png"); // icon path
        frame.setIconImage(icon.getImage()); // for icon
        
        
        // Create panel with GridLayout (1 row, 7 columns)
       final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 7));
        frame.add(panel);
        
        dayTextAreas = new HashMap<>();
        // Add labels with borders to the panel
        for (String day : days) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            JTextArea textArea = new JTextArea(day + ":\n"); // add a text area
            textArea.setEditable(false); // non editable text area
            label.setVerticalAlignment(SwingConstants.TOP);
            label.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));  // Add a dark gray border around each label
            //panel.add(label);
            panel.add(textArea);
            dayTextAreas.put(day,textArea); // store reference to text area for each day
        }
        
        // Makes the frame visible
        frame.setVisible(true);
      
       
    }
	
    public void updateTasks(WeeklyTaskManager weeklyTaskManager) {
        for (String day : dayTextAreas.keySet()) {
            JTextArea textArea = dayTextAreas.get(day);
            List<Task> tasks = weeklyTaskManager.getDayTasks(day);

            // Clear previous content except for the day label
            textArea.setText(day + ":\n");

            // Append each task title to the text area
            for (Task task : tasks) {
                textArea.append("- " + task.getTitle() + "\n");
                textArea.append("Description: " + task.getDescription() + "\n" );
                textArea.append("Due Date: " + task.getdueDate() + "\n");
                textArea.append("\n");
            }
        }
    }
	
	
	public void close() {
		if(frame != null) {
			frame.dispose();
			//System.out.println("Test"); This line used for debugging to make sure close method was being called properly
			
		}
	}
}
