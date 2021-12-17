
package Business.Organization;

import Business.Role.Role;
import Business.Role.VolunteerRole;
import java.util.ArrayList;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class VolunteerOrganization extends Organization
    {
    public VolunteerOrganization() 
    {
        super(Organization.Type.Volunteer.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() 
    {
        ArrayList<Role> items = new ArrayList();
        
        items.add(new VolunteerRole());
        
        return items;
    }
}
