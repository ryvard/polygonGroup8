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
    public void createBuildingInDB(Building b)
    {
        try
        {
            String query = "INSERT INTO buildings(CustID,CPID,BuildingName,StreetName,"
                    + "StreetNumb,Zipcode,YearOfConst,SquareMeters,BuildingUse) "
                    + "VALUES('" + b.getCustID() + "','" + b.getCPID() + "','" + b.getBuildingName() + "','" + b.getStreetName()
                    + "','" + b.getStreetNumb() + "','" + b.getZipcode() + "','"
                    + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" + b.getBuildingUse() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (Exception ex)
        {
            System.out.println("createBuildingInDB - " + ex);
        }
    }

    public ArrayList<Building> getBuildingList()
    {
        ArrayList<Building> buildings = new ArrayList();
        String query = "SELECT * FROM buildings;";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);

        try
        {
            System.out.println("res er forskellig fra null: "+(res !=null));
            while (res.next())
            {
                Building building = new Building(res.getInt(1), res.getString(4), 
                        res.getString(5), res.getString(6), getCity(res.getInt(7)), 
                        res.getInt(7), res.getInt(8), res.getDouble(9), 
                        res.getString(10), res.getInt(2), res.getInt(3));
                buildings.add(building);
            }
            return buildings;
        } catch (SQLException ex)
        {
            System.out.println("getBuildingList - " + ex);
        }
        return null;
    }

    public String getCity(int zip)
    {
        String query = "SELECT * FROM Zipcodes WHERE Zipcode ='" + zip + "';";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try
        {
            res.next();
            String city = res.getString(2);
            return city;
        } catch (SQLException ex)
        {
            System.out.println("city - " + ex);
        }
        return null;
    }
    
    public Building getBuildingFromID(int BuildingID)
    {
        String query = "SELECT * FROM Buildings WHERE BuildingID ='"+ BuildingID +"';";
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try
        {
            res.next();
            Building building = new Building(res.getInt(1), res.getString(4), res.getString(5), res.getString(6), getCity(res.getInt(7)), res.getInt(7),res.getInt(8), res.getDouble(9), res.getString(10), res.getInt(2), res.getInt(3));
            return building;
        }
        catch(SQLException ex)
        {
            System.out.println("getBuildingFromID" + ex);
        }
        return null;
    }
}
