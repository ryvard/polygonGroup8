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
    
    public void createBuildingInDB(Building b)
    {
        System.out.println("DM_Building    -    " + b.getStreetName());
        String query = "INSERT INTO Buildings(BuildingName,StreetName,"
                + "StreetNumb,Zipcode.YearOfConst,SquareMeters,BuildingUse) "
                + "VALUES('"+ b.getBuildingName() + "','" + b.getStreetName() 
                + "','" + b.getStreetNumb() + "','" + b.getZipcode() 
                + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" + b.getBuildingUse()+"');";
        
//      DATABASE TABLE BUILDINGS
//      BuildingID, BuildingName, StreetName, StreetNumb, Zipcode, Picture			
//      YearOfConst, SquareMeters, BuildingUse, CustID		   

     DatabaseConnector db_Connect = DatabaseConnector.getInstance();
       db_Connect.updateData(query);

    }
    
    
    
}


