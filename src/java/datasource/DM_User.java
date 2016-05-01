/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.DatasourceLayerException;
import businesslogic.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmablomsterberg
 */
public class DM_User
{

    public boolean login(User u) 
    {
        try {
            System.out.println("login user " + u.getUserName());
            String query = "SELECT * FROM Login WHERE User = '" + u.getUserName() + "' AND Passw = '" + u.getPassword()+ "';";
           
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);         
        
            return res.next();
        } catch (SQLException ex) {
            
           
        }
        
        return false;
    }
}
