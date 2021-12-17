
package userinterface.SystemAdminWorkArea;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import org.jfree.chart.ChartPanel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import Business.EcoSystem;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.util.HashMap;
import userinterface.LoginJPanel;
import Business.Analytics.NetworkManagement;
import Business.DB4OUtil.DB4OUtil;


/**
 *
 * @author niyati
 */
@SuppressWarnings("unchecked")

public class AnalyticsReportsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalyticsReportsJPanel
     */
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    private EcoSystem system;
    private JPanel userProcessContainer;
    public AnalyticsReportsJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        populateEmployeeCountGraph(system.getNetworkList().get(0).toString());
        populateFundsGraph(system.getNetworkList().get(0).toString());
    }
    
    private void populateEmployeeCountGraph(String networkSelected){

        HashMap<String,HashMap<String,Integer>> datamap=(new NetworkManagement(system)).getNetworkUsersWRTOrg(networkSelected);
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        for(String ent:datamap.keySet()){
            for(String org:datamap.get(ent).keySet()){
                dataset.addValue(datamap.get(ent).get(org),org,ent);
                String top=networkSelected;
                barGraph(dataset,top,"Enterprises","Employee Count");
            }
        }
    }
    
    private void populateFundsGraph(String networkSelected){

        HashMap<String,Integer> datamap=(new NetworkManagement(system)).getMoneyCollected(networkSelected);
        DefaultPieDataset dataset = new DefaultPieDataset( );
        for(String ent:datamap.keySet()){
            dataset.setValue(ent, datamap.get(ent));
            String top=networkSelected;
            pieChart(dataset,"Funds Analysis");
        }
    }
    
      private void barGraph(DefaultCategoryDataset dataset,String tHeader,String bHeader,String lHeader)
      
      {

        JFreeChart chart = ChartFactory.createBarChart3D
       (
        tHeader, // Title
        bHeader, // x-axis Label
        lHeader, // y-axis Label
        dataset, // Dataset
        PlotOrientation.VERTICAL, // Plot Orientation
        true, // Show Legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
       );
        plotJPanel.removeAll();
        plotJPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        plotJPanel.add(CP,BorderLayout.CENTER);
        plotJPanel.validate();
        
    }

    
    private void pieChart(DefaultPieDataset dataset,String tHeader){
        JFreeChart chart = ChartFactory.createPieChart3D(
        tHeader, // Title
        dataset, // Dataset
        true, // Show Legend
        true, // Use tooltips
        false // Configure chart to generate URLs?
        );
        
        pieplotJPanel.removeAll();
        pieplotJPanel.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        pieplotJPanel.add(CP,BorderLayout.CENTER);
        pieplotJPanel.validate();
    }
    

 
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plotJPanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        pieplotJPanel = new javax.swing.JPanel();
        logoutJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout plotJPanelLayout = new javax.swing.GroupLayout(plotJPanel);
        plotJPanel.setLayout(plotJPanelLayout);
        plotJPanelLayout.setHorizontalGroup(
            plotJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        plotJPanelLayout.setVerticalGroup(
            plotJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setText("<< back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pieplotJPanelLayout = new javax.swing.GroupLayout(pieplotJPanel);
        pieplotJPanel.setLayout(pieplotJPanelLayout);
        pieplotJPanelLayout.setHorizontalGroup(
            pieplotJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        pieplotJPanelLayout.setVerticalGroup(
            pieplotJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        logoutJButton.setBackground(new java.awt.Color(255, 0, 0));
        logoutJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        logoutJButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutJButton.setText("Logout");
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(logoutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plotJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieplotJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutJButton)
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(plotJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pieplotJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        LoginJPanel loginJPanel=new LoginJPanel();
        userProcessContainer.add("loginJPanel",loginJPanel);
        CardLayout layout=(CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPanel pieplotJPanel;
    private javax.swing.JPanel plotJPanel;
    // End of variables declaration//GEN-END:variables
}
