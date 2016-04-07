
package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseConnector
{
    private String DB_URL = "jdbc:mysql://localhost:3306/PolygonGroup8";
    private String USER = "root";
    private String PASS = "1234";

    private DatabaseConnector() {
        
    }
    private static DatabaseConnector dbCon_Instance;  
    public static DatabaseConnector getInstance() {
        if (dbCon_Instance == null) {
            
            dbCon_Instance = new DatabaseConnector(); 
        }
        return dbCon_Instance; 
    }
     
    public ResultSet getData(String query)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            
            return stmt.executeQuery(query);

        } catch (Exception ex)
        {
            
            System.out.println(ex.toString());
            return null;

        }

    }

    public void updateData(String query)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query);

        } catch (Exception ex)
        {
            System.out.println("!!!!!!!!!!!!!!!! connection FAIL");
            System.out.println("###########" +ex.toString());
        }

    }
}
