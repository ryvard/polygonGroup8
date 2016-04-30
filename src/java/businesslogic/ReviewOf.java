package businesslogic;

/**
 *
 * @author miaryvard
 */
public class ReviewOf
{
    private int roomID;
    private int floorID;
    private String part;
    private String note;

    /**
     * Constructor used for outer reviews
     * @param part
     * @param note 
     */
    public ReviewOf(String part, String note)
    {
        this.part = part;
        this.note = note;
    }
    /**
     * Constructor used for view report
     * @param roomID
     * @param part
     * @param note 
     */
    public ReviewOf(int roomID, String part, String note)
    {
        this.roomID = roomID;
        this.part = part;
        this.note = note;
    }
    
    /**
     * Constructor used when creating a review for a room
     * @param roomID
     * @param floorID
     * @param part
     * @param note 
     */
    public ReviewOf(int roomID, int floorID, String part, String note)
    {
        this.roomID = roomID;
        this.floorID = floorID;
        this.part = part;
        this.note = note;
    }

    public int getFloorID()
    {
        return floorID;
    }

    public int getRoomID()
    {
        return roomID;
    }

    public String getPart()
    {
        return part;
    }

    public String getNote()
    {
        return note;
    }
}
