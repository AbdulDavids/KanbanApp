import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kanbanapp.taskClass;

public class taskTest {

    // --------------------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        taskClass tk = new taskClass();
        tk.addTasks(2);
        tk.displayTasks();
    }

// --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void correctTaskDescription() {

        String description = "Create Login to authenticate users";
        String message = "";

        if (taskClass.checkTaskDescription(description)) {
            message = "Task successfully captured";
        } else {
            message = "Please enter a task description of less than 50 characters";
        }
        assertEquals(message, "Task successfully captured");

    }

// --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void tooLongTaskDescription() {

        String description = "Create Add Task feature to add task users. Random extra words to exceed the description. If you read this you're silly hehehehe";
        String message = "";

        if (taskClass.checkTaskDescription(description)) {
            message = "Task successfully captured";
        } else {
            message = "Please enter a task description of less than 50 characters";
        }
        assertEquals(message, "Please enter a task description of less than 50 characters");

    }

// --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void generateTaskID() {

        String[] taskIDArr = { "", "" };
        String[] taskIDArrTarget = { "AD:1:BYN", "AD:2:IKE" };

        taskClass tk = new taskClass();

        tk.names.add("Add Login Feature");
        tk.description.add("Create Login to authenticate users");
        tk.developer.add("Robyn");
        tk.duration.add(String.valueOf(8));
        tk.Status.add("To Do");
        tk.taskNumber.add(String.valueOf("1"));

        tk.names.add("Add Task Feature");
        tk.description.add("Create Add Task feature to add task users");
        tk.developer.add("Mike");
        tk.duration.add(String.valueOf(10));
        tk.Status.add("To Do");
        tk.taskNumber.add(String.valueOf("2"));

        for (int i = 0; i < 2; i++) {
            String taskID = taskClass.createTaskID(tk.names.get(i), tk.taskNumber.get(i), tk.developer.get(i));

            taskIDArr[i] += taskID;
            System.out.println(taskID);
            assertEquals(taskIDArr[i], taskIDArrTarget[i]);

        }
    }

// --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void returnTotalHoursTest() {
        taskClass tk = new taskClass();
        tk.duration.add(String.valueOf(8));
        tk.duration.add(String.valueOf(10));

        int totalHours = taskClass.returnTotalHours(tk.duration);

        assertEquals(totalHours, 18);
    }

// --------------------------------------------------------------------------------------------------------------------------//

    @Test
    public void returnTotalHoursTestExtra() {
        taskClass tk = new taskClass();
        tk.duration.add(String.valueOf(10));
        tk.duration.add(String.valueOf(12));
        tk.duration.add(String.valueOf(55));
        tk.duration.add(String.valueOf(11));
        tk.duration.add(String.valueOf(1));

        int totalHours = taskClass.returnTotalHours(tk.duration);

        assertEquals(totalHours, 89);
    }

}

// --------------------------------------------------------------------------------------------------------------------------//
// ------------------------------------------------End Of File---------------------------------------------------------------//
