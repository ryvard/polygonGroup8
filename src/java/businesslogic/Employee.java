package businesslogic;

/**
 *
 * @author miaryvard
 */
public class Employee
{

    int eID;
    String firstName;
    String lastName;

    /**
     * Constructor used when creating an employee(create report)
     *
     * @param firstName
     * @param lastName
     */
    public Employee(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Constructor used for Employees from the database (view report)
     *
     * @param eID
     * @param firstName
     * @param lastName
     */
    public Employee(int eID, String firstName, String lastName)
    {
        this.eID = eID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int geteID()
    {
        return eID;
    }

    public void seteID(int eID)
    {
        this.eID = eID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
}
