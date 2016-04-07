/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
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
public class DatabaseConnectorTest
{
    
    public DatabaseConnectorTest()
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
     * Test of getInstance method, of class DatabaseConnector.
     */
    @Test
    public void testGetInstance()
    {
        System.out.println("getInstance");
        DatabaseConnector expResult = null;
        DatabaseConnector result = DatabaseConnector.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getData method, of class DatabaseConnector.
     */
    @Test
    public void testGetData()
    {
        System.out.println("getData");
        String query = "";
        DatabaseConnector instance = null;
        ResultSet expResult = null;
        ResultSet result = instance.getData(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateData method, of class DatabaseConnector.
     */
    @Test
    public void testUpdateData()
    {
        System.out.println("updateData");
        String query = "";
        DatabaseConnector instance = null;
        instance.updateData(query);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
