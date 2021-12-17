/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class LabOrganization extends Organization{

    public LabOrganization()
    {
        super(Organization.Type.Lab.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() 
    
    {
        ArrayList<Role> items = new ArrayList();
        
        items.add(new LabAssistantRole());
        return items;
    }
     
   
    
    
}
