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
public class DM_ContactPerson {
    
    public void createContactPerson(ContactPerson cp) {
        
        String query = "INSERT INTO ContactPerson(CPFistName,CPLastName) VALUES('" + cp.getCPFirstName()
                + "','" + cp.getCPLastName() + "');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
}
