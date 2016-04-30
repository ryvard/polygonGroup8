package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Room
{
    private int floor;
    private int room;
    private int roomID;

    public Room(int floor, int room, int roomID)
    {
        this.floor = floor;
        this.room = room;
        this.roomID = roomID;
    }

    public Room(int floor, int room)
    {
        this.floor = floor;
        this.room = room;
    }

    public int getRoomID()
    {
        return roomID;
    }

    public int getFloor()
    {
        return floor;
    }

    public int getRoom()
    {
        return room;
    }
}
