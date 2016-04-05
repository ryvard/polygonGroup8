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
 * @author miaryvard
 */
public class DM_BuildingTest
{
    
    public DM_BuildingTest()
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
     * Test of createBuildingInDB method, of class DM_Building.
     */
    @Test
    public void testCreateBuildingInDB()
    {
        System.out.println("createBuildingInDB");
        Building b = null;
        DM_Building instance = new DM_Building();
        instance.createBuildingInDB(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBuildingList method, of class DM_Building.
     */
    @Test
    public void testGetBuildingList1()
    {
        System.out.println("getBuildingList");
        DM_Building instance = new DM_Building();
        ArrayList<Building> expResult = null;
        ArrayList<Building> result = instance.getBuildingList();
        assertEquals(expResult, result);
        
        // OBS !!! Ikke lavet endnu
    }
    
    
    @Test
    public void testGetBuildingList2()
    {
        System.out.println("getBuildingList - isEmpty");
        DM_Building instance = new DM_Building();    
        ArrayList<Building> result = instance.getBuildingList();
        
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testGetBuildingList3()
    {
        System.out.println("getBuildingList - size");
        DM_Building instance = new DM_Building();
        
        int expSize = 0;
        
        ArrayList<Building> result = instance.getBuildingList();
        int resultSize = result.size();
        assertEquals(expSize, resultSize);
    }

    /**
     * Test of getCity method, of class DM_Building.
     */
    @Test
    public void testGetCity1()
    {
        System.out.println("getCity");
        DM_Building instance = new DM_Building();
        int zip = 2800;
        String expResult = "Lyngby";
        String result = instance.getCity(zip);
        assertEquals(expResult, result);
    }
    /**
     * testing city with an ø
     */
    @Test
    public void testGetCity2()
    {
        System.out.println("getCity");
        DM_Building instance = new DM_Building();
        int zip = 3450;
        String expResult = "Allerød";
        String result = instance.getCity(zip);
        assertEquals(expResult, result);
    }
    /**
     * Testing wrong zip input
     */
    @Test
    public void testGetCity3()
    {
        System.out.println("getCity - wrong input test");
        DM_Building instance = new DM_Building();
        int zip = 345;
        String expResult = null;
        String result = instance.getCity(zip);
        assertEquals(expResult, result);
    }
}
