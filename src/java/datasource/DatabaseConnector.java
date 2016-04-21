
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnector
{
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/PolygonGroup8";
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static Connection con;
    private DatabaseConnector() throws SQLException {
        try
            {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            con = DriverManager.getConnection(DB_URL, USER, PASS);
    }
    private static DatabaseConnector dbCon_Instance;  
    public static DatabaseConnector getInstance() throws SQLException {
        if (dbCon_Instance == null) {
            dbCon_Instance = new DatabaseConnector(); 
            
        }
        return dbCon_Instance; 
    }
    public static Connection getConnection() throws SQLException
    {

        if (con == null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        return con;
    }
     
    public ResultSet getData(String query)
    {
        try
        {
            
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
            
            Statement stmt = con.createStatement();
            
            stmt.executeUpdate(query);

        } catch (Exception ex)
        {
            System.out.println("!!!!!!!!!!!!!!!! connection FAIL");
            System.out.println("###########" +ex.toString());
        }

    }
}
