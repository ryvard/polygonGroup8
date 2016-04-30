/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.DatasourceLayerException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emmablomsterberg
 */
public class DM_User
{

    public boolean login(String username, String password) //throws DatasourceLayerException
    {
        try
        {

            String query = "SELECT * FROM login WHERE User = '" + username + "' AND Passw = '" + password + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

                return res.next();
                
        } catch (SQLException ex)
        {
            System.out.println("hejhej");
            throw new DatasourceLayerException("Login failed - " + ex);
        }
        
    }
}
