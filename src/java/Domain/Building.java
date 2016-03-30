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
    String street;
    String streetNo;
    String city;
    int zipcode;
    int condition;
    int customerID;
    
    
//Cunstructor used when createBuilding 
    public Building(String street, String streetNo, int zipcode, String city)
    {
        this.street = street;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
        this.city = city;
    }
    
    public Building(String street, String streetNo, int zipcode, String city, int condition, int customerID)
    {
        this.street = street;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
        this.city = city;
        this.condition = condition;
        this.customerID = customerID;
    }

    

    public int getCustomerID()
    {
        return customerID;
    }

    public void setCustomerID(int customerID)
    {
        this.customerID = customerID;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getStreetNo()
    {
        return streetNo;
    }

    public void setStreetNo(String streetNo)
    {
        this.streetNo = streetNo;
    }

    public int getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }
    
    
}
