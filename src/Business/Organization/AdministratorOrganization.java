
package Business.Organization;


import Business.Role.Role;
import Business.Role.AdminRole;
import java.util.ArrayList;

/*
 * @author piyush.dandekar
 */


@SuppressWarnings("unchecked")

public class AdministratorOrganization extends Organization{

    public AdministratorOrganization() {
        
        super(Type.Admin.getValue());
        
    }
    
    @Override
    public ArrayList<Role> getSupportedRole()
    
    {
        ArrayList<Role> roles = new ArrayList();
        
        roles.add(new AdminRole());
        
        return roles;
    }
     
}
