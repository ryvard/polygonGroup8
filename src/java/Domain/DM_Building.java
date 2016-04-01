/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class DM_Building {

    public void createBuildingInDB(Building b) {
        System.out.println("DM_Building    -    " + b.getStreet());
        String query = "INSERT INTO Buildings(StreetName,StreetNumb,Zipcode)"
                + "VALUES('" + b.getStreet() + "','" + b.getStreetNo() + "','"
                + b.getZipcode() + "');";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);

    }

    public ArrayList<Building> getBuildingList() {

        
        ArrayList<Building> buildings = new ArrayList();
        String query = "SELECT * FROM Buildings;";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        
        try {
            while (res.next()) {
                Building building = new Building(res.getInt(1), res.getString(2),
                        res.getString(3), res.getInt(4), res.getString(5),
                        res.getInt(6), res.getInt(7));
                buildings.add(building);

            }

        } catch (SQLException ex) {
            System.out.println(ex);

        }
        return null;

        //return buildings;
    }

}
