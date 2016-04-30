package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Conclusion
{
    private int bRoom;
    private int bFloor;
    private String recommendation;

    /**
     * Constructor for conclusion of room condition, used for both create and view report 
     * @param bRoom
     * @param bFloor
     * @param recommendation 
     */
    public Conclusion(int bRoom, int bFloor, String recommendation)
    {
        this.bRoom = bRoom;
        this.bFloor = bFloor;
        this.recommendation = recommendation;
    }

    public int getbFloor()
    {
        return bFloor;
    }

    public int getbRoom()
    {
        return bRoom;
    }

    public String getRecommendation()
    {
        return recommendation;
    }
}
