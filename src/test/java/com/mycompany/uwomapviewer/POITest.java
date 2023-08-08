/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.uwomapviewer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * POITest class for testing POI class
 * 
 * @author Talia
 */
public class POITest {
    
    public POITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCreated method, of class POI.
     */
    @Test
    public void testGetCreated() {
        System.out.println("getCreated");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "username";
        String result = instance.getCreated();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIconPath method, of class POI.
     */
    @Test
    public void testGetIconPath() {
        System.out.println("getIconPath");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "dataStorage/POIicons/POI.png";
        String result = instance.getIconPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of addFavorite method, of class POI.
     */
    @Test
    public void testAddFavorite() {
        System.out.println("addFavorite");
        String user = "username";
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "", "username");
        instance.addFavorite(user);
        boolean expResult = true;
        boolean result = instance.getFavorite(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFavorite method, of class POI.
     */
    @Test
    public void testRemoveFavorite() {
        System.out.println("removeFavorite");
        String user = "username";
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "", "username");
        instance.removeFavorite(user);
        boolean expResult = false;
        boolean result = instance.getFavorite(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of getBuilding method, of class POI.
     */
    @Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "MSC";
        String result = instance.getBuilding();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBuilding method, of class POI.
     */
    @Test
    public void testSetBuilding() {
        System.out.println("setBuilding");
        String building = "TD";
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        instance.setBuilding(building);
        String result = instance.getBuilding();
        assertEquals(building, result);
        
    }

    /**
     * Test of getFloor method, of class POI.
     */
    @Test
    public void testGetFloor() {
        System.out.println("getFloor");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        int expResult = 1;
        int result = instance.getFloor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFloor method, of class POI.
     */
    @Test
    public void testSetFloor() {
        System.out.println("setFloor");
        int floor = 2;
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        instance.setFloor(2);
        int result = instance.getFloor();
        assertEquals(floor, result);
    }

    /**
     * Test of getPoiName method, of class POI.
     */
    @Test
    public void testGetPoiName() {
        System.out.println("getPoiName");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "New POI";
        String result = instance.getPoiName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPoiName method, of class POI.
     */
    @Test
    public void testSetPoiName() {
        System.out.println("setPoiName");
        String poiName = "New Name";
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        instance.setPoiName(poiName);
        String result = instance.getPoiName();
        assertEquals (poiName, result);
    }

    /**
     * Test of getX method, of class POI.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        int expResult = 200;
        int result = instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY method, of class POI.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        int expResult = 100;
        int result = instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategory method, of class POI.
     */
    @Test
    public void testGetCategory() {
        System.out.println("getCategory");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "userCreated";
        String result = instance.getCategory();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class POI.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "This is a test POI";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFavorite method, of class POI.
     */
    @Test
    public void testGetFavorite() {
        System.out.println("getFavorite");
        String user = "username";
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        boolean expResult = true;
        boolean result = instance.getFavorite(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFavoriteString method, of class POI.
     */
    @Test
    public void testGetFavoriteString() {
        System.out.println("getFavoriteString");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "<username>";
        String result = instance.getFavoriteString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoomNumber method, of class POI.
     */
    @Test
    public void testSetRoomNumber() {
        System.out.println("setRoomNumber");
        String roomNumber = "456";
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        instance.setRoomNumber(roomNumber);
        String result = instance.getRoomNumber();
        assertEquals (roomNumber, result);
    }

    /**
     * Test of getRoomNumber method, of class POI.
     */
    @Test
    public void testGetRoomNumber() {
        System.out.println("getRoomNumber");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "123";
        String result = instance.getRoomNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUser method, of class POI.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        POI instance = new POI ("New POI", 200, 100, "MSC", 1, "userCreated", "123", "This is a test POI", "<username>", "username");
        String expResult = "username";
        String result = instance.getUser();
        assertEquals(expResult, result);
    }
    
}
