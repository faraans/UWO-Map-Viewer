/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uwomapviewer;

import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * homeScreen class for the home screen
 *
 * @author Harrison, Jerry
 */
public class homeScreen extends javax.swing.JFrame {

    /**
     * user using the program
     */
    private String userName;

    /**
     * constructor method creating new home screen
     * @param user user using this program
     */
    public homeScreen(String user) {
        initComponents();
        userName = user;
        if (new Weather(this).updateWeatherData() != null) {
            displayWeather();
        }

        // Add for loop here that iterates through database, and adds all of the options to the list
        jComboBox1.addItem("Middlesex College");
        jComboBox1.addItem("Western Alumni Stadium");
        jComboBox1.addItem("Alumni Hall");
        jComboBox1.setEditable(false);

    }

    /**
     * desPlayWeather method for displaying the weather
     */
    public void displayWeather() {

        jLabel3.setText(new Weather(this).updateWeatherData() + "°C");

    }

    /**
     * noWeather method for no internet to get weather data
     */
    public void noWeather() {
        jLabel2.setText("Unable to pull weather data,check internect connection");
        jLabel3.setVisible(false);

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 25, 603, 548));
        setMinimumSize(new java.awt.Dimension(603, 548));
        setResizable(false);
        setSize(new java.awt.Dimension(603, 548));
        getContentPane().setLayout(null);

        jComboBox1.setBackground(new java.awt.Color(79, 38, 131));
        jComboBox1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(60, 140, 280, 40);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 38, 131));
        jLabel1.setText("Select Building");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 110, 200, 30);

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(79, 38, 131));
        jLabel4.setText("Campus Map Viewer");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 40, 510, 62);

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(79, 38, 131));
        jLabel2.setText("Current Weather on Campus:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 450, 530, 60);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 470, 110, 20);

        jButton2.setBackground(new java.awt.Color(79, 38, 131));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Help");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 140, 120, 40);

        jButton1.setBackground(new java.awt.Color(79, 38, 131));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Map");
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
        jButton1.setBounds(60, 190, 130, 40);

        jButton3.setBackground(new java.awt.Color(79, 38, 131));
        jButton3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Log Out");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(60, 390, 130, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        String comboInput = (String) jComboBox1.getSelectedItem();

        if (comboInput.equals("Middlesex College")) {

            buildingScreen buildingSc1 = new buildingScreen("MSC", userName);
            buildingSc1.setVisible(true);
            //this.setVisible(false);
            this.dispose();
        }
        if (comboInput.equals("Alumni Hall")) {

            buildingScreen buildingSc1 = new buildingScreen("AH", userName);
            buildingSc1.setVisible(true);
            //this.setVisible(false);
            this.dispose();
        }

        if (comboInput.equals("Western Alumni Stadium")) {

            buildingScreen buildingSc1 = new buildingScreen("TD", userName);
            buildingSc1.setVisible(true);
            //this.setVisible(false);
            this.dispose();
        }


    }//GEN-LAST:event_jButton1MouseClicked


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        Help help = new Help();
        help.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        //this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
