/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.uwomapviewer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * LoginTest class for testing Login class
 * 
 * @author Talia
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkPassword method, of class Login.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        
        Login instance = new Login();
        
        String pwd = "pass1234";
        String userName = "user";
        dataStorage data = new dataStorage();
        JSONArray userList = data.getUserData();
        userList.forEach(user -> instance.checkPassword((JSONObject) user, userName, pwd));
        
        boolean exp = true;
        boolean result = instance.correct;
        assertEquals(exp, result);

        
    }
    
}
