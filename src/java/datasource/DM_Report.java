/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Report;
import businesslogic.Condition;
import businesslogic.Damage;
import businesslogic.ReportErrorException;
import businesslogic.ReviewOf;
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
    public void createReport(Report r)throws ReportErrorException
    {
        try
        {
            System.out.println("************  Halløj DM report  **************");
            insertDataInReportTable(r);
            
            //??????
            int repID = getRepID(r);
            r.setRepID(repID);
            //---
            
            int numberOfOuterReviews = r.getOuterReviews().size()-1;
            for(int i = 0; i<= numberOfOuterReviews; i++)
                insertOuterReview(r, i);
            System.out.println("*** Efter outside review: " + numberOfOuterReviews);
            
            int numberOfRooms = r.getRoomList().size()-1;
            for(int i = 0; i <= numberOfRooms;i++)
                insertRooms(r, i);
            System.out.println("*** Efter room: " + numberOfRooms);
            
            int numberOfDamage = r.getDamageList().size()-1;
            for(int i = 0; i<= numberOfDamage;i++)
                 insertDamage(r,i);
            System.out.println("*** Efter damage: " + numberOfDamage);
            
            
            int numberOfReviews = r.getReviewList().size()-1;
            for(int i = 0; i <= numberOfReviews;i++)
                insertReview(r, i);
            System.out.println("*** Efter review" + numberOfReviews);
            
            int numberOfMS = r.getMsList().size()-1;
            for(int i = 0; i <= numberOfMS; i++)
                insertMoistScan(r, i);
            System.out.println("*** Efter Moist: "+ numberOfMS);
            
            int numberOfConclusions = r.getConclusionList().size()-1;
            for(int i = 0; i <= numberOfConclusions;i++)
                insertConclusion(r, i);
            System.out.println("*** Efter Conclusion: "+ numberOfMS);
            
        } catch (ReportErrorException ex)
        {
            throw new ReportErrorException("create report: " + ex);
        }
        
    }
    
    
    private void insertDataInReportTable(Report r)
    {
        String query = "INSERT INTO Report(BuildingID, EID, RDate, BCondition)"
                + "VALUES('"+ r.getBuilding().getBuildingID()+"','"
                + r.getEmployee().geteID() +"','" + r.getDate() +"','"
                + r.getCondition() +"');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertOuterReview(Report r, int i)
    {
        String query = "INSERT INTO OuterReviewOf(RepID, Part, Note) "
                + "VALUES('"+r.getRepID()+"','"+r.getOuterReviews().get(i).getPart()+"','"+
                r.getOuterReviews().get(i).getNote()+"')";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertRooms(Report r, int i)
    {
        String query = "INSERT INTO Room(Room, BFloorID) "
                + "VALUES('"+r.getRoomList().get(i).getRoom()+"','"+
                r.getRoomList().get(i).getFloor()+"');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertDamage(Report r, int i)
    {
        String query = "INSERT INTO Damage(RoomID, RepID, DamageInRoom, DWhen, DWhere, DWhat, Repaired, DamageType, OtherDamage) "
                + "VALUES('"+r.getDamageList().get(i).getbRoom()+"','"+r.getRepID()+"','"+
                r.getDamageList().get(i).getDamageInRoom()+"','"+r.getDamageList().get(i).getWhen()+"','"+
                r.getDamageList().get(i).getWhere()+"','"+r.getDamageList().get(i).getWhat()+"','"+
                r.getDamageList().get(i).getRepaired()+"','"+r.getDamageList().get(i).getDamage()+"','"+
                r.getDamageList().get(i).getOtherDamage()+"');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertReview(Report r, int i)
    {
        String query = "INSERT INTO ReviewOf(RoomID, RepID, Part, Note)  "
                + "VALUES('"+r.getReviewList().get(i).getRoomID()+"','"+r.getRepID()+"','"+r.getReviewList().get(i).getPart()+"','"+r.getReviewList().get(i).getNote()+"');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertMoistScan(Report r, int i)
    {
        String query = "INSERT INTO MoistScan(RoomID,RepID,MSComplete, MSNote, MeasurePoint)"
                + "VALUES('"+r.getMsList().get(i).getbRoom()+"','"+r.getRepID()+"','"+
                r.getMsList().get(i).getMsComplete()+"','"+r.getMsList().get(i).getMoistScan()+"','"+
                r.getMsList().get(i).getMeasurePoint()+"');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertConclusion(Report r, int i)
    {
        String query = "INSERT INTO Conclusion(RepID, RoomID, Recommendation) "
                + "VALUES('"+r.getRepID()+"','"+r.getConclusionList().get(i).getbRoom()+"','"+
                r.getConclusionList().get(i).getRecommendation()+"');";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
      
    //--------------------------------------------------
//    private void insertEmployee(Report r)
//    {
//        String query = "INSERT INTO Employees(EFirstName, ELastName) "
//                + "VALUES('"+ r.getEmployee().getFirstName() +"','"
//                + r.getEmployee().getLastName()+"')";
//    }
    
    private int getRepID(Report r) throws ReportErrorException
    {
        String query = "SELECT RepID FROM Report "
                + "WHERE BuildingID = '" + r.getBuilding().getBuildingID()
                + "' AND RDate = '"+r.getDate()+"';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try
        {
            res.next();
            int repID = res.getInt(1);

            return repID;
        } catch (SQLException ex)
        {
            throw new ReportErrorException("1FEJL get repID" + ex);
        }
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
                //reports.addArrayFloor(report);
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
            }
            return conditions;
        } catch (SQLException ex)
        {
            System.out.println("getCondition sql ex: " + ex);
        }
        return null;
    }
    public int getNewRepID() throws ReportErrorException
    {
        String query = "SELECT COUNT(RepID) From Report";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        ResultSet res = db_Connect.getData(query);
        try
        {
            res.next();
            int repID = res.getInt(1)+1;
            return repID;
        } catch (SQLException ex)
        {
            throw new ReportErrorException("getNEWRepID");
        }
    }
    
    
}
