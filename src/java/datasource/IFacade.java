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
import businesslogic.DatasourceLayerException;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public interface IFacade
{
    public void createBuilding(Building building)throws DatasourceLayerException;
    
    public void createCustomer(Customer customer)throws DatasourceLayerException;
    
    public ArrayList<Building> getBuildingList()throws DatasourceLayerException; 
    
    public int createContactPerson(ContactPerson contactPerson)throws DatasourceLayerException;
    
    public ArrayList<ContactPerson> getContactPersonList()throws DatasourceLayerException;
    
    public Building getBuildingFromID(int buildingID) throws DatasourceLayerException;
    
    public ArrayList<Condition> getConditions()throws DatasourceLayerException;
   
    public void createContactPersonInfo(ContactPerson cp)throws DatasourceLayerException;
    
    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID)throws DatasourceLayerException;
    
    public int getBuildingIDFromDB(String buildingName, String streetName)throws DatasourceLayerException;
    
    
    // MIA used for create report
    public int getCPID(String firstName, String lastName)throws DatasourceLayerException;
    
    public int getEID(String firstName, String lastName) throws DatasourceLayerException;
    
    public Employee getEmployeeFromEID(int eID) throws DatasourceLayerException;
    
    public void createReport(Report r) throws DatasourceLayerException;
    
    public ContactPerson getCPFromCPID(int CPID)throws DatasourceLayerException;
    
    public ArrayList<Floor> getFloors(int BuildingID) throws DatasourceLayerException;
    
    public ContactPerson getCP(int BuildingID) throws DatasourceLayerException;
    
    public int getNewRepID() throws DatasourceLayerException;
    
    public Report viewReport(int repID) throws DatasourceLayerException;
    
    public boolean login(String userName, String password);
    
    public Customer getCustFromCustID(int custID) throws DatasourceLayerException;
    
}
