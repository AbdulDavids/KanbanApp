package kanbanapp;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class taskClass {

    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> taskNumber = new ArrayList<String>();
    ArrayList<String> description = new ArrayList<String>();
    ArrayList<String> developer = new ArrayList<String>();
    ArrayList<String> duration = new ArrayList<String>();
    ArrayList<String> ID = new ArrayList<String>();
    ArrayList<String> Status = new ArrayList<String>();

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
                } else {
                    JOptionPane.showConfirmDialog(null, panel,
                            "Please enter a description with less than 50 characters",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                }

            }

        }

    }

    public void displayTasks() {

        StringBuilder message = new StringBuilder();
        Integer count = 0;

        for (String name : names) {

            int num = count + 1;

            message.append("\nTask #" + num + "\n");
            message.append("Task: ").append(name).append("\n");
            message.append("ID: ").append(ID.get(count)).append("\n");
            message.append("Developer: ").append(developer.get(count)).append("\n");
            message.append("Description: ").append(description.get(count)).append("\n");
            message.append("Status: ").append(Status.get(count)).append("\n");

            count += 1;
        }

        JOptionPane.showMessageDialog(null, message.toString(), "Tasks", JOptionPane.INFORMATION_MESSAGE);

    }

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

    public static int returnTotalHours(int[] durationArr) {

        int d = durationArr.length;
        int totalHours = 0;

        for (int i = 0; i < d; i++) {
            totalHours += durationArr[i];
        }

        return totalHours;
    }

    public static boolean checkTaskDescription(String description) {

        if (description.length() < 50) {
            return true;
        }

        return false;
    }



}
