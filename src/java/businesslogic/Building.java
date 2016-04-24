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
    private Customer cust;
   
    private ArrayList<Floor> floors;
    private ContactPerson cp;

    
     
    /**
     * Cunstructor used when creating a Building
     */
    
    public Building(String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse, Customer cust, ContactPerson cp)
    {
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.streetNumb = streetNumb;
        this.city = city;
        this.zipcode = zipcode;
        this.YearOfConst = YearOfConst;
        this.squareMeters = squareMeters;
        this.buildingUse = buildingUse;
        this.cust = cust;
        this.cp = cp;
    }
    /**
     * Cunstructor used for list of buildings
     */
    public Building(int buildingID, String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse, Customer cust, ContactPerson cp)
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
        this.cust = cust;
        this.cp = cp;
    }
    
    public Building(String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse) {
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.streetNumb = streetNumb;
        this.city = city;
        this.zipcode = zipcode;
        this.YearOfConst = YearOfConst;
        this.squareMeters = squareMeters;
        this.buildingUse = buildingUse;
    }

    public Building(int buildingID, String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse) {
        this.buildingID = buildingID;
        this.buildingName = buildingName;
        this.streetName = streetName;
        this.streetNumb = streetNumb;
        this.city = city;
        this.zipcode = zipcode;
        this.YearOfConst = yearOfConst;
        this.squareMeters = squareMeters;
        this.buildingUse = buildingUse;
    }

     public ContactPerson getCP()
    {
        return cp;
    }

    public void setCP(ContactPerson cp)
    {
        this.cp = cp;
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

    public void setCustID(Customer cust)
    {
        this.cust = cust;
    }

    public void addArrayFloor(ArrayList<Floor> arrayFloor)
    {
        floors = arrayFloor;
    }

    public ArrayList<Floor> getFloors()
    {
        return floors;
    }
    
    public void addCust(Customer cust) 
    {
        this.cust = cust;
    }
    
    public Customer getCust()
    {
        return cust;
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
