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
public class DM_Building
{
// djghdfjihsjdk
    public void createBuildingInDB(Building b)
    {
        System.out.println("DM_Building    -    " + b.getStreetName());
        String query = "INSERT INTO Buildings(BuildingName,StreetName,"
                + "StreetNumb,Zipcode,YearOfConst,SquareMeters,BuildingUse,CustID) "
                + "VALUES('" + b.getBuildingName() + "','" + b.getStreetName()
                + "','" + b.getStreetNumb() + "','" + b.getZipcode() +"','"
                + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" + b.getBuildingUse() + "','"+b.getCustID()+"');";

//      DATABASE TABLE BUILDINGS
//      BuildingID, BuildingName, StreetName, StreetNumb, Zipcode, Picture			
//      YearOfConst, SquareMeters, BuildingUse, CustID		   
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);

    }

    public ArrayList<Building> getBuildingList()
    {

        ArrayList<Building> buildings = new ArrayList();
        String query = "SELECT * FROM Buildings;";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);

        try
        {
            while (res.next())
            {
                Building building = new Building(res.getString(1), res.getString(2),
                        res.getString(3), res.getString(4), res.getInt(5),
                        res.getInt(6), res.getDouble(7), res.getString(8), res.getInt(9));
                buildings.add(building);

            }
            return buildings;

        } catch (SQLException ex)
        {
            System.out.println(ex);

        }
        return null;

    }

}
