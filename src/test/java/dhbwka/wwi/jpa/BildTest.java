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
public class BildTest {
        String beschreibung = "Das Oberteil ist von Gucci";
        byte[] bild = null;
        User user =null;
    public BildTest() {
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
     * Test of getId method, of class Bild.
    
    @Test
    public void testGetId() {
        System.out.println("getId");
        Bild instance = new Bild();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        
    }
*/ 
    /**
     * Test of setId method, of class Bild.
     
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Bild instance = new Bild();
        instance.setId(id);
        
    }
    */ 
    /**
     * Test of getBeschreibung method, of class Bild.
    */ 
    @Test
    public void testGetBeschreibung() {
        
        System.out.println(beschreibung + " -->eingegebene Beschreibung");
        Bild instance = new Bild(beschreibung, bild, user);
        String expResult = "Das Oberteil ist von Gucci";
        String result = instance.getBeschreibung();
        assertEquals(expResult, result);
        System.out.println(instance.getBeschreibung()+ " -->Beschreibung aus dem Bildobjekt");
    }

    /**
     * Test of setBeschreibung method, of class Bild.
    */
    @Test
    public void testSetBeschreibung() {
        
        System.out.println("testSetBeschreibung");
        String beschreibung = "Das Oberteil ist von Gucci";
        byte[] bild = null;
        User user = null;
        Bild instance = new Bild(beschreibung, bild,user);
        instance.setBeschreibung(beschreibung);
        
    }

    /**
     * Test of getBild method, of class Bild.
    
    @Test
    public void testGetBild() {
        byte[] b = null;
        System.out.println("getBild");
        Bild instance = new Bild(beschreibung, b, user);
        byte[] expResult = null;
        byte[] result = instance.getBild();
        assertArrayEquals(expResult, result);
        
    }
*/
    /**
     * Test of setBild method, of class Bild.
    
    @Test
    public void testSetBild() {
        System.out.println("setBild");
        byte[] bild = null;
        User user = null;
        Bild instance = new Bild("Das Oberteil ist von Gucci",bild, user);
        instance.setBild(bild);
        
    }
*/
    /**
     * Test of getTimestamp method, of class Bild.
   
    @Test
    public void testGetTimestamp() {
        System.out.println("getTimestamp");
        Bild instance = new Bild();
        String expResult = "";
        String result = instance.getTimestamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
    /**
     * Test of setTimestamp method, of class Bild.
    
    @Test
    public void testSetTimestamp() {
        System.out.println("setTimestamp");
        String timestamp = "";
        Bild instance = new Bild();
        instance.setTimestamp(timestamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of toString method, of class Bild.
    
    @Test
    public void testToString() {
        System.out.println("toString");
        Bild instance = new Bild();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
   */ 
}
