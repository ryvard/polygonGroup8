/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author miaryvard
 */
public class DM_Employee
{
    public int getEID(String firstName, String lastName)
    {
        String query = "SELECT EID FROM PolygonGroup8.Employees WHERE EFirstName ='"+ firstName+"' AND ELastName='"+ lastName + "';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try {
            res.next();
            int eID = res.getInt(1);
            
        return eID;
        
        } catch(SQLException ex) {
            System.out.println("FEJL GetEID " + ex);
        }
        return 0;
    }
    
}
