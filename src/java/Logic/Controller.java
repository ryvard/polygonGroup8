/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Building;
import Domain.Facade;

/**
 *
 * @author miaryvard
 */
public class Controller implements IController
{
    Facade facade = new Facade();
    Building building;
  
    @Override
    public void createBuilding(String street, String streetNo, int zipcode, String city)
    {
        System.out.println("controller1  -   "+streetNo);
        building = new Building(street, streetNo, zipcode, city);
        facade.createBuilding(building);
        System.out.println("controller2");
    }
    
}
