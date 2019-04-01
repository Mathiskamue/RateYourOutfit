/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.jpa;

import java.util.ArrayList;
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
public class KommentarTest {
    Bild bild;
    Kommentar comment1;
    Kommentar comment2;
    Kommentar comment3;
    
    
    public KommentarTest() {
    }
    
    @Before
    public void setUpClass() {
        String beschreibung = "";
        User user1 = null;
        User user2 = null;
        byte[] b = null;
        bild = new Bild(beschreibung, b, user1);
        comment1 = new Kommentar("Das Oberteil gefällt mir!",bild, user1 );
        comment2 = new Kommentar("Das Outfit gefällt mir nicht!",bild, user2 );
        comment3 = new Kommentar("Die Hose ist cool!",bild, user1 );
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
     * Test:
     * Sind alle Kommentare, welche von den Benutzern geschrieben wurden,
     * wirklich mit dem Bildobjekt verknüpft und in dessen 
     * Kommentarliste enthalten?
    */
    @Test
    public void alleKommentare(){
        
        List<Kommentar> expResult = new ArrayList<>();
        expResult.add(comment1);
        expResult.add(comment2);
        expResult.add(comment3);
        List<Kommentar> result = bild.getKommentar();
        for(int i =0; i < result.size();i++){
            result.contains(comment1);
            result.contains(comment2);
            result.contains(comment3);
        }
        System.out.println(result);
    }
    /**
     * Test of getText method, of class Kommentar.
     
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
*/
    /**
     * Test of setText method, of class Kommentar.
     
    @Test
    public void testSetText() {
        System.out.println("Dieses Outfit gefällt mir");
        String text = "Dieses Outfit gefällt mir";
        Kommentar instance = new Kommentar();
        instance.setText(text);
       
    }
*/
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
