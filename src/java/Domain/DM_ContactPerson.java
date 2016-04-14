/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author emmablomsterberg
 */
public class DM_ContactPerson {
    
    public int createContactPerson(ContactPerson cp) {
        
        try {
        
        String query = "INSERT INTO ContactPerson(CPFirstName,CPLastName) VALUES('" + cp.getCPFirstName()
                + "','" + cp.getCPLastName() + "');";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
        
        } catch(Exception e) {
            System.out.println("FEJL" + e);
        }
        
        int cpID = getCPID(cp.getCPFirstName(), cp.getCPLastName());
        
        return cpID;
    }
    
    public void createContactPersonInfo(ContactPerson cp) {
        try {
            
            String queryEmail = "INSERT INTO CPMail(CPID,CPMail) VALUES('" + getCPID(cp.getCPFirstName(),cp.getCPLastName())
                    + "','" + cp.getEmail() +"');";
            
            String queryPhone = "INSERT INTO CPPhone(CPID,CPPhone) VALUES('" + getCPID(cp.getCPFirstName(), cp.getCPLastName())
                    + "','" + cp.getPhone() +"');";
            
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(queryEmail);
            db_Connect.updateData(queryPhone);
            
        } catch(Exception e) {
            System.out.println("" + e);
        }
    }
    
    public ArrayList<ContactPerson> getContactPersonList() {
        
        ArrayList<ContactPerson> contactPerson = new ArrayList();
        
        String query = "SELECT * FROM ContactPerson;";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);

        try
        {
            while (res.next())
            {
                ContactPerson cp = new ContactPerson(res.getInt(1), res.getString(2), res.getString(3));
                
                contactPerson.add(cp);
                
            }
            return contactPerson;
            
        } catch (SQLException ex)
        {
            System.out.println("€€€€€€€€€€€€€€€%&€#   " + ex);

        }
        return null;
    }
    
    public int getCPID(String firstName, String lastName) {
        
        String query = "SELECT CPID FROM PolygonGroup8.ContactPerson WHERE CPFirstName ='"+ firstName+"' AND CPLastName='"+ lastName + "';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try {
            res.next();
            int cpID = res.getInt("CPID");
            
        return cpID;
        
        } catch(SQLException ex) {
            System.out.println("FEJL GetCPID " + ex);
        }
        return 0;
        
    }
    
    public ContactPerson getCPFromCPID(int cpID)
    {
        String query = "SELECT * FROM PolygonGroup8.ContactPerson WHERE CPID ='"+ cpID+"';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try {
            res.next();
            ContactPerson cp = new ContactPerson(res.getInt(1), res.getString(2), res.getString(3));
            
        return cp;
        
        } catch(SQLException ex) {
            System.out.println("FEJL GetCPFromCPID " + ex);
        }
        return null;
    }
    
    
   
    
}
