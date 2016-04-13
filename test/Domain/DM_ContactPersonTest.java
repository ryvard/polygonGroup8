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
        ContactPerson cp = new ContactPerson("Lasse","Blomsterberg", "lh@hotmail.com", "38291019");
        DM_ContactPerson instance = new DM_ContactPerson();
        int index = instance.getContactPersonList().size()-1;
        int expResult = instance.getContactPersonList().get(index).getCPID();
        int result = instance.createContactPerson(cp);
        assertEquals(expResult, result);
       
        
    }

    /**
     * Test of getContactPersonList method, of class DM_ContactPerson.
     */
    @Test
    public void testGetContactPersonList() {
        System.out.println("getContactPersonList");
        DM_ContactPerson instance = new DM_ContactPerson();
        ContactPerson cp = new ContactPerson("Cecillie", "Nielsen", "cn@hotmail.com", "328304021");
        instance.createContactPerson(cp);
        ArrayList<ContactPerson> expList = new ArrayList();
        expList.add(cp);
        ArrayList<ContactPerson> expResult = expList;
        int index = instance.getContactPersonList().size()-1;
        ArrayList<ContactPerson> test = new ArrayList();
        test.add(instance.getContactPersonList().get(index));
        ArrayList<ContactPerson> result =  test;
        assertEquals(expResult, result);
        
    }
    
}
