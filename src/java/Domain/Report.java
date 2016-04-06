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
    
    
    /*
    String roofNote;
    String outerWallNote;
    ArrayList<Conclusion> conclusions;
    */

    public Report(int repID, String date, Building building)
    {
        this.repID = repID;
        this.date = date;
        this.building = building;
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
