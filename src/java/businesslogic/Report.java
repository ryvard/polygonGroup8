package businesslogic;

import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class Report
{
    private int repID;
    private int BuildingID;
    private int eID;
    private String date;
    private Building building;
    private int condition;
    
    private ArrayList<ReviewOf> outerReviews;
    private Employee employee;
    
    private ArrayList<Room> roomList; 
    private ArrayList<Damage> damageList;
    private ArrayList<ReviewOf> reviewList;
    private ArrayList<MoistScan> msList;
    private ArrayList<Conclusion> conclusionList;
    
    
    public Report(int BuildingID, int eID, String date, int condition)
    {
        this.BuildingID = BuildingID;
        this.eID = eID;
        this.date = date;
        this.condition = condition;
    }

    public Report(String date, int condition)
    {
        this.date = date;
        this.condition = condition;
    }
    
//    public Report(int repID, String date, Building building, Employee employee)
//    {
//        this.repID = repID;
//        this.date = date;
//        this.building = building;
//        this.employee = employee;
//    }
//
//    public Report(String date, Building building, Employee employee, int condition)
//    {
//        this.date = date;
//        this.building = building;
//        this.employee = employee;
//        this.condition = condition;
//    }
    

    public int geteID()
    {
        return eID;
    }
    
    public int getBuildingID()
    {
        return BuildingID;
    }

    
    public int getRepID()
    {
        return repID;
    }

    public void setRepID(int repID)
    {
        this.repID = repID;
    }

    public String getDate()
    {
        return date;
    }
    
     public int getCondition()
    {
        return condition;
    }

    public void addBuilding(Building building)
    {
        this.building = building;
    }
    public Building getBuilding()
    {
        return building;
    }
    
    public void addOuterReview(ArrayList<ReviewOf> outerReviews)
    {
        this.outerReviews = outerReviews;
    }
    
    public ArrayList<ReviewOf> getOuterReviews()
    {
        return outerReviews;
    }
    
    public void addEmployee(Employee employee)
    {
        this.employee = employee;
    }
    
    public Employee getEmployee()
    {
        return employee;
    }
    public void addDamageList(ArrayList<Damage> damageList)
    {
        this.damageList = damageList;
    }
    public ArrayList<Damage> getDamageList()
    {
        return damageList;
    }
    
    public void addReviewList(ArrayList<ReviewOf> reviewList)
    {
        this.reviewList = reviewList;
    }

    public ArrayList<ReviewOf> getReviewList()
    {
        return reviewList;
    }
    
    public void addMSList(ArrayList<MoistScan> msList)
    {
        this.msList = msList;
    }

    public ArrayList<MoistScan> getMsList()
    {
        return msList;
    }
    
     public void addConclusionList(ArrayList<Conclusion> conclusionList)
    {
        this.conclusionList = conclusionList;
    }

    public ArrayList<Conclusion> getConclusionList()
    {
        return conclusionList;
    }
    
    public void addRoomList(ArrayList<Room> roomList)
    {
        this.roomList = roomList;
    }

    public ArrayList<Room> getRoomList()
    {
        return roomList;
    }
}
