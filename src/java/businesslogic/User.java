package businesslogic;

/**
 *
 * @author emmablomsterberg
 */
public class User {
    
    String user;
    String password;
    
    public User(String userName, String uPassword) {
        this.user = userName;
        this.password = uPassword;
    }
    
    public String getUserName() {
        return user;
    }
    
    public void setUserName(String userName) {
        this.user = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
