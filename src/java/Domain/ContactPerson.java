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
    
    int ID;
    String firstName;
    String lastName;
    
    public ContactPerson(int cpID, String cpFirstName, String cpLastName) {
        
        this.ID = cpID;
        this.firstName = cpFirstName;
        this.lastName = cpLastName;
    }
    
    public int getCPID() {
        return ID;
    }
    
    public void setCPID(int cpID) {
        this.ID = cpID;
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
}
