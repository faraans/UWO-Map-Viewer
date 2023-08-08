/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.uwomapviewer;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * dataStorageTest for testing dataStorage class
 * 
 * @author harrisonangellotti
 */
public class dataStorageTest {
    
    private JSONArray userList;
    private dataStorage user;
    private POI poi;
    private POI poiObject;
    private ArrayList<POI> poiList;
    private POI test;
    
    public dataStorageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        user = new dataStorage();
        userList = user.getUserData();
        poiList = user.getpoiData();
        test = new POI("s", 1, 2, "MSC", 1, "s", "4", "test for add poi", "favourite", "Built-in");
        user.addPoi(test);
        poi = user.searchPoi("test for add poi").get(0);
    }
    
    @After
    public void tearDown() {
        
       user.deletePoi(test);
    }

    /**
     * 
     * Test of getUserData method, of class dataStorage.
     * 
     * This method is used to test whether or not ALL userData can be read from
     * our database (user.json file), and then if it can retrieve this data,
     * then the function has thus successfully passed the test.
     * 
     */
    @Test
    public void testGetUserData() {
        System.out.println("getUserData");
        dataStorage instance = new dataStorage();
        JSONArray expResult = userList;
        JSONArray result = instance.getUserData();
        assertEquals(expResult, result);
    }

    /**
     * 
     * Test of getpoiData method, of class dataStorage.
     * 
     * 
     */
    @Test
    //come back 
    // TALIA
    public void testGetpoiData() {
        System.out.println("getpoiData");
        dataStorage instance = new dataStorage();
        ArrayList<POI> expResult = new ArrayList();
        ArrayList<POI> result = new ArrayList();
        
        POI test1 = new POI("get1", 1, 2, "MSC", 1, "s", "4", "4", "favourite", "Built-in");
        
        expResult = user.getpoiData();
        user.addPoi(test1);
        result = user.getpoiData();
        assertEquals(expResult.size()+1, result.size());
        user.deletePoi(test1);
        
        
    }

    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the name of a POI is successfully stored
     */
    @Test
    public void testAddPoiName() {
        System.out.println("addPoiName");
        assertEquals("s", poi.getPoiName());
    }

    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the x position of a POI is successfully stored
     */
    @Test
    public void testAddPoiPosX() {
        System.out.println("addPoiPosX");
        assertEquals(1, poi.getX());
    }
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the y position of a POI is successfully stored
     */    
    @Test
    public void testAddPoiPosY() {
        System.out.println("addPoiPosY");
        assertEquals(2, poi.getY());
    }

    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the building of a POI is successfully stored
     */    
    @Test
    public void testAddPoiBuilding() {
        System.out.println("addPoiBuilding");
        assertEquals("MSC", poi.getBuilding());
    }
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the floor of a POI is successfully stored
     */    
    @Test
    public void testAddPoiFloor() {
        System.out.println("addPoiFloor");
        assertEquals(1, poi.getFloor());
    }
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the category of a POI is successfully stored
     */    
    @Test
    public void testAddPoiCategory() {
        System.out.println("addPoiCategory");       
        assertEquals("s", poi.getCategory());
    }
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the Room Number of a POI is successfully stored
     */    
    @Test
    
    public void testAddPoiRoomNumber() {
        System.out.println("addPoiRoomNumber");       
        assertEquals("4", poi.getRoomNumber());
    }
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the Description of a POI is successfully stored
     */    
    @Test
    
    public void testAddPoiDescription() {
        System.out.println("addPoiDescription");       
        assertEquals("test for add poi", poi.getDescription());
    }
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the Favorite of a POI is successfully stored
     */    
    @Test
    public void testAddPoiFavorite() {
        System.out.println("addPoiFavorite");       
        assertEquals(false, poi.getFavorite("me"));
    }    
    
    /**
     * Test of addPoi method, of class dataStorage.
     * 
     * This method tests if the Creator of a POI is successfully stored
     */    
    @Test
    public void testAddPoiUser() {
        System.out.println("addPoiUser");       
        assertEquals("Built-in", poi.getUser());
    }
    
    /**
     * Test of deletePoi method, of class dataStorage.
     * 
     * This method will access the JSON where POI's are stored, and if the POI
     * can no longer be found, then it will have been successfully deleted
     * 
     */
    @Test
    public void testDeletePoi() {
        System.out.println("deletePoi");
        POI delete = new POI("delete", 1, 2, "MSC", 1, "s", "4", "4", "favourite", "Built-in");
        user.addPoi(delete);
        int poiListSize = user.getpoiData().size();
        user.deletePoi(delete);
        int newpoiListSize = user.getpoiData().size();
        assertEquals(poiListSize, newpoiListSize+1);
        
        
    }

    /**
     * 
     * Test of editPoi method, of class dataStorage.
     * 
     * This method tests if the user is able to take an exisiting POI, and replace
     * it with an "edited" version of that prexisting POI.
     */
    @Test
    public void testEditPoi() {
        System.out.println("editPoi");
        POI oldPoi = new POI("before", 1, 2, "MSC", 1, "s", "4", "test for edit", "favourite", "Built-in");
        POI newPoi = new POI("after", 1, 2, "MSC", 1, "s", "4", "test for edit", "favourite", "Built-in");
        user.addPoi(oldPoi);
        user.editPoi(oldPoi, newPoi);
        POI result = user.searchPoi("test for edit").get(0);
        assertEquals(newPoi.getPoiName(), result.getPoiName());
        user.deletePoi(newPoi);
    }

    /**
     * Test of selectPoi method, of class dataStorage.
     */
    @Test
    public void testSelectPoi() {
        System.out.println("selectPoi");
        
        ArrayList<POI> poiList = new ArrayList<POI>();
        POI poi1 = new POI("s", 10, 20, "MSC", 1, "s", "4", "4", "favourite", "Built-in");;
        poiList.add(poi1);
        
        //searches for the index of a POI that is in the arrayList of POIs
        int index1 = user.selectPoi(poiList, "MSC", 1, 10, 20);
        assertEquals(0, index1);
        user.deletePoi(poi1);
        
        
    }
    
    /**
     * Test of selectPoi method, of class dataStorage.
     */
    @Test
    public void testSelectPoiNotIndexed() {
        System.out.println("selectPoi");
        
        ArrayList<POI> poiList = new ArrayList<POI>();
        POI poi1 = new POI("s", 10, 20, "MSC", 1, "s", "4", "4", "favourite", "Built-in");
        poiList.add(poi1);
        
        // Tests for a POI that is outside of the range of the arrayList of POIs
        int index3 = user.selectPoi(poiList, "MSC", 2, 100, 200);
        assertEquals(-1, index3);
        user.deletePoi(poi1);
        
        
    }

    /**
     * 
     * Test of searchPoi method, of class dataStorage.
     * 
     * Essentially, here we are trying to test the overall functionality of the
     * searchPoi method. The method returns a very long list of every single similar
     * word, that can be uppercase or lowercase. As shown below, you can see that
     * passing "SEARCH" into the searchPoi function gives the same result as passing
     * "searchpoi1234" into the function. Therefore, we can conclude that since the same
     * list is returned from the function in either upper or lowercase, the function
     * is performing as intended. This was a odd method to test because it works in 
     * way that most JUnit tests do not typically perform, and it was determined that
     * this was the best way to display the working functionality of the function.
     * 
     */
    
    @Test
    public void testSearchPoi() {
        System.out.println("searchPoi");
        String keyword1 = "SEARCH";
        String keyword2 = "searchpoi1234";
        POI poi1 = new POI("test search", 10, 20, "MSC", 1, "s", "4", "test for search poi", "favourite", "Built-in");
        
        dataStorage instance = new dataStorage();
        instance.addPoi(poi1);
        ArrayList<POI> result = instance.searchPoi("test for search poi");
        assertEquals(poi1.getPoiName(), result.get(0).getPoiName());
        user.deletePoi(poi1);

    }

    /**
     * 
     * Test of favoritePoi method, of class dataStorage.
     * 
     * This method tests the 
     */
    @Test
    public void testFavoritePoi() {
        System.out.println("favoritePoi");
        
        // get favourite returns a boolean, use this one
        POI test = new POI("sksadjf", 100, 254, "MSC12", 5, "ssdaf", "44", "42", "favourite", "Built-in");
        user.addPoi(test);
        String user1 = "User";
        //dataStorage instance = new dataStorage();
        user.favoritePoi(test, user1);
        POI test1 = user.searchPoi("sksadjf").get(0);
        assertEquals(true, test1.getFavorite("User"));
        user.deletePoi(test);
    }
}
