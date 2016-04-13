/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miaryvard
 */
public class DM_Report
{
    public void createReportInDB(Report r)
    {
        insertDataInReportTable(r);
    }
    
    
    private void insertDataInReportTable(Report r)
    {
        String query = "INSERT INTO Report(BuildingID, EID, RDate, BCondition)"
                + "VALUES('"+ r.getBuilding().getBuildingID()+"','"
                + r.getEmployee().geteID() +"','" + r.getDate() +"','"
                + r.getCondition() +"')";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertDamage(Report r)
    {
        String query = "INSERT INTO  VALUES";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertReview(Report r)
    {
        String query = "INSERT INTO(RoomID, RepID, Part, Note)  "
                + "VALUES()";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertMoistScan(Report r)
    {
        String query = "INSERT INTO MoistScan(RoomID,RepID,MSComplete) "
                + "VALUES()";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertConclusion(Report r)
    {
        String query = "INSERT INTO Conclusion(RepID, RoomID, Recomendation) VALUES";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
      
    private void insertEmployee(Report r)
    {
        String query = "INSERT INTO Employees(EFirstName, ELastName) "
                + "VALUES('"+ r.getEmployee().getFirstName() +"','"
                + r.getEmployee().lastName+"')";
    }
    
    private void getRepID(Report r)
    {
        String query = "SELECT RepID FROM Report "
                + "WHERE BuildingID = '" + r.getBuilding().buildingID 
                + "' AND RDate = '"+r.getDate()+"';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    public ArrayList<Report> viewReport()
    {
        ArrayList<Report> reports = new ArrayList();
        String query = "SELECT * FROM report;";

        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);

        try
        {
            System.out.println("res er forskellig fra null: "+(res !=null));
            while (res.next())
            {
                //Report report = new Report(res.getInt(1), res.getString(4), 
                //        res.getString(5), res.getString(6), (res.getInt(7)), 
                //        res.getInt(7), res.getInt(8), res.getDouble(9), 
                //        res.getString(10), res.getInt(2), res.getInt(3));
                //reports.add(report);
            }
            return reports;
        } catch (SQLException ex)
        {
            System.out.println("viewReport - " + ex);
        }
        return null;
    }
    
    public ArrayList<Condition> getConditions()
    {
        String query = "SELECT * FROM BuildCondition;";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        ArrayList<Condition> conditions = new ArrayList();
        try
        {
            while(res.next())
            {
                Condition condition = new Condition(res.getInt(1), res.getString(2), res.getString(3));
                conditions.add(condition);
                return conditions;
            }
        } catch (SQLException ex)
        {
            System.out.println("getCondition sql ex: " + ex);
        }
        return null;
    }
    
    
}
