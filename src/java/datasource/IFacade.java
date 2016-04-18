/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Employee;
import businesslogic.Report;
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
public interface IFacade
{
    public void createBuilding(Building building);
    
    public void createCustomer(Customer customer);
    
    public ArrayList<Building> getBuildingList(); 
    
    public int createContactPerson(ContactPerson contactPerson);
    
    public ArrayList<ContactPerson> getContactPersonList();
    
    public Building getBuildingFromID(int buildingID) throws ReportErrorException;
    
    public Report viewReport();
    
    public ArrayList<Condition> getConditions();
   
    public void createContactPersonInfo(ContactPerson cp);
    
    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID);
    
    public int getBuildingIDFromDB(String buildingName, String streetName);
    
    
    // MIA used for create report
    public int getCPID(String firstName, String lastName);
    
    public int getEID(String firstName, String lastName) throws ReportErrorException;
    
    public Employee getEmployeeFromEID(int eID) throws ReportErrorException;
    
    public void createReport(Report r) throws ReportErrorException;
    
    public ContactPerson getCPFromCPID(int CPID);
}
