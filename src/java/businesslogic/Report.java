/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogic.Building;
import businesslogic.ContactPerson;

import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class Report
{
    private int repID;
    
    private String date;
    private Building building;
    private int condition;
    
    private ArrayList<ReviewOf> outerReviews;
    private Employee employee;
    
    
    private ArrayList<Damage> damageList;
    private ArrayList<ReviewOf> reviewList;
    private ArrayList<MoistScan> msList;
    private ArrayList<Conclusion> conclusionList;
    
    
    
    
    
    
    //private ContactPerson contactPerson;
    
    
    

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

    public void setDate(String date)
    {
        this.date = date;
    }

    
     public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }
    
    //-------
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
    
    
    
}
