/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import datasource.DM_Customer;
import businesslogic.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lasse
 */
public class DM_CustomerTest
{
    
    public DM_CustomerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of createCustomer method, of class DM_Customer.
     */
    @Test
    public void testCreateCustomer()
    {
        System.out.println("createCustomer");
        Customer cus = CustomerObjForTestCreate();
        DM_Customer instance = new DM_Customer();
        instance.createCustomer(cus);
        
    }
    
   private Customer CustomerObjForTestCreate()
    {
        String custName = "Herlev Hospital", type = "Hospital", 
                streetName = "Herlev Ringvej", streetNo = "75", contactName = "Doctor Phil", phone = "911", mail = "DoctorPhil@gmail.com"; 
        int zipcode = 2730; 
                
        Customer cus = new Customer(custName, type, streetName, streetNo, 
                zipcode, contactName, phone, mail);
        
        return cus;
    }
}
