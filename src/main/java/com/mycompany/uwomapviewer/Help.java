/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uwomapviewer;

/**
 * Help class for the help screen
 *
 * @author Faraan, Jerry
 */
public class Help extends javax.swing.JFrame {

    /**
     * constructor method creating the help screen
     *
     */
    public Help() {
        initComponents();
        setDefaultCloseOperation(Help.DISPOSE_ON_CLOSE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea13 = new javax.swing.JTextArea();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextArea11 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea12 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(79, 38, 131));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jTextArea13.setEditable(false);
        jTextArea13.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea13.setColumns(20);
        jTextArea13.setLineWrap(true);
        jTextArea13.setRows(5);
        jTextArea13.setText("Once you enter in the username and password, click the login button to view the building selection screen.");
        jTextArea13.setWrapStyleWord(true);
        jScrollPane13.setViewportView(jTextArea13);

        jTabbedPane1.addTab("Login", jScrollPane13);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setText("Each floor has a list of POIs that are discoverable through the search list, the current list, and on the map. ");
        jTextArea2.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTextArea2);

        jTabbedPane3.addTab("Discovery", jScrollPane2);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jTextArea3.setText("To create a POI, click the \"Add POI\" button and click on the part of the map you want to place it. After giving it a name and any additional descriptions, the POI will be discoverable on the map and stored in the search bar and curren POI bar.");
        jTextArea3.setWrapStyleWord(true);
        jScrollPane3.setViewportView(jTextArea3);

        jTabbedPane3.addTab(" User-Created POI", jScrollPane3);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea4.setColumns(20);
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(5);
        jTextArea4.setText("When a POI is clicked, a dialog box will display a toggle to favourite POIs. If favourited, the POI will be added to a list of favourite POIs.");
        jTextArea4.setWrapStyleWord(true);
        jScrollPane4.setViewportView(jTextArea4);

        jTabbedPane3.addTab("Favourites", jScrollPane4);

        jTabbedPane1.addTab("POI", jTabbedPane3);

        jTabbedPane4.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea6.setEditable(false);
        jTextArea6.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea6.setColumns(20);
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(5);
        jTextArea6.setText("On the building selection page, the weather is on the botton left corner");
        jTextArea6.setWrapStyleWord(true);
        jScrollPane6.setViewportView(jTextArea6);

        jTabbedPane4.addTab("Weather", jScrollPane6);

        jTextArea8.setEditable(false);
        jTextArea8.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea8.setColumns(20);
        jTextArea8.setLineWrap(true);
        jTextArea8.setRows(5);
        jTextArea8.setText("From the main menu select the dropdown prompt . Select the desired Building, and then click the \"Open Map\" Button.");
        jTextArea8.setWrapStyleWord(true);
        jScrollPane8.setViewportView(jTextArea8);

        jTabbedPane4.addTab("Building Selection", jScrollPane8);

        jTabbedPane1.addTab("Main Page", jTabbedPane4);
        jTabbedPane4.getAccessibleContext().setAccessibleName("Weather");

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea11.setEditable(false);
        jTextArea11.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea11.setColumns(20);
        jTextArea11.setLineWrap(true);
        jTextArea11.setRows(5);
        jTextArea11.setText("Each floor is built with layers that can be toggled on and off to easily find what you are looking for\n");
        jTextArea11.setWrapStyleWord(true);
        jScrollPane11.setViewportView(jTextArea11);

        jTabbedPane5.addTab("Layers", jScrollPane11);

        jTextArea12.setEditable(false);
        jTextArea12.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea12.setColumns(20);
        jTextArea12.setLineWrap(true);
        jTextArea12.setRows(5);
        jTextArea12.setText("To return to the home screen from the building you selected, click the button in the top left hand corner of the screen.");
        jTextArea12.setWrapStyleWord(true);
        jScrollPane12.setViewportView(jTextArea12);

        jTabbedPane5.addTab("Return to Home Screen", jScrollPane12);

        jTabbedPane1.addTab("Maps", jTabbedPane5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea8;
    // End of variables declaration//GEN-END:variables
}
