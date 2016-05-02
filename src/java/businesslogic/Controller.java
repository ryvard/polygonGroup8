package businesslogic;

import datasource.Facade;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author miaryvard
 */
public class Controller implements IController
{

    Facade facade = new Facade();

    @Override
    public ArrayList<Building> getBuildingList() throws DatasourceLayerException
    {
        return facade.getBuildingList();
    }

    @Override
    public void createBuilding(Building b, ArrayList<Floor> arrayFloor, int custID, int cpID) throws DatasourceLayerException
    {
        b.addCust(facade.getCustFromCustID(custID));
        b.addCP(facade.getCPFromCPID(cpID));
        b.addArrayFloor(arrayFloor);
        facade.createBuilding(b);
    }

    @Override
    public Building getBuildingFromID(int buildingID) throws DatasourceLayerException
    {
        ContactPerson c = facade.getCP(buildingID);
        Building b = facade.getBuildingFromID(buildingID);
        b.addCP(c);
        return b;
    }

    @Override
    public int getBuildingIDFromDB(String buildingName, String streetName) throws DatasourceLayerException
    {
        return facade.getBuildingIDFromDB(buildingName, streetName);
    }

    @Override
    public ArrayList<Floor> getFloors(int BuildingID) throws DatasourceLayerException
    {
        return facade.getFloors(BuildingID);
    }

    @Override
    public void createCustomer(String name, String type, String streetName, String streetNo, int zipcode) throws DatasourceLayerException
    {
        Customer customer = new Customer(name, type, streetName, streetNo, zipcode);
        facade.createCustomer(customer);
    }

    @Override
    public int createContactPerson(String cpFirstName, String cpLastName, String email, String phone) throws DatasourceLayerException
    {
        ContactPerson cp = new ContactPerson(cpFirstName, cpLastName, email, phone);
        return facade.createContactPerson(cp);
    }

    @Override
    public void createContactPersonInfo(String firstName, String lastName, String mail, String phone) throws DatasourceLayerException
    {
        ContactPerson cp = new ContactPerson(firstName, lastName, mail, phone);
        facade.createContactPersonInfo(cp);
    }

    @Override
    public void createReport(int buildingID, Report r, ArrayList<ReviewOf> outerReviews,
            Employee employee, ArrayList<Room> roomList, ArrayList<Damage> damageList, ArrayList<ReviewOf> reviewList,
            ArrayList<MoistScan> msList, ArrayList<Conclusion> conclusionList) throws DatasourceLayerException
    {
        Building building = getBuildingFromID(buildingID);
        r.addBuilding(building);
        r.addOuterReview(outerReviews);
        employee.seteID(facade.getEID(employee.getFirstName(), employee.getLastName()));
        r.addEmployee(employee);

        r.addRoomList(roomList);
        r.addDamageList(damageList);
        r.addReviewList(reviewList);
        r.addMSList(msList);
        r.addConclusionList(conclusionList);

        facade.createReport(r);
    }

    @Override
    public ArrayList<Condition> getConditions() throws DatasourceLayerException
    {
        return facade.getConditions();
    }

    @Override
    public int getNewRepID() throws DatasourceLayerException
    {
        return facade.getNewRepID();
    }

    @Override
    public Report viewReport(int repID) throws DatasourceLayerException
    {
        Report r = facade.viewReport(repID);
        Building b = facade.getBuildingFromID(r.getBuildingID());
        System.out.println("hej"+ r.getBuildingID());
        System.out.println("hej : "+ facade.getCPFromCPID(b.getCP().getCPID()));
        ContactPerson c = facade.getCPFromCPID(b.getCP().getCPID());
        b.addCP(c);
        r.addBuilding(b);
        Employee e = facade.getEmployeeFromEID(r.geteID());
        r.addEmployee(e);

        return r;
    }

    @Override
    public boolean login(User u)
    {
         return facade.login(u);
    }

    @Override
    public void uploadPicture(InputStream is, long size, Building building) 
    {
        facade.uploadPicture(is, size, building);
    }
    
    @Override
    public Customer getCustomer(Customer cust) throws DatasourceLayerException {
        return facade.getCustomer(cust);
    }
//    @Override
//    public Customer getCustFromCustID(int custID) throws DatasourceLayerException {
//         return facade.getCustFromCustID(custID);
//    }
//    @Override
//    public void createBuilding(String buildingName, String streetName, String streetNumb, String city, int zipcode, int yearOfConst, double squareMeters, String buildingUse, int custID, int CPID)throws DatasourceLayerException
//    {
//        System.out.println("controller1  -   " + streetNumb);
//
//        Building building = new Building(buildingName, streetName, streetNumb,
//                city, zipcode, yearOfConst, squareMeters, buildingUse, custID, CPID);
//
//        System.out.println("hejhej ");
//
//        facade.createBuilding(building);
//
//        System.out.println("controller2");
//
//    }
    //    @Override
//    public ContactPerson getCPFromCPID(int CPID)throws DatasourceLayerException
//    {
//        return facade.getCPFromCPID(CPID);
//    }
    //--------------------------------------------------------------
//    @Override
//    public void createFloor(ArrayList<Floor> arrayFloor, int buildingID)throws DatasourceLayerException
//    {
//        facade.createFloor(arrayFloor, buildingID);
//    }
//    // ikke brugt
//    @Override
//    public int getCPID(String firstName, String lastName)throws DatasourceLayerException
//    {
//        return facade.getCPID(firstName, lastName);
//    }
    //--------------------------------------------------------------
//    @Override
//    public ArrayList<ContactPerson> getContactPersonList()throws DatasourceLayerException
//    {
//        return facade.getContactPersonList();
//    }

    

}
