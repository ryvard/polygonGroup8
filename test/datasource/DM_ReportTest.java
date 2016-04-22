/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Building;
import businesslogic.Conclusion;
import businesslogic.Condition;
import businesslogic.Damage;
import businesslogic.DatasourceLayerException;
import businesslogic.Employee;
import businesslogic.Floor;
import businesslogic.MoistScan;
import businesslogic.Report;
import businesslogic.ReviewOf;
import businesslogic.Room;
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

    private Report r;
    DM_Building instance_DM_Building = new DM_Building();
    DM_Employee instance_DM_Employee = new DM_Employee();

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
//        Building b = new Building("Nybrogaard", "Nybrovej", "304", "Kongens Lyngby", 2800, 1990, 300, "Beboelse", 1, 1);
//       
//        Floor f = new Floor(floor, squareM);

        r = new Report(1, 1, "22-04-16", 1);
        
        try
        {
            Building b = instance_DM_Building.getBuildingFromID(1);
            r.addBuilding(b);
            Employee empl = instance_DM_Employee.getEmployeeFromEID(1);
            r.addEmployee(empl);
        } catch (DatasourceLayerException ex)
        {
            fail();
        }
        
        
        //get rep id:
        ArrayList<ReviewOf> outerReviewList = new ArrayList();
        ReviewOf oRev1 = new ReviewOf("Tag", "okay");
        ReviewOf oRev2 = new ReviewOf("Vægge", "k3 bemærkning");
        outerReviewList.add(oRev1);
        outerReviewList.add(oRev2);

        r.addOuterReview(outerReviewList);

        ArrayList<Room> roomList = new ArrayList();
        Room room1 = new Room(1, 101);
        Room room2 = new Room(1, 102);
        Room room3 = new Room(2, 201);
        Room room4 = new Room(2, 202);
        Room room5 = new Room(3, 301);
        Room room6 = new Room(3, 302);
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);
        roomList.add(room5);
        roomList.add(room6);

        r.addRoomList(roomList);

        ArrayList<Damage> damageList = new ArrayList();
        Damage dam1 = new Damage(101, 1, "Ja", "igår", "her", "den der", "nej", "Fugt", "nææ");
        Damage dam2 = new Damage(102, 1, "Nej", "igår", "her", "den der", "nej", "Fugt", "nææ");
        Damage dam3 = new Damage(201, 2, "Ja", "igår", "her", "den der", "nej", "Fugt", "nææ");
        Damage dam4 = new Damage(202, 2, "Nej", "igår", "her", "den der", "nej", "Fugt", "nææ");
        Damage dam5 = new Damage(301, 3, "Ja", "igår", "her", "den der", "nej", "Fugt", "nææ");
        Damage dam6 = new Damage(302, 3, "Ja", "igår", "her", "den der", "nej", "Fugt", "nææ");
        damageList.add(dam1);
        damageList.add(dam2);
        damageList.add(dam3);
        damageList.add(dam4);
        damageList.add(dam5);
        damageList.add(dam6);

        r.addDamageList(damageList);

        ArrayList<ReviewOf> reviewList = new ArrayList();
        ReviewOf rev1 = new ReviewOf(101, 1, "Vægge", "hej");
        ReviewOf rev2 = new ReviewOf(101, 1, "Loft", "hej");
        ReviewOf rev3 = new ReviewOf(102, 1, "Vægge", "hej");
        ReviewOf rev4 = new ReviewOf(102, 1, "Loft", "hej");
        ReviewOf rev5 = new ReviewOf(201, 2, "Vægge", "hej");
        ReviewOf rev6 = new ReviewOf(201, 2, "Loft", "hej");
        ReviewOf rev7 = new ReviewOf(202, 2, "Vægge", "hej");
        ReviewOf rev8 = new ReviewOf(202, 2, "Loft", "hej");
        ReviewOf rev9 = new ReviewOf(301, 3, "Vægge", "hej");
        ReviewOf rev10 = new ReviewOf(301, 3, "Loft", "hej");
        ReviewOf rev11 = new ReviewOf(302, 3, "Vægge", "hej");
        ReviewOf rev12 = new ReviewOf(302, 3, "Loft", "hej");
        reviewList.add(rev1);
        reviewList.add(rev2);
        reviewList.add(rev3);
        reviewList.add(rev4);
        reviewList.add(rev5);
        reviewList.add(rev6);
        reviewList.add(rev7);
        reviewList.add(rev8);
        reviewList.add(rev9);
        reviewList.add(rev10);
        reviewList.add(rev11);
        reviewList.add(rev12);

        r.addReviewList(reviewList);

        ArrayList<MoistScan> msList = new ArrayList();
        MoistScan ms1 = new MoistScan(101, 1, "Ja", "bla", "bla");
        MoistScan ms2 = new MoistScan(102, 1, "Ja", "bla", "bla");
        MoistScan ms3 = new MoistScan(201, 2, "Ja", "bla", "bla");
        MoistScan ms4 = new MoistScan(202, 2, "Ja", "bla", "bla");
        MoistScan ms5 = new MoistScan(301, 3, "Ja", "bla", "bla");
        MoistScan ms6 = new MoistScan(302, 3, "Ja", "bla", "bla");
        msList.add(ms1);
        msList.add(ms2);
        msList.add(ms3);
        msList.add(ms4);
        msList.add(ms5);
        msList.add(ms6);

        r.addMSList(msList);

        ArrayList<Conclusion> conclusionList = new ArrayList();
        Conclusion conclusion1 = new Conclusion(101, 1, "blabla");
        Conclusion conclusion2 = new Conclusion(102, 1, "blabla");
        Conclusion conclusion3 = new Conclusion(201, 2, "blabla");
        Conclusion conclusion4 = new Conclusion(202, 2, "blabla");
        Conclusion conclusion5 = new Conclusion(301, 3, "blabla");
        Conclusion conclusion6 = new Conclusion(302, 3, "blabla");
        conclusionList.add(conclusion1);
        conclusionList.add(conclusion2);
        conclusionList.add(conclusion3);
        conclusionList.add(conclusion4);
        conclusionList.add(conclusion5);
        conclusionList.add(conclusion6);

        r.addConclusionList(conclusionList);

    }

    @After
    public void tearDown()
    {
    }


    /**
     * Test of createReport method, of class DM_Report.
     * Do also test viewReport method, of class DM_Report.
     */
    @Test
    public void testCreateReport_Condition() throws Exception
    {
        System.out.println("createReport");
        DM_Report instance = new DM_Report();
        instance.createReport(r);
        
        int expResult = r.getCondition();
        int repID = r.getRepID();
        Report rOut = instance.viewReport(repID);
        int result = rOut.getCondition();
        
        assertEquals(expResult, result);
    }
    /**
     * Test of createReport method, of class DM_Report.
     * Do also test viewReport method, of class DM_Report.
     */
     
    @Test
    public void testCreateReport_Damage() throws Exception
    {
        System.out.println("createReport");
        DM_Report instance = new DM_Report();
        instance.createReport(r);
        String expResult = r.getDamageList().get(1).getDamage();
        int repID = r.getRepID();
        Report rOut = instance.viewReport(repID);
        String result = rOut.getDamageList().get(1).getDamage();
        
        assertEquals(expResult, result);
    }
    /**
     * Test of getConditions method, of class DM_Report.
     */
    @Test
    public void testGetConditionsFunction() throws Exception
    {
        System.out.println("getConditions");
        DM_Report instance = new DM_Report();
        String expResult = "Funktionen er som beskrevet";
        String result = instance.getConditions().get(1).getFunction();
        assertEquals(expResult, result);
    }
    /**
     * Test of getConditions method, of class DM_Report.
     */
    @Test
    public void testGetConditionsDescription() throws Exception
    {
        System.out.println("getConditions");
        DM_Report instance = new DM_Report();
        String expResult = "Bygningsdelen er nedbrudt og skal udskiftes";
        String result = instance.getConditions().get(3).getDescription();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of getConditions method, of class DM_Report.
     */
    @Test
    public void testGetConditionsCondition() throws Exception
    {
        System.out.println("getConditions");
        DM_Report instance = new DM_Report();
        int expResult = 0;
        int result = instance.getConditions().get(0).getCondition();
        assertEquals(expResult, result);
        
    }

    

}
