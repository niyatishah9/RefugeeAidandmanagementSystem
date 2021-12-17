/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.VolunteerFundsRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FundsWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.LoginJPanel;

/**
 *
 * @author niyati
 */
@SuppressWarnings("unchecked")
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VolunteerWorkAreaJPanel
     */

    private JPanel userProcessContainer;
    private VolunteerOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public VolunteerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, VolunteerOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        if(account.getUploadedVolunteerPhoto()!=null){
            ImageIcon icon=new ImageIcon(account.getUploadedVolunteerPhoto());
            Image image=icon.getImage().getScaledInstance(1,1, Image.SCALE_SMOOTH);
            volunteerUploadedjLabel.setIcon(icon);
//            volunteerUploadedjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/images/"+account.getUploadedVolunteerPhoto())));
        }
        populateRequestTable();
    }
    
    // populate table with fundsWorkRequest
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        System.out.println(userAccount.getWorkQueue().getWorkRequestList());
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((FundsWorkRequest) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestFundJButton = new javax.swing.JButton();
        refreshTestJButton = new javax.swing.JButton();
        resReqBtn = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        volunteerUploadedjLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(30, 35, 70));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" FUNDS MANAGER");
        add(jLabel1);
        jLabel1.setBounds(280, 140, 269, 29);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/images/volunteerimage.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(250, -40, 290, 250);

        workRequestJTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(130, 186, 630, 175);

        requestFundJButton.setBackground(new java.awt.Color(255, 255, 255));
        requestFundJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        requestFundJButton.setText("Request New Funds");
        requestFundJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestFundJButtonActionPerformed(evt);
            }
        });
        add(requestFundJButton);
        requestFundJButton.setBounds(352, 421, 230, 31);

        refreshTestJButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });
        add(refreshTestJButton);
        refreshTestJButton.setBounds(657, 388, 103, 31);

        resReqBtn.setBackground(new java.awt.Color(255, 255, 255));
        resReqBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        resReqBtn.setText("Resolve Funds Request");
        resReqBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resReqBtnActionPerformed(evt);
            }
        });
        add(resReqBtn);
        resReqBtn.setBounds(352, 481, 230, 31);

        logoutJButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        add(logoutJButton);
        logoutJButton.setBounds(783, 25, 87, 29);

        volunteerUploadedjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(volunteerUploadedjLabel);
        volunteerUploadedjLabel.setBounds(600, 30, 150, 130);

        jLabel3.setText("jLabel3");
        add(jLabel3);
        jLabel3.setBounds(1, 0, 890, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void requestFundJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestFundJButtonActionPerformed
        // go to fundRequest Page
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestFundsJPanel", new RequestFundsJPanel(userProcessContainer, userAccount, enterprise,business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_requestFundJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        populateRequestTable();

    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void resReqBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resReqBtnActionPerformed
        // TODO add your handling code here:
        // go to fundRequest Page
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ResolveRequestsJPanel", new ResolveRequestsJPanel(userProcessContainer, userAccount,organization, enterprise, business));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_resReqBtnActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        LoginJPanel loginJPanel=new LoginJPanel();
        userProcessContainer.add("loginJPanel",loginJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_logoutJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestFundJButton;
    private javax.swing.JButton resReqBtn;
    private javax.swing.JLabel volunteerUploadedjLabel;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}