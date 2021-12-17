
package ui.VolunteerFundsRole;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.HousesMedicalCampRequest;
import Business.WorkQueue.HelpCareMedicalRequest;
import Business.WorkQueue.WorkRequest;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.Network;
import Business.Organization.MedicalCampOrganization;
import Business.Organization.Organization;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.LoginJPanel;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;


/**
 *
 * @author niyati
 */
@SuppressWarnings("unchecked")
public class ResolveRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResolveRequestsJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private Organization organization;
    private EcoSystem business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public ResolveRequestsJPanel(JPanel userProcessContainer, UserAccount userAccount,Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.business = business;
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        model.setRowCount(0);
        System.out.println("organization in rr "+ organization);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request;
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            model.addRow(row);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton1 = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        refreshJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        reqHEbtn = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(30, 35, 70));
        setPreferredSize(new java.awt.Dimension(1174, 691));
        setLayout(null);

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
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false
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
        jScrollPane1.setBounds(118, 114, 641, 156);

        assignJButton1.setBackground(new java.awt.Color(255, 255, 255));
        assignJButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignJButton1.setText("Assign ");
        assignJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButton1ActionPerformed(evt);
            }
        });
        add(assignJButton1);
        assignJButton1.setBounds(273, 315, 263, 31);

        processJButton.setBackground(new java.awt.Color(255, 255, 255));
        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setText("Process Money Requested");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton);
        processJButton.setBounds(273, 380, 263, 31);

        refreshJButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton);
        refreshJButton.setBounds(633, 296, 126, 31);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MONEY REQUEST PROCESSING");
        add(jLabel1);
        jLabel1.setBounds(256, 59, 380, 29);

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setText("<<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn);
        backBtn.setBounds(40, 30, 110, 31);

        reqHEbtn.setBackground(new java.awt.Color(255, 255, 255));
        reqHEbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reqHEbtn.setText("Request Hospital Enterprise");
        reqHEbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqHEbtnActionPerformed(evt);
            }
        });
        add(reqHEbtn);
        reqHEbtn.setBounds(273, 440, 263, 31);

        logoutJButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        add(logoutJButton);
        logoutJButton.setBounds(723, 22, 143, 31);
        add(jLabel3);
        jLabel3.setBounds(0, 0, 890, 580);
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButton1ActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null){
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            populateTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        }
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_assignJButton1ActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        HelpCareMedicalRequest request = (HelpCareMedicalRequest)workRequestJTable.getValueAt(selectedRow, 0);
        if(request.getHmcwr() != null){
            request.setStatus("Request Processed");
            dB4OUtil.storeSystem(business);
            ProcessWorkRequestJPanel processWorkRequestJPanel = new ProcessWorkRequestJPanel(userProcessContainer, request,business);
            userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Cannot Process it Yet Please raise hospital request");
            return;
        }
    }//GEN-LAST:event_processJButtonActionPerformed

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
         // refreshing components when going back page
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void reqHEbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqHEbtnActionPerformed
            // TODO add your handling code here:
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row");
            return;
        }

        HelpCareMedicalRequest relatedReq = (HelpCareMedicalRequest)workRequestJTable.getValueAt(selectedRow, 0);
        
        
        if(!relatedReq.getStatus().equals("Processing") && !relatedReq.getStatus().equals("Completed")) {
            relatedReq.setStatus("Processing");
            String message = "need medical camp";
            HousesMedicalCampRequest request = new HousesMedicalCampRequest();
            
            request.setMessage(message);
            request.setSender(userAccount);
            request.setStatus("Sent");
            request.setNmcwr(relatedReq);
            relatedReq.setHmcwr(request);

            Organization org = null;
        
            for(Network n : business.getNetworkList()){
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e instanceof HospitalEnterprise){
                        for (Organization organization : e.getOrganizationDirectory().getOrganizationArrayList()){
                            if (organization instanceof MedicalCampOrganization){
                                org = organization;
                                break;
                            }
                        }
                    }
                }
            }
        
            if (org!=null){
                System.out.println(userAccount);
                org.getWorkQueue().getWorkRequestList().add(request);
                userAccount.getWorkQueue1().getWorkRequestList().add(request);
                JOptionPane.showMessageDialog(null, "Hos Med Request Created");
            }
            dB4OUtil.storeSystem(business);
            populateTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Request is already in Process");
            return;
        }
    }//GEN-LAST:event_reqHEbtnActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        LoginJPanel loginJPanel=new LoginJPanel();
        userProcessContainer.add("loginJPanel",loginJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_logoutJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton1;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton reqHEbtn;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
