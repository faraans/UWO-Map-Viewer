/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uwomapviewer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * login class for login screen
 * 
 * @author Harrison, Jerry
 */
public class Login extends javax.swing.JFrame {

    /**
     * whether or not the password and username entered is correct
     */
    boolean correct = false;

    /**
     * Constructor method creating new Login screen
     */
    public Login() {

        initComponents();

        ImageIcon iconLogo = new ImageIcon("dataStorage/AppLogonBanner.png");
        jLabel5.setIcon(iconLogo);

    }

    /**
     * checkPassword method checking if the username and password entered match
     * the JSON file. Public for testing
     *
     * @param user JSONObject storing the username and password
     * @param userName username entered
     * @param pwd password entered
     */
    public void checkPassword(JSONObject user, String userName, String pwd) {
        if (userName.equals(user.get("userName")) && pwd.equals(user.get("passWord")) && !correct) {
            // JOptionPane.showMessageDialog(null, "Login Successfull");
            homeScreen homeSc1 = new homeScreen(userName);
            homeSc1.setVisible(true);
            //this.setVisible(false);
            this.dispose();
            correct = true;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 38, 597, 529));
        setMinimumSize(new java.awt.Dimension(597, 529));
        setResizable(false);
        setSize(new java.awt.Dimension(597, 529));
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 210, 300, 40);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(150, 290, 300, 40);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 38, 131));
        jLabel1.setText("Password");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 270, 120, 17);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 38, 131));
        jLabel2.setText("Username");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 190, 120, 17);

        jButton1.setBackground(new java.awt.Color(79, 38, 131));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(150, 350, 130, 40);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 42)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(79, 38, 131));
        jLabel3.setText("Western University");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 40, 490, 59);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 42)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 38, 131));
        jLabel4.setText("Campus Map Viewer");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 90, 510, 52);

        jLabel5.setIcon(new javax.swing.ImageIcon("/Users/harrisonangellotti/Dropbox/Fourth Year/Software Engineering/Project/Western University Map Viewer/UwoMap/dataStorage/AppLogonBanner.png")); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-70, -110, 1020, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:

        String pwd = new String(jPasswordField1.getPassword());
        String userName = jTextField1.getText();
        dataStorage data = new dataStorage();
        JSONArray userList = data.getUserData();
        userList.forEach(user -> checkPassword((JSONObject) user, userName, pwd));
        if (!correct) {
            JOptionPane.showMessageDialog(null, "Login Failure!");
        }


    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * main method of the program
     * 
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
