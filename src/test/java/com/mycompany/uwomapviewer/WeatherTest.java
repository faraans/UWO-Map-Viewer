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
 * WeatherTest class for testing Weather class
 *
 * @author Talia
 */
public class WeatherTest {
    
    public WeatherTest() {
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
     * Test of updateWeatherData method, of class Weather.
     */
    @Test
    public void testUpdateWeatherData() {
        System.out.println("updateWeatherData");
        homeScreen screen = new homeScreen("username");
        Weather instance = new Weather (screen);
        Double result = instance.updateWeatherData();
        Double currTemp = instance.getTemperature();
        Double expResult = currTemp;
        assertEquals(expResult, result);
    }

    /**
     * Test of getTemperature method, of class Weather.
     */
    @Test
    public void testGetTemperature() {
        System.out.println("getTemperature");
        homeScreen screen = new homeScreen("username");
        Weather instance = new Weather (screen);
        double expResult = 0.0;
        double result = instance.getTemperature();
        assertEquals(expResult, result, 0);
    }
    
}
