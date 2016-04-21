/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Employee;
import businesslogic.DatasourceLayerException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author miaryvard
 */
public class DM_Employee
{

    public int getEID(String firstName, String lastName) throws DatasourceLayerException
    {
        try
        {
        String query = "SELECT EID FROM Employees WHERE EFirstName ='" + firstName + "' AND ELastName='" + lastName + "';";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        
            res.next();
            int eID = res.getInt(1);

            return eID;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("1FEJL getEmployeeFromEID" + ex);
        }
    }

    public Employee getEmployeeFromEID(int eID) throws DatasourceLayerException
    {
        try
        {
        String query = "SELECT * FROM PolygonGroup8.Employees WHERE EID ='" + eID + "';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        
            res.next();
            Employee employee = new Employee(res.getInt(1), res.getString(2), res.getString(3));
            
            return employee;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("2FEJL getEmployeeFromEID" + ex);
        }
    }

}
