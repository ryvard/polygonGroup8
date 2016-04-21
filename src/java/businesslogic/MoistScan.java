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
public class MoistScan
{
    private int bRoom;
    private int bFloor;
    private String msComplete;
    private String moistScan;
    private String measurePoint; 

    public MoistScan(int bRoom, int bFloor, String msComplete, String moistScan, String measurePoint)
    {
        this.bRoom = bRoom;
        this.bFloor = bFloor;
        this.msComplete = msComplete;
        this.moistScan = moistScan;
        this.measurePoint = measurePoint;
    }

    public int getbFloor()
    {
        return bFloor;
    }

    public void setbFloor(int bFloor)
    {
        this.bFloor = bFloor;
    }

    public int getbRoom()
    {
        return bRoom;
    }

    public void setbRoom(int bRoom)
    {
        this.bRoom = bRoom;
    }

    public String getMsComplete()
    {
        return msComplete;
    }

    public void setMsComplete(String msComplete)
    {
        this.msComplete = msComplete;
    }

    public String getMoistScan()
    {
        return moistScan;
    }

    public void setMoistScan(String moistScan)
    {
        this.moistScan = moistScan;
    }

    public String getMeasurePoint()
    {
        return measurePoint;
    }

    public void setMeasurePoint(String measurePoint)
    {
        this.measurePoint = measurePoint;
    }
    
}
