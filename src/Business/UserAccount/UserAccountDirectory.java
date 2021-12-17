/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author niyati
 */
@SuppressWarnings("unchecked")
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for (UserAccount ua : userAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public UserAccount createUserAccount(String username, String password, Employee employee, Role role){
        Boolean checkUnique = checkIfUsernameIsUnique(username);
        if(checkUnique){
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setEmployee(employee);
            userAccount.setRole(role);
            userAccountList.add(userAccount);
            return userAccount;
        }
        else{
            return null;
        }
    }
    
    public UserAccount createVolunteerUserAccount(String username, String password, Employee employee, Role role,String Uploaded){
        Boolean checkUnique = checkIfUsernameIsUnique(username);
        if(checkUnique){
            UserAccount userAccount = new UserAccount();
            userAccount.setUsername(username);
            userAccount.setPassword(password);
            userAccount.setEmployee(employee);
            userAccount.setRole(role);
            userAccount.setUploadedVolunteerPhoto(Uploaded);
            userAccountList.add(userAccount);
            return userAccount;
        }
        else{
            return null;
        }
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    public void deleteUser(String username){
        UserAccount delUsr = null;
        for(UserAccount usr: userAccountList){
            if(usr.getUsername().equals(username)){
                delUsr = usr;
            }
        }
        userAccountList.remove(delUsr);
    }
}
