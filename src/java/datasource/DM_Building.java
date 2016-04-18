/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Floor;
import businesslogic.Building;
import businesslogic.ReportErrorException;
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
            
            int ID = getBuildingIDFromDB(b.getBuildingName(), b.getStreetName());
            createFloor(b.getFloors(), ID);
            
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
    
    public Building getBuildingFromID(int BuildingID) throws ReportErrorException
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
            throw new ReportErrorException("FEJL getBuildingFromID" + ex);
        }
        
    }
    
    
    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID) {
        
//       ArrayList<Building> building = getBuildingList();
//        int index = building.size()-1;
        try {
        for (int i = 0; i < arrayFloor.size(); i++) {
           String query = "INSERT INTO BFloor(BuildingID,Floor,SquareM) VALUES('"+ buildingID
                + "','" + arrayFloor.get(i).getFloor() + "','" + arrayFloor.get(i).getSquareM() + "');";
           DatabaseConnector db_Connect = DatabaseConnector.getInstance();
           db_Connect.updateData(query);
        }
        
        } catch(Exception ex) {
            System.out.println(""  + ex);
        }
        
        
    }
    
//    public ArrayList<Floor> getFloorListFromBuildingID(int buildingID) throws ReportErrorException
//    {
//        String query = "SELECT * FROM BFloor WHERE BuildingID ='"+buildingID+"';";
//        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
//        ResultSet res = db_Connect.getData(query);
//        ArrayList<Floor> floorList = new ArrayList();
//        try{
//        while(res.next())
//        {
//            Floor floor = new Floor(res.getInt(2),res.getInt(3),res.getDouble(4));
//            floorList.add(floor);
//        }
//        return floorList;
//        }catch(SQLException ex)
//        {
//            throw new ReportErrorException("get floorList: "+ex);
//        }
//    }
    
    public int getBuildingIDFromDB(String buildingName, String streetName) {
        
        
        String query = "SELECT BuildingID FROM PolygonGroup8.Buildings WHERE BuildingName ='"+ buildingName+"' AND StreetName='"+ streetName + "';";
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try
        {
            res.next();
            int buildingID = res.getInt(1);
            return buildingID;
        }
        catch(SQLException ex)
        {
            System.out.println("getBuildingFromID" + ex);
        }
        return 0;
    }
}
