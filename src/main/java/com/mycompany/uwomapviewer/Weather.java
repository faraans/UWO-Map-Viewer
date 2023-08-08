package com.mycompany.uwomapviewer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.net.URL;
import org.json.JSONObject;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.IOException;

/**
 * Weather class for getting the current temperature
 *
 * @author Jerry, Harrison
 */
public class Weather {

    /**
     * the current temperature
     */
    private double temp;
    /**
     * the homeScreen that is calling this class
     */
    private homeScreen screen;

    /**
     * updateWeatherData method for getting the weather data from web
     *
     * @return current temperature
     */
    public Double updateWeatherData() {
        try {
            String API_KEY = "f59561d72c672e43e986ba62a98f8d63";
            String LOCATION = "London, ON";
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=43.00980105786034&lon=-81.27369605123431&appid=f59561d72c672e43e986ba62a98f8d63&units=metric");
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            String result = new String(stream.readAllBytes());
            stream.close();
            Object jS = result;
            JSONObject data = new JSONObject(result).getJSONObject("main");
            temp = data.getDouble("temp");

        } catch (IOException e) {
            screen.noWeather();
            return null;
        }
        return temp;
    }

    /**
     * constructor method
     *
     * @param screen homeScreen calling this class
     */
    public Weather(homeScreen screen) {
        this.screen = screen;

    }

    /**
     * getTemperature method return the temperature
     *
     * @return current temperature
     */
    public double getTemperature() {
        return temp;
    }

}
