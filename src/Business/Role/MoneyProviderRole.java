
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import javax.swing.JPanel;
import userinterface.MoneyProviderRole.MoneyProviderWorkAreaJPanel;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;


/**
 *
 * @author  piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class MoneyProviderRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new MoneyProviderWorkAreaJPanel(userProcessContainer, account, organization, business);
    }
}
