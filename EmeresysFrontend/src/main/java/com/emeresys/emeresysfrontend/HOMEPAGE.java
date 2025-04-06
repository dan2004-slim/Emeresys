
package com.emeresys.emeresysfrontend;
import javax.swing.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.awt.event.ActionEvent;


public class HOMEPAGE extends javax.swing.JFrame {

    
    public HOMEPAGE() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        userLoginLabel = new javax.swing.JLabel();
        usernameoremail = new javax.swing.JLabel();
        identifierField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        forgotPassword = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Emeresys HomePage");
        setMinimumSize(new java.awt.Dimension(341, 100));
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        Right.setBackground(new java.awt.Color(50, 205, 50));
        Right.setPreferredSize(new java.awt.Dimension(402, 500));

        jLabel2.setText("Copyright © 2025 Emeresys. All Rights Reserved.");

        userLoginLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        userLoginLabel.setText("User Login");
        userLoginLabel.setAlignmentX(0.5F);

        usernameoremail.setText("Username /email: ");

        jLabel4.setText("Password:");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        signUpButton.setText("SignUp");

        forgotPassword.setText("Forgot Password");
        forgotPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotPasswordActionPerformed(evt);
            }
        });

        jLabel5.setText("forgot password?");

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameoremail)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(loginButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(forgotPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(identifierField)
                                .addComponent(passwordField)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(signUpButton))))))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(userLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(userLoginLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameoremail)
                    .addComponent(identifierField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(signUpButton))
                .addGap(41, 41, 41)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(forgotPassword)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(50, 205, 50));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 205, 50));
        jLabel1.setText("Choose account");

        jButton1.setBackground(new java.awt.Color(50, 205, 50));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("RESPONDENT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(50, 205, 50));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("USER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(50, 205, 50));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("ADMIN");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(93, 93, 93))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jButton1)
                .addGap(44, 44, 44)
                .addComponent(jButton2)
                .addGap(44, 44, 44)
                .addComponent(jButton3)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Right, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Right.getAccessibleContext().setAccessibleName("EM");

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 500);
        jPanel1.getAccessibleContext().setAccessibleName("HOMEPAGE");

        getAccessibleContext().setAccessibleName("Emeresys Homepage");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         Respodent RespodentFrame = new Respodent();
         RespodentFrame.setVisible(true);
         RespodentFrame.pack();
         RespodentFrame.setLocationRelativeTo(null); //center
         this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         UserLogin UserLoginFrame = new UserLogin();
         UserLoginFrame.setVisible(true);
         UserLoginFrame.pack();
         UserLoginFrame.setLocationRelativeTo(null); //center
         this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
        adminDashboard.pack();
        adminDashboard.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        //retrieve username from textfield
        String identifier = identifierField.getText();
        
        //retrieve password from password field
        String password = new String(passwordField.getPassword());
        
        
        // validate input to ensure neither field is empty
        if (identifier.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Username/ email and password are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop if validation fails
        }
        
        
        try{
            // call the ApiClient for login process
        String response = ApiClient.login(identifier, password);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> responseMap = mapper.readValue(response, Map.class);
        
        //Extract the message and the role
        String message = responseMap.get("message");
        String role = responseMap.get("role");
        
        //Handle successful login
        if (message.equals("Login Successful")){
            this.dispose();
        
          
            //Redirect based on role
            switch(role){
                case "user":
                    
                    UserDashboard userDashboard = new UserDashboard();
                    userDashboard.setVisible(true);
                    
                    break;
                case "admin":
                    AdminDashboard adminDashboard = new AdminDashboard();
                    adminDashboard.setVisible(true);
                    break;
                case "responder":
                    
                    ResponderDashboard responderDashboard = new ResponderDashboard();
                    responderDashboard.setVisible(true);
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Unkmown role. Please contact support", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            
            
        }
        //Handles invalid crederntials
        else if(response.contains("Invalid Username/email or password")){
            //Show error for failed login
            JOptionPane.showMessageDialog(this, "Invalid Username/email or password. Please try again ","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Handles other responses
        else {
            
            JOptionPane.showMessageDialog(this,response, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
        }catch(Exception e){
            // Handles Backend offline scenario
            JOptionPane.showMessageDialog(this,"Unable to connect to the server. Please check connection and try again ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private String extractRole(String jsonResponse){
        try{
            ObjectMapper mapper = new ObjectMapper();// jackson library for object parsing
            Map<String, String> responseMap = mapper.readValue(jsonResponse, Map.class);//Convert JSON to map
            
            return responseMap.get("role").toLowerCase(); //Retrieves the role key
        }catch(Exception e){
            e.printStackTrace();
            return "UNKNOWN";//Default to "UKNOWN" if parsing fails
        
        }
        
    }
    
    
    
    private void forgotPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_forgotPasswordActionPerformed

    
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOMEPAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</edpasswordField    //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOMEPAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JButton forgotPassword;
    private javax.swing.JTextField identifierField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel userLoginLabel;
    private javax.swing.JLabel usernameoremail;
    // End of variables declaration//GEN-END:variables
}
