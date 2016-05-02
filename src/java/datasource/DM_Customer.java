/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.ContactPerson;
import businesslogic.Customer;
import businesslogic.DatasourceLayerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emmablomsterberg
 */
public class DM_Customer
{

    public void createCustomer(Customer cus) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO Customers(CustName, CustType,StreetName,StreetNumb,Zipcode)"
                    + "VALUES('" + cus.getCustName() + "','" + cus.getType() + "','" + cus.getStreetName() 
                    + "','" + cus.getStreetNo() + "','" + cus.getZipcode() + "');";
            
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("create customer - "+ex);
        }
        
    }
    
    public Customer getCustFromCustID(int custID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM PolygonGroup8.Customers WHERE CustID ='" + custID + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            Customer cust = new Customer(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));

            return cust;

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get Customer from custid - " + ex);
        }
        
    }
    
    public Customer getCustomer(Customer customer) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM PolygonGroup8.Customers WHERE CustName ='" + customer.getCustName() +"' AND StreetName ='" + customer.getStreetName() + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            Customer cus = new Customer(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getInt(6));

            return cus;

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get Customer from customer - " + ex);
        }
    }
}
