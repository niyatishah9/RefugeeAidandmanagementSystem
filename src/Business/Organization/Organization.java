
package Business.Organization;

import Business.UserAccount.UserAccountDirectory;
import Business.Employee.EmployeeDirectory;
import java.util.ArrayList;
import Business.WorkQueue.WorkQueue;
import Business.Role.Role;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
                
        Amenities("Amenities Organization"),
        MedicalCampOrganizer("MedicalCamp Organization"),
        Inventory("InventoryOraganization"),
        Volunteer("Volunteer Organization"), 
        FundsProvider("FundsProvider Organization"),
        Admin("Admin Organization"), 
        Doctor("Doctor Organization"), 
        Lab("Lab Organization"),
        RefugeeCamp("RefugeeCamp Organization");
      
        
        private String OrganizationValue;
        
        private Type(String value) {
            this.OrganizationValue = value;
        }
        public String getValue() {
            return OrganizationValue;
        }
    }

    public Organization(String orgName) {
        this.name = orgName;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
