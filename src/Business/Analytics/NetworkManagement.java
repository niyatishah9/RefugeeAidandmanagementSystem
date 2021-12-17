
package Business.Analytics;
        
import Business.Organization.Organization;        
import Business.Enterprise.HelpCareCenterEnterprise;
import Business.WorkQueue.FundsWorkRequest;
import Business.Enterprise.Enterprise;
import Business.WorkQueue.WorkRequest;
import java.util.HashMap;
import Business.EcoSystem;
import Business.Network.Network;
import Business.Organization.MoneyProviderOrganization;


/**
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")

public class NetworkManagement {
    
        private EcoSystem system;
        String tempName;
        
        public NetworkManagement (EcoSystem system){
            this.system = system;
        }
          
        
        public HashMap<String,Integer> getMoneyCollected (String networkSelelected )
        {
                      
            HashMap<String,Integer> ent = null;
            
            for(Network network:system.getNetworkList())
            
            {
                ent = new HashMap<String,Integer>();
                
                if(networkSelelected==null)
                    
                    tempName = system.getNetworkList().get(0).getName();
                
                else
                {
                    tempName = networkSelelected;
                }
                
                
                //Verifying each enterprise
                
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
                
                {
                    if(enterprise instanceof HelpCareCenterEnterprise)
                    
                    {
                        for (Organization org: enterprise.getOrganizationDirectory().getOrganizationArrayList()){
                            
                            if(org instanceof MoneyProviderOrganization)
                            
                            {
                                int amountreq = 0;
                                int amountfunded = 0;
                                for(WorkRequest wr: org.getWorkQueue().getWorkRequestList())
                                
                                {
                                    FundsWorkRequest fwr = (FundsWorkRequest) wr;
                                    amountreq += fwr.getAmount();
                                    amountfunded += fwr.getAmountFunded();
                                }
                                
                                ent.put("Amount Req", amountreq);
                                ent.put("Amount Funded", amountfunded);
                            }
                        }
                    }
                }

                if(tempName == network.getName())
                    return ent;
                }
                return ent;
        }
        
        public HashMap<String,HashMap<String,Integer>> getNetworkUsersWRTOrg( String networkSelected )
        
        {            
                        
            HashMap<String,HashMap<String,Integer>> enterpriseArr = null;
            
            for(Network network:system.getNetworkList())
            {
                
                enterpriseArr = new HashMap<String,HashMap<String,Integer>>();
                
                if(networkSelected==null)
                    
                    tempName = system.getNetworkList().get(0).getName();
                
                else
                {
                    tempName = networkSelected;
                }
                
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
                
                {
                    HashMap<String,Integer> org =new HashMap<String,Integer>();
                    
                    
                    org.put("Admins",enterprise.getEmployeeDirectory().getEmployeeList().size());
                    
                    for(Organization organization: enterprise.getOrganizationDirectory().getOrganizationArrayList())
                    {
                       org.put(organization.getName(),organization.getUserAccountDirectory().getUserAccountList().size()) ;
                    }
                    
                    enterpriseArr.put(enterprise.getEnterpriseType().getValue(),org);
                }

                if(tempName == network.getName())
                    
                    return enterpriseArr;
                }
            
                return enterpriseArr;
        }

}
