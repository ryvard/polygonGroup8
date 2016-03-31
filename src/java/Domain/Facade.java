/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author miaryvard
 */
public class Facade
{
    DM_Building dm_building = new DM_Building();
    DM_Customer dm_customer = new DM_Customer();
    
    public void createBuilding(Building building)
    {
        dm_building.createBuildingInDB(building);
    }
    
    public void createCustomer(Customer customer) 
    {
        dm_customer.createCustomer(customer);
    }
}
