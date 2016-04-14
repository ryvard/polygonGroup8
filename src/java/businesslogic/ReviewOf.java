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
public class ReviewOf
{
    int ReviewID;
    int roomID;
    int repID;
    String part;
    String note;

    public ReviewOf(int ReviewID, int roomID, int repID, String part, String note)
    {
        this.ReviewID = ReviewID;
        this.roomID = roomID;
        this.repID = repID;
        this.part = part;
        this.note = note;
    }

    public int getReviewID()
    {
        return ReviewID;
    }

    public void setReviewID(int ReviewID)
    {
        this.ReviewID = ReviewID;
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

    public String getPart()
    {
        return part;
    }

    public void setPart(String part)
    {
        this.part = part;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
    
    
    
}
