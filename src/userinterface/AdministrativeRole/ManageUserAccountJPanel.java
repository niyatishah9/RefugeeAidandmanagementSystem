/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import userinterface.LoginJPanel;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author piyush.dandekar
 */
@SuppressWarnings("unchecked")
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    private EcoSystem business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private String uploadedVounteer;
    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;
        this.business=business;
        populateOrgComboBox();
       // employeeJComboBox.removeAllItems();
        populateData();
    }

    public void populateOrgComboBox() {
        orgcombo.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationArrayList()) {
            orgcombo.addItem(organization);
        }
    }
    
    public void populateEmployeeComboBox(Organization organization){
        empcombo.removeAllItems();
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            empcombo.addItem(employee);
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        rolecombo.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            System.out.println(role);
            rolecombo.addItem(role);
        }
    }

    public void populateData() {

        DefaultTableModel model = (DefaultTableModel) usertbl.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationArrayList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) usertbl.getModel()).addRow(row);
            }
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

        pswlbl = new javax.swing.JTextField();
        PhotojPanel = new javax.swing.JPanel();
        volunteerUpload = new javax.swing.JLabel();
        uploadPicturebtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        empcombo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        updateprofile = new javax.swing.JButton();
        createuserbtn = new javax.swing.JButton();
        orgcombo = new javax.swing.JComboBox();
        nametxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        rolecombo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertbl = new javax.swing.JTable();
        deletebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        logoutJButton = new javax.swing.JButton();
        backbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(null);

        pswlbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pswlbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pswlblActionPerformed(evt);
            }
        });
        add(pswlbl);
        pswlbl.setBounds(150, 360, 335, 28);

        PhotojPanel.setBackground(java.awt.SystemColor.text);

        uploadPicturebtn.setBackground(new java.awt.Color(153, 153, 153));
        uploadPicturebtn.setText("Upload Volunteer Photo");
        uploadPicturebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadPicturebtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Photo :");

        javax.swing.GroupLayout PhotojPanelLayout = new javax.swing.GroupLayout(PhotojPanel);
        PhotojPanel.setLayout(PhotojPanelLayout);
        PhotojPanelLayout.setHorizontalGroup(
            PhotojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PhotojPanelLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(PhotojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volunteerUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PhotojPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(uploadPicturebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        PhotojPanelLayout.setVerticalGroup(
            PhotojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PhotojPanelLayout.createSequentialGroup()
                .addGroup(PhotojPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadPicturebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(volunteerUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(PhotojPanel);
        PhotojPanel.setBounds(510, 200, 367, 203);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(10, 250, 110, 22);

        empcombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        empcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(empcombo);
        empcombo.setBounds(150, 240, 306, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Organization");
        add(jLabel5);
        jLabel5.setBounds(10, 210, 120, 22);

        updateprofile.setBackground(new java.awt.Color(153, 153, 153));
        updateprofile.setText("Update Profile");
        updateprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateprofileActionPerformed(evt);
            }
        });
        add(updateprofile);
        updateprofile.setBounds(160, 420, 120, 32);

        createuserbtn.setBackground(new java.awt.Color(153, 153, 153));
        createuserbtn.setText("Create");
        createuserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createuserbtnActionPerformed(evt);
            }
        });
        add(createuserbtn);
        createuserbtn.setBounds(300, 420, 95, 32);

        orgcombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        orgcombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        orgcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgcomboActionPerformed(evt);
            }
        });
        add(orgcombo);
        orgcombo.setBounds(150, 200, 306, 28);

        nametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(nametxt);
        nametxt.setBounds(150, 320, 335, 28);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(10, 280, 34, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(10, 320, 120, 22);

        rolecombo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rolecombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rolecombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rolecomboActionPerformed(evt);
            }
        });
        add(rolecombo);
        rolecombo.setBounds(150, 280, 306, 28);

        usertbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usertbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usertblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usertbl);

        add(jScrollPane1);
        jScrollPane1.setBounds(50, 500, 388, 168);

        deletebtn.setBackground(new java.awt.Color(153, 153, 153));
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        add(deletebtn);
        deletebtn.setBounds(70, 420, 74, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(10, 360, 110, 22);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        logoutJButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutJButton.setText("Logout");
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        backbtn.setBackground(new java.awt.Color(153, 153, 153));
        backbtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backbtn.setText("<< Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("USER DETAILS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutJButton)
                    .addComponent(backbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 890, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        LoginJPanel loginJPanel=new LoginJPanel();
        container.add("loginJPanel",loginJPanel);
        CardLayout layout=(CardLayout)container.getLayout();
        layout.next(container);
        dB4OUtil.storeSystem(business);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void uploadPicturebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadPicturebtnActionPerformed
        JFileChooser uploadphotoDirectory=new JFileChooser(System.getProperty("user.dir"));
        File currentDirectory=new File(System.getProperty("user.dir")+"/src/userinterface/images");

        uploadphotoDirectory.setDialogTitle("Please Choose Volunteer Picture");
        FileNameExtensionFilter filter=new FileNameExtensionFilter("JPG or PNG","jpg","png");
        uploadphotoDirectory.setFileFilter(filter);
        File vlounteerUploaded=null;
        int statusReturn=uploadphotoDirectory.showOpenDialog(null);
        if(statusReturn==JFileChooser.APPROVE_OPTION){
            vlounteerUploaded=uploadphotoDirectory.getSelectedFile();
            try{
                File directoryPath=new File(currentDirectory+"/volunteer_pic_"+vlounteerUploaded.getName());
                this.uploadedVounteer="volunteer_pic_"+vlounteerUploaded.getName();
                this.uploadedVounteer=directoryPath.getAbsolutePath();
                //                System.out.println("Before "+uploadedVounteer);
                Files.copy(vlounteerUploaded.toPath(), directoryPath.toPath());
                ImageIcon icon=new ImageIcon(directoryPath.getAbsolutePath());
                Image image=icon.getImage().getScaledInstance(volunteerUpload.getWidth(), volunteerUpload.getHeight(), Image.SCALE_SMOOTH);
                volunteerUpload.setIcon(icon);

                //                System.out.println("Copied "+vlounteerUploaded.toPath());
            }
            catch(Exception ex){
                //                volunteerUploadedjLabel.setIcon(null);
                //                this.uploadedVounteer="";
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, "Picture not Valid");
            }
        }
    }//GEN-LAST:event_uploadPicturebtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backbtnActionPerformed

    private void updateprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateprofileActionPerformed
        int selectedRow = usertbl.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "No User Selected");
            return;
        }

        UserAccount userAcoount = (UserAccount)usertbl.getValueAt(selectedRow, 0);

        if(!this.uploadedVounteer.isEmpty()){
            userAcoount.setUploadedVolunteerPhoto(this.uploadedVounteer);
            dB4OUtil.storeSystem(business);
        }
        else{
            volunteerUpload.setIcon(null);
        }
    }//GEN-LAST:event_updateprofileActionPerformed

    private void createuserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createuserbtnActionPerformed
        String userName = nametxt.getText();
        String password = pswlbl.getText();
        Organization organization = (Organization) orgcombo.getSelectedItem();
        Employee employee = (Employee) empcombo.getSelectedItem();
        Role role = (Role) rolecombo.getSelectedItem();
        if (role!=null && role.toString().contains("Business.Role.VolunteerRole")){
            if(!uploadedVounteer.isEmpty()){
                UserAccount a = organization.getUserAccountDirectory().createVolunteerUserAccount(userName, password, employee, role,uploadedVounteer);
                if(a == null){
                    JOptionPane.showMessageDialog(null, "Username already exists. Use unique one");
                    return;
                }
            }
        }
        else if (role!=null && !role.toString().contains("Business.Role.VolunteerRole")){
            UserAccount a = organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
            if(a == null){
                JOptionPane.showMessageDialog(null, "Username already exists choose unique one");
                return;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please choose a role");
            return;
        }
        dB4OUtil.storeSystem(business);
        populateData();
        nametxt.setText("");
        pswlbl.setText("");
    }//GEN-LAST:event_createuserbtnActionPerformed

    private void orgcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgcomboActionPerformed
        Organization organization = (Organization) orgcombo.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_orgcomboActionPerformed

    private void rolecomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rolecomboActionPerformed
        Role role = (Role) this.rolecombo.getSelectedItem();
        if (role!=null && role.toString().contains("Business.Role.VolunteerRole")){
            PhotojPanel.setVisible(true);
        }
        else{
            PhotojPanel.setVisible(false);
        }
    }//GEN-LAST:event_rolecomboActionPerformed

    private void usertblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usertblMouseClicked
        int selectedRow = usertbl.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "No User Selected");
            return;
        }

        UserAccount userAcoount = (UserAccount)usertbl.getValueAt(selectedRow, 0);

        String uploaded=null;
        uploaded=(userAcoount.getUploadedVolunteerPhoto())!=null?userAcoount.getUploadedVolunteerPhoto():"";
        //        System.out.println(uploaded);
        if(!uploaded.isEmpty()){
            ImageIcon icon=new ImageIcon(uploaded);
            Image image=icon.getImage().getScaledInstance(volunteerUpload.getWidth(), volunteerUpload.getHeight(), Image.SCALE_SMOOTH);
            volunteerUpload.setIcon(icon);

        }
        else{
            volunteerUpload.setIcon(null);
        }
    }//GEN-LAST:event_usertblMouseClicked

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) orgcombo.getSelectedItem();
        int row = usertbl.getSelectedRow();
        int column = 0;
        String value = usertbl.getModel().getValueAt(row, column).toString();
        System.out.println(value);
        organization.getUserAccountDirectory().deleteUser(value);
        dB4OUtil.storeSystem(business);
        volunteerUpload.setIcon(null);
        populateData();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void pswlblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pswlblActionPerformed
        // TODO add your handling code here:
        pswlbl.setVisible(false);
        

    }//GEN-LAST:event_pswlblActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PhotojPanel;
    private javax.swing.JButton backbtn;
    private javax.swing.JButton createuserbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JComboBox empcombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JTextField nametxt;
    private javax.swing.JComboBox orgcombo;
    private javax.swing.JTextField pswlbl;
    private javax.swing.JComboBox rolecombo;
    private javax.swing.JButton updateprofile;
    private javax.swing.JButton uploadPicturebtn;
    private javax.swing.JTable usertbl;
    private javax.swing.JLabel volunteerUpload;
    // End of variables declaration//GEN-END:variables
}
