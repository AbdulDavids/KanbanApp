package kanbanapp;

import java.util.Objects;

import javax.swing.JOptionPane;

public class Login {
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    public Boolean registerSuccessful = false;

    //---------------------------------------------------------------------------------------------------------------------------//


    // getters and setters
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //---------------------------------------------------------------------------------------------------------------------------//


    // methods
    public Boolean checkUserName() {
        if (userName.length() < 6 && userName.indexOf('_') > -1) {
            return true;
        } else {
            return false;
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------//


    public boolean checkPasswordComplexity() {
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

    //---------------------------------------------------------------------------------------------------------------------------//


    public String registerUser() {
        if (Boolean.TRUE.equals(checkUserName()) && checkPasswordComplexity()) {
            this.registerSuccessful = true;
            return "Username and password sucessfully captured";
        } else if (Boolean.TRUE.equals(checkUserName())) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else if (checkPasswordComplexity()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        return "Username and password are not correctly formatted";
    }

    //---------------------------------------------------------------------------------------------------------------------------//


    public Boolean loginUser(String loginUserName, String loginPassword) {

        if (Objects.equals(password, loginPassword) && Objects.equals(userName, loginUserName)) {
            return true;
        }
        return false;
    }

    //---------------------------------------------------------------------------------------------------------------------------//


    public String returnLoginStatus(Boolean loginStatus) {
        if (Boolean.TRUE.equals(loginStatus)) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again. ";
        }
        return "Username or password incorrect, please try again";
    }

    public Integer loginOrRegister(){
        // show a dialog with the options and a message
        String[] options = { "Register", "Login" };
        return JOptionPane.showOptionDialog(null, "Please choose an option",
                "User Input",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);

    }
}

    //---------------------------------------------------------------------------------------------------------------------------//
