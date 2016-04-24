/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author emmablomsterberg
 */
public class Customer {
    
    private int custID;
    private String custName;
    private String type;
    private String streetName;
    private String streetNo;
    private int zipcode;
    private String contactName;
    private String phone;
    private String mail;
    // heh ehhr

    public Customer(String custName, String type, String streetName, String streetNo, int zipcode)
    {
        this.custName = custName;
        this.type = type;
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
        
    }
    
    public Customer(int custID, String custName, String type, String streetName, String streetNo, int zipcode) {
        this.custID = custID;
        this.custName = custName;
        this.type = type;
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
        
    }
    
   
    public int getCustID() 
    {
        return custID;
    }
    
    public void setCustID(int custID) 
    {
        this.custID = custID;
    }
    
    public String getCustName()
    {
        return custName;
    }

    public void setCustName(String custName)
    {
        this.custName = custName;
    }
     
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getStreetNo() {
        return streetNo;
    }
    
    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }
    
    public int getZipcode() {
        return zipcode;
    }
    
    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
    
   
    
}
