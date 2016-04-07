/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class Report
{
    int repID;
    
    String date;
    
    Building building;
    
   
    
    ArrayList<Conclusion> conclusions;
    
    Employee employee;
    
    ContactPerson contactPerson;
    
    int condition;

    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }
    
    
    
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
   
    
}
