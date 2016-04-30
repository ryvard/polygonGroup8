package businesslogic;

/**
 *
 * @author emmablomsterberg
 */
public class Customer
{

    private int custID;
    private String custName;
    private String type;
    private String streetName;
    private String streetNo;
    private int zipcode;

    /**
     * Used when creating a new customer
     *
     * @param custName
     * @param type
     * @param streetName
     * @param streetNo
     * @param zipcode
     */
    public Customer(String custName, String type, String streetName, String streetNo, int zipcode)
    {
        this.custName = custName;
        this.type = type;
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
    }

    /**
     * Used when creating a customer that already exist in the database
     *
     * @param custID
     * @param custName
     * @param type
     * @param streetName
     * @param streetNo
     * @param zipcode
     */
    public Customer(int custID, String custName, String type, String streetName, String streetNo, int zipcode)
    {
        this.custID = custID;
        this.custName = custName;
        this.type = type;
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.zipcode = zipcode;
    }

    public Customer(int custID)
    {
        this.custID = custID;
    }

    public int getCustID()
    {
        return custID;
    }

    public String getCustName()
    {
        return custName;
    }

    public String getType()
    {
        return type;
    }

    public String getStreetName()
    {
        return streetName;
    }

    public String getStreetNo()
    {
        return streetNo;
    }

    public int getZipcode()
    {
        return zipcode;
    }
}
