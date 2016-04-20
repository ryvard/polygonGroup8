/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class Building
{
    private int buildingID;
    private String buildingName;
    private String streetName;
    private String streetNumb;
    private String city;
    private int zipcode;
    //String Picture;
    private int YearOfConst;
    private double squareMeters;
    private String buildingUse;
    private int custID;
    private int CPID;
    private ArrayList<Floor> floors;
    private ContactPerson cp;

    
     
    /**
     * Cunstructor used when creating a Building
     */
    public Building(String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse, int custID, int CPID)
    {
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.streetNumb = streetNumb;
        this.city = city;
        this.zipcode = zipcode;
        this.YearOfConst = YearOfConst;
        this.squareMeters = squareMeters;
        this.buildingUse = buildingUse;
        this.custID = custID;
        this.CPID = CPID;
    }
    /**
     * Cunstructor used for list of buildings
     */
    public Building(int buildingID, String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse, int custID, int CPID)
    {
        this.buildingID = buildingID;
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.streetNumb = streetNumb;
        this.city = city;
        this.zipcode = zipcode;
        this.YearOfConst = YearOfConst;
        this.squareMeters = squareMeters;
        this.buildingUse = buildingUse;
        this.custID = custID;
        this.CPID = CPID;
    }

     public int getCPID()
    {
        return CPID;
    }

    public void setCPID(int CPID)
    {
        this.CPID = CPID;
    }
    
    public String getBuildingUse()
    {
        return buildingUse;
    }

    public void setBuildingUse(String buildingUse)
    {
        this.buildingUse = buildingUse;
    }
    
    public int getBuildingID()
    {
        return buildingID;
    }

    public void setBuildingID(int buildingID)
    {
        this.buildingID = buildingID;
    }

    public String getBuildingName()
    {
        return buildingName;
    }

    public void setBuildingName(String buildingName)
    {
        this.buildingName = buildingName;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public void setStreetName(String streetName)
    {
        this.streetName = streetName;
    }

    public String getStreetNumb()
    {
        return streetNumb;
    }

    public void setStreetNumb(String streetNumb)
    {
        this.streetNumb = streetNumb;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }

    public int getYearOfConst()
    {
        return YearOfConst;
    }

    public void setYearOfConst(int YearOfConst)
    {
        this.YearOfConst = YearOfConst;
    }

    public double getSquareMeters()
    {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters)
    {
        this.squareMeters = squareMeters;
    }

    public int getCustID()
    {
        return custID;
    }

    public void setCustID(int custID)
    {
        this.custID = custID;
    }

    public void addArrayFloor(ArrayList<Floor> arrayFloor)
    {
        floors = arrayFloor;
    }

    public ArrayList<Floor> getFloors()
    {
        return floors;
    }
    
    
    
    
    public void addCP(ContactPerson cp)
    {
        this.cp = cp;
    }
    
    public ContactPerson getCp()
    {
        return cp;
    }
//    
    
   
  
   
}
