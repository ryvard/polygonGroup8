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
        
        String query = "INSERT INTO buildings(CustID,CPID,BuildingName,StreetName,"
                + "StreetNumb,Zipcode,YearOfConst,SquareMeters,BuildingUse) "
                + "VALUES('" + b.getCustID() + "','" + b.getCPID() + "','" + b.getBuildingName() + "','" + b.getStreetName()
                + "','" + b.getStreetNumb() + "','" + b.getZipcode() +"','"
                + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" + b.getBuildingUse() + "');";

        
                       
//   1 BuildingID		INT(20) NOT NULL AUTO_INCREMENT, 
//   2 CustID                    INT(20),
//   3 CPID			INT(20),
//   4 BuildingName              VARCHAR(50),
//     5 StreetName		VARCHAR(50), 
//     6 StreetNumb		VARCHAR(10),
//     7 Zipcode                 INT(4), 
//    8 YearOfConst		DATE,
//    9 SquareMeters              DECIMAL(8,2),
//    10 BuildingUse		VARCHAR(50),
                
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);

    }

    public ArrayList<Building> getBuildingList()
    {
        ArrayList<Building> buildings = new ArrayList();
        String query = "SELECT * FROM buildings;";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);

        try
        {
            // Lav natural join til Zipcodes og hent city der fremfor ekstra metode
            while (res.next())
            {
                Building building = new Building(res.getInt(1), res.getString(4),res.getString(5), res.getString(6), getCity(res.getInt(7)), res.getInt(7), res.getInt(8), res.getDouble(9), res.getString(10), res.getInt(2), res.getInt(3));
        
                buildings.add(building);
                
                System.out.println("1- building id"+ res.getInt(1));
                
                System.out.println("-------------------arraylist str. !!!!!!  "+buildings.size());

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
        String query = "SELECT * FROM Zipcodes WHERE Zipcode ='" + zip + "';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try{
        res.next();
        String city = res.getString(2);
            System.out.println("city " + city);
        return city;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return null;
        
    }

}
