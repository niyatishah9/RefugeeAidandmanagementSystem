package Business;
import Business.UserAccount.UserAccount;
import Business.Role.SystemAdminRole;
import Business.Employee.Employee;
/*
 * @author piyush.dandekar
 */


@SuppressWarnings("unchecked")

public class SystemConfiguration 

{
    
    public static EcoSystem configuration()
    {
        
        EcoSystem system = EcoSystem.getInstance();              
        
        Employee emp = system.getEmployeeDirectory().createEmployee("sysadmin");        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", emp, new SystemAdminRole());
        
        return system;
    }
    
}
