/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.emeresys.emeresysfrontend;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author USER
 */
public class ResponderDashboard extends javax.swing.JFrame {

    private javax.swing.JPanel dropdownMenu;

    /**
     * Creates new form ResponderDashboard
     */
    public ResponderDashboard() {
        initComponents();

        dropdownMenu = new javax.swing.JPanel();
        dropdownMenu.setLayout(new javax.swing.BoxLayout(dropdownMenu, javax.swing.BoxLayout.Y_AXIS)); // Vertical layout
        dropdownMenu.setBackground(new java.awt.Color(0, 0, 0, 150)); // Semi-transparent black
        dropdownMenu.setVisible(false); // Start as hidden

// Add the dropdown menu below the navbar
        navbar.add(dropdownMenu, java.awt.BorderLayout.SOUTH);

        options.setText("☰"); // Unicode character for the hamburger icon

        // Custom layout logic for your navbar (AFTER initComponents())
        setupNavbarComponents();

        setupDropdownMenuItems();

        navbar.setLayout(new BorderLayout());
        // Move options (hamburger button) to the leftmost
        navbar.remove(navProfile); // Remove jPanel1 from its default position
        navProfile.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align components to the left
        navbar.add(navProfile, BorderLayout.WEST); // Add jPanel1 (hamburger panel) to the left

        // Move userProfile to the rightmost
        navbar.remove(userProfile); // Remove userProfile from its default position
        userProfile.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align components to the right
        navbar.add(userProfile, BorderLayout.EAST); // Add userProfile to the right

        // Revalidate and repaint to apply changes
        navbar.revalidate();
        navbar.repaint();
        
        options.addActionListener(e -> toggleDropdownMenu());


    }

    private void setupNavbarComponents() {
        navbar.setLayout(new BorderLayout()); // Set navbar layout to BorderLayout

        // *** Hamburger Panel (Left) ***
        JPanel hamburgerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Align components to the left
        options = new javax.swing.JButton("☰"); // Initialize the hamburger button
        hamburgerPanel.add(options); // Add the hamburger button
        navbar.add(hamburgerPanel, BorderLayout.WEST); // Add the panel to the left

        // *** User Profile Panel (Right) ***
        JPanel userProfilePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Align components to the right
        JLabel profilePicture = new JLabel("Profile Picture"); // Placeholder for profile picture
        JLabel username = new JLabel("Username"); // Replace with actual username
        JLabel role = new JLabel("Role"); // Replace with actual role
        userProfilePanel.add(profilePicture);
        userProfilePanel.add(username);
        userProfilePanel.add(role);
        navbar.add(userProfilePanel, BorderLayout.EAST); // Add the panel to the right
    }
    
    private void toggleDropdownMenu() {
    if (dropdownMenu.isVisible()) {
        dropdownMenu.setVisible(false); // Hide dropdown
    } else {
        dropdownMenu.setVisible(true); // Show dropdown
    }
    dropdownMenu.revalidate();
    dropdownMenu.repaint();
}
    
    private void setupDropdownMenuItems() {
    JButton btnMap = new JButton("Map");
    btnMap.addActionListener(e -> switchToPanel("map")); // Switch to Map panel

    JButton btnComms = new JButton("Comms");
    btnComms.addActionListener(e -> switchToPanel("comms")); // Switch to Comms panel

    JButton btnSettings = new JButton("Settings");
    btnSettings.addActionListener(e -> switchToPanel("settings")); // Switch to Settings panel

    // Add buttons to the dropdown
    dropdownMenu.add(btnMap);
    dropdownMenu.add(Box.createVerticalStrut(10)); // Spacer
    dropdownMenu.add(btnComms);
    dropdownMenu.add(Box.createVerticalStrut(10)); // Spacer
    dropdownMenu.add(btnSettings);
}
    private void switchToPanel(String cardName) {
    CardLayout layout = (CardLayout) viewpane.getLayout();
    layout.show(viewpane, cardName);
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
        navbar = new javax.swing.JPanel();
        navProfile = new javax.swing.JPanel();
        options = new javax.swing.JButton();
        userProfile = new javax.swing.JPanel();
        pfp = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        viewpane = new javax.swing.JPanel();
        map = new javax.swing.JPanel();
        comms = new javax.swing.JPanel();
        settings = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HomePage");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.BorderLayout());

        navbar.setPreferredSize(new java.awt.Dimension(800, 50));
        navbar.setLayout(new java.awt.BorderLayout());

        navProfile.setBackground(new java.awt.Color(204, 204, 255));
        navProfile.setPreferredSize(new java.awt.Dimension(400, 50));

        options.setText("options");
        navProfile.add(options);
        options.getAccessibleContext().setAccessibleName("options ");

        navbar.add(navProfile, java.awt.BorderLayout.EAST);

        userProfile.setBackground(new java.awt.Color(255, 255, 255));
        userProfile.setPreferredSize(new java.awt.Dimension(400, 50));

        pfp.setText("Profile Picture");
        userProfile.add(pfp);

        username.setText("Username");
        userProfile.add(username);

        role.setText("Role");
        userProfile.add(role);

        navbar.add(userProfile, java.awt.BorderLayout.WEST);

        container.add(navbar, java.awt.BorderLayout.PAGE_START);

        viewpane.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout mapLayout = new javax.swing.GroupLayout(map);
        map.setLayout(mapLayout);
        mapLayout.setHorizontalGroup(
            mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );
        mapLayout.setVerticalGroup(
            mapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        viewpane.add(map, "map");

        javax.swing.GroupLayout commsLayout = new javax.swing.GroupLayout(comms);
        comms.setLayout(commsLayout);
        commsLayout.setHorizontalGroup(
            commsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );
        commsLayout.setVerticalGroup(
            commsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        viewpane.add(comms, "comms");

        javax.swing.GroupLayout settingsLayout = new javax.swing.GroupLayout(settings);
        settings.setLayout(settingsLayout);
        settingsLayout.setHorizontalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 824, Short.MAX_VALUE)
        );
        settingsLayout.setVerticalGroup(
            settingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        viewpane.add(settings, "settings");

        container.add(viewpane, java.awt.BorderLayout.CENTER);

        getContentPane().add(container, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ResponderDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResponderDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResponderDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResponderDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResponderDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel comms;
    private javax.swing.JPanel container;
    private javax.swing.JPanel map;
    private javax.swing.JPanel navProfile;
    private javax.swing.JPanel navbar;
    private javax.swing.JButton options;
    private javax.swing.JLabel pfp;
    private javax.swing.JLabel role;
    private javax.swing.JPanel settings;
    private javax.swing.JPanel userProfile;
    private javax.swing.JLabel username;
    private javax.swing.JPanel viewpane;
    // End of variables declaration//GEN-END:variables
}
