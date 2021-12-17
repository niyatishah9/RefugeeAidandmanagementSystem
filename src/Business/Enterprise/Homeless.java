
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class Homeless extends Enterprise {
    
     public Homeless(String name)
     {
        super(name, Enterprise.EnterpriseType.Homeless);
     }
     
    @Override    
    public ArrayList<Role> getSupportedRole() 
    
    {
        return null;
    }
    
}
