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
    int floorID;
    double squareM; 
    
    public Floor(int bID, int fID, double squareM) {
        this.buildingID = bID;
        this.floorID = fID;
        this.squareM = squareM;
    }
    
    public int getBuildingID() {
        return buildingID;
    }
    
    public void setBuildingID(int bID) {
        this.buildingID = bID;
    }
    
    public int getFloorID() {
        return floorID;
    }
    
    public void setFloorID(int fID) {
        this.floorID = fID;
    } 
    
    public double getSquareM() {
        return squareM;
    }
    
    public void setSquareM(int squareM) {
        this.squareM = squareM;
    }
}
