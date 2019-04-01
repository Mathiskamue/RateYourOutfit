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
    @Test
    public void testGetText() {
        Bild bild = null;
        System.out.println("Dieses Outfit gefällt mir");
        User user = null;
        Kommentar instance = new Kommentar("Dieses Outfit gefällt mir", bild, user );
        String expResult = "Dieses Outfit gefällt mir";
        String result = instance.getText();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setText method, of class Kommentar.
     */
    @Test
    public void testSetText() {
        System.out.println("Dieses Outfit gefällt mir");
        String text = "Dieses Outfit gefällt mir";
        Kommentar instance = new Kommentar();
        instance.setText(text);
       
    }

    /**
     * Test of getId method, of class Kommentar.
     
    @Test
    public void testGetId() {
        System.out.println("getId");
        Kommentar instance = new Kommentar();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Kommentar.
    
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Kommentar instance = new Kommentar();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of toString method, of class Kommentar.
     
    @Test
    public void testToString() {
        Bild bild = null;
        System.out.println("Dieses Outfit gefällt mir");
        Kommentar instance = new Kommentar("Dieses Outfit gefällt mir",bild);
        String expResult = "Dieses Outfit gefällt mir";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    */
}
