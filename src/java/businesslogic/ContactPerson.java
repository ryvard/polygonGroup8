package businesslogic;

/**
 *
 * @author emmablomsterberg
 */
public class ContactPerson {
    
    private int cpID;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    
    /** 
     * Contructor for creating contactperson 
     * @param cpFirstName
     * @param cpLastName
     * @param email
     * @param phone
     */
    public ContactPerson(String cpFirstName, String cpLastName, String email, String phone)
    {
        this.firstName = cpFirstName;
        this.lastName = cpLastName;
        this.email = email;
        this.phone = phone;
    }
    
    /** 
     * Constructor for displaying contactperson 
     * @param cpID
     * @param cpFirstName
     * @param cpLastName
     */
    public ContactPerson(int cpID, String cpFirstName, String cpLastName) {
        this.cpID = cpID;
        this.firstName = cpFirstName;
        this.lastName = cpLastName;
    }

    public ContactPerson(int CPID) {
        this.cpID = CPID;
    }
    
    public String getCPFirstName() {
        return firstName;
    }
    
    public String getCPLastName() {
        return lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public int getCPID() {
        return cpID;
    }
}
