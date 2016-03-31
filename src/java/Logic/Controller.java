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
    Customer customer;
  
    @Override
    public void createBuilding(String street, String streetNo, int zipcode, String city)
    {
        System.out.println("controller1  -   "+streetNo);
        building = new Building(street, streetNo, zipcode, city);
        facade.createBuilding(building);
        System.out.println("controller2");
    }

    @Override
    public void createCustomer(String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail) {
        customer = new Customer(type, streetName, streetNo, zipcode, contactName, phone, mail);
        facade.createCustomer(customer);
    }

   
    @Override
    public ArrayList<Building> getBuildingList()
    {
//        ArrayList<Building> building = new ArrayList();
//        return building;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
