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

    /**
     * Used when creating a new moistScan in the report
     * @param bRoom
     * @param bFloor
     * @param msComplete
     * @param moistScan
     * @param measurePoint 
     */
    public MoistScan(int bRoom, int bFloor, String msComplete, String moistScan, String measurePoint)
    {
        this.bRoom = bRoom;
        this.bFloor = bFloor;
        this.msComplete = msComplete;
        this.moistScan = moistScan;
        this.measurePoint = measurePoint;
    }
    /**
     * Used when creating a moistScan that already exixt in the database(view report)
     * @param bRoom
     * @param msComplete
     * @param moistScan
     * @param measurePoint 
     */
    public MoistScan(int bRoom, String msComplete, String moistScan, String measurePoint)
    {
        this.bRoom = bRoom;
        this.msComplete = msComplete;
        this.moistScan = moistScan;
        this.measurePoint = measurePoint;
    }
    
    public int getbFloor()
    {
        return bFloor;
    }

    public int getbRoom()
    {
        return bRoom;
    }

    public String getMsComplete()
    {
        return msComplete;
    }

    public String getMoistScan()
    {
        return moistScan;
    }

    public String getMeasurePoint()
    {
        return measurePoint;
    }
}
