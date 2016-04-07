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
public class Controller implements IController {

    Facade facade = new Facade();
    Building building;
//    Customer customer;

    @Override
    public void createBuilding(String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse, int custID, int CPID)
    {
        System.out.println("controller1  -   "+streetNumb);
        
        Building building = new Building(buildingName, streetName, streetNumb, 
                city, zipcode, yearOfConst, squareMeters, buildingUse, custID, CPID);
        
        System.out.println("hejhej ");

        facade.createBuilding(building);

        System.out.println("controller2");

    }

    @Override
    public void createCustomer(String name, String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail) {
        Customer customer = new Customer(name, type, streetName, streetNo, zipcode, contactName, phone, mail);
        facade.createCustomer(customer);
    }

    @Override
    public ArrayList<Building> getBuildingList() {
        System.out.println("controller");
        return facade.getBuildingList();
    }

    @Override
    public void createReport(String reportNumber, String date, int squareMeter, String buildingUseability, String roof, String roofPicture, String outerwalls, String outerwallsPicture, Object conclusion, String reviewedBy, String collaboration, int condition) {

    }


}
