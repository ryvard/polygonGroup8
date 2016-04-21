/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Employee;
import businesslogic.Report;
import datasource.DM_Building;
import datasource.DM_ContactPerson;
import datasource.DM_Customer;
import datasource.DM_Report;
import datasource.DM_Employee;
import businesslogic.Building;
import businesslogic.Customer;
import businesslogic.ContactPerson;
import businesslogic.Condition;
import businesslogic.Floor;
import businesslogic.DatasourceLayerException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miaryvard
 */
public class Facade implements IFacade
{

    DM_Building dm_building = new DM_Building();
    DM_Customer dm_customer = new DM_Customer();
    DM_ContactPerson dm_cp = new DM_ContactPerson();
    DM_Report dm_report = new DM_Report();
    DM_Employee dm_employee = new DM_Employee();

    @Override
    public void createBuilding(Building building)throws DatasourceLayerException
    {
        dm_building.createBuildingInDB(building);
    }

    @Override
    public void createCustomer(Customer customer)throws DatasourceLayerException
    {
        dm_customer.createCustomer(customer);
    }

    @Override
    public ArrayList<Building> getBuildingList()throws DatasourceLayerException
    {
        return dm_building.getBuildingList();
    }

    @Override
    public int createContactPerson(ContactPerson contactPerson)throws DatasourceLayerException
    {
        return dm_cp.createContactPerson(contactPerson);
    }

    @Override
    public ArrayList<ContactPerson> getContactPersonList()throws DatasourceLayerException
    {
        return dm_cp.getContactPersonList();
    }

    @Override
    public Building getBuildingFromID(int buildingID) throws DatasourceLayerException
    {
        return dm_building.getBuildingFromID(buildingID);
    }

    @Override
    public ArrayList<Condition> getConditions()throws DatasourceLayerException
    {
        return dm_report.getConditions();
    }

    @Override
    public void createContactPersonInfo(ContactPerson cp)throws DatasourceLayerException
    {
        dm_cp.createContactPersonInfo(cp);
    }

    @Override
    public int getCPID(String firstName, String lastName)throws DatasourceLayerException
    {
        return dm_cp.getCPID(firstName, lastName);
    }

    @Override
    public int getEID(String firstName, String lastName) throws DatasourceLayerException
    {
        return dm_employee.getEID(firstName, lastName);
    }

    @Override
    public Employee getEmployeeFromEID(int eID) throws DatasourceLayerException
    {
        return dm_employee.getEmployeeFromEID(eID);
    }

    //------
    @Override
    public void createReport(Report r) throws DatasourceLayerException
    {
        dm_report.createReport(r);
    }
    //-----

    @Override
    public ContactPerson getCPFromCPID(int CPID) throws DatasourceLayerException
    {
        return dm_cp.getCPFromCPID(CPID);
    }

    @Override
    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID)throws DatasourceLayerException
    {
        dm_building.createFloor(arrayFloor, buildingID);
    }

    @Override
    public int getBuildingIDFromDB(String buildingName, String streetName)throws DatasourceLayerException
    {
        return dm_building.getBuildingIDFromDB(buildingName, streetName);
    }

    @Override
    public ArrayList<Floor> getFloors(int BuildingID) throws DatasourceLayerException
    {
        return dm_building.getFloorListFromBuildingID(BuildingID);
    }

    @Override
    public ContactPerson getCP(int BuildingID) throws DatasourceLayerException
    {
        return dm_cp.getCPFromBuildingID(BuildingID);
    }

    @Override
    public int getNewRepID() throws DatasourceLayerException
    {
        return dm_report.getNewRepID();
    }

    @Override
    public Report viewReport(int repID) throws DatasourceLayerException
    {
        return dm_report.viewReport(repID);
    }

}
