/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businesslogic;

import businesslogic.Building;
import businesslogic.Condition;
import businesslogic.ContactPerson;
import businesslogic.Customer;
import businesslogic.Employee;
import businesslogic.Report;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public interface IController
{
    /**
     * This method is used to create a new customer.
     * @param name
     * @param type
     * @param streetName
     * @param streetNo
     * @param zipcode
     * @throws DatasourceLayerException
     */
    public void createCustomer(String name, String type, String streetName, String streetNo, int zipcode) throws DatasourceLayerException;    
    
    /**
     * This method is used to get a list of all the buildings stored inside the database.
     * When this method is called it returns an ArrayList of building-objects.
     * @return ArrayList.
     * @throws DatasourceLayerException 
     */
    public ArrayList<Building> getBuildingList() throws DatasourceLayerException;

    
    /**
     * This method returns a building stored in the database when given the matching int building ID.
     * @param buildingID
     * @return Building
     * @throws DatasourceLayerException 
     */
    public Building getBuildingFromID(int buildingID) throws DatasourceLayerException;
    
    /**
     * This method is used to create a contactperson. When the contactperson is created and stored in the database it returns an int with the contactperson ID (cpID)
     * @param cpFirstName
     * @param cpLastName
     * @param mail
     * @param phone
     * @return int (cpID)
     * @throws DatasourceLayerException 
     */
    public int createContactPerson(String cpFirstName, String cpLastName, String mail, String phone) throws DatasourceLayerException;

    /**
     * This method is used to create a contactperson.
     * @param firstName
     * @param lastName
     * @param mail
     * @param phone
     * @throws DatasourceLayerException 
     */
    public void createContactPersonInfo(String firstName, String lastName, String mail, String phone) throws DatasourceLayerException;

    /**
     * This method is used to get a list of premade conditions stored in the database. When this method is called it returns all the state of conditions a building can be defined as.
     * @return ArrayList
     * @throws DatasourceLayerException
     */
    public ArrayList<Condition> getConditions() throws DatasourceLayerException;

    /**
     * This method is used to get the buildingID of a building. When this method is called it returns an int with the building ID from the database.
     * @param buildingName
     * @param streetName
     * @return int (buildingID)
     * @throws DatasourceLayerException 
     */
    public int getBuildingIDFromDB(String buildingName, String streetName) throws DatasourceLayerException;

    /**
     * This method is used to create a report 
     * @param buildingID
     * @param r
     * @param outerReviews
     * @param employee
     * @param roomList
     * @param damageList
     * @param reviewList
     * @param msList
     * @param conclusionList
     * @throws DatasourceLayerException 
     */
    public void createReport(int buildingID, Report r, ArrayList<ReviewOf> outerReviews,
            Employee employee, ArrayList<Room> roomList, ArrayList<Damage> damageList, ArrayList<ReviewOf> reviewList,
            ArrayList<MoistScan> msList, ArrayList<Conclusion> conclusionList) throws DatasourceLayerException;

    //public ContactPerson getCPFromCPID(int CPID) throws DatasourceLayerException;

    public Report viewReport(int repID) throws DatasourceLayerException;

    public boolean login(String userName, String password) throws DatasourceLayerException;

    public void createBuilding(Building b, ArrayList<Floor> arrayFloor, int custID, int cpID) throws DatasourceLayerException;

    public ArrayList<Floor> getFloors(int BuildingID) throws DatasourceLayerException;

    //public Customer getCustFromCustID(int custID) throws DatasourceLayerException;

    public int getNewRepID() throws DatasourceLayerException;

    //Udkommenteret metoder
    //public void createBuilding(String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse, int custID, int CPID)throws DatasourceLayerException;
    //public void createReport(String reportNumber, String date, int squareMeter, String buildingUseability, String roof, String roofPicture, String outerwalls, String outerwallsPicture, Object conclusion, String reviewedBy, String collaboration, int condition);
    //public ArrayList<ContactPerson> getContactPersonList()throws DatasourceLayerException;
    //public void createFloor(ArrayList<Floor> arrayFloor, int buildingID)throws DatasourceLayerException;
    //public int getCPID(String firstName, String lastName)throws DatasourceLayerException;
}
