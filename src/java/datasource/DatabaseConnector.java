package datasource;

import businesslogic.DatasourceLayerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector
{

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/PolygonGroup8";
    private static final String USER = "root";
    private static final String PASS = "1234";
    private static Connection con;

    private DatabaseConnector() throws SQLException
    {
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

    public static DatabaseConnector getInstance() throws SQLException
    {
        if (dbCon_Instance == null)
        {
            dbCon_Instance = new DatabaseConnector();
        }
        return dbCon_Instance;
    }

    public static Connection getConnection() throws SQLException, DatasourceLayerException
    {
        if (con == null)
        {
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
                throw new DatasourceLayerException("PROGRAMMET VIRKER IKKE: " + ex);
            }
            con = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        return con;
    }

    public ResultSet getData(String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        return stmt.executeQuery(query);
    }

    public void updateData(String query) throws SQLException
    {
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
    }
}
