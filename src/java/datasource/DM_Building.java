/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Floor;
import businesslogic.Building;
import businesslogic.ContactPerson;
import businesslogic.Customer;
import businesslogic.DatasourceLayerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class DM_Building
{

    public void createBuildingInDB(Building b) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO buildings(CustID,CPID,BuildingName,StreetName,"
                    + "StreetNumb,Zipcode,YearOfConst,SquareMeters,BuildingUse) "
                    + "VALUES('" + b.getCust().getCustID() + "','" + b.getCP().getCPID() + "','" + b.getBuildingName() + "','" + b.getStreetName()
                    + "','" + b.getStreetNumb() + "','" + b.getZipcode() + "','"
                    + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" + b.getBuildingUse() + "');";
            
             String query2 = "INSERT INTO CustomerCP(CPID,CustID) VALUES('"+ b.getCP().getCPID() +"','" + b.getCust().getCustID() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
            
            db_Connect.updateData(query2);

            int ID = getBuildingIDFromDB(b.getBuildingName(), b.getStreetName());
            createFloor(b.getFloors(), ID);

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("create building - " + ex);
        }
    }

    public ArrayList<Building> getBuildingList() throws DatasourceLayerException
    {
        try
        {
            ArrayList<Building> buildings = new ArrayList();
            String query = "SELECT * FROM buildings;";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            
            while (res.next())
            {
                Building building = new Building(res.getInt(1), res.getString(4),
                        res.getString(5), res.getString(6), getCity(res.getInt(7)),
                        res.getInt(7), res.getInt(8), res.getDouble(9),
                        res.getString(10));
                Customer cust = new Customer(res.getInt(2));
                ContactPerson cp = new ContactPerson(res.getInt(3));
                building.addCust(cust);
                building.addCP(cp);
                buildings.add(building);
                
            }
            return buildings;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get building list - " + ex);
        }

    }
    

    public String getCity(int zip) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM Zipcodes WHERE Zipcode ='" + zip + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            String city = res.getString(2);
            return city;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get city - " + ex);
        }

    }

    public Building getBuildingFromID(int BuildingID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM Buildings WHERE BuildingID ='" + BuildingID + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            Building building = new Building(res.getInt(1), res.getString(4), res.getString(5), res.getString(6), getCity(res.getInt(7)), res.getInt(7), res.getInt(8), res.getDouble(9), res.getString(10));
            return building;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("Get Building From ID - " + ex);
        }

    }

    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID) throws DatasourceLayerException
    {
        try
        {
            for (int i = 0; i < arrayFloor.size(); i++)
            {
                String query = "INSERT INTO BFloor(BuildingID,Floor,SquareM) VALUES('" + buildingID
                        + "','" + arrayFloor.get(i).getFloor() + "','" + arrayFloor.get(i).getSquareM() + "');";
                DatabaseConnector db_Connect = DatabaseConnector.getInstance();
                db_Connect.updateData(query);
            }

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("create floor - " + ex);
        }
    }

    public ArrayList<Floor> getFloorListFromBuildingID(int buildingID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM BFloor WHERE BuildingID ='" + buildingID + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            ArrayList<Floor> floorList = new ArrayList();

            while (res.next())
            {
                Floor floor = new Floor(res.getInt(1), res.getInt(2), res.getInt(3), res.getDouble(4));
                floorList.add(floor);
            }
            return floorList;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get floorList - " + ex);
        }
    }

    public int getBuildingIDFromDB(String buildingName, String streetName) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT BuildingID FROM PolygonGroup8.Buildings WHERE BuildingName ='" + buildingName + "' AND StreetName='" + streetName + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            int buildingID = res.getInt(1);
            return buildingID;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get building id - " + ex);
        }
    }
    
    public Building getBulding(String buildingName, String streetName) throws DatasourceLayerException {
        try {
       String query = "SELECT * FROM PolygonGroup8.Buildings WHERE BuildingName ='" + buildingName + "' AND StreetName='" + streetName + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            Building building = new Building(res.getInt(1), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getInt(8), res.getInt(9), res.getDouble(10), res.getString(11), (Customer) res.getObject(2), (ContactPerson) res.getObject(3));
            return building;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get building id - " + ex);
        }
    }

}
