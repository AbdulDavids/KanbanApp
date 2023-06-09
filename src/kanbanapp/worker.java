package kanbanapp;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class worker {
    taskClass tc = new taskClass();

    ArrayList<String> usernameList = new ArrayList<String>();
    ArrayList<String> passwordList = new ArrayList<String>();
    ArrayList<String> firstNameList = new ArrayList<String>();
    ArrayList<String> lastNameList = new ArrayList<String>();

    public worker() {

        usernameList.add("admin");
        passwordList.add("admin");
        firstNameList.add("Administrator");
        lastNameList.add(" ");

    }
    // --------------------------------------------------------------------------------------------------------------------------//

    // provides UI for registratration and login, loops til login successful
    public Boolean signIn() {

        Boolean finished = false;
        while (!finished) {

            int choice = menuClass.loginOrRegister();
            switch (choice) {
                case 0:
                    // Registration code
                    String firstName = JOptionPane.showInputDialog(
                            "Please enter your first name");

                    String lastName = JOptionPane.showInputDialog(
                            "Please enter your last name");

                    String userName = JOptionPane.showInputDialog(
                            "Enter a username that contains an underscore, no spaces and is less than 5 characters long");

                    String password = JOptionPane.showInputDialog(
                            "Enter a password that contains:" + System.lineSeparator()
                                    + "At least 8 characters."
                                    + System.lineSeparator() + "A capital letter"
                                    + System.lineSeparator()
                                    + "Contains a number." + System.lineSeparator()
                                    + "Contains a special character");

                    if (LoginClass.checkUserName(userName) && LoginClass.checkPasswordComplexity(password)) {
                        firstNameList.add(firstName);
                        lastNameList.add(lastName);
                        usernameList.add(userName);
                        passwordList.add(password);
                    }
                    JOptionPane.showMessageDialog(null, LoginClass.registerUser(userName, password));
                    break;

                case 1:
                    // login code

                    String loginUserName = JOptionPane.showInputDialog("Please enter your username");

                    String loginPassword = JOptionPane.showInputDialog("Please enter your password");

                    Boolean loginStatus = LoginClass.loginUser(loginUserName, loginPassword, usernameList,
                            passwordList);

                    Integer userIndex = LoginClass.returnUserIndex(loginUserName, usernameList);

                    String loginMessage = LoginClass.loginMessage(loginStatus, userIndex, firstNameList, lastNameList);

                    JOptionPane.showMessageDialog(null, loginMessage, null, 1);

                    if (loginStatus) {
                        finished = true;
                    }

                    break;
            }

        }
        return finished;
    }

    // -------------------------------------------------------------------------------------------------------------------------//

    // displays task app
    public void displayTaskApp() {

        Boolean quit = false;

        while (!quit) {

            switch (menuClass.taskMenu()) {
                case 0:
                    // JOptionPane.showMessageDialog(null, "Add Task Coming Soon", null, 1);

                    tc.addTasks(2);

                    break;

                case 1:
                    // JOptionPane.showMessageDialog(null, "Coming Soon!", null, 1);

                    tc.displayTasks();

                    break;

                case 2:

                    quit = true;
                    break;

                case 3:
                    LoginClass.displayUsers(usernameList);
                    break;

            }

        }

    }
}

// ------------------------------------------------------------------------------------------------------------------------------//