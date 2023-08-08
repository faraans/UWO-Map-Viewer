/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.uwomapviewer;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;

/**
 * dataStorage class for storing and getting data from JSON file
 *
 * @author Jerry, Harrison 
 */
public class dataStorage {

    /**
     * JSONArray list storing user data
     */
    private JSONArray userList = new JSONArray();
    /**
     * JSONArray list storing poi data
     */
    private JSONArray poiList = new JSONArray();

    /**
     * constructor method, reading JSON files into application
     *
     */
    public dataStorage() {
        readUserData();
        readPoiData();

    }

    /**
     * readUserData method read user.json from dataStorage folder
     *
     */
    private void readUserData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("dataStorage/JSON/user.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray userList = (JSONArray) obj;
            this.userList = userList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    /**
     * readPoirData method read poi.json from dataStorage folder
     *
     */
    private JSONArray readPoiData() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("dataStorage/JSON/poi.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray poiList = (JSONArray) obj;
            this.poiList = poiList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return poiList;

    }

    /**
     * getUserData method return the Json Array list of user data(username and
     * password)
     *
     * @return JSONArray Json array list
     */
    public JSONArray getUserData() {
        return userList;
    }

    /**
     * getpoiData method return the poi Array list of poi data objects
     *
     * @return ArrayList POI array list
     */
    public ArrayList<POI> getpoiData() {

        ArrayList<POI> Poi = new ArrayList<>();
        poiList.forEach(poi -> Poi.add(parsePoi((JSONObject) poi)));
        return Poi;

    }

    /**
     * parsePOi method turning JSON object to POI object
     *
     * @param Poi a JSON object of poi
     * @return POI a poi object
     */
    private POI parsePoi(JSONObject Poi) {

        int x = ((Number) Poi.get("X")).intValue();
        int y = ((Number) Poi.get("Y")).intValue();
        int floor = ((Number) Poi.get("floor")).intValue();

        POI poi = new POI((String) Poi.get("name"), x, y, (String) Poi.get("building"), (int) floor, (String) Poi.get("category"), (String) Poi.get("room"), (String) Poi.get("description"), (String) Poi.get("favorite"), (String) Poi.get("createdBy"));

        return poi;
    }

    /**
     * savePoiFile method saving the Json List of POI to Json file
     *
     * @param poiList a JSONArray list of POI
     */
    private static void savePoiFile(JSONArray poiList) {
        try (FileWriter file = new FileWriter("dataStorage/JSON/poi.json")) {
            file.write(poiList.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * addPoi method taking a POI object as input and add it to JSON List and
     * save to JSON file
     *
     * @param poi a POI class object
     */
    public void addPoi(POI poi) {
        JSONObject Poi = new JSONObject();
        Poi.put("name", poi.getPoiName());
        Poi.put("X", poi.getX());
        Poi.put("Y", poi.getY());
        Poi.put("category", poi.getCategory());
        Poi.put("favorite", poi.getFavoriteString());
        Poi.put("building", poi.getBuilding());
        Poi.put("floor", poi.getFloor());
        Poi.put("room", poi.getRoomNumber());
        Poi.put("description", poi.getDescription());
        Poi.put("createdBy", poi.getCreated());
        poiList.add(Poi);
        savePoiFile(poiList);
        poiList = readPoiData();
    }

    /**
     * deletePoi method deleting a poi from the JSON file if the poi exists in
     * it
     *
     * @param poi a POI class object
     */
    public void deletePoi(POI poi) {
        for (int i = 0; i < poiList.size(); i++) {
            int x = ((Number) ((JSONObject) poiList.get(i)).get("X")).intValue();

            int y = ((Number) ((JSONObject) poiList.get(i)).get("Y")).intValue();

            int floor = ((Number) ((JSONObject) poiList.get(i)).get("floor")).intValue();

            if ((((JSONObject) poiList.get(i)).get("name").equals(poi.getPoiName()))
                    && (((JSONObject) poiList.get(i)).get("building").equals(poi.getBuilding()))
                    && (floor == poi.getFloor())
                    && (x == poi.getX())
                    && (y == poi.getY())) {
                poiList.remove(i);
            }
        }
        savePoiFile(poiList);
        poiList = readPoiData();
    }

    /**
     * editPoi method editing a POI
     *
     * @param oldPoi POI object containing the old poi info
     * @param newPoi POI object containing the new poi info
     */
    public void editPoi(POI oldPoi, POI newPoi) {
        deletePoi(oldPoi);
        addPoi(newPoi);
    }

    /**
     * selectPoi method returning the index of the target POI in Array list of
     * POIs
     *
     * @param poilist an array list of POI objects
     * @param building the building of the POI
     * @param floor the floor of the POI
     * @param x the x coordinate of the POI
     * @param y the y coordinate of the POI
     * @return int index of the POI
     */
    public int selectPoi(ArrayList<POI> poilist, String building, int floor, int x, int y) {
        for (int i = 0; i < poilist.size(); i++) {
            if ((poilist.get(i).getBuilding()).equals(building)
                    && (poilist.get(i).getFloor() == floor)
                    && (poilist.get(i).getX() == x)
                    && (poilist.get(i).getY() == y)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * searchPoi method, given a keyword, return all the pois that contain the
     * keyword in their name, category, description, floor number, room number
     * and building
     *
     * @param keyword String of the searched poi must contain
     * @return POI array list containing all poi object that contains the
     * keyword
     */
    public ArrayList<POI> searchPoi(String keyword) {
        ArrayList<POI> searchList = new ArrayList();
        ArrayList<POI> poilist = getpoiData();
        for (int i = 0; i < poilist.size(); i++) {
            if ((poilist.get(i).getPoiName().contains(keyword))
                    || (poilist.get(i).getCategory().contains(keyword))
                    || (poilist.get(i).getDescription().contains(keyword))
                    || (String.valueOf(poilist.get(i).getFloor()).equals(keyword))
                    || (poilist.get(i).getRoomNumber().contains(keyword))
                    || (poilist.get(i).getBuilding().contains(keyword))) {
                searchList.add(poilist.get(i));
            }
            //}
        }
        return searchList;
    }

    /**
     * favoritePoi method update the poi favorite status to JSON file
     *
     * @param poi the POI object that is changing favorite type
     * @param user the user who is changing the favorite type
     */
    public void favoritePoi(POI poi, String user) {
        for (int i = 0; i < poiList.size(); i++) {
            int x = ((Number) ((JSONObject) poiList.get(i)).get("X")).intValue();

            int y = ((Number) ((JSONObject) poiList.get(i)).get("Y")).intValue();

            int floor = ((Number) ((JSONObject) poiList.get(i)).get("floor")).intValue();

            if ((((JSONObject) poiList.get(i)).get("name").equals(poi.getPoiName()))
                    && (((JSONObject) poiList.get(i)).get("building").equals(poi.getBuilding()))
                    && (floor == poi.getFloor())
                    && (x == poi.getX())
                    && (y == poi.getY())) {
                String fav = (String) ((JSONObject) poiList.get(i)).get("favorite");
                if (fav.contains("<" + user + ">")) {
                    fav = fav.replace("<" + user + ">", "");
                } else {
                    fav = fav + "<" + user + ">";
                }
                ((JSONObject) poiList.get(i)).replace("favorite", fav);
            }
        }
        savePoiFile(poiList);
    }

}
