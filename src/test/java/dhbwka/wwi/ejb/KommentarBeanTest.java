/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Kommentar;
import dhbwka.wwi.jpa.User;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
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
public class KommentarBeanTest {
    
    public KommentarBeanTest() {
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
     * Test of findById method, of class KommentarBean.
     
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        Kommentar expResult = null;
        Kommentar result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of findAll method, of class KommentarBean.
     
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        List<Kommentar> expResult = null;
        List<Kommentar> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of saveNew method, of class KommentarBean.
     
    @Test
    public void testSaveNew() throws Exception {
        System.out.println("saveNew");
        Kommentar entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        Kommentar expResult = null;
        Kommentar result = instance.saveNew(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/
    /**
     * Test of update method, of class KommentarBean.
     
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Kommentar entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        Kommentar expResult = null;
        Kommentar result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    /**
     * Test of delete method, of class KommentarBean.
     
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Kommentar entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        instance.delete(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
*/ 
    /**
     * Test of createNewComment method, of class KommentarBean.
     */
    @Test
    public void testCreateNewComment() throws Exception {
        System.out.println("createNewComment");
        String comment = "Das Oberteil gefällt mir!";
        Bild bild = null;
        User user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        Kommentar expResult = null;
        Kommentar result = instance.createNewComment(comment, bild, user);
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of findCommentsById method, of class KommentarBean.
     
    @Test
    public void testFindCommentsById() throws Exception {
        System.out.println("findCommentsById");
        long id = 0L;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        KommentarBean instance = (KommentarBean)container.getContext().lookup("java:global/classes/KommentarBean");
        List<Kommentar> expResult = null;
        List<Kommentar> result = instance.findCommentsById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
