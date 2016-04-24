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
public class ContactPerson {
    
    private int cpID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    
    /* Contructor for creating contactperson */
    
    public ContactPerson(String cpFirstName, String cpLastName, String email, String phone)
    {
        this.firstName = cpFirstName;
        this.lastName = cpLastName;
        this.email = email;
        this.phone = phone;
    }
    
    
    public String getCPFirstName() {
        return firstName;
    }
    
    public void setCPFirstName(String cpFirstName) {
        this.firstName = cpFirstName;
    }
    
    public String getCPLastName() {
        return lastName;
    }
    
    public void setCPLastName(String cpLastName) {
        this.lastName = cpLastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /* Constructor for displaying contactperson */
    
    public ContactPerson(int cpID, String cpFirstName, String cpLastName) {
        this.cpID = cpID;
        this.firstName = cpFirstName;
        this.lastName = cpLastName;
    }
    
    public int getCPID() {
        return cpID;
    }
    
    public void setCPID(int cpID) {
        this.cpID = cpID;
    }
    
}
