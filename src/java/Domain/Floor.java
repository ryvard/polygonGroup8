/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author emmablomsterberg
 */
public class Floor {
    
    int buildingID;
    int floor;
    double squareM; 
    
    public Floor(int bID, int fID, double squareM) {
        this.buildingID = bID;
        this.floor = fID;
        this.squareM = squareM;
    }
    
    public int getBuildingID() {
        return buildingID;
    }
    
    public void setBuildingID(int bID) {
        this.buildingID = bID;
    }
    
    public int getFloor() {
        return floor;
    }
    
    public void setFloor(int fID) {
        this.floor = fID;
    } 
    
    public double getSquareM() {
        return squareM;
    }
    
    public void setSquareM(int squareM) {
        this.squareM = squareM;
    }
}
