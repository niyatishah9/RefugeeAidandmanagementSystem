
package Business.Enterprise;

import java.util.ArrayList;
import Business.Role.Role;

/**
 *
 * @author piyush.dandekar
 */

@SuppressWarnings("unchecked")

public class HospitalEnterprise extends Enterprise {
    
    public HospitalEnterprise(String name)    
    {
        super(name,Enterprise.EnterpriseType.Hospital);
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
