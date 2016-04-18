/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogic.Building;
import businesslogic.ContactPerson;
import businesslogic.Conclusion;
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
    
    private ArrayList<ReviewOf> reviewOf;
    
    private ArrayList<Conclusion> conclusions;
    
    private Employee employee;
    
    private ContactPerson contactPerson;
    
    private int condition;

    /*
    String roofNote;
    String outerWallNote;
    
    */

    public Report(int repID, String date, Building building, Employee employee)
    {
        this.repID = repID;
        this.date = date;
        this.building = building;
        this.employee = employee;
    }

    public Report(String date, Building building, Employee employee, int condition)
    {
        this.date = date;
        this.building = building;
        this.employee = employee;
        this.condition = condition;
    }
    

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
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

    public void setDate(String date)
    {
        this.date = date;
    }

    public Building getBuilding()
    {
        return building;
    }

    public void setBuilding(Building building)
    {
        this.building = building;
    }
     public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }
    
    
}
