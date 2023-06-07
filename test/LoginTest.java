/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class LoginTest {

    public LoginTest() {

    }

    @Test
    public void usernameListTest() {
        ArrayList<String> usernameList = new ArrayList<String>();

        usernameList.add("Abdul_");
        usernameList.add("Humi_");
        System.out.println(usernameList);
    }

    
}
