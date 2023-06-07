package kanbanapp;

import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

public class LoginClass {
    // --------------------------------------------------------------------------------------------------------------------------//


    // methods
    public static Boolean checkUserName(String username) {
        if (username.length() < 6 && username.indexOf('_') > -1) {
            return true;
        } else {
            return false;
        }
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
            if (hasCapital && hasNumber && hasSpecial) {
                return true;
            }
        }
        return false;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    // Takes username and password as Strings and returns necessary message
    public static String registerUser(String username, String password) {

        boolean usernameTrue = checkUserName(username);
        boolean passwordTrue = checkPasswordComplexity(password);

        if (usernameTrue && passwordTrue) {
            return "Username and password sucessfully captured";
        } else if (usernameTrue) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else if (passwordTrue) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        return "Username and password are not correctly formatted";
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public static String returnLoginStatus(Boolean loginStatus, String firstName, String lastName) {
        if (Boolean.TRUE.equals(loginStatus)) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again. ";
        }
        return "Username or password incorrect, please try again";
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public static Integer loginOrRegister() {
        // show a dialog with the options and a message
        String[] options = { "Register", "Login" };
        return JOptionPane.showOptionDialog(null, "Please choose an option",
                "User Input",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
    }

    //-------------------------------------------------------------------------------------------------------------------------//

    // returns true if a username and password are at the same index values in their
    // respective arraylists
    public static boolean loginUser(String username, String password, ArrayList<String> userNameArray,
            ArrayList<String> passwordArray) {

        int size = userNameArray.size();
        for (int i = 0; i < size; i++) {

            String us = userNameArray.get(i);
            String ps = passwordArray.get(i);
            if (Objects.equals(us, username) && Objects.equals(ps, password)) {
                return true;
            }
        }

        return false;
    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public static String loginMessage(Boolean loginStatus, Integer userIndex, ArrayList<String> firstNameList,
            ArrayList<String> lastNameList) {

        String firstName = null;
        String lastName = null;

        if (loginStatus) {

            firstName = firstNameList.get(userIndex);
            lastName = lastNameList.get(userIndex);

            loginStatus = true;

        }
        return LoginClass.returnLoginStatus(loginStatus, firstName, lastName);

    }

    // --------------------------------------------------------------------------------------------------------------------------//

    public static Integer returnUserIndex(String username, ArrayList<String> userNameArray) {

        int size = userNameArray.size() + 1;

        int none = 0;
        for (int i = 0; i < size; i++) {

            String us = userNameArray.get(i);

            if (Objects.equals(us, username)) {
                return i;
            }

        }
        return none;

    }

        //-----------------------------------------------------------------------------------------------------------------------//

        public static void displayUsers(ArrayList usernameList){
            String output = "";
                for(int i = 0; i<usernameList.size(); i++){
                    String usernames = usernameList.get(i).toString();
                
                    int userNum = i + 1;

                    output += "User #" + userNum + ": " + usernames ;       
                }
                JOptionPane.showMessageDialog(null, output);
        }
























}