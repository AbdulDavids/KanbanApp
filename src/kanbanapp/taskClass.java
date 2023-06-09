package kanbanapp;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class taskClass {


    //task ArrayLists
    public ArrayList<String> names = new ArrayList<String>();
    public ArrayList<String> taskNumber = new ArrayList<String>();
    public ArrayList<String> description = new ArrayList<String>();
    public ArrayList<String> developer = new ArrayList<String>();
    public ArrayList<String> duration = new ArrayList<String>();
    public ArrayList<String> ID = new ArrayList<String>();
    public ArrayList<String> Status = new ArrayList<String>();


    // --------------------------------------------------------------------------------------------------------------------------//


    //prompts the user to fill task arrays using JPanel, takes an integer as an arguement for the number of tasks to be entered. Displays all tasks once complete
    public void addTasks(Integer NumberOfTasks) {

        for (int count = 0; count < NumberOfTasks;) {

            JPanel panel = new JPanel();
            JTextField[] fields = new JTextField[5];
            JLabel[] labels = new JLabel[5];
            String[] fieldNames = { "Task Name:", "Description:", "Developer", "Duration", "Status" };

            for (int i = 0; i < fields.length; i++) {
                labels[i] = new JLabel(fieldNames[i]);
                fields[i] = new JTextField(10);
                panel.add(labels[i]);
                panel.add(fields[i]);
            }

            int result = JOptionPane.showConfirmDialog(null, panel, "Enter Values",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                if (checkTaskDescription(fields[1].getText())) {

                    names.add(fields[0].getText());
                    description.add(fields[1].getText());
                    developer.add(fields[2].getText());
                    duration.add(fields[3].getText());
                    Status.add(fields[4].getText());
                    taskNumber.add(String.valueOf(count));

                    ID.add(createTaskID(fields[0].getText(), String.valueOf(count), fields[2].getText()));

                    count += 1;
                } else 
                
                {
                    JOptionPane.showConfirmDialog(null, panel,
                            "Please enter a description with less than 50 characters",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                }

            }

        }
        displayTasks();
    }




// --------------------------------------------------------------------------------------------------------------------------//




//Does what it says on the tin. Displays all tasks in the taskClass using JOptionpane
    public void displayTasks() {

        StringBuilder message = new StringBuilder();
        Integer count = 0;

        for (String name : names) {

            int num = count + 1;

            message.append("\nTask #" + num + "\n");
            message.append("Status: ").append(Status.get(count)).append("\n");

            message.append("Task: ").append(name).append("\n");
            message.append("Description: ").append(description.get(count)).append("\n");
            message.append("ID: ").append(ID.get(count)).append("\n");
            message.append("Duration: ").append(duration.get(count)).append("\n");

            count += 1;
        }

        message.append("\nTotalDuration: ").append(returnTotalHours(duration)).append("\n");

        JOptionPane.showMessageDialog(null, message.toString(), "Tasks", JOptionPane.INFORMATION_MESSAGE);

    }



// --------------------------------------------------------------------------------------------------------------------------//


    //takes task name, number and dev name as parameter and returns task ID
    public static String createTaskID(String taskName, String taskNumber, String developer) {

        StringBuilder taskID = new StringBuilder();

        taskID.append(taskName.charAt(0));
        taskID.append(taskName.charAt(1));

        taskID.append(":");

        taskID.append(taskNumber);

        taskID.append(":");

        int s = developer.length() - 3;

        for (int i = 0; i < 3; i++) {
            taskID.append(developer.charAt(s));
            s++;
        }

        return taskID.toString().toUpperCase();
    }



// --------------------------------------------------------------------------------------------------------------------------//


    //tasks an array and returns the sum of all values
    public static int returnTotalHours(ArrayList<String> durationArr) {

        int d = durationArr.size();
        int totalHours = 0;

        for (int i = 0; i < d; i++) {
            totalHours += Integer.valueOf(durationArr.get(i));
        }

        return totalHours;
    }



// --------------------------------------------------------------------------------------------------------------------------//

    //ensures description string contains less than 50 characters
    public static boolean checkTaskDescription(String description) {

        if (description.length() < 50) {
            return true;
        } else {
            return false;
        }

    }

}



// --------------------------------------------------------------------------------------------------------------------------//
// -----------------------------------------------End of File-------------------------------------------------------------------//