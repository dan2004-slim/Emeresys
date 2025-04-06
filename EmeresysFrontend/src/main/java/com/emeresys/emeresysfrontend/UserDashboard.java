/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.emeresys.emeresysfrontend;
import javax.swing.*;
import java.awt.*;
import java.awt.CardLayout;

/**
 *
 * @author USER
 */
public class UserDashboard extends javax.swing.JFrame {

    private NewsTicker newsTicker;
    /**
     * Creates new form UserDashboard
     */
    public UserDashboard() {
        initComponents();
        setSize(800,600);
        setLocationRelativeTo(null);
        
        sidePanel.setLayout(new javax.swing.BoxLayout(sidePanel, javax.swing.BoxLayout.Y_AXIS));
        sidePanel.remove(Box.createVerticalStrut(10));
        
        
       
        
        //Button overrides
        JButton[] buttons = {btnEmergencyHub, btnMapView, btnResources, btnCommunity, btnSettings};
        for (JButton button : buttons){
            button.setMinimumSize(new java.awt.Dimension(0,70));
            button.setPreferredSize(new java.awt.Dimension(0,70));
            button.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 70));
            button.setBorderPainted(false);
            button.setFocusPainted(false);
            button.setContentAreaFilled(true);
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            //Default background and text colors
            button.setBackground(new java.awt.Color(44, 44, 44)); // Charcoal gray background
            button.setForeground(new java.awt.Color(255, 255, 255)); // White text for contrast
            
