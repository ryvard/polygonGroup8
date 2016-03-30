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

    @Override
    public void createBuilding(Building building)
    {
        facade.createBuilding(building);
    }
    
}
