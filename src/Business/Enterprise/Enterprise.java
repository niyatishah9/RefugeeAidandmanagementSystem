
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import Business.Organization.Organization;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public abstract class Enterprise extends Organization{
    
    
    private OrganizationDirectory organizationDirectory;
    private EnterpriseType enterpriseType;
    
    // dropdown entities for Enterprise Type on Manage Enterprise Area
    public enum EnterpriseType{
        
        HelpCareCenter("HelpCareCenter"), // NGO, Hospital, Refugee - Organization, 
        Hospital("Hospital"),
        Homeless("Homeless");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        

        @Override
        public String toString()
        
        {
            return value;
        }
        
        public String getValue()
        {
            return value;
        }
    }
    
    
    public EnterpriseType getEnterpriseType() 
    
    {
        return enterpriseType;
    }
        
        
    public Enterprise(String name,EnterpriseType entType)
    
    {
        super(name);
        this.enterpriseType= entType;
        organizationDirectory=new OrganizationDirectory();
    }
    
    public void setEnterpriseType(EnterpriseType enterpriseType)
    
    {
        this.enterpriseType = enterpriseType;
    }
        
    public OrganizationDirectory getOrganizationDirectory()
    {
        return organizationDirectory;
    }

    
}
