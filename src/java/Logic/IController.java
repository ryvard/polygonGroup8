/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Building;
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
        public void createBuilding(String street, String StreetNo, int zipcode, String city);
        
        
        public void createCustomer(String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail);
        
        
    /*
     * Called when entering the site BuildingList.jsp 
     * Arraylist containing all buildings.
     */
        public ArrayList<Building> getBuildingList(); 
}
