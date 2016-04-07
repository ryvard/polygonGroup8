/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Building;
import Domain.ContactPerson;
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
        
        public int createContactPerson(String cpFirstName, String cpLastName);
        
        public ArrayList<ContactPerson> getContactPersonList();
        
       
        
}
