/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Building;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lasse
 */
public class DM_Image
{

    public void uploadPicture(InputStream is, long size, Building building)
    {
        try
        {
            byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) != -1)
                    {
                        System.out.println("writing " + length + " bytes");
                    }
            String query = "INSERT INTO picture(BuildingID,Picture) VALUES(?,?)";
            System.out.println("Made the SQL statement");
//            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
//            db_Connect.updateData(query);
            PreparedStatement pstmt = DatabaseConnector.getConnection().prepareStatement(query);
            pstmt.setInt(1, building.getBuildingID());
            pstmt.setBinaryStream(2, is, size);
            pstmt.executeUpdate();
        } catch (Exception ex)
        {
            System.out.println("UploadPicture - " + ex);
        }
    }

//    public List<Integer> getAllPictureId(int buildingID) throws SQLException
//    {
//        List<Integer> ids = new ArrayList();
//        String query = "SELECT PictureID FROM Picture WHERE BuildingID ='" + buildingID + "';";
//
//        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
//        ResultSet res = db_Connect.getData(query);
//        while (res.next())
//        {
//            int id = res.getInt("PictureID");
//            ids.add(id);
//        }
//        return ids;
//    }

    public InputStream getImageAsStream(int buildingID)
    {

        try
        {
            String query = "SELECT Picture FROM Picture WHERE BuildingID =" + buildingID + ";";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            if (res.next())
            {
                Blob blob = res.getBlob("Picture");
                InputStream is = blob.getBinaryStream();
                System.out.println("I Got The Picture!!!");
                return is;

            }
        } catch (Exception ex)
        {
            System.out.println("ShowPicture - " + ex);
        }
        System.out.println("OBS! Der er intet billede!");
        return null;
    }

}
