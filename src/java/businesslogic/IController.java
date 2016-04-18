/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogic.Building;
import businesslogic.Condition;
import businesslogic.ContactPerson;
import businesslogic.Customer;
import businesslogic.Employee;
import businesslogic.Report;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public interface IController
{
    /*
     * Called when you submit your new building.
     */
        public void createBuilding(String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse, int custID, int CPID);
        
        
        public void createCustomer(String name, String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail);
        
        public void createReport(String reportNumber, String date, int squareMeter, String buildingUseability, String roof, String roofPicture, String outerwalls, String outerwallsPicture, Object conclusion, String reviewedBy, String collaboration, int condition);
    /*
     * Called when entering the site BuildingList.jsp 
     * Arraylist containing all buildings.
     */
        public ArrayList<Building> getBuildingList(); 
        
        public Building getBuildingFromID(int buildingID) throws ReportErrorException;
        
        public int createContactPerson(String cpFirstName, String cpLastName, String mail, String phone);
        
        public void createContactPersonInfo(String firstName, String lastName, String mail, String phone);
        
        public ArrayList<ContactPerson> getContactPersonList();
        
        public Report viewReport();
        
        public ArrayList<Condition> getConditions();
        
        public void createFloor(ArrayList<Floor> arrayFloor, int buildingID);
        
        public int getBuildingIDFromDB(String buildingName, String streetName);
        
        
        
        //MIA  Used when creating the report
        
        public int getCPID(String firstName, String lastName);
    
        public void createReport(int buildingID, Report r, ArrayList<ReviewOf> outerReviews, Employee employee, Damage roomDamage) throws ReportErrorException;
        
        public ContactPerson getCPFromCPID(int CPID);

}
