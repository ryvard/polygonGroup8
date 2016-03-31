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
    //DatabaseConnector con = new DatabaseConnector();
    
    public void createBuildingInDB(Building b)
    {
        System.out.println("DM_Building    -    " + b.getStreet());
        String query = "INSERT INTO Buildings(StreetName,StreetNumb,Zipcode)"
                + "VALUES('" + b.getStreet() + "','" + b.getStreetNo() + "','" 
                + b.getZipcode() + "');";
        
       // con.updateData(query);
    }
    
}
