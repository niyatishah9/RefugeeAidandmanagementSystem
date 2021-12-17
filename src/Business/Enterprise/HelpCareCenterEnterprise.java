
package Business.Enterprise;

import java.util.ArrayList;
import Business.Role.Role;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public class HelpCareCenterEnterprise extends Enterprise 
{
    public HelpCareCenterEnterprise(String name)
    
    {
        super(name, Enterprise.EnterpriseType.HelpCareCenter);
    }
    
    @Override
    
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
}
