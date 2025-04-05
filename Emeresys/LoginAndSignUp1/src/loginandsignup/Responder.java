
package loginandsignup;


public class Responder extends javax.swing.JFrame {

    
    public Responder() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        Left = new javax.swing.JPanel();
        copyrightLabel = new javax.swing.JLabel();
        ResponderLoginFormLogoButton = new javax.swing.JToggleButton();
        Right = new javax.swing.JPanel();
        ResponderLoginLabel = new javax.swing.JLabel();
        ResponderEmail = new javax.swing.JLabel();
        ResponderEmailTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        ResponderPasswordField = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ResponderSignUpButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Respondent_Login");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(800, 500));

        Left.setBackground(new java.awt.Color(50, 205, 50));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        copyrightLabel.setText("Copyright © 2025 Emeresys. All Rights Reserved.");

        ResponderLoginFormLogoButton.setBackground(new java.awt.Color(50, 205, 50));
        ResponderLoginFormLogoButton.setFont(new java.awt.Font("Sitka Text", 3, 48)); // NOI18N
        ResponderLoginFormLogoButton.setText("EMERESYS");
        ResponderLoginFormLogoButton.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(80, 205, 59)));
        ResponderLoginFormLogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponderLoginFormLogoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addComponent(copyrightLabel)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                        .addComponent(ResponderLoginFormLogoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(ResponderLoginFormLogoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(copyrightLabel)
                .addGap(68, 68, 68))
        );

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        ResponderLoginLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ResponderLoginLabel.setText("LOGIN");

        ResponderEmail.setText("Email");

        PasswordLabel.setText("Password");

        LoginButton.setBackground(new java.awt.Color(50, 205, 50));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LoginButton.setText("LOGIN");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("I don,t have an account ");

        ResponderSignUpButton.setBackground(new java.awt.Color(204, 204, 204));
        ResponderSignUpButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ResponderSignUpButton.setForeground(new java.awt.Color(255, 0, 0));
        ResponderSignUpButton.setText("Sign Up");
        ResponderSignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResponderSignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ResponderEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ResponderEmail))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PasswordLabel))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ResponderPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LoginButton))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ResponderSignUpButton))
                    .addGroup(RightLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(ResponderLoginLabel)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(ResponderLoginLabel)
                .addGap(42, 42, 42)
                .addComponent(ResponderEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResponderEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(PasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ResponderPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(LoginButton)
                .addGap(18, 18, 18)
                .addGroup(RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ResponderSignUpButton))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        BackButton.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Right, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BackButton))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResponderSignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResponderSignUpButtonActionPerformed
        
        SignUp SignUpFrame = new SignUp();
         SignUpFrame.setVisible(true);
         SignUpFrame.pack();
         SignUpFrame.setLocationRelativeTo(null); //center
         this.dispose();
    }//GEN-LAST:event_ResponderSignUpButtonActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
         HOMEPAGE HOMEPAGEFrame = new HOMEPAGE();
         HOMEPAGEFrame.setVisible(true);
         HOMEPAGEFrame.pack();
         HOMEPAGEFrame.setLocationRelativeTo(null); //center
         this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ResponderLoginFormLogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResponderLoginFormLogoButtonActionPerformed
        // TODO add your handling code here:
        HOMEPAGE HOMEPAGEFrame = new HOMEPAGE();
        HOMEPAGEFrame.setVisible(true);
        HOMEPAGEFrame.pack();
        HOMEPAGEFrame.setLocationRelativeTo(null); //center
        this.dispose();
    }//GEN-LAST:event_ResponderLoginFormLogoButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("login btn is clicked");
    }//GEN-LAST:event_LoginButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Responder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel Left;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel ResponderEmail;
    private javax.swing.JTextField ResponderEmailTextField;
    private javax.swing.JToggleButton ResponderLoginFormLogoButton;
    private javax.swing.JLabel ResponderLoginLabel;
    private javax.swing.JPasswordField ResponderPasswordField;
    private javax.swing.JButton ResponderSignUpButton;
    private javax.swing.JPanel Right;
    private javax.swing.JLabel copyrightLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
