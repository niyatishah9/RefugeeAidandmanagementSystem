/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.RefugeeCampManagerRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HelpCareCenterEnterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HelpCareMedicalRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class RequestNgojPanel extends javax.swing.JPanel {

    /**
     * Creates new form RequestNgojPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public RequestNgojPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = userAccount;
        this.business = business;
        valueLabel.setText(enterprise.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        requestTestJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        enterpriseLabel.setText("EnterPrise :");
        add(enterpriseLabel);
        enterpriseLabel.setBounds(224, 158, 120, 30);

        valueLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(valueLabel);
        valueLabel.setBounds(377, 158, 285, 30);

        messageJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(messageJTextField);
        messageJTextField.setBounds(377, 247, 285, 28);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Message");
        add(jLabel1);
        jLabel1.setBounds(224, 248, 135, 26);

        requestTestJButton.setBackground(new java.awt.Color(102, 102, 102));
        requestTestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        requestTestJButton.setText("SEND REQUEST");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });
        add(requestTestJButton);
        requestTestJButton.setBounds(328, 318, 164, 31);

        backJButton.setBackground(new java.awt.Color(102, 102, 102));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton);
        backJButton.setBounds(25, 10, 110, 31);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Request Area");
        add(jLabel2);
        jLabel2.setBounds(320, 10, 264, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/images/refugeeameneties (1).jpg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 50, 890, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

        String message = messageJTextField.getText();

        if(message.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter text");
            return;
        }

        HelpCareMedicalRequest request = new HelpCareMedicalRequest();
        request.setMessage(message);
        request.setSender(userAccount);
        request.setStatus("Sent");

        Organization org = null;
        for(Network network: business.getNetworkList()){
            for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()){
                if(enterprise instanceof HelpCareCenterEnterprise){
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationArrayList()){
                        // raising req to volunteer organization
                        if (organization instanceof VolunteerOrganization){
                            org = organization;
                            break;
                        }
                    }
                }
            }
        }
        if (org!=null){
            // adding req on user account of refugee camp manager
            org.getWorkQueue().getWorkRequestList().add(request);
            userAccount.getWorkQueue1().getWorkRequestList().add(request);
            dB4OUtil.storeSystem(business);
        }
        messageJTextField.setText("");
        
        JOptionPane.showMessageDialog(null, "Done");
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // refreshing components when going back page
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        RefugeeCMWorkAreajPanel rcjp = (RefugeeCMWorkAreajPanel) component;
        rcjp.populateRequestTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
