/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.uwomapviewer;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;

/**
 * building screen class for showing the target building that the user wants to
 * look at
 *
 * @author Jerry, Harrison, Talia, Farran, Abdul
 */
public class buildingScreen extends javax.swing.JFrame {
    // private ArrayList<JLabel> mapImage;

    /**
     * image of the map
     */
    private JLabel mapImage;

    /**
     * search list GUI
     */
    DefaultListModel defaultListModel = new DefaultListModel();
    /**
     * favorite list GUI
     */
    DefaultListModel defaultListModel_Favourite = new DefaultListModel();
    /**
     * current list GUI
     */
    DefaultListModel defaultListModel_Current = new DefaultListModel();
    /**
     * user created list GUI
     */
    DefaultListModel defaultListModel_User = new DefaultListModel();

    /**
     * the current building
     */
    private String currentBuilding;
    /**
     * the current floor
     */
    private int currentFloor;
    /**
     * if the add poi button is clicked
     */
    private boolean addButtonClicked;
    /**
     * if user is in editor mode
     */
    public boolean editorMode;
    /**
     * list of searched POIs
     */
    ArrayList<POI> searchList;
    /**
     * list of POI in all buildings
     */
    ArrayList<POI> buildingList;
    /**
     * list of user favorited POIs
     */
    ArrayList<POI> favouriteList;
    /**
     * list of POIs on current floor and layers
     */
    ArrayList<POI> currentList;
    /**
     * list of user created POIs
     */
    ArrayList<POI> userList;
    /**
     * list of poi buttons matching building list
     */
    ArrayList<JToggleButton> buttonList = new ArrayList();

    /**
     * stores the layers currently on
     */
    private ArrayList<String> layerList = new ArrayList<>();

    /**
     * dataStorage class object for storing and getting datas
     */
    public dataStorage user;
    /**
     * username of the current user
     */
    private String userName;

    /**
     * constructor method creates new form buildingScreen
     *
     * @param selectedBuilding the building name
     * @param userName the user who is viewing the map
     */
    public buildingScreen(String selectedBuilding, String userName) {
        initComponents();

        this.userName = userName;
        jComboBox1.addItem("User Created POIs");
        jComboBox1.addItem("Favourited POIs");
        user = new dataStorage();
        buildingList = user.getpoiData();
        editorMode = false;

        accesibilityLayer.setSelected(true);

        //If MiddleSex building is selected, set up building object which stores all floors for that building.
        currentBuilding = selectedBuilding;
        accesibilityLayer.setSelected(true);
        userCreatedLayer.setSelected(true);
        classroomLayer.setSelected(true);
        labLayer.setSelected(true);
        washroomsLayer.setSelected(true);
        stairLayer.setSelected(true);
        elevatorLayer.setSelected(true);
        exitLayer.setSelected(true);
        restaurantLayer.setSelected(true);

        this.blindData();
        this.blindData_Favourite();
        this.blindData_Current();
        this.blindData_User();
        for (int i = 0; i < buildingList.size(); i++) {
            loadPOI(buildingList.get(i));
        }

        int numOfFloors = 5;
        switch (selectedBuilding) {
            case "MSC" -> {
                numOfFloors = 5;
                //Display the name of the current building
                buildingName.setText("Middlesex College");
            }
            case "AH" -> {
                numOfFloors = 3;
                floor4Button.setVisible(false);
                floor5Button.setVisible(false);
                //Display the name of the current building
                buildingName.setText("Alumni Hall");
            }
            case "TD" -> {
                numOfFloors = 2;
                floor3Button.setVisible(false);
                floor4Button.setVisible(false);
                floor5Button.setVisible(false);
                //Display the name of the current building
                buildingName.setText("Western Alumni Stadium");

            }
        }

        changeFloor(1);
        this.blindData();
        this.blindData_Favourite();
        this.blindData_Current();
        this.blindData_User();
        /*
        buttonList.clear();
        for (int i = 0; i< buildingList.size(); i++){
            loadPOI(buildingList.get(i));
        }
         */
    }

    /**
     * getSelectedPOIs method return the POI list which is on current floor and
     * is selected by checkbox type
     *
     * @return ArrayList of POI objects
     */
    public ArrayList<POI> getSelectedPOIs() {
        ArrayList<POI> poi;
        ArrayList<POI> filtered = new ArrayList<>();
        poi = user.getpoiData();
        for (int i = 0; i < poi.size(); i++) {
            if (poi.get(i).getBuilding().equals(currentBuilding) && poi.get(i).getFloor() == currentFloor) {
                if (classroomLayer.isSelected() && poi.get(i).getCategory().equals("classroom")) {
                    filtered.add(poi.get(i));
                }
                if (stairLayer.isSelected() && poi.get(i).getCategory().equals("stairs")) {
                    filtered.add(poi.get(i));
                }
                if (washroomsLayer.isSelected() && poi.get(i).getCategory().equals("washroom")) {
                    filtered.add(poi.get(i));
                }
                if (userCreatedLayer.isSelected() && poi.get(i).getCategory().equals("userCreated")) {
                    filtered.add(poi.get(i));
                }
                if (labLayer.isSelected() && poi.get(i).getCategory().equals("lab")) {
                    filtered.add(poi.get(i));
                }
                if (restaurantLayer.isSelected() && poi.get(i).getCategory().equals("restaurant")) {
                    filtered.add(poi.get(i));
                }
                if (exitLayer.isSelected() && poi.get(i).getCategory().equals("exit")) {
                    filtered.add(poi.get(i));
                }
                if (elevatorLayer.isSelected() && poi.get(i).getCategory().equals("elevator")) {
                    filtered.add(poi.get(i));
                }

            }
        }
        return filtered;
    }

