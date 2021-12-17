
package Business.Employee;

/**
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public class Employee {
    
    private int  empId;
    private String empName;
    private static int count = 1;
    
     public Employee() 
    {
        empId = count;
        
        count++;
    }
    
    public void setName(String name) 
    {
        this.empName = name;
    }
    
    public String getName() 
    {
        return empName;
    }
     

    public int getId()
    {
        return empId;
    }
    
    @Override
    public String toString() 
    {
        return empName;
    }
}
