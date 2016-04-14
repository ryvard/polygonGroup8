/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Building;
import Domain.Condition;
import Domain.ContactPerson;
import Domain.Customer;
import Domain.Employee;
import Domain.Facade;
import Domain.Report;
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


    @Override
    public int createContactPerson(String cpFirstName, String cpLastName, String email, String phone) {
        ContactPerson cp = new ContactPerson(cpFirstName, cpLastName, email, phone);
        return facade.createContactPerson(cp);
    }

    @Override
    public ArrayList<ContactPerson> getContactPersonList() {
        return facade.getContactPersonList();
    }

    @Override
    public Building getBuildingFromID(int buildingID)
    {
        return facade.getBuildingFromID(buildingID);
    }
    
    @Override
    public Report viewReport()
    {
        return null;
    }

    @Override
    public ArrayList<Condition> getConditions()
    {
        return facade.getConditions();
    }
    
    @Override
    public void createContactPersonInfo(String firstName, String lastName,String mail,String phone) {
        ContactPerson cp = new ContactPerson(firstName, lastName, mail, phone);
        facade.createContactPersonInfo(cp);
    }

    @Override
    public int getCPID(String firstName, String lastName)
    {
        return facade.getCPID(firstName, lastName);
    }

    @Override
    public int getEID(String firstName, String lastName)
    {
        return facade.getEID(firstName, lastName);
    }

    @Override
    public Employee getEmployeeFromEID(int eID)
    {
        return facade.getEmployeeFromEID(eID);
    }

    @Override
    public void createReportInDB(Report r)
    {
        facade.createReportInDB(r);
    }

    @Override
    public ContactPerson getCPFromCPID(int CPID)
    {
        return facade.getCPFromCPID(CPID);
    }
    
    

}
