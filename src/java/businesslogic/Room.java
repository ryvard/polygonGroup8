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
public class Room
{
    int floor;
    int room;
    int roomID;

    public int getRoomID()
    {
        return roomID;
    }

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

    public int getFloor()
    {
        return floor;
    }

    public void setFloor(int floor)
    {
        this.floor = floor;
    }

    public int getRoom()
    {
        return room;
    }

    public void setRoom(int room)
    {
        this.room = room;
    }
    
}
