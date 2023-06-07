package kanbanapp;

import javax.swing.JOptionPane;

public class menuClass {
    public static Integer taskMenu() {

        String[] options = { "Add Tasks", "Show Report", "Sign Out", "Show all Users" };
        Integer loginOrRegister = JOptionPane.showOptionDialog(null, "Welcome to EasyKanban",
                null, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);

        return loginOrRegister;
    }
}
