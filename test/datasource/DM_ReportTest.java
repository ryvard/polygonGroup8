/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Condition;
import businesslogic.Report;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author miaryvard
 */
public class DM_ReportTest
{
    
    public DM_ReportTest()
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
     * Test of createReport method, of class DM_Report.
     */
    @Test
    public void testCreateReport() throws Exception
    {
        System.out.println("createReport");
        Report r = null;
        DM_Report instance = new DM_Report();
        instance.createReport(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConditions method, of class DM_Report.
     */
    @Test
    public void testGetConditions() throws Exception
    {
        System.out.println("getConditions");
        DM_Report instance = new DM_Report();
        ArrayList<Condition> expResult = null;
        ArrayList<Condition> result = instance.getConditions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewReport method, of class DM_Report.
     */
    @Test
    public void testViewReport() throws Exception
    {
        System.out.println("viewReport");
        int repID = 0;
        DM_Report instance = new DM_Report();
        Report expResult = null;
        Report result = instance.viewReport(repID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
