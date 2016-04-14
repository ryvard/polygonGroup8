/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

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
    
    public Building getBuildingFromID(int buildingID);
    
    public Report viewReport();
    
    public ArrayList<Condition> getConditions();
   
    public void createContactPersonInfo(ContactPerson cp);
    
    
    // MIA used for create report
    public int getCPID(String firstName, String lastName);
    
    public int getEID(String firstName, String lastName);
    
    public Employee getEmployeeFromEID(int eID);
    
    public void createReportInDB(Report r);
    
    public ContactPerson getCPFromCPID(int CPID);
}
