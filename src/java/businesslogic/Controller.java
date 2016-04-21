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
import datasource.Facade;
import businesslogic.Report;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miaryvard
 */
public class Controller implements IController
{

    Facade facade = new Facade();
    //Building building;
//    Customer customer;

    @Override
    public void createBuilding(String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse, int custID, int CPID)throws DatasourceLayerException
    {
        System.out.println("controller1  -   " + streetNumb);

        Building building = new Building(buildingName, streetName, streetNumb,
                city, zipcode, yearOfConst, squareMeters, buildingUse, custID, CPID);

        System.out.println("hejhej ");

        facade.createBuilding(building);

        System.out.println("controller2");

    }

    @Override
    public void createCustomer(String name, String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail)throws DatasourceLayerException
    {
        Customer customer = new Customer(name, type, streetName, streetNo, zipcode, contactName, phone, mail);
        facade.createCustomer(customer);
    }

    @Override
    public ArrayList<Building> getBuildingList()throws DatasourceLayerException
    {
        System.out.println("controller");
        return facade.getBuildingList();
    }

    @Override
    public int createContactPerson(String cpFirstName, String cpLastName, String email, String phone)throws DatasourceLayerException
    {
        ContactPerson cp = new ContactPerson(cpFirstName, cpLastName, email, phone);
        return facade.createContactPerson(cp);
    }

    @Override
    public ArrayList<ContactPerson> getContactPersonList()throws DatasourceLayerException
    {
        return facade.getContactPersonList();
    }


    @Override
    public void createContactPersonInfo(String firstName, String lastName, String mail, String phone)throws DatasourceLayerException
    {
        ContactPerson cp = new ContactPerson(firstName, lastName, mail, phone);
        facade.createContactPersonInfo(cp);
    }

    // ikke brugt
    @Override
    public int getCPID(String firstName, String lastName)throws DatasourceLayerException
    {
        return facade.getCPID(firstName, lastName);
    }

    //--------------------------------------------------------------
    @Override
    public void createReport(int buildingID, Report r, ArrayList<ReviewOf> outerReviews,
            Employee employee, ArrayList<Room> roomList, ArrayList<Damage> damageList, ArrayList<ReviewOf> reviewList,
            ArrayList<MoistScan> msList, ArrayList<Conclusion> conclusionList) throws DatasourceLayerException
    {

        Building building = getBuildingFromID(buildingID);
        r.addBuilding(building);
        r.addOuterReview(outerReviews);
        employee.seteID(facade.getEID(employee.getFirstName(), employee.getLastName()));
        r.addEmployee(employee);

        r.addRoomList(roomList);
        r.addDamageList(damageList);
        r.addReviewList(reviewList);
        r.addMSList(msList);
        r.addConclusionList(conclusionList);

        facade.createReport(r);
    }

//    //ikke brugt
    @Override
    public ArrayList<Condition> getConditions()throws DatasourceLayerException
    {
        return facade.getConditions();
    }

    //create b from bid
    @Override
    public Building getBuildingFromID(int buildingID) throws DatasourceLayerException
    {
        ContactPerson c = facade.getCP(buildingID);
        Building b = facade.getBuildingFromID(buildingID);
        b.addCP(c);

        return b;
    }

    @Override
    public ContactPerson getCPFromCPID(int CPID)throws DatasourceLayerException
    {
        return facade.getCPFromCPID(CPID);
    }

    //--------------------------------------------------------------
    @Override
    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID)throws DatasourceLayerException
    {
        facade.createFloor(arrayFloor, buildingID);
    }

    //Forsøg på fejlhåndtering 
    //ikke brugt
    @Override
    public int getBuildingIDFromDB(String buildingName, String streetName)throws DatasourceLayerException
    {
        return facade.getBuildingIDFromDB(buildingName, streetName);
    }

    public void createBuilding(Building b, ArrayList<Floor> arrayFloor)throws DatasourceLayerException
    {
        b.addArrayFloor(arrayFloor);
        facade.createBuilding(b);
    }

    public ArrayList<Floor> getFloors(int BuildingID) throws DatasourceLayerException
    {
        return facade.getFloors(BuildingID);
    }

    public int getNewRepID() throws DatasourceLayerException
    {
        return facade.getNewRepID();
    }
    

    @Override
    public Report viewReport(int repID) throws DatasourceLayerException
    {
        Report r = facade.viewReport(repID);
        Building b = facade.getBuildingFromID(r.getBuildingID());
        r.addBuilding(b);
        Employee e = facade.getEmployeeFromEID(r.geteID());
        r.addEmployee(e);
        
        return r;
    }

}
