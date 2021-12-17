/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Doctor;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class DoctorOrganization extends Organization{

    public DoctorOrganization() {
        super(Organization.Type.Doctor.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole()
    {
        ArrayList<Role> items = new ArrayList();
        
        items.add(new Doctor());
        
        return items;
    }
     
}