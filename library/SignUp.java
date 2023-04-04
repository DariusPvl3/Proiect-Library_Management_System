/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Darius
 */
public class SignUp extends javax.swing.JFrame {

    /**
     * Creates new form SignUp
     */
    public SignUp() {
        initComponents();
    }
    
    Connection con = null;
    
    /**
     * Method to insert values into the users table 
     */
    public void insertSignUpDetails(){
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
           PreparedStatement pst = con.prepareStatement("INSERT INTO utilizatori(name, password, email, phone) VALUES(?, ?, ?, ?)");
           pst.setString(1, usernameField.getText());
           pst.setString(2, String.valueOf(passwordField.getPassword()));
           pst.setString(3, emailField.getText());
           pst.setString(4, phoneField.getText());    
           int updatedRowCount = pst.executeUpdate();
           if(updatedRowCount > 0){
            JOptionPane.showMessageDialog(this, "Record Inserted Succesfully!");
            LogIn login = new LogIn();
            login.setVisible(true);
            this.dispose();
           }
           else
            JOptionPane.showMessageDialog(this, "Record Insertion Failed!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // sign-up validation
    public boolean validateSignUp(){
        if(usernameField.getText().equals("")){ JOptionPane.showMessageDialog(this, "Please enter an username!"); return false; } 
        else if(String.valueOf(passwordField.getPassword()).equals("") || String.valueOf(passwordField.getPassword()).matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")){ JOptionPane.showMessageDialog(this, "Please enter a valid password!"); return false; } 
        else if(emailField.getText().equals("") || !emailField.getText().matches("^.+@.+\\..+$")){ JOptionPane.showMessageDialog(this, "Please enter a valid email address!"); return false; }
        else if(phoneField.getText().equals("") || !phoneField.getText().matches("0(([7][456728])|([23]51)).*")){ JOptionPane.showMessageDialog(this, "Please enter a valid phone number!"); return false;}
        else { return true; }
    }

    public boolean duplicateUser(){
        String name = usernameField.getText();
        boolean userExists = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM utilizatori WHERE name = ?");
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){ userExists = true; }
            else { userExists = false; }
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
        return userExists;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainFrame = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formFrame = new javax.swing.JPanel();
        signUpLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        logInButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        mainFrame.setBackground(new java.awt.Color(234, 253, 248));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("Library Management System");

        formFrame.setBackground(new java.awt.Color(22, 105, 122));
        formFrame.setForeground(new java.awt.Color(0, 0, 0));

        signUpLabel.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        signUpLabel.setForeground(new java.awt.Color(234, 253, 248));
        signUpLabel.setText("Sign Up");

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(234, 253, 248));
        usernameLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Account_50px.png"))); // NOI18N
        usernameLabel.setText("Username");

        usernameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFieldFocusLost(evt);
            }
        });
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(234, 253, 248));
        passwordLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Secure_50px.png"))); // NOI18N
        passwordLabel.setText("Password");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        phoneLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(234, 253, 248));
        phoneLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Google_Mobile_50px.png"))); // NOI18N
        phoneLabel.setText("Phone");

        phoneField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneFieldActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(234, 253, 248));
        emailLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_Secured_Letter_50px.png"))); // NOI18N
        emailLabel.setText("E-Mail");

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        logInButton.setBackground(new java.awt.Color(72, 159, 181));
        logInButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        logInButton.setForeground(new java.awt.Color(0, 0, 0));
        logInButton.setText("Log In");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        signUpButton.setBackground(new java.awt.Color(72, 159, 181));
        signUpButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(0, 0, 0));
        signUpButton.setText("Sign Up");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        closeButton.setBackground(new java.awt.Color(72, 159, 181));
        closeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        closeButton.setForeground(new java.awt.Color(0, 0, 0));
        closeButton.setText("X");
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout formFrameLayout = new javax.swing.GroupLayout(formFrame);
        formFrame.setLayout(formFrameLayout);
        formFrameLayout.setHorizontalGroup(
            formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formFrameLayout.createSequentialGroup()
                .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formFrameLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(signUpLabel))
                    .addGroup(formFrameLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel)
                            .addComponent(usernameLabel))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formFrameLayout.createSequentialGroup()
                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formFrameLayout.createSequentialGroup()
                        .addComponent(closeButton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formFrameLayout.createSequentialGroup()
                        .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
            .addGroup(formFrameLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formFrameLayout.createSequentialGroup()
                            .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailLabel)
                                .addComponent(phoneLabel))
                            .addGap(76, 76, 76))
                        .addGroup(formFrameLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        formFrameLayout.setVerticalGroup(
            formFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(closeButton)
                .addGap(2, 2, 2)
                .addComponent(signUpLabel)
                .addGap(41, 41, 41)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/signup-library-icon.png"))); // NOI18N

        javax.swing.GroupLayout mainFrameLayout = new javax.swing.GroupLayout(mainFrame);
        mainFrame.setLayout(mainFrameLayout);
        mainFrameLayout.setHorizontalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addGroup(mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainFrameLayout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(titleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainFrameLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(formFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainFrameLayout.setVerticalGroup(
            mainFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainFrameLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(formFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void phoneFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        // TODO add your handling code here:
        if(validateSignUp() == true){
            if(duplicateUser() == false)
                insertSignUpDetails();
            else
                JOptionPane.showMessageDialog(this, "This username already exists!");
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        // TODO add your handling code here:
        LogIn login = new LogIn();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logInButtonActionPerformed

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeButtonMouseClicked

    private void usernameFieldFocusLost(java.awt.event.FocusEvent evt) {                                        
        // TODO add your handling code here:
        if(duplicateUser() == true)
            JOptionPane.showMessageDialog(this, "This username already exists!");

    }                                         

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel formFrame;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logInButton;
    private javax.swing.JPanel mainFrame;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}