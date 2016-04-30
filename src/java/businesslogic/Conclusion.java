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
