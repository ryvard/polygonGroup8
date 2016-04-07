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
public class ContactPerson {
    
    int cpID;
    String firstName;
    String lastName;
    
    /* Contructor for creating contactperson */
    
    public ContactPerson(String cpFirstName, String cpLastName) {
        
        this.firstName = cpFirstName;
        this.lastName = cpLastName;
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
