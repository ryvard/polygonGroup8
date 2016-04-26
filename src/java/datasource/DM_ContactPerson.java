/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import businesslogic.ContactPerson;
import businesslogic.DatasourceLayerException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author emmablomsterberg
 */
public class DM_ContactPerson
{

    public int createContactPerson(ContactPerson cp) throws DatasourceLayerException
    {

        try
        {

            String query = "INSERT INTO ContactPerson(CPFirstName,CPLastName) VALUES('" + cp.getCPFirstName()
                    + "','" + cp.getCPLastName() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(query);

            int cpID = getCPID(cp.getCPFirstName(), cp.getCPLastName());

            return cpID;
        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("create contact person - " + ex);
        }
    }

    public void createContactPersonInfo(ContactPerson cp) throws DatasourceLayerException
    {
        try
        {

            String queryEmail = "INSERT INTO CPMail(CPID,CPMail) VALUES('" + getCPID(cp.getCPFirstName(), cp.getCPLastName())
                    + "','" + cp.getEmail() + "');";

            String queryPhone = "INSERT INTO CPPhone(CPID,CPPhone) VALUES('" + getCPID(cp.getCPFirstName(), cp.getCPLastName())
                    + "','" + cp.getPhone() + "');";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            db_Connect.updateData(queryEmail);
            db_Connect.updateData(queryPhone);

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("create CP info - " + ex);
        }
    }

    public ArrayList<ContactPerson> getContactPersonList() throws DatasourceLayerException
    {
        try
        {
            ArrayList<ContactPerson> contactPerson = new ArrayList();

            String query = "SELECT * FROM ContactPerson;";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            while (res.next())
            {
                ContactPerson cp = new ContactPerson(res.getInt(1), res.getString(2), res.getString(3));

                contactPerson.add(cp);

            }
            return contactPerson;

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get list of contact persons - " + ex);
        }
    }

    public int getCPID(String firstName, String lastName) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT CPID FROM PolygonGroup8.ContactPerson WHERE CPFirstName ='" 
                    + firstName + "' AND CPLastName='" + lastName + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            int cpID = res.getInt("CPID");

            return cpID;

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get contact person ID (CPID) - " + ex);
        }

    }

    public ContactPerson getCPFromCPID(int cpID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT * FROM PolygonGroup8.ContactPerson WHERE CPID ='" + cpID + "';";

            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            ContactPerson cp = new ContactPerson(res.getInt(1), res.getString(2), res.getString(3));

            return cp;

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get CP from cpid - " + ex);
        }

    }

    public ContactPerson getCPFromBuildingID(int BuildingID) throws DatasourceLayerException
    {
        try
        {
            String query = "SELECT CPID,CPFirstName, CPLastName "
                    + "FROM ContactPerson NATURAL JOIN Buildings "
                    + "WHERE BuildingID ='" + BuildingID + "';";
            DatabaseConnector db_Connect = DatabaseConnector.getInstance();
            ResultSet res = db_Connect.getData(query);

            res.next();
            ContactPerson cp = new ContactPerson(res.getInt(1), res.getString(2), res.getString(3));

            return cp;

        } catch (SQLException ex)
        {
            throw new DatasourceLayerException("get cpFrom bid" + ex);
        }

    }

}
