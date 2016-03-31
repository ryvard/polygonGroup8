/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author emmablomsterberg
 */
public class Customer {
    
    String type;
    String streetName;
    String streetNo;
    int zipcode;
    String contactName;
    String phone;
    String mail;
  
    public Customer(String type, String streetName, String streetNo, int zipcode, String contactName, String phone, String mail) {
        
        this.type = type;
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
        this.contactName = contactName;
        this.phone = phone;
        this.mail = mail;
        
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
    
    public String getContactName() {
        return contactName;
    }
    
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
