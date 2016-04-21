/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;

/**
 *
 * @author Lasse
 */
public class DM_Image
{

    public InputStream getImageAsStream(int buildingID)
    {

        try
        {
            String query = "SELECT Picture FROM Pictures WHERE BuildingID =" + buildingID + ";";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            if (res.next())
            {
                Blob blob = res.getBlob("Picture");
                InputStream is = blob.getBinaryStream();

                return is;

            }
        } catch (Exception ex)
        {
            System.out.println("ShowPicture - " + ex);
        }
        return null;
    }

}
