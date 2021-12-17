
package Business.Employee;
import java.util.ArrayList;


/**
 *
 * @author piyush.dandekar
 */

@SuppressWarnings("unchecked")
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    public void deleteEmployee(String empName)
    
    {
        Employee deleteEmp = null;
        for(Employee emp: employeeList)
        {
            if(emp.getName().equals(empName))
            
            {
                deleteEmp = emp;
            }
        }
        employeeList.remove(deleteEmp);
    }
}