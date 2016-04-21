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
    private int bRoom;
    private int bFloor;

    public int getbFloor()
    {
        return bFloor;
    }

    public void setbFloor(int bFloor)
    {
        this.bFloor = bFloor;
    }
    private String recommendation;

    public Conclusion(int bRoom,int bFloor, String recommendation)
    {
        this.bRoom = bRoom;
        this.bFloor = bFloor;
        this.recommendation = recommendation;
    }

    public int getbRoom()
    {
        return bRoom;
    }

    public void setbRoom(int bRoom)
    {
        this.bRoom = bRoom;
    }

    public String getRecommendation()
    {
        return recommendation;
    }

    public void setRecommendation(String recommendation)
    {
        this.recommendation = recommendation;
    }
    
    
    
    
}
