import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import org.junit.Test;

import kanbanapp.LoginClass;

public class LoginTest {


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void usernameCorrectFormat() {
    // testparams

    String firstName = "Kyle";
    String lastName = "Williams";
    String userName = "kyl_1";
    String usernameMessage = "";

    if (LoginClass.checkUserName(userName)) {

      usernameMessage = "Welcome " + firstName + ", " + lastName + " it is great to see you.";

      JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

    }

    assertEquals(usernameMessage, "Welcome Kyle, Williams it is great to see you.");

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void usernameInCorrectFormat() {
    // testparams
    String userName = "kyle!!!!!!!";
    String password = "6T4fce$92";
    String usernameMessage = "";

    if (!LoginClass.checkUserName(userName)) {

      usernameMessage = LoginClass.registerUser(userName, password);

      JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

    }

    assertEquals(usernameMessage,
        "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void PasswordComplexity() {

    // testparams

    String password = "Ch&&sec@ke99!";
    String usernameMessage = "";

    if (LoginClass.checkPasswordComplexity(password)) {

      usernameMessage = "Password successfully captured";

      JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

    }

    assertEquals(usernameMessage,
        "Password successfully captured");

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void InsufficientPasswordComplexity() {

    // testparams
    String firstName = "Kyle";
    String lastName = "Williams";
    String userName = "kyl_1";
    String password = "password";
    String usernameMessage = "";

    if (!LoginClass.checkPasswordComplexity(password)) {

      usernameMessage = "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";

      JOptionPane.showMessageDialog(null, usernameMessage, null, 1);

    }

    assertEquals(usernameMessage,
        "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void LoginSuccessful() {

    // testparams
    String userName = "kyl_1";
    String password = "Ch&&sec@ke99!";

    ArrayList<String> usernameList = new ArrayList<String>();
    ArrayList<String> passwordList = new ArrayList<String>();

    usernameList.add(userName);
    passwordList.add(password);

    Boolean loginStatus = LoginClass.loginUser(userName, password, usernameList, passwordList);

    assertTrue(loginStatus);

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void LoginFailed() {

    // testparams
    String userName = "kyle";
    String password = "password";

    ArrayList<String> usernameList = new ArrayList<String>();
    ArrayList<String> passwordList = new ArrayList<String>();

    usernameList.add("userName");
    passwordList.add("password");

    Boolean loginStatus = LoginClass.loginUser(userName, password, usernameList, passwordList);

    assertFalse(loginStatus);

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void checkUserName() {
    // testparams
    String userName = "kyl_1";

    assertTrue(LoginClass.checkUserName(userName));

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void FalseCheckUserName() {
    // testparams
    String userName = "kyle!!!!!!!";

    assertFalse(LoginClass.checkUserName(userName));

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void checkPasswordComplexity() {
    // testparams

    String password = "6T4fce$92";

    assertTrue(LoginClass.checkPasswordComplexity(password));

  }


// --------------------------------------------------------------------------------------------------------------------------//


  @Test
  public void falseCheckPasswordComplexity() {
    // testparams

    String password = "password";

    assertFalse(LoginClass.checkPasswordComplexity(password));

  }
}


// --------------------------------------------------------------------------------------------------------------------------//
// -----------------------------------------------End of File-------------------------------------------------------------------//