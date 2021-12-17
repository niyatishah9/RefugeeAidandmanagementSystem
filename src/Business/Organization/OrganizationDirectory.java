
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationArrayList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type organizationType){
        Organization organization = null;
        
        
        if (organizationType.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (organizationType.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (organizationType.getValue().equals(Type.Volunteer.getValue())){
            organization = new VolunteerOrganization();
            organizationList.add(organization);
        }
        else if (organizationType.getValue().equals(Type.FundsProvider.getValue())){
            organization = new MoneyProviderOrganization();
            organizationList.add(organization);
        }
         else if (organizationType.getValue().equals(Type.RefugeeCamp.getValue())){
            organization = new HomelessCampOrganization();
            organizationList.add(organization);
        }
        else if (organizationType.getValue().equals(Type.Amenities.getValue())){
            organization = new AmenitiesOrganization();
            organizationList.add(organization);
        }
        else if (organizationType.getValue().equals(Type.MedicalCampOrganizer.getValue())){
            organization = new MedicalCampOrganization();
            organizationList.add(organization);
        }
        else if (organizationType.getValue().equals(Type.Inventory.getValue())){
            organization = new InventoryOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
}