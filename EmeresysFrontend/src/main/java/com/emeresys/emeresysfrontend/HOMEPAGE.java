
package com.emeresys.emeresysfrontend;
import javax.swing.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.awt.event.ActionEvent;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.client5.http.fluent.Request;


public class HOMEPAGE extends javax.swing.JFrame {

    private static final String BASE_URL = "http://localhost:8080";

    
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
        Left = new javax.swing.JPanel();

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
                            .addComponent(loginButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(identifierField)
                            .addComponent(passwordField)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                                .addGap(0, 46, Short.MAX_VALUE)
                                .addComponent(signUpButton)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
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

    
    
    
    
    
    
    
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        
        //retrieve username from textfield
        String identifier = identifierField.getText();
        char[] passwordChars = passwordField.getPassword();
        
        //retrieve password from password field
        String password = new String(passwordChars);
        java.util.Arrays.fill(passwordChars, ' ');
        
        
        // validate input to ensure neither field is empty
        if (identifier.isEmpty() || password.isEmpty()){
            JOptionPane.showMessageDialog(this, "Username/ email and password are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop if validation fails
        }
        
        
        try{
            // call the ApiClient for login process
        String userId = ApiClient.login(identifier, password);
        
        if (userId == null){
            JOptionPane.showMessageDialog(this, "Login failed. Could not retrieve user ID. Please check credentials.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String role = determineUserRole(userId);
        String message = "Login Successful";
        //Extract the message and the role
        
        
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
                    
                    responderDashboard_1 responderDashboard = new responderDashboard_1();
                    responderDashboard.setVisible(true);
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Unknown role. Please contact support", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
            
            
        }
       
        
        //Handles other responses
        else {
            
            JOptionPane.showMessageDialog(this,message, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
        
        
        }catch(Exception e){
            // Handles Backend offline scenario
            JOptionPane.showMessageDialog(this,"Unable to connect to the server. Please check connection and try again ", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private String determineUserRole(String userId){
        try{
            // Make a backend call to fetch user role (e.g., GET /users/{id}/role)
        String endpoint = BASE_URL + "/users/" + userId + "/role";
        Content content = Request.get(endpoint)
                .execute()
                .returnContent();

        // Parse the backend response to extract the role
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> responseMap = mapper.readValue(content.asString(), Map.class);

        // Retrieve and return the role key
        String role = responseMap.get("role").toLowerCase();
        String id = responseMap.get("id"); // Extracting "id"
String message = responseMap.get("message"); // Extracting "message"
System.out.println("Role received: " + role);
System.out.println("ID received: " + id);
System.out.println("Message received: " + message);

        System.out.println("Role fetched:" + role);
        return role;
            
        }catch(Exception e){
            e.printStackTrace();
            return "UNKNOWN";//Default to "UKNOWN" if parsing fails
        
        }
        
    }
    
    
    
    
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
    private javax.swing.JTextField identifierField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel userLoginLabel;
    private javax.swing.JLabel usernameoremail;
    // End of variables declaration//GEN-END:variables
}
