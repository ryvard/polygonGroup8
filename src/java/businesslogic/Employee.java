/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Employee
{
    int eID;
    String firstName;
    String lastName;
    //int phone;
    //String Mail;

    /**
     * Constructor used when creating an employee in the DB, (create report)
     * @param firstName
     * @param lastName 
     */
    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Constructor used to get an employee out of the DB
     * @param eID
     * @param firstName
     * @param lastName 
     */
    public Employee(int eID, String firstName, String lastName)
    {
        this.eID = eID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int geteID()
    {
        return eID;
    }

    public void seteID(int eID)
    {
        this.eID = eID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    
    
    
    
}
