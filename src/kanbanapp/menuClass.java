package kanbanapp;

import javax.swing.JOptionPane;

public class menuClass {

    // show task menu dialog, returns: 
    //0 - add task, 
    //1 - show report, 
    //2 - sign out,
    // 3 - show all users

    public static Integer taskMenu() {

        String[] options = { "Add Tasks", "Show Report", "Sign Out", "Show all Users" };
        Integer loginOrRegister = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);

        return loginOrRegister;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // show a dialog with the options and a message, 
    //returns 0 for register and 1 for login
    public static Integer loginOrRegister() {

        String[] options = { "Register", "Login" };
        return JOptionPane.showOptionDialog(null, "Please choose an option",
                "User Input",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
    }
}
