/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uwomapviewer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * UserPOIEdit class for poi edit screen for user mode
 *
 * @author Talia, Jerry
 */
public class UserPOIEdit extends javax.swing.JFrame {

    /**
     * determine if user is editing or adding POI
     */
    private boolean editPOIStatus;
    /**
     * determine if the POI is favorited by the user
     */
    private boolean favoriteStatus = false;
    /**
     * the buildingScreen that is calling this class
     */
    private buildingScreen screen;
    /**
     * the poi that is being edited
     */
    private POI poi;
    /**
     * determine if the info is being added or discarded
     */
    private boolean add;
    /**
     * determine if user is exiting the screen or staying
     */
    private boolean exitStatus = false;

    /**
     * Constructor method used for creating new POIs
     *
     */
    public UserPOIEdit() {
        initComponents();
        editPOIStatus = false;
        add = false;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!exitStatus) {
                    int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? Your changes will not be saved",
                            "Close Window", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if ((x == JOptionPane.YES_OPTION)) {
                        e.getWindow().dispose();

                    } else {
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                }
            }
        });

        //Title is set to edit POI
        titleLabel.setText("Create New POI");
        setDefaultCloseOperation(UserPOIEdit.DISPOSE_ON_CLOSE);
    }

    /**
     * Constructor method used for existing POIs that will be edited
     *
     * @param poi the POI object that is being edited
     * @param screen the buildingScreen class that called this method
     */
    public UserPOIEdit(POI poi, buildingScreen screen) {
        initComponents();
        this.screen = screen;
        this.poi = poi;

        this.editPOIStatus = true;
        setDefaultCloseOperation(UserPOIEdit.DISPOSE_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!exitStatus) {
                    int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit? Your changes will not be saved",
                            "Close Window", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    if ((x == JOptionPane.YES_OPTION)) {
                        e.getWindow().dispose();

                    } else {
                        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                    }
                }
            }
        });

        //Title is set to edit POI
        titleLabel.setText("Edit POI");

        //Text fields will already have the existing values for the POI's name, room number and description
        POINameField.setText(poi.getPoiName());
        POIRoomField.setText(poi.getRoomNumber());
        DescriptionTextField.setText(poi.getDescription());
        favoriteButton.setSelected(poi.getFavorite(screen.getUser()));
    }

    /**
     * checkAddStatus method checks if adding poi is allowed(done button is
     * clicked)
     *
     * @return boolean
     */
    public boolean checkAddStatus() {
        return add;
    }

    /**
     * checkStatus returning if it is edit or add poi
     *
     * @return boolean of if edit
     */
    public boolean checkStatus() {
        return editPOIStatus;
    }

    /**
     * getPOIName method returning the name of the POI
     *
     * @return String of POI name
     */
    public String getPOIName() {
        return POINameField.getText();
    }

    /**
     * getRoomNumber method returning the room number of the POI
     *
     * @return String of room number
     */
    public String getRoomNumber() {
        return POIRoomField.getText();
    }

    /**
     * getDescription method returning the description of the POI
     *
     * @return String of POI description
     */
    public String getDescription() {
        return DescriptionTextField.getText();
    }

    /**
     * getFavoriteStatus method returning if the POI is favorited by current
     * user
     *
     * @return boolean
     */
    public Boolean getFavoriteStatus() {
        return favoriteStatus;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        POINameField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DescriptionTextField = new javax.swing.JTextField();
        doneButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        POIRoomField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        favoriteButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        POINameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POINameFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel4.setText("Description:");

        DescriptionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescriptionTextFieldActionPerformed(evt);
            }
        });

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        titleLabel.setText("Create New POI");

        POIRoomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POIRoomFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Room Number:");

        favoriteButton.setText("Favourite");
        favoriteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                favoriteButtonActionPerformed(evt);
            }
        });
        favoriteButton.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                favoriteButtonPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(POINameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(POIRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(doneButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(favoriteButton))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(POINameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(POIRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DescriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doneButton)
                            .addComponent(favoriteButton)))
                    .addComponent(jLabel2))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void favoriteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_favoriteButtonActionPerformed

        //If toggle button is on, favorite status will be true, otherwise it will be false.
        favoriteStatus = favoriteButton.isSelected();
    }//GEN-LAST:event_favoriteButtonActionPerformed

    private void POIRoomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POIRoomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_POIRoomFieldActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        // if there is no blanks in the form
        add = true;
        dispose();

        if (editPOIStatus == true) {
            POI newPOI = new POI(this.getPOIName(), poi.getX(), poi.getY(), poi.getBuilding(), poi.getFloor(), "userCreated", this.getRoomNumber(), this.getDescription(), poi.getFavoriteString(), screen.getUser());
            if (favoriteStatus && !poi.getFavorite(screen.getUser())) {
                newPOI.addFavorite(screen.getUser());
            }
            if (!favoriteStatus && poi.getFavorite(screen.getUser())) {
                newPOI.removeFavorite(screen.getUser());
            }
            screen.user.editPoi(poi, newPOI);
            screen.refresh();
            screen.loadPOIs();
            // screen.newPOI (this.getPOIName(), poi.getX(), poi.getY(), this.getCategory(), this.getRoomNumber(), this.getDescription(), this.getFavoriteStatus()); 
        }

    }//GEN-LAST:event_doneButtonActionPerformed

    private void DescriptionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescriptionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescriptionTextFieldActionPerformed

    private void POINameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POINameFieldActionPerformed

    }//GEN-LAST:event_POINameFieldActionPerformed

    private void favoriteButtonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_favoriteButtonPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_favoriteButtonPropertyChange



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DescriptionTextField;
    private javax.swing.JTextField POINameField;
    private javax.swing.JTextField POIRoomField;
    private javax.swing.JButton doneButton;
    private javax.swing.JToggleButton favoriteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