            // sidePanel hover effect
            button.addMouseListener(new java.awt.event.MouseAdapter(){
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt){
                    button.setBackground(new java.awt.Color(60,60,60));
                    expandSidePanel();
                }
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt){
                    button.setBackground(new java.awt.Color(44,44,44));
                    collapseSidePanel();
                }
                
                
                
            });
            
        }
       
        //ReportButton functionality
        btnReportEmergency.addActionListener(e-> showSeverityDialog());
        
        //alertsBtn
        
        btnAlerts.addActionListener(e ->{
            if(isPanelExpanded){
                
            recollapseAlertsPanel();
            isPanelExpanded = false;
                
            }else{
            expandAlertsPanel();
            setupAlertsScrollPane();
            isPanelExpanded = true;
            }
        });
            
        
        // newsTicker initialisation
        newsTicker = new NewsTicker();
        
        //Add newsTicker to alertsFooter
        alertsPanel.setLayout(new BorderLayout());
        alertsPanel.add(newsTicker, BorderLayout.CENTER);
        
        }
        //method to expand sidepanel
    private void expandSidePanel(){
        sidePanel.setPreferredSize(new java.awt.Dimension(120,600));// Expanded width
        sidePanel.setBackground(new java.awt.Color(0,0,0, 150));// semi transparent
        sidePanel.revalidate();
        sidePanel.repaint();
    
   

    }
    
    private void collapseSidePanel(){
        sidePanel.setPreferredSize(new java.awt.Dimension(75,600));
        sidePanel.setBackground(new java.awt.Color(44,44, 44, 100));
        sidePanel.revalidate();
        sidePanel.repaint();
    }
    
    
    //Popup dialog method
    private void showSeverityDialog(){
        JDialog dialog  =new JDialog (this, "Emergency severity", true);
        dialog.setSize(300,150);
        dialog.setLayout(new BorderLayout());
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel("Select Emergency Severity");
        String[] severityOptions = {"low", "medium", "high"};
        JComboBox<String> severityComboBox = new JComboBox<>(severityOptions);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String selectedSeverity = (String) severityComboBox.getSelectedItem();
            System.out.println("Selected severity: "+selectedSeverity);
            dialog.dispose();
        });
        panel.add(label);
        panel.add(severityComboBox);
        dialog.add(panel,BorderLayout.CENTER);
        dialog.add(submitButton,BorderLayout.SOUTH);
        dialog.setVisible(true);
        
        
                
    }
    
    
    // boolean to track panel state
    private boolean isPanelExpanded = false;
    
    private void toggleAlertsPanel(){
        if (isPanelExpanded){
            
            recollapseAlertsPanel();
            isPanelExpanded = false;
        }else{
            expandAlertsPanel();
            setupAlertsScrollPane();
            isPanelExpanded = true;
        }
                
                
        
    }
    
    
    
    
    //panel height adjustment
    private void expandAlertsPanel(){
        alertsPanel.setPreferredSize(new java.awt.Dimension(getWidth(), 250));
        alertsPanel.revalidate();
        alertsPanel.repaint();
        
    }
    
        //panel height adjustment
    private void recollapseAlertsPanel(){
        alertsPanel.setPreferredSize(new java.awt.Dimension(getWidth(), 50));
        alertsPanel.removeAll();
        alertsPanel.setLayout(new BorderLayout());
        alertsPanel.add(newsTicker, BorderLayout.CENTER);
        alertsPanel.revalidate();
        alertsPanel.repaint();
        
    }
    
    
    
    
    //Changin  from ticker to scrollpane
    private void setupAlertsScrollPane(){
        //creating the scrollpane
        JScrollPane alertsScrollPane = new JScrollPane();
        alertsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //Panel inside the scrollpane with the alerts
        JPanel alertsContentPanel = new JPanel();
        alertsContentPanel.setLayout(new BoxLayout(alertsContentPanel, BoxLayout.Y_AXIS));
        
        //Using ticker alerts 
        for (String alert : newsTicker.getAlerts()) {
        JLabel alertLabel = new JLabel(alert); // Create a label for each alert
        alertLabel.setFont(new Font("Arial", Font.PLAIN, 14)); // Style the alerts
        alertsContentPanel.add(alertLabel); // Add to the panel
        }
        
        alertsScrollPane.setViewportView(alertsContentPanel);
        
        alertsPanel.removeAll();
        alertsPanel.setLayout(new BorderLayout());
        alertsPanel.add(alertsScrollPane, BorderLayout.CENTER);
        alertsPanel.revalidate();
        alertsPanel.repaint();
        
    }
    
   
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        btnEmergencyHub = new javax.swing.JButton();
        btnMapView = new javax.swing.JButton();
        btnCommunity = new javax.swing.JButton();
        btnResources = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        viewPane = new javax.swing.JPanel();
        emergencyHubTab = new javax.swing.JPanel();
        alertsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnReportEmergency = new javax.swing.JButton();
        btnAlerts = new javax.swing.JButton();
        mapViewTab = new javax.swing.JPanel();
        communityTab = new javax.swing.JPanel();
        resourcesTab = new javax.swing.JPanel();
        settingsTab = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomePage");
        setPreferredSize(new java.awt.Dimension(800, 600));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(800, 600));
        container.setLayout(new java.awt.BorderLayout());

        sidePanel.setPreferredSize(new java.awt.Dimension(50, 600));
        sidePanel.setLayout(new javax.swing.BoxLayout(sidePanel, javax.swing.BoxLayout.LINE_AXIS));

        btnEmergencyHub.setText("Emergency");
        btnEmergencyHub.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEmergencyHub.setPreferredSize(new java.awt.Dimension(70, 70));
        btnEmergencyHub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmergencyHubActionPerformed(evt);
            }
        });
        sidePanel.add(btnEmergencyHub);

        btnMapView.setText("Map");
        btnMapView.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnMapView.setPreferredSize(new java.awt.Dimension(70, 70));
        btnMapView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapViewActionPerformed(evt);
            }
        });
        sidePanel.add(btnMapView);

        btnCommunity.setText("community");
        btnCommunity.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnCommunity.setPreferredSize(new java.awt.Dimension(70, 70));
        btnCommunity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCommunityActionPerformed(evt);
            }
        });
        sidePanel.add(btnCommunity);

        btnResources.setText("resources");
        btnResources.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnResources.setPreferredSize(new java.awt.Dimension(70, 70));
        btnResources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResourcesActionPerformed(evt);
            }
        });
        sidePanel.add(btnResources);

        btnSettings.setText("settings");
        btnSettings.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnSettings.setPreferredSize(new java.awt.Dimension(70, 70));
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        sidePanel.add(btnSettings);

        container.add(sidePanel, java.awt.BorderLayout.LINE_START);

        viewPane.setLayout(new java.awt.CardLayout());

        emergencyHubTab.setBackground(new java.awt.Color(255, 255, 255));
        emergencyHubTab.setLayout(new java.awt.BorderLayout());

        alertsPanel.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout alertsPanelLayout = new javax.swing.GroupLayout(alertsPanel);
        alertsPanel.setLayout(alertsPanelLayout);
        alertsPanelLayout.setHorizontalGroup(
            alertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        alertsPanelLayout.setVerticalGroup(
            alertsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        emergencyHubTab.add(alertsPanel, java.awt.BorderLayout.PAGE_END);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        emergencyHubTab.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        btnReportEmergency.setText("Report Emergency");

        btnAlerts.setText("View Alerts");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReportEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlerts, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(598, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnReportEmergency, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnAlerts, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        emergencyHubTab.add(jPanel2, java.awt.BorderLayout.CENTER);

        viewPane.add(emergencyHubTab, "emergency");

        mapViewTab.setBackground(new java.awt.Color(204, 204, 255));
        mapViewTab.setLayout(new java.awt.BorderLayout());
        viewPane.add(mapViewTab, "map");

        communityTab.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout communityTabLayout = new javax.swing.GroupLayout(communityTab);
        communityTab.setLayout(communityTabLayout);
        communityTabLayout.setHorizontalGroup(
            communityTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        communityTabLayout.setVerticalGroup(
            communityTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        viewPane.add(communityTab, "community");

        resourcesTab.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout resourcesTabLayout = new javax.swing.GroupLayout(resourcesTab);
        resourcesTab.setLayout(resourcesTabLayout);
        resourcesTabLayout.setHorizontalGroup(
            resourcesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        resourcesTabLayout.setVerticalGroup(
            resourcesTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        viewPane.add(resourcesTab, "resources");

        settingsTab.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout settingsTabLayout = new javax.swing.GroupLayout(settingsTab);
        settingsTab.setLayout(settingsTabLayout);
        settingsTabLayout.setHorizontalGroup(
            settingsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        settingsTabLayout.setVerticalGroup(
            settingsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );

        viewPane.add(settingsTab, "settings");

        container.add(viewPane, java.awt.BorderLayout.CENTER);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmergencyHubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmergencyHubActionPerformed
        // TODO add your handling code here:
        
        CardLayout cl = (CardLayout) viewPane.getLayout();
        cl.show(viewPane, "emergency");
    }//GEN-LAST:event_btnEmergencyHubActionPerformed

    private void btnMapViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapViewActionPerformed
        // TODO add your handling code here:
        
        CardLayout cl = (CardLayout) viewPane.getLayout();
        cl.show(viewPane, "map");
    }//GEN-LAST:event_btnMapViewActionPerformed

    private void btnCommunityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCommunityActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) viewPane.getLayout();
        cl.show(viewPane, "community");
    }//GEN-LAST:event_btnCommunityActionPerformed

    private void btnResourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResourcesActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) viewPane.getLayout();
        cl.show(viewPane, "resources");
    }//GEN-LAST:event_btnResourcesActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) viewPane.getLayout();
        cl.show(viewPane, "settings");
    }//GEN-LAST:event_btnSettingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel alertsPanel;
    private javax.swing.JButton btnAlerts;
    private javax.swing.JButton btnCommunity;
    private javax.swing.JButton btnEmergencyHub;
    private javax.swing.JButton btnMapView;
    private javax.swing.JButton btnReportEmergency;
    private javax.swing.JButton btnResources;
    private javax.swing.JButton btnSettings;
    private javax.swing.JPanel communityTab;
    private javax.swing.JPanel container;
    private javax.swing.JPanel emergencyHubTab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel mapViewTab;
    private javax.swing.JPanel resourcesTab;
    private javax.swing.JPanel settingsTab;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JPanel viewPane;
    // End of variables declaration//GEN-END:variables
}
