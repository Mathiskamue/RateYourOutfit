/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEETMUMI
 */
public class UserTest {
   
    public UserTest() {
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
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        User instance = new User("username", "passwort");
        String expResult = "username";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String id = "usename";
        User instance = new User("username","passwort");
        instance.setUsername(id);
        
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "passwort";
        User instance = new User("username","passwort");
        instance.setPassword(password);
        
    }

    
    /**
     * Test of checkPassword method, of class User.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "Test1234";
        User instance = new User("instance","123456");
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        
    }

    
}
