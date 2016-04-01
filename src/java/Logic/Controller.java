/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Building;
import Domain.Customer;
import Domain.Facade;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class Controller implements IController
{
    Facade facade = new Facade();
    Building building;
//    Customer customer;
  
    
    @Override
    public void createBuilding(String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse, int custID)
    {
        System.out.println("controller1  -   "+streetNumb);
        
        Building building = new Building(buildingName, streetName, streetNumb, 
                city, zipcode, yearOfConst, squareMeters, buildingUse, custID);
        
        facade.createBuilding(building);
        
        System.out.println("controller2");
        
    }
    
    @Override
    public void createCustomer(String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail) {
        Customer customer = new Customer(type, streetName, streetNo, zipcode, contactName, phone, mail);
        facade.createCustomer(customer);
    }

   
    @Override
    public ArrayList<Building> getBuildingList()
    {
        return facade.getBuildingList();
    }

    

    
    
    
}
