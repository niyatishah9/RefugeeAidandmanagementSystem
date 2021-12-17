package Business.Organization;

import Business.Role.Role;
import Business.Role.AmenitiesProviderRole;
import java.util.ArrayList;


/**
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public class AmenitiesOrganization extends Organization
    {
     public AmenitiesOrganization()
    {
        super(Organization.Type.Amenities.getValue());
    }

    @Override    
    public ArrayList<Role> getSupportedRole() 
    {
        ArrayList<Role> rolesArr = new ArrayList();
        
        rolesArr.add(new AmenitiesProviderRole());
        return rolesArr;
    }
    
}
