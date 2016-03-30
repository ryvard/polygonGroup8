/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author miaryvard
 */
public class DM_Building
{
    DatabaseConnector con = new DatabaseConnector();
    
    public void createBuildingInDB(Building b)
    {
        String query = "INSERT INTO "
                + "VALUES('" + b.getStreet() + "','" + b.getStreetNo() + "','" 
                + b.getZipcode() + "','" + b.getCondition() + "','" 
                + b.getCustomerID() +"');";
        
        //kald metode i connectoren -- con.updateData(queryUpdate);
        
    }
    
    
}
