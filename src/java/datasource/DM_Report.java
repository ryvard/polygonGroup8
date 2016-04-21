/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.Building;
import businesslogic.Conclusion;
import businesslogic.Report;
import businesslogic.Condition;
import businesslogic.Damage;
import businesslogic.MoistScan;
import businesslogic.DatasourceLayerException;
import businesslogic.ReviewOf;
import businesslogic.Room;
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

    public void createReport(Report r) throws DatasourceLayerException
    {
        System.out.println("************  Halløj DM report  **************");
        insertDataInReportTable(r);

        //??????
        int repID = getRepID(r);
        r.setRepID(repID);
        //---

        int numberOfOuterReviews = r.getOuterReviews().size() - 1;
        for (int i = 0; i <= numberOfOuterReviews; i++)
        {
            insertOuterReview(r, i);
        }
        System.out.println("*** Efter outside review: " + numberOfOuterReviews);

        int numberOfRooms = r.getRoomList().size() - 1;
        for (int i = 0; i <= numberOfRooms; i++)
        {
            insertRooms(r, i);
        }
        System.out.println("*** Efter room: " + numberOfRooms);

        int numberOfDamage = r.getDamageList().size() - 1;
        for (int i = 0; i <= numberOfDamage; i++)
        {
            insertDamage(r, i);
        }
        System.out.println("*** Efter damage: " + numberOfDamage);

        int numberOfReviews = r.getReviewList().size() - 1;
        for (int i = 0; i <= numberOfReviews; i++)
        {
            insertReview(r, i);
        }
        System.out.println("*** Efter review" + numberOfReviews);

        int numberOfMS = r.getMsList().size() - 1;
        for (int i = 0; i <= numberOfMS; i++)
        {
            insertMoistScan(r, i);
        }
        System.out.println("*** Efter Moist: " + numberOfMS);

        int numberOfConclusions = r.getConclusionList().size() - 1;
        for (int i = 0; i <= numberOfConclusions; i++)
        {
            insertConclusion(r, i);
        }
        System.out.println("*** Efter Conclusion: " + numberOfMS);
    }

    private void insertDataInReportTable(Report r) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO Report(BuildingID, EID, RDate, BCondition)"
                    + "VALUES('" + r.getBuilding().getBuildingID() + "','"
                    + r.getEmployee().geteID() + "','" + r.getDate() + "','"
                    + r.getCondition() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("insertInReportTable" + ex);
        }
    }

    private void insertOuterReview(Report r, int i) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO OuterReviewOf(RepID, Part, Note) "
                    + "VALUES('" + r.getRepID() + "','" + r.getOuterReviews().get(i).getPart() + "','"
                    + r.getOuterReviews().get(i).getNote() + "')";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("insertOuterReview " + ex);
        }
    }

    private void insertRooms(Report r, int i) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO Room(Room, BFloorID) "
                    + "VALUES('" + r.getRoomList().get(i).getRoom() + "','"
                    + r.getRoomList().get(i).getFloor() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("insertRooms: " + ex);
        }
    }

    private void insertDamage(Report r, int i) throws DatasourceLayerException
    {

        try
        {
            System.out.println("flor: " + r.getRoomList().get(i).getFloor() + "' AND Room = '" + r.getRoomList().get(i).getRoom() + "';");
            System.out.println("get id in damage:" + getRoomID(r.getRoomList().get(i).getRoom(), r.getRoomList().get(i).getFloor()));

            String query = "INSERT INTO Damage(RoomID, RepID, DamageInRoom, DWhen, DWhere, DWhat, Repaired, DamageType, OtherDamage)"
                    + "VALUES('" + getRoomID(r.getDamageList().get(i).getbRoom(), r.getDamageList().get(i).getbFloorID()) + "','"
                    + r.getRepID() + "','"
                    + r.getDamageList().get(i).getDamageInRoom() + "','" + r.getDamageList().get(i).getWhen() + "','"
                    + r.getDamageList().get(i).getWhere() + "','" + r.getDamageList().get(i).getWhat() + "','"
                    + r.getDamageList().get(i).getRepaired() + "','" + r.getDamageList().get(i).getDamage() + "','"
                    + r.getDamageList().get(i).getOtherDamage() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("Insert Damage" + ex);
        }
    }

    private int getRoomID(int room, int floorID) throws DatasourceLayerException
    {
        try
        {
            System.out.println("room: " + room + " floor: " + floorID);
            String query = "SELECT RoomID FROM Room WHERE BFloorID = '" + floorID + "' AND Room = '" + room + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            int roomID = res.getInt(1);
            return roomID;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get roomID" + ex);
        }
    }

    private void insertReview(Report r, int i) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO ReviewOf(RoomID, RepID, Part, Note)"
                    + "VALUES('" + getRoomID(r.getReviewList().get(i).getRoomID(), r.getReviewList().get(i).getFloorID()) + "','"
                    + r.getRepID() + "','" + r.getReviewList().get(i).getPart() + "','"
                    + r.getReviewList().get(i).getNote() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);

        } catch (DatasourceLayerException ex)
        {
            throw new DatasourceLayerException("InsertMoist" + ex);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("hejhej2" + ex);
        }
    }

    private void insertMoistScan(Report r, int i) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO MoistScan(RoomID,RepID,MSComplete, MSNote, MeasurePoint)"
                    + "VALUES('" + getRoomID(r.getMsList().get(i).getbRoom(), r.getMsList().get(i).getbFloor()) + "','" + r.getRepID() + "','"
                    + r.getMsList().get(i).getMsComplete() + "','" + r.getMsList().get(i).getMoistScan() + "','"
                    + r.getMsList().get(i).getMeasurePoint() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("insertMoist " + ex);
        }
    }

    private void insertConclusion(Report r, int i) throws DatasourceLayerException
    {
        try
        {
            String query = "INSERT INTO Conclusion(RepID, RoomID, Recommendation) "
                    + "VALUES('" + r.getRepID() + "','" + getRoomID(r.getConclusionList().get(i).getbRoom(), r.getConclusionList().get(i).getbFloor()) + "','"
                    + r.getConclusionList().get(i).getRecommendation() + "');";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("insertConclusion " + ex);
        }
    }

    private int getRepID(Report r) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT RepID FROM Report "
                    + "WHERE BuildingID = '" + r.getBuilding().getBuildingID()
                    + "' AND RDate = '" + r.getDate() + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            int repID = res.getInt(1);

            return repID;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get repID" + ex);
        }
    }

    public int getNewRepID() throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT COUNT(RepID) From Report";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            int repID = res.getInt(1) + 1;
            return repID;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("getNEWRepID" + ex);
        }
    }

    public ArrayList<Condition> getConditions() throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM BuildCondition;";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            ArrayList<Condition> conditions = new ArrayList();
            while (res.next())
            {
                Condition condition = new Condition(res.getInt(1), res.getString(2), res.getString(3));
                conditions.add(condition);
            }
            return conditions;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("getConditions" + ex);
        }

    }

    public Report viewReport(int repID) throws DatasourceLayerException
    {
        try
        {
            Report r = getReportTableData(repID);

            ArrayList<ReviewOf> outerReviewList = getOuterReviewList(repID);
            r.addOuterReview(outerReviewList);

            ArrayList<Room> roomList = getRoomList(repID);
            r.addRoomList(roomList);

            ArrayList<Damage> damageList = getDamageList(repID);
            r.addDamageList(damageList);

            ArrayList<ReviewOf> reviewList = getReviewList(repID);
            r.addReviewList(reviewList);

            ArrayList<MoistScan> msList = getMSList(repID);
            r.addMSList(msList);
            
            return r;
        } catch (DatasourceLayerException ex)
        {
            throw new DatasourceLayerException("View Report - " + ex);
        }
    }

    private Report getReportTableData(int repID) throws DatasourceLayerException
    {
        System.out.println("repID til get report" + repID);
        String query = "SELECT BuildingID,EID,RDate,BCondition FROM Report WHERE RepID ='" + repID + "';";
        try
        {
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            Report r = new Report(res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4));

            return r;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get report" + ex);
        }
    }

    private ArrayList<ReviewOf> getOuterReviewList(int repID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT Part,Note FROM OuterReviewOf WHERE RepID = '" + repID + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            ArrayList<ReviewOf> outerReviews = new ArrayList();

            while (res.next())
            {
                ReviewOf outerReview = new ReviewOf(res.getString(1), res.getString(2));
                outerReviews.add(outerReview);
            }

            return outerReviews;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get outer review" + ex);
        }

    }

    private ArrayList<Room> getRoomList(int repID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT floor, Room, RoomID FROM Report natural join Buildings "
                    + "natural join BFloor natural join Room where RepID='" + repID + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            ArrayList<Room> rooms = new ArrayList();

            while (res.next())
            {
                Room room = new Room(res.getInt(1), res.getInt(2), res.getInt(3));

                rooms.add(room);
            }

            return rooms;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get rooms" + ex);
        }

    }

    private ArrayList<Damage> getDamageList(int repID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT RoomID,DamageInRoom, DWhen, DWhere, DWhat, Repaired, DamageType, OtherDamage FROM Damage where RepID='" + repID + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            ArrayList<Damage> damageList = new ArrayList();

            while (res.next())
            {
                Damage damage = new Damage(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));

                damageList.add(damage);
            }

            return damageList;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get damage" + ex);
        }
    }

    private ArrayList<ReviewOf> getReviewList(int repID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT RoomID,Part,Note FROM ReviewOf WHERE RepID='"+repID+"';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            
            ArrayList<ReviewOf> reviewList = new ArrayList();

            while (res.next())
            {
                
                ReviewOf review = new ReviewOf(res.getInt(1), res.getString(2), res.getString(3));
                System.out.println("hej get review #€#€#€#€#€#€#€ "+ review.getNote());
                reviewList.add(review);
            }

            return reviewList;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get review" + ex);
        }
    }

    private ArrayList<MoistScan> getMSList(int repID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT RoomID, MSComplete, MSNote, MeasurePoint FROM MoistScan WHERE RepID='"+repID+"';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);
            ArrayList<MoistScan> msList = new ArrayList();

            while (res.next())
            {
                MoistScan ms = new MoistScan(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
                msList.add(ms);
            }

            return msList;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get ms list" + ex);
        }
    }

    
}
