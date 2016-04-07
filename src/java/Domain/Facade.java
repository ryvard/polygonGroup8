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
        System.out.println("facade");
        return dm_building.getBuildingList();
    }

    @Override
    public String getCity(int zipcode)
    {
        dm_building.getCity(zipcode);
    }
}
