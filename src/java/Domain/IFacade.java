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
    
    public String getCity(int zipcode);
   
}
