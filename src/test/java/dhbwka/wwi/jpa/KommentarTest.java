/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

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
public class KommentarTest {
    
    public KommentarTest() {
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
     * Test of getText method, of class Kommentar.
     */


    /**
     * Test of toString method, of class Kommentar.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Kommentar instance = new Kommentar("text to test");
        String expResult = "text to test";
        String result = instance.getText();
        assertEquals(expResult, result);
    }
    
}
