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

}
