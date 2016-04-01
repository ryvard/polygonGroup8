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
public class DM_Customer {
    
    
    public void createCustomer(Customer cus) {
        
        String query = "INSERT INTO Customer(Type,StreetName,StreetNo,Zipcode,ContactName,Phone,Mail)"
                + "VALUES('"+cus.getType()+"','"+cus.getStreetName()+"','"+cus.getStreetNo()+"'.'"
                + cus.getZipcode()+"','"+cus.getPhone()+"','"+cus.getMail()+"');";
        
    DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
            
    }
}
