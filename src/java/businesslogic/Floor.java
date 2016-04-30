package businesslogic;

/**
 *
 * @author emmablomsterberg
 */
public class Floor
{

    private int floorID;
    private int buildingID;
    private int floor;
    private double squareM;

    public Floor(int floorID, int buildingID, int floor, double squareM)
    {
        this.floorID = floorID;
        this.buildingID = buildingID;
        this.floor = floor;
        this.squareM = squareM;
    }

    public Floor(int floor, double squareM)
    {
        this.floor = floor;
        this.squareM = squareM;
    }

    public int getFloorID()
    {
        return floorID;
    }

    public void setFloorID(int floorID)
    {
        this.floorID = floorID;
    }

    public int getBuildingID()
    {
        return buildingID;
    }

    public int getFloor()
    {
        return floor;
    }

    public double getSquareM()
    {
        return squareM;
    }
}