    /**
     * getPOIFav method return the list of favorite POIs by the current user
     *
     * @return ArrayList of POI objects
     */
    public ArrayList<POI> getPOIFav() {
        ArrayList<POI> poi;
        ArrayList<POI> filtered = new ArrayList<>();
        poi = user.getpoiData();
        for (int i = 0; i < poi.size(); i++) {
            if (poi.get(i).getFavorite(userName)) {
                filtered.add(poi.get(i));
            }

        }

        return filtered;
    }

    /**
     * getPOIUser method return the list of current user created POIs
     *
     * @return ArrayList of POI objects
     */
    public ArrayList getPOIUser() {

        ArrayList<POI> poi;
        ArrayList<POI> filtered = new ArrayList<>();
        poi = user.getpoiData();

        for (int i = 0; i < poi.size(); i++) {
            if (poi.get(i).getCategory().equals("userCreated") && poi.get(i).getCreated().equals(userName)) {
                filtered.add(poi.get(i));
            }
        }
        return filtered;
    }

    /**
     * getButtonList method return the list of all poi buttons
     *
     * @return ArrayList of JToggleButtons
     */
    public ArrayList<JToggleButton> getButtonList() {
        return buttonList;
    }

    /**
     * getPOIList method returns the poi list of the whole map
     *
     * @return ArrayList of POI objects
     */
    public ArrayList<POI> getPOIList() {
        return buildingList;
    }

