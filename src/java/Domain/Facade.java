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
public class Facade implements IFacade
{
    DM_Building dm_building = new DM_Building();
    DM_Customer dm_customer = new DM_Customer();
    DM_ContactPerson dm_cp = new DM_ContactPerson();
    DM_Report dm_report = new DM_Report();
    
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
}
