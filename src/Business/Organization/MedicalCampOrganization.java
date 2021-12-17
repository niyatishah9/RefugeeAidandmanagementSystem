
package Business.Organization;

import Business.Role.Role;
import Business.Role.MedicalCampOrganizerRole;
import java.util.ArrayList;

/**
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public class MedicalCampOrganization extends Organization

{
    
    public MedicalCampOrganization() 
    {
        super(Organization.Type.MedicalCampOrganizer.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole()
    
    {
        ArrayList<Role> items = new ArrayList();
        
        items.add(new MedicalCampOrganizerRole());
        
        return items;
    }
    
}
