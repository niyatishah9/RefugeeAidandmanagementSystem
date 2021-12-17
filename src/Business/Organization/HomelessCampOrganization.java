
package Business.Organization;

import java.util.ArrayList;
import Business.Role.LabAssistantRole;
import Business.Role.RefugeeCampManagerRole;
import Business.Role.Role;


/**
 * @author piyush.dandekar
 */

@SuppressWarnings("unchecked")

public class HomelessCampOrganization extends Organization {
      public HomelessCampOrganization() 
    {
        super(Organization.Type.RefugeeCamp.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() 
    
    {
        ArrayList<Role> items = new ArrayList();
        
        items.add(new RefugeeCampManagerRole());
        
        return items;
    }
    
}
