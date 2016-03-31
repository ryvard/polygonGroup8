/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Domain.Building;

/**
 *
 * @author miaryvard
 */
public interface IController
{
    /**
     * Called when you submit your new building.
     */
        public void createBuilding(String street, String StreetNo, int zipcode, String city);
}
