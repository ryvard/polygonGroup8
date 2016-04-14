/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Customer;

/**
 *
 * @author emmablomsterberg
 */
public class DM_Customer
{

    public void createCustomer(Customer cus)
    {
        String query = "INSERT INTO Customers(CustName, CustType,StreetName,StreetNumb,Zipcode)"
                + "VALUES('" + cus.getCustName() + "','" + cus.getType() + "','" + cus.getStreetName() + "','"
                + cus.getStreetNo() + "','" + cus.getZipcode() + "');";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
}
