/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author miaryvard
 */
public class DM_Report
{
    public void createReportInDB(Report r)
    {
        insertDataInReportTable();
//                "INSERT INTO Buildings(CustID,CPID,BuildingName,StreetName,"
//                + "StreetNumb,Zipcode,YearOfConst,SquareMeters,BuildingUse) "
//                + "VALUES('" + b.getCustID() + "','" + b.getCPID() + "','" + b.getBuildingName() + "','" + b.getStreetName()
//                + "','" + b.getStreetNumb() + "','" + b.getZipcode() +"','"
//                + b.getYearOfConst() + "','" + b.getSquareMeters() + "','" + b.getBuildingUse() + "');";
    }
    
    private void insertDataInReportTable()
    {
        String query = "INSERT INTO Report(BuildingID, EID, RDate, BCondition)"
                + "VALUES('" +r.getBuilding().getBuildingID()+ "','" + !!EID!! 
        +"','" + r.getDate() + "','" + !!Condition!! + "')";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertReview(Report r)
    {
//        String query = "INSERT INTO(RoomID, RepID, Part, Note)  "
//                + "VALUES('" ++ "','" + getRepID(r)+ "','" ++ "','" ++"')";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertConclution(Report r)
    {
        String query = "INSERT INTO  VALUES";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
    private void insertDamage(Report r)
    {
        String query = "INSERT INTO  VALUES";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    private void insertMoistScan(Report r)
    {
        String query = "INSERT INTO  VALUES";
        
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
//    private void insertRoom(Report r)
//    {
//        String query = "INSERT INTO  VALUES";
//        
//        
//        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
//        db_Connect.updateData(query);
//    }
    
    private void insertEmployee(Report r)
    {
        String query = "INSERT INTO Employees(EFirstName, ELastName) "
                + "VALUES('"+ r.getEmployee().getFirstName() +"','"
                + r.getEmployee().lastName+"')";
    }
    
    private void getRepID(Report r)
    {
        String query = "SELECT RepID FROM Report "
                + "WHERE BuildingID = '" + r.getBuilding().buildingID 
                + "' AND RDate = '"+r.getDate()+"';";
        
        DatabaseConnector db_Connect = DatabaseConnector.getInstance();
        db_Connect.updateData(query);
    }
    
}
