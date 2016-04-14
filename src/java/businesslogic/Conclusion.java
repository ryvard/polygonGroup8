/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Conclusion
{
    int roomID;
    int repID;
    String recomendation;
    
    /**
     * Used when we whant to get conclusions from the DB
     */
    public Conclusion(int roomID, String recomendation)
    {
        this.roomID = roomID;
        this.recomendation = recomendation;
    }
    
    /**
     * 
     * Used when you want to insert a conclusion into the DB
     * @param roomID is auto generated in the database, a unic id for every conclusion
     */
    public Conclusion(int roomID, int repID, String recomendation)
    {
        this.roomID = roomID;
        this.repID = repID;
        this.recomendation = recomendation;
    }

    public int getRoomID()
    {
        return roomID;
    }

    public void setRoomID(int roomID)
    {
        this.roomID = roomID;
    }

    public int getRepID()
    {
        return repID;
    }

    public void setRepID(int repID)
    {
        this.repID = repID;
    }

    public String getRecomendation()
    {
        return recomendation;
    }

    public void setRecomendation(String recomendation)
    {
        this.recomendation = recomendation;
    }
    
    
    
}
