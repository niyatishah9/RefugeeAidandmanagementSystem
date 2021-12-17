
package Business.Organization;

import Business.Role.MoneyProviderRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public class MoneyProviderOrganization extends Organization

{
    public MoneyProviderOrganization()
    
    {
        
        super(Organization.Type.FundsProvider.getValue());
        
    }

    @Override
    
    public ArrayList<Role> getSupportedRole() {
        
        ArrayList<Role> items = new ArrayList();
        
        items.add(new MoneyProviderRole());
        
        return items;
    }
}