    /**
     * blindData method insert the list of searched poi list to jList
     *
     */
    public void blindData() {
        defaultListModel.removeAllElements();

        buildingList = user.getpoiData();
        searchList = user.searchPoi("");
        for (int i = 0; i < searchList.size(); i++) {
            defaultListModel.addElement(searchList.get(i).getPoiName());
        }
        jList1.setModel(defaultListModel);
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * blindData_Favourite method insert the list of current user favourite poi
     * list to jList
     *
     */
    public void blindData_Favourite() {
        //buildingList = user.getpoiData();
        defaultListModel_Favourite.removeAllElements();
        //getPOIFav().stream().forEach((POI) -> {defaultListModel_Favourite.addElement(POI);});
        favouriteList = getPOIFav();
        for (int i = 0; i < favouriteList.size(); i++) {
            defaultListModel_Favourite.addElement(favouriteList.get(i).getPoiName());
        }
        jList3.setModel(defaultListModel_Favourite);
        jList3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * blindData_Current method insert the list of current floor selected poi
     * list to jList
     *
     */
    public void blindData_Current() {
        defaultListModel_Current.removeAllElements();

        currentList = getSelectedPOIs();
        for (int i = 0; i < currentList.size(); i++) {
            defaultListModel_Current.addElement(currentList.get(i).getPoiName());
        }
        jList2.setModel(defaultListModel_Current);
        jList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * blindData_Current method insert the list of current user created poi list
     * to jList
     *
     */
    public void blindData_User() {
        defaultListModel_User.removeAllElements();

        userList = getPOIUser();
        for (int i = 0; i < userList.size(); i++) {
            defaultListModel_User.addElement(userList.get(i).getPoiName());
        }
        jList4.setModel(defaultListModel_User);
        jList4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * getUser method return the user current using the app
     *
     * @return String
     */
    public String getUser() {
        return userName;
    }

    /*
    public void setUpBuilding(String buildingCode, int numberOfFloors) {
        //Building msc = new Building("MSC");

        /*
        for (int i = 1; i <= numberOfFloors; i++) {
            msc.addFloor(i);
        }
        

        changeFloor(1);
    }
     */
    /**
     * changeFloor method changes to specific floor and initializes GUI
     *
     * @param floorNum the floor the user is switching to
     */
    public void changeFloor(int floorNum) {

        //reset the layerList array to contain all categories
        layerList = new ArrayList();
        layerList.add("accessibility");
        layerList.add("userCreated");
        layerList.add("classroom");
        layerList.add("lab");
        layerList.add("washroom");
        layerList.add("stairs");
        layerList.add("elevator");
        layerList.add("exit");
        layerList.add("restaurant");

        //turn all layers on
        accesibilityLayer.setSelected(true);
        userCreatedLayer.setSelected(true);
        classroomLayer.setSelected(true);
        labLayer.setSelected(true);
        washroomsLayer.setSelected(true);
        stairLayer.setSelected(true);
        elevatorLayer.setSelected(true);
        exitLayer.setSelected(true);
        restaurantLayer.setSelected(true);

        //set editor mode to false and addButtonClicked to false
        //addButtonClicked = false;
        //
        //Update current floor variable
        currentFloor = floorNum;

        //Reset scroll locations
        mscScrollPane.getHorizontalScrollBar().setValue(0);
        mscScrollPane.getVerticalScrollBar().setValue(0);

        //Load all the POIs for the floor
        loadPOIs();

        blindData_Current();
    }

    /**
     * loadPOIs method reloads all POIs according to the current building, floor
     * and layers selected
     *
     */
    public void loadPOIs() {
        int x = mscScrollPane.getHorizontalScrollBar().getValue();
        int y = mscScrollPane.getVerticalScrollBar().getValue();

        mscLayeredPane = new javax.swing.JLayeredPane();

        getContentPane().add(mscScrollPane);

        mapImage = new JLabel();
        if (layerList.contains("accessibility")) {
            mapImage.setIcon(new ImageIcon("dataStorage/" + currentBuilding + "/" + currentBuilding + "_A" + currentFloor + ".png"));
        } else {
            mapImage.setIcon(new ImageIcon("dataStorage/" + currentBuilding + "/" + currentBuilding + "_NA" + currentFloor + ".png"));
        }

        mscLayeredPane.add(mapImage);
        mscLayeredPane.setComponentZOrder(mapImage, 0);
        mapImage.setBounds(0, 0, 1220, 790);

        getContentPane().add(mscLayeredPane);
        mscLayeredPane.setBounds(0, 0, 1220, 790);
        mscLayeredPane.setPreferredSize(new Dimension(1220, 790));
        mscScrollPane.setViewportView(mscLayeredPane);

        //Maintain scroll location
        mscScrollPane.getHorizontalScrollBar().setValue(x);
        mscScrollPane.getVerticalScrollBar().setValue(y);

        buttonList.clear();
        for (int i = 0; i < buildingList.size(); i++) {
            loadPOI(buildingList.get(i));
        }

        //load all POIs for current floor of the selected categories
        ArrayList<POI> poiList = user.getpoiData();

        for (int i = 0; i < poiList.size(); i++) {

            if ((poiList.get(i).getBuilding().equals(currentBuilding)) && (poiList.get(i).getFloor() == currentFloor) && (layerList.contains(poiList.get(i).getCategory()))) {
                if (poiList.get(i).getCategory().equals("userCreated")) {
                    if (poiList.get(i).getCreated().equals(userName)) {
                        displayPOI(poiList.get(i));
                    }
                } else {
                    displayPOI(poiList.get(i));
                }

            }

        }

    }

    /**
     * newPOI method creates a new poi, save it to json file and display the new
     * POI
     *
     * @param name name of the poi
     * @param x x coordinate of the poi
     * @param y y coordinate of the poi
     * @param category category of the poi
     * @param roomNum room number of the poi
     * @param description description of the poi
     * @param fav if the poi is favorited by the user when created
     */
    public void newPOI(String name, int x, int y, String category, String roomNum, String description, Boolean fav) {
        String favourite;
        if (fav) {
            favourite = "<" + userName + ">";
        } else {
            favourite = "";
        }
        POI p = new POI(name, x, y, currentBuilding, currentFloor, category, roomNum, description, favourite, userName);
        user.addPoi(p);
        refresh();
        displayPOI(p);
    }

    buildingScreen thisScreen = this;

    /**
     * loadPOI method load the GUI component for a single poi
     *
     * @param p a POI object
     */
    public void loadPOI(POI p) {
        JToggleButton poiLabel = new JToggleButton(new ImageIcon(p.getIconPath()));
        poiLabel.setBounds(p.getX(), p.getY(), 40, 40);
        buttonList.add(poiLabel);
    }

    /**
     * displayPOI method display the GUI component of a single poi
     *
     * @param p a POI object
     */
    public void displayPOI(POI p) {

        int i = user.selectPoi(buildingList, p.getBuilding(), p.getFloor(), p.getX(), p.getY());

        JToggleButton select = buttonList.get(i);
        mscLayeredPane.add(select);
        mscLayeredPane.setComponentZOrder(select, 0);
        select.addActionListener((ActionEvent e) -> {
            Favourite newBox = new Favourite(buildingList.get(i), thisScreen);
            newBox.setVisible(true);
            newBox.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    select.setSelected(false);

                }

            });
        });

    }

    /**
     * checkPassword method checks if the password is correct for editor mode
     *
     * @param eme the jframe class for the enter password screen
     */
    public void checkPassword(EnterPasswordScreen eme) {
        if (eme.getPasswordCorrect() == true) {
            editorMode = true;
        } else {
            editorMode = false;
            JOptionPane.showMessageDialog(null, "Password incorrect");
            editorModeToggleButton.setSelected(false);
        }
    }

    /**
     * editPOI method lets user to edit the data of a poi
     *
     * @param p POI class object
     */
    public void editPOI(POI p) {
        if (editorMode) {
            DeveloperPOIEdit editScreen = new DeveloperPOIEdit(p, this);
            editScreen.setVisible(true);
        } else {
            UserPOIEdit editScreen = new UserPOIEdit(p, this);
            editScreen.setVisible(true);
        }
    }

    /**
     * refresh method refreshes the buttonList and building list and reload then
     * to side bars again
     *
     */
    public void refresh() {
        jTextField1.setText("");
        this.blindData();
        this.blindData_Favourite();
        this.blindData_Current();
        this.blindData_User();
        buildingList = user.getpoiData();
        //buildingList = getBuildingPOIs();
        buttonList.clear();
        for (int i = 0; i < buildingList.size(); i++) {
            loadPOI(buildingList.get(i));
        }
    }

    /**
     * setWindow method set the scroll panel window to have to target poi shown
     * on the map
     *
     * @param poi POI class object
     */
    public void setWindow(POI poi) {
        if (poi.getX() < 400) {
            mscScrollPane.getHorizontalScrollBar().setValue(0);
        } else if (poi.getX() > 800) {
            mscScrollPane.getHorizontalScrollBar().setValue(240);
        } else {
            mscScrollPane.getHorizontalScrollBar().setValue(120);
        }
        //set vertical scroll value
        if (poi.getY() < 370) {
            mscScrollPane.getVerticalScrollBar().setValue(0);
        } else {
            mscScrollPane.getVerticalScrollBar().setValue(230);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buildingName = new javax.swing.JLabel();
        addPOI = new javax.swing.JToggleButton();
        Back = new javax.swing.JButton();
        mscScrollPane = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        CurrentPOILabel = new javax.swing.JLabel();
        exitLayer = new javax.swing.JCheckBox();
        accesibilityLayer = new javax.swing.JCheckBox();
        washroomsLayer = new javax.swing.JCheckBox();
        userCreatedLayer = new javax.swing.JCheckBox();
        stairLayer = new javax.swing.JCheckBox();
        CurrentPOILabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        restaurantLayer = new javax.swing.JCheckBox();
        floor5Button = new javax.swing.JButton();
        floor1Button = new javax.swing.JButton();
        floor2Button = new javax.swing.JButton();
        floor3Button = new javax.swing.JButton();
        floor4Button = new javax.swing.JButton();
        editorModeToggleButton = new javax.swing.JToggleButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        classroomLayer = new javax.swing.JCheckBox();
        elevatorLayer = new javax.swing.JCheckBox();
        labLayer = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        CurrentPOILabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 550, 500));
        setMinimumSize(new java.awt.Dimension(1281, 736));
        setResizable(false);
        getContentPane().setLayout(null);

        buildingName.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        buildingName.setForeground(new java.awt.Color(79, 38, 131));
        buildingName.setText("Western Alumni Stadium");
        getContentPane().add(buildingName);
        buildingName.setBounds(180, 20, 460, 50);

        addPOI.setBackground(new java.awt.Color(79, 38, 131));
        addPOI.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        addPOI.setForeground(new java.awt.Color(255, 255, 255));
        addPOI.setText("Add POI");
        addPOI.setToolTipText("");
        addPOI.setActionCommand("Back");
        addPOI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPOIMouseClicked(evt);
            }
        });
        addPOI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPOIActionPerformed(evt);
            }
        });
        getContentPane().add(addPOI);
        addPOI.setBounds(20, 80, 230, 30);

        Back.setBackground(new java.awt.Color(79, 38, 131));
        Back.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(20, 20, 130, 50);

        mscScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mscScrollPaneMouseClicked(evt);
            }
        });
        getContentPane().add(mscScrollPane);
        mscScrollPane.setBounds(270, 100, 1000, 580);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(79, 38, 131));
        jLabel1.setText("Layers");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 570, 100, 17);

        CurrentPOILabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        CurrentPOILabel.setForeground(new java.awt.Color(79, 38, 131));
        CurrentPOILabel.setText("Search POIs");
        getContentPane().add(CurrentPOILabel);
        CurrentPOILabel.setBounds(20, 110, 100, 17);

        exitLayer.setText("Exit/Entrance");
        exitLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitLayerActionPerformed(evt);
            }
        });
        getContentPane().add(exitLayer);
        exitLayer.setBounds(130, 650, 110, 20);

        accesibilityLayer.setText("Accesibility");
        accesibilityLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesibilityLayerActionPerformed(evt);
            }
        });
        getContentPane().add(accesibilityLayer);
        accesibilityLayer.setBounds(20, 590, 81, 20);

        washroomsLayer.setText("Washrooms");
        washroomsLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                washroomsLayerActionPerformed(evt);
            }
        });
        getContentPane().add(washroomsLayer);
        washroomsLayer.setBounds(20, 670, 100, 20);

        userCreatedLayer.setText("User Created");
        userCreatedLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userCreatedLayerActionPerformed(evt);
            }
        });
        getContentPane().add(userCreatedLayer);
        userCreatedLayer.setBounds(130, 590, 120, 20);

        stairLayer.setText("Stairwell");
        stairLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stairLayerActionPerformed(evt);
            }
        });
        getContentPane().add(stairLayer);
        stairLayer.setBounds(130, 610, 80, 20);

        CurrentPOILabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        CurrentPOILabel1.setForeground(new java.awt.Color(79, 38, 131));
        CurrentPOILabel1.setText("Current POIs");
        getContentPane().add(CurrentPOILabel1);
        CurrentPOILabel1.setBounds(20, 310, 100, 17);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(20, 130, 230, 30);

        restaurantLayer.setText("Restaurant");
        restaurantLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantLayerActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantLayer);
        restaurantLayer.setBounds(20, 650, 85, 20);

        floor5Button.setText("Floor 5");
        floor5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor5ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(floor5Button);
        floor5Button.setBounds(1000, 40, 75, 23);

        floor1Button.setText("Floor 1");
        floor1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor1ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(floor1Button);
        floor1Button.setBounds(640, 40, 75, 23);

        floor2Button.setText("Floor 2");
        floor2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor2ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(floor2Button);
        floor2Button.setBounds(730, 40, 75, 23);

        floor3Button.setText("Floor 3");
        floor3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor3ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(floor3Button);
        floor3Button.setBounds(820, 40, 75, 23);

        floor4Button.setText("Floor 4");
        floor4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                floor4ButtonActionPerformed(evt);
            }
        });
        getContentPane().add(floor4Button);
        floor4Button.setBounds(910, 40, 75, 23);

        editorModeToggleButton.setText("Editor Mode");
        editorModeToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorModeToggleButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editorModeToggleButton);
        editorModeToggleButton.setBounds(1135, 70, 120, 23);

        jList1.setBackground(new java.awt.Color(79, 38, 131));
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 190, 230, 120);

        jButton1.setBackground(new java.awt.Color(79, 38, 131));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Help");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1135, 23, 120, 40);

        classroomLayer.setText("Classrooms");
        classroomLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classroomLayerActionPerformed(evt);
            }
        });
        getContentPane().add(classroomLayer);
        classroomLayer.setBounds(20, 610, 90, 20);

        elevatorLayer.setText("Elevator");
        elevatorLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elevatorLayerActionPerformed(evt);
            }
        });
        getContentPane().add(elevatorLayer);
        elevatorLayer.setBounds(130, 630, 80, 20);

        labLayer.setText("Lab");
        labLayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labLayerActionPerformed(evt);
            }
        });
        getContentPane().add(labLayer);
        labLayer.setBounds(20, 630, 85, 20);

        jList2.setBackground(new java.awt.Color(79, 38, 131));
        jList2.setForeground(new java.awt.Color(255, 255, 255));
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(20, 330, 230, 110);

        jList3.setBackground(new java.awt.Color(79, 38, 131));
        jList3.setForeground(new java.awt.Color(255, 255, 255));
        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jList3);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(20, 460, 230, 100);

        CurrentPOILabel3.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        CurrentPOILabel3.setForeground(new java.awt.Color(79, 38, 131));
        CurrentPOILabel3.setText("Seach results");
        getContentPane().add(CurrentPOILabel3);
        CurrentPOILabel3.setBounds(20, 170, 100, 17);

        jComboBox1.setBackground(new java.awt.Color(79, 38, 131));
        jComboBox1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 442, 230, 17);

        jList4.setBackground(new java.awt.Color(79, 38, 131));
        jList4.setForeground(new java.awt.Color(255, 255, 255));
        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jList4);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(20, 460, 230, 100);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addPOIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPOIMouseClicked


    }//GEN-LAST:event_addPOIMouseClicked

    private void addPOIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPOIActionPerformed

        if (!addButtonClicked) {
            addButtonClicked = true;
            mscScrollPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        } else {
            addButtonClicked = false;
            mscScrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }//GEN-LAST:event_addPOIActionPerformed

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        // TODO add your handling code here:
        homeScreen homeSc1 = new homeScreen(userName);
        homeSc1.setVisible(true);
        //this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_BackMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private void accesibilityLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesibilityLayerActionPerformed
        // TODO add your handling code here:
        ImageIcon newIcon;
        if (accesibilityLayer.isSelected()) {
            if (layerList.contains("accessibility") == false) {
                layerList.add("accessibility");
            }
            newIcon = new ImageIcon("dataStorage/" + currentBuilding + "/" + currentBuilding + "_A" + currentFloor + ".png");
        } else {
            if (layerList.contains("accessibility")) {
                layerList.remove("accessibility");
            }
            newIcon = new ImageIcon("dataStorage/" + currentBuilding + "/" + currentBuilding + "_NA" + currentFloor + ".png");
        }
        mapImage.setIcon(newIcon);
    }//GEN-LAST:event_accesibilityLayerActionPerformed

    private void washroomsLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_washroomsLayerActionPerformed
        if (washroomsLayer.isSelected()) {
            if (layerList.contains("washroom") == false) {
                layerList.add("washroom");
            }
        } else {
            if (layerList.contains("washroom")) {
                layerList.remove("washroom");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_washroomsLayerActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void stairLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stairLayerActionPerformed
        if (stairLayer.isSelected()) {
            if (layerList.contains("stairs") == false) {
                layerList.add("stairs");
            }
        } else {
            if (layerList.contains("stairs")) {
                layerList.remove("stairs");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_stairLayerActionPerformed

    private void mscScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mscScrollPaneMouseClicked

        if (addButtonClicked == true) {

            int x = evt.getX() - 22 + mscScrollPane.getHorizontalScrollBar().getValue();
            int y = evt.getY() - 39 + mscScrollPane.getVerticalScrollBar().getValue();

            if (editorMode == false) {
                UserPOIEdit add = new UserPOIEdit();
                add.setVisible(true);
                add.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Implementation here
                        //String name, int x, int y, String category, String roomNum, String description, Boolean fav){

                        if ((!add.checkStatus()) && add.checkAddStatus()) {
                            newPOI(add.getPOIName(), x, y, "userCreated", add.getRoomNumber(), add.getDescription(), add.getFavoriteStatus());
                            loadPOIs();
                        }
                        //refresh();
                    }

                });
                mscScrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                addPOI.setSelected(false);
                addButtonClicked = false;
            }

            if (editorMode == true) {
                DeveloperPOIEdit add = new DeveloperPOIEdit();
                add.setVisible(true);
                add.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        // Implementation here
                        //String name, int x, int y, String category, String roomNum, String description, Boolean fav){
                        if (!add.checkStatus() && add.checkAddStatus()) {
                            newPOI(add.getPOIName(), x, y, add.getCategory(), add.getRoomNumber(), add.getDescription(), add.getFavoriteStatus());
                            loadPOIs();
                        }
                        //refresh();
                    }

                });
                mscScrollPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                addPOI.setSelected(false);
                addButtonClicked = false;
            }
        }

    }//GEN-LAST:event_mscScrollPaneMouseClicked

    private void userCreatedLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userCreatedLayerActionPerformed
        if (userCreatedLayer.isSelected()) {
            if (layerList.contains("userCreated") == false) {
                layerList.add("userCreated");
            }
        } else {
            if (layerList.contains("userCreated")) {
                layerList.remove("userCreated");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_userCreatedLayerActionPerformed

    private void floor1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor1ButtonActionPerformed
        changeFloor(1);
    }//GEN-LAST:event_floor1ButtonActionPerformed

    private void floor2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor2ButtonActionPerformed
        // TODO add your handling code here:
        changeFloor(2);
    }//GEN-LAST:event_floor2ButtonActionPerformed

    private void floor3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor3ButtonActionPerformed
        // TODO add your handling code here:
        changeFloor(3);
    }//GEN-LAST:event_floor3ButtonActionPerformed

    private void floor4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor4ButtonActionPerformed
        // TODO add your handling code here:
        changeFloor(4);
    }//GEN-LAST:event_floor4ButtonActionPerformed

    private void floor5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_floor5ButtonActionPerformed
        // TODO add your handling code here:
        changeFloor(5);
    }//GEN-LAST:event_floor5ButtonActionPerformed


    private void editorModeToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorModeToggleButtonActionPerformed

        if (editorModeToggleButton.isSelected()) {
            EnterPasswordScreen eme = new EnterPasswordScreen(this);
            eme.setVisible(true);
        } else {
            editorMode = false;
        }
    }//GEN-LAST:event_editorModeToggleButtonActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        // TODO add your handling code here:JList list = (JList)evt.getSource();

        jList2.clearSelection();
        jList3.clearSelection();
        jList4.clearSelection();

        if (evt.getClickCount() == 2) {

            // POI INFO GOES HERE
            int index = jList1.locationToIndex(evt.getPoint());

            if (index >= 0) {
                POI poi = searchList.get(index);
                if (!currentBuilding.equals(poi.getBuilding())) {
                    buildingScreen building = new buildingScreen(poi.getBuilding(), userName);
                    building.setVisible(true);
                    //this.setVisible(false);
                    this.dispose();
                    building.changeFloor(poi.getFloor());
                    int select = user.selectPoi(building.getPOIList(), poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = building.getButtonList().get(select);
                    selected.doClick();
                    building.setWindow(poi);
                } else if (poi.getFloor() != currentFloor) {
                    changeFloor(poi.getFloor());
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                } else {
                    if (!layerList.contains(poi.getCategory())) {
                        switch (poi.getCategory()) {
                            case "classroom" ->
                                classroomLayer.doClick();
                            case "lab" ->
                                labLayer.doClick();
                            case "stairs" ->
                                stairLayer.doClick();
                            case "washroom" ->
                                washroomsLayer.doClick();
                            case "restaurant" ->
                                restaurantLayer.doClick();
                            case "exit" ->
                                exitLayer.doClick();
                            case "elevator" ->
                                elevatorLayer.doClick();
                            case "userCreated" ->
                                userCreatedLayer.doClick();
                            default -> {
                            }
                        }
                    }

                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                }

                if (poi.getX() < 400) {
                    mscScrollPane.getHorizontalScrollBar().setValue(0);
                } else if (poi.getX() > 800) {
                    mscScrollPane.getHorizontalScrollBar().setValue(240);
                } else {
                    mscScrollPane.getHorizontalScrollBar().setValue(120);
                }

                //set vertical scroll value
                if (poi.getY() < 370) {
                    mscScrollPane.getVerticalScrollBar().setValue(0);
                } else {
                    mscScrollPane.getVerticalScrollBar().setValue(230);
                }

            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        Help help = new Help();
        help.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void restaurantLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantLayerActionPerformed
        if (restaurantLayer.isSelected()) {
            if (layerList.contains("restaurant") == false) {
                layerList.add("restaurant");
            }
        } else {
            if (layerList.contains("restaurant")) {
                layerList.remove("restaurant");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_restaurantLayerActionPerformed

    private void labLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labLayerActionPerformed
        if (labLayer.isSelected()) {
            if (layerList.contains("lab") == false) {
                layerList.add("lab");
            }
        } else {
            if (layerList.contains("lab")) {
                layerList.remove("lab");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_labLayerActionPerformed

    private void classroomLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classroomLayerActionPerformed
        if (classroomLayer.isSelected()) {
            if (layerList.contains("classroom") == false) {
                layerList.add("classroom");
            }
        } else {
            if (layerList.contains("classroom")) {
                layerList.remove("classroom");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_classroomLayerActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        jList1.clearSelection();
        jList3.clearSelection();
        jList4.clearSelection();

        if (evt.getClickCount() == 2) {

            // POI INFO GOES HERE
            int index = jList2.locationToIndex(evt.getPoint());

            if (index >= 0) {
                POI poi = currentList.get(index);

                if (poi.getFloor() != currentFloor) {
                    changeFloor(poi.getFloor());
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                } else {
                    if (!layerList.contains(poi.getCategory())) {
                        switch (poi.getCategory()) {
                            case "classroom" ->
                                classroomLayer.doClick();
                            case "lab" ->
                                labLayer.doClick();
                            case "stairs" ->
                                stairLayer.doClick();
                            case "washroom" ->
                                washroomsLayer.doClick();
                            case "restaurant" ->
                                restaurantLayer.doClick();
                            case "exit" ->
                                exitLayer.doClick();
                            case "elevator" ->
                                elevatorLayer.doClick();
                            case "userCreated" ->
                                userCreatedLayer.doClick();
                            default -> {
                            }
                        }
                    }
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                }

                if (poi.getX() < 400) {
                    mscScrollPane.getHorizontalScrollBar().setValue(0);
                } else if (poi.getX() > 800) {
                    mscScrollPane.getHorizontalScrollBar().setValue(240);
                } else {
                    mscScrollPane.getHorizontalScrollBar().setValue(120);
                }

                //set vertical scroll value
                if (poi.getY() < 370) {
                    mscScrollPane.getVerticalScrollBar().setValue(0);
                } else {
                    mscScrollPane.getVerticalScrollBar().setValue(230);
                }

            }
        }
    }//GEN-LAST:event_jList2MouseClicked

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
        // TODO add your handling code here:
        jList1.clearSelection();
        jList2.clearSelection();
        if (evt.getClickCount() == 2) {

            // POI INFO GOES HERE
            int index = jList3.locationToIndex(evt.getPoint());

            if (index >= 0) {
                POI poi = favouriteList.get(index);
                if (!currentBuilding.equals(poi.getBuilding())) {
                    buildingScreen building = new buildingScreen(poi.getBuilding(), userName);
                    building.setVisible(true);
                    //this.setVisible(false);
                    this.dispose();
                    building.changeFloor(poi.getFloor());
                    int select = user.selectPoi(building.getPOIList(), poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = building.getButtonList().get(select);
                    selected.doClick();
                    building.setWindow(poi);
                }
                if (poi.getFloor() != currentFloor) {
                    changeFloor(poi.getFloor());
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                } else {
                    if (!layerList.contains(poi.getCategory())) {
                        switch (poi.getCategory()) {
                            case "classroom" ->
                                classroomLayer.doClick();
                            case "lab" ->
                                labLayer.doClick();
                            case "stairs" ->
                                stairLayer.doClick();
                            case "washroom" ->
                                washroomsLayer.doClick();
                            case "restaurant" ->
                                restaurantLayer.doClick();
                            case "exit" ->
                                exitLayer.doClick();
                            case "elevator" ->
                                elevatorLayer.doClick();
                            case "userCreated" ->
                                userCreatedLayer.doClick();
                            default -> {
                            }
                        }
                    }
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                }

                if (poi.getX() < 400) {
                    mscScrollPane.getHorizontalScrollBar().setValue(0);
                } else if (poi.getX() > 800) {
                    mscScrollPane.getHorizontalScrollBar().setValue(240);
                } else {
                    mscScrollPane.getHorizontalScrollBar().setValue(120);
                }

                //set vertical scroll value
                if (poi.getY() < 370) {
                    mscScrollPane.getVerticalScrollBar().setValue(0);
                } else {
                    mscScrollPane.getVerticalScrollBar().setValue(230);
                }

            }
        }
    }//GEN-LAST:event_jList3MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        DefaultListModel filteredItems = new DefaultListModel();
        searchList = user.searchPoi(jTextField1.getText());
        for (int i = 0; i < searchList.size(); i++) {
            filteredItems.addElement(searchList.get(i).getPoiName());
        }
        defaultListModel = filteredItems;
        jList1.setModel(defaultListModel);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void exitLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitLayerActionPerformed
        // TODO add your handling code here:
        if (exitLayer.isSelected()) {
            if (layerList.contains("exit") == false) {
                layerList.add("exit");
            }
        } else {
            if (layerList.contains("exit")) {
                layerList.remove("exit");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_exitLayerActionPerformed

    private void elevatorLayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elevatorLayerActionPerformed
        // TODO add your handling code here:
        if (elevatorLayer.isSelected()) {
            if (layerList.contains("elevator") == false) {
                layerList.add("elevator");
            }
        } else {
            if (layerList.contains("elevator")) {
                layerList.remove("elevator");
            }
        }
        blindData_Current();
        loadPOIs();
    }//GEN-LAST:event_elevatorLayerActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String input = (String) jComboBox1.getSelectedItem();
        if (input.equals("User Created POIs")) {
            jScrollPane4.setVisible(false);
            jScrollPane5.setVisible(true);
        } else {
            jScrollPane4.setVisible(true);
            jScrollPane5.setVisible(false);
        }

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
        // TODO add your handling code here:
        jList1.clearSelection();
        jList2.clearSelection();
        jList3.clearSelection();
        if (evt.getClickCount() == 2) {

            // POI INFO GOES HERE
            int index = jList4.locationToIndex(evt.getPoint());

            if (index >= 0) {
                POI poi = userList.get(index);

                if (!currentBuilding.equals(poi.getBuilding())) {
                    buildingScreen building = new buildingScreen(poi.getBuilding(), userName);
                    building.setVisible(true);
                    //this.setVisible(false);
                    this.dispose();
                    building.changeFloor(poi.getFloor());
                    int select = user.selectPoi(building.getPOIList(), poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = building.getButtonList().get(select);
                    selected.doClick();
                    building.setWindow(poi);
                }
                if (poi.getFloor() != currentFloor) {
                    changeFloor(poi.getFloor());
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                } else {
                    if (!layerList.contains(poi.getCategory())) {
                        switch (poi.getCategory()) {
                            case "classroom" ->
                                classroomLayer.doClick();
                            case "lab" ->
                                labLayer.doClick();
                            case "stairs" ->
                                stairLayer.doClick();
                            case "washroom" ->
                                washroomsLayer.doClick();
                            case "restaurant" ->
                                restaurantLayer.doClick();
                            case "exit" ->
                                exitLayer.doClick();
                            case "elevator" ->
                                elevatorLayer.doClick();
                            case "userCreated" ->
                                userCreatedLayer.doClick();
                            default -> {
                            }
                        }
                    }
                    int select = user.selectPoi(buildingList, poi.getBuilding(), poi.getFloor(), poi.getX(), poi.getY());
                    JToggleButton selected = buttonList.get(select);
                    selected.doClick();
                }

                if (poi.getX() < 400) {
                    mscScrollPane.getHorizontalScrollBar().setValue(0);
                } else if (poi.getX() > 800) {
                    mscScrollPane.getHorizontalScrollBar().setValue(240);
                } else {
                    mscScrollPane.getHorizontalScrollBar().setValue(120);
                }

                //set vertical scroll value
                if (poi.getY() < 370) {
                    mscScrollPane.getVerticalScrollBar().setValue(0);
                } else {
                    mscScrollPane.getVerticalScrollBar().setValue(230);
                }

            }
        }
    }//GEN-LAST:event_jList4MouseClicked

    private javax.swing.JLayeredPane mscLayeredPane;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel CurrentPOILabel;
    private javax.swing.JLabel CurrentPOILabel1;
    private javax.swing.JLabel CurrentPOILabel3;
    private javax.swing.JCheckBox accesibilityLayer;
    private javax.swing.JToggleButton addPOI;
    private javax.swing.JLabel buildingName;
    private javax.swing.JCheckBox classroomLayer;
    private javax.swing.JToggleButton editorModeToggleButton;
    private javax.swing.JCheckBox elevatorLayer;
    private javax.swing.JCheckBox exitLayer;
    private javax.swing.JButton floor1Button;
    private javax.swing.JButton floor2Button;
    private javax.swing.JButton floor3Button;
    private javax.swing.JButton floor4Button;
    private javax.swing.JButton floor5Button;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JCheckBox labLayer;
    private javax.swing.JScrollPane mscScrollPane;
    private javax.swing.JCheckBox restaurantLayer;
    private javax.swing.JCheckBox stairLayer;
    private javax.swing.JCheckBox userCreatedLayer;
    private javax.swing.JCheckBox washroomsLayer;
    // End of variables declaration//GEN-END:variables
}
