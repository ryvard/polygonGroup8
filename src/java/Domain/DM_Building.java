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
// djghdfjihsjdkh
    public void createBuildingInDB(Building b)
    {
        System.out.println("DM_Building    -    " + b.getStreetName());
        
        String query = "INSERT INTO Buildings(BuildingName,StreetName,"
                + "StreetNumb,Zipcode,Picture,YearOfConst,SquareMeters,BuildingUse,CustID) "
                + "VALUES('" + b.getBuildingName() + "','" + b.getStreetName()
                + "','" + b.getStreetNumb() + "','" + b.getZipcode() +  "','b','"
                + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" 
                + b.getBuildingUse() + "','"+ b.getCustID()+ "');";

//      DATABASE TABLE BUILDINGS
//      BuildingID, BuildingName, StreetName, StreetNumb, Zipcode, Picture			
//      YearOfConst, SquareMeters, BuildingUse, CustID		   
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);

    }

    public ArrayList<Building> getBuildingList()
    {
        System.out.println("DATA MAPPER  HEJ");

        ArrayList<Building> buildings = new ArrayList();
        String query = "SELECT * FROM Buildings;";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);

        try
        {
            while (res.next())
            {
                Building building = new Building(res.getInt(1), res.getString(2), 
                        res.getString(3), res.getString(4), getCity(res.getInt(5)), 
                        res.getInt(5), res.getInt(7), res.getDouble(8), res.getString(9), res.getInt(10));
                
//                Building building = new Building(res.getString(1), res.getString(2),
//                        res.getString(3), res.getString(4), res.getInt(5),
//                        res.getInt(6), res.getDouble(7), res.getString(8), res.getInt(9));
                
                buildings.add(building);
                
                System.out.println("arraylist str. !!!!!!  "+buildings.size());

            }
            return buildings;

        } catch (SQLException ex)
        {
            System.out.println("€€€€€€€€€€€€€€€%&€#   " + ex);

        }
        return null;

    }
    
    public String getCity(int zip)
    {
        String query = "SELECT * FROM City WHERE Zipcode ='" + zip + "';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try{
        String city = res.getString(2);
        return city;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return null;
        
    }

}
