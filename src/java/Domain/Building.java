/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author miaryvard
 */
public class Building
{
    int buildingID;
    String buildingName;
    String streetName;
    String streetNumb;
    String city;
    int zipcode;
    //String Picture;
    int YearOfConst;
    double squareMeters;
    String buildingUse;
    int custID;
    
//Cunstructor used when creating a Building FIRST VERSION
    public Building(String streetName, String streetNumb, int zipcode, String city)
    {
        this.streetName = streetName;
        this.streetNumb = streetNumb;
        this.zipcode = zipcode;
        this.city = city;
    }
    
   /**Cunstructor used when creating a Building SECOND VERSION*/
    public Building(String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse, int custID)
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
    }
   
   //Cunstructor used for list of buildings
    public Building(int buildingID, String buildingName, String streetName, String streetNumb, String city, int zipcode, int YearOfConst, double squareMeters, String buildingUse, int custID)
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
   
   
}