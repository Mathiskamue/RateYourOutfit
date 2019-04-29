/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbwka.wwi.ejb;

import dhbwka.wwi.jpa.Bild;
import dhbwka.wwi.jpa.Stern;
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
public class SternBeanTest {
    
    public SternBeanTest() {
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
     * Test of findById method, of class SternBean.
     
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        Long id = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SternBean instance = (SternBean)container.getContext().lookup("java:global/classes/SternBean");
        Stern expResult = null;
        Stern result = instance.findById(id);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of findAll method, of class SternBean.
     
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SternBean instance = (SternBean)container.getContext().lookup("java:global/classes/SternBean");
        List<Stern> expResult = null;
        List<Stern> result = instance.findAll();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of saveNew method, of class SternBean.
     
    @Test
    public void testSaveNew() throws Exception {
        System.out.println("saveNew");
        Stern entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SternBean instance = (SternBean)container.getContext().lookup("java:global/classes/SternBean");
        Stern expResult = null;
        Stern result = instance.saveNew(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of update method, of class SternBean.
     
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Stern entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SternBean instance = (SternBean)container.getContext().lookup("java:global/classes/SternBean");
        Stern expResult = null;
        Stern result = instance.update(entity);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of delete method, of class SternBean.
     
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Stern entity = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SternBean instance = (SternBean)container.getContext().lookup("java:global/classes/SternBean");
        instance.delete(entity);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
*/
    /**
     * Test of createNewStern method, of class SternBean.
     
    @Test
    public void testCreateNewStern() throws Exception {
        System.out.println("createNewStern");
        double bewertung = 0.0;
        Bild bild = null;
        User user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        SternBean instance = (SternBean)container.getContext().lookup("java:global/classes/SternBean");
        Double expResult = null;
        Double result = instance.createNewStern(bewertung, bild, user);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    */
}
