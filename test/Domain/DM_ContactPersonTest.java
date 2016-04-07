/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author emmablomsterberg
 */
public class DM_ContactPersonTest {
    
    public DM_ContactPersonTest() {
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
     * Test of createContactPerson method, of class DM_ContactPerson.
     */
    @Test
    public void testCreateContactPerson() {
        System.out.println("createContactPerson");
        ContactPerson cp = new ContactPerson("Lasse","Blomsterberg");
        DM_ContactPerson instance = new DM_ContactPerson();
        int result = instance.createContactPerson(cp);
        int index = instance.getContactPersonList().size()-1;
        int expResult = instance.getContactPersonList().get(index).getCPID();
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of getContactPersonList method, of class DM_ContactPerson.
     */
    @Test
    public void testGetContactPersonList() {
        System.out.println("getContactPersonList");
        DM_ContactPerson instance = new DM_ContactPerson();
        ContactPerson cp = new ContactPerson("Cecillie", "Nielsen");
        instance.createContactPerson(cp);
        ArrayList<ContactPerson> expList = new ArrayList();
        expList.add(cp);
        ArrayList<ContactPerson> expResult = expList;
        ArrayList<ContactPerson> result = instance.getContactPersonList();
        assertEquals(expResult, result);
        
    }
    
}
