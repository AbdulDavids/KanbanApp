package kanbanapp;

import javax.swing.JOptionPane;

public class worker {

    private Login account = new Login();

    // --------------------------------------------------------------------------------------------------------------------------//

    // provides UI for registratration and login
    public Boolean signIn() {
        Boolean finished = false;
        while (!finished) {

            int choice = account.loginOrRegister();
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

                    account.setFirstName(firstName);
                    account.setLastName(lastName);
                    account.setUserName(userName);
                    account.setPassword(password);

                    JOptionPane.showMessageDialog(null, account.registerUser());
                    break;

                case 1:
                    // login code
                    if (choice == 1) {
                        String loginUserName = JOptionPane.showInputDialog("Please enter your username");

                        String loginPassword = JOptionPane.showInputDialog("Please enter your password");

                        Boolean loginStatus = account.loginUser(loginUserName, loginPassword);

                        JOptionPane.showMessageDialog(null, account.returnLoginStatus(loginStatus), null, 1);

                        if (loginStatus) {

                            finished = true;
                        }
                    }
                    break;
                default:
                    break;
            }

        }
        return finished;
    }

    //---------------------------------------------------------------------------------------------------------------------------//

    // displays task menu
    public void displayTaskApp() {

        Boolean quit = false;
        Task tk = new Task();

        while (!quit) {
            String[] options = { "Add Tasks", "Show Report", "Quit" };
            Integer loginOrRegister = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban",
                    null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                    options[0]);

            switch (loginOrRegister) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Add Task Coming Soon", null, 1);
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "Coming Soon!", null, 1);
                    break;

                case 2:

                    quit = true;
                    break;

            }

        }

    }
}

// ------------------------------------------------------------------------------------------------------------------------------//