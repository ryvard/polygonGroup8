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
import businesslogic.ReportErrorException;
import java.util.ArrayList;

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
    public void createBuilding(Building building)
    {
        dm_building.createBuildingInDB(building);
    }
    
    @Override
    public void createCustomer(Customer customer) 
    {
        dm_customer.createCustomer(customer);
    }

    @Override
    public ArrayList<Building> getBuildingList()
    {
        return dm_building.getBuildingList();
    }

    @Override
    public int createContactPerson(ContactPerson contactPerson) {
        return dm_cp.createContactPerson(contactPerson);
    }

    @Override
    public ArrayList<ContactPerson> getContactPersonList() {
        return dm_cp.getContactPersonList();
    }

    @Override
    public Building getBuildingFromID(int buildingID)
    {
        return dm_building.getBuildingFromID(buildingID);
    }
    
    @Override
    public Report viewReport()
    {
        return null;
    }

    @Override
    public ArrayList<Condition> getConditions()
    {
        return dm_report.getConditions();
    }
    
    @Override
    public void createContactPersonInfo(ContactPerson cp) {
        dm_cp.createContactPersonInfo(cp);
    } 

    @Override
    public int getCPID(String firstName, String lastName)
    {
        return dm_cp.getCPID(firstName, lastName);
    }

    @Override
    public int getEID(String firstName, String lastName)
    {
        return dm_employee.getEID(firstName, lastName);
    }

    
    @Override
    public Employee getEmployeeFromEID(int eID) throws ReportErrorException
    {
        return dm_employee.getEmployeeFromEID(eID);
    }

    @Override
    public void createReportInDB(Report r)
    {
        dm_report.createReportInDB(r);
    }

    @Override
    public ContactPerson getCPFromCPID(int CPID)
    {
       return dm_cp.getCPFromCPID(CPID);
    }

    @Override
    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID) {
         dm_building.createFloor(arrayFloor, buildingID);
    }
 
}
