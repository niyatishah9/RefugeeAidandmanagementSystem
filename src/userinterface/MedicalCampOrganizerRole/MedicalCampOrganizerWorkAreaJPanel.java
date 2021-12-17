/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.MedicalCampOrganizerRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HousesMedicalCampRequest;
import Business.WorkQueue.MedicalCamp;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.LoginJPanel;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class MedicalCampOrganizerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MedicalCampOrganizerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
     public MedicalCampOrganizerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business=business;
        populateTable();
        populateTableReqFromVol();
    }
     
    public void populateTableReqFromVol(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
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
    
     public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        //System.out.print(userAccount.getWorkQueue1().getWorkRequestList());
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
            String result = ((MedicalCamp) request).getTestResult();
            row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        requestCampJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        assignBtn = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("Medical Camp Organizer");
        add(jLabel1);
        jLabel1.setBounds(240, 70, 321, 29);

        workRequestJTable.setBackground(new java.awt.Color(219, 251, 251));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        ));
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 650, 140);

        refreshJButton.setBackground(new java.awt.Color(153, 153, 153));
        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });
        add(refreshJButton);
        refreshJButton.setBounds(680, 180, 110, 31);

        requestCampJButton.setBackground(new java.awt.Color(153, 153, 153));
        requestCampJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        requestCampJButton.setText("Request for Doctor");
        requestCampJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestCampJButtonActionPerformed(evt);
            }
        });
        add(requestCampJButton);
        requestCampJButton.setBounds(680, 420, 196, 31);

        workRequestJTable1.setBackground(new java.awt.Color(219, 251, 251));
        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Reciever", "Status"
            }
        ));
        jScrollPane2.setViewportView(workRequestJTable1);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 330, 650, 140);

        assignBtn.setBackground(new java.awt.Color(153, 153, 153));
        assignBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignBtn.setText("Assign Organizer");
        assignBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignBtnActionPerformed(evt);
            }
        });
        add(assignBtn);
        assignBtn.setBounds(680, 370, 196, 31);

        logoutJButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        add(logoutJButton);
        logoutJButton.setBounds(747, 20, 110, 31);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/images/medicalcamp organizer (1).jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        add(jLabel2);
        jLabel2.setBounds(0, 60, 890, 580);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 60);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
        populateTableReqFromVol();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void requestCampJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestCampJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a Row");
            return;
        }
        HousesMedicalCampRequest relatedReq = (HousesMedicalCampRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        if(relatedReq.getStatus().equals("Pending")){
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            userProcessContainer.add("RequestCampsJPanel", new RequestCampsJPanel(userProcessContainer, userAccount, enterprise,relatedReq,business));
            layout.next(userProcessContainer);
        }
        else{
            JOptionPane.showMessageDialog(null, "Request is already completed or in progress");
            return;
        }
    }//GEN-LAST:event_requestCampJButtonActionPerformed

    private void assignBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = workRequestJTable1.getSelectedRow();

        if (selectedRow < 0){
            return;
        }

        WorkRequest request = (WorkRequest)workRequestJTable1.getValueAt(selectedRow, 0);
        if(request.getReceiver() == null){
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            dB4OUtil.storeSystem(business);
            populateTableReqFromVol();
        }
        else{
            JOptionPane.showMessageDialog(null, "Already Assigned");
            return;
        }
    }//GEN-LAST:event_assignBtnActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        LoginJPanel loginJPanel=new LoginJPanel();
        userProcessContainer.add("loginJPanel",loginJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_logoutJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JButton requestCampJButton;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}