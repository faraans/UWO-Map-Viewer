package com.mycompany.uwomapviewer;

/**
 * POI class for poi objects
 * 
 * @author Jerry, Abdul
 */
public class POI {

    /**
     * building of the poi
     */
    private String building;
    /**
     * floor of the poi
     */
    private int floor;
    /**
     * name of the poi
     */
    private String poiName;
    /**
     * x coordinate of the poi
     */
    private int poiPositionX;
    /**
     * y coordinate of the poi
     */
    private int poiPositionY;
    /**
     * users that favorited the poi
     */
    private String poiFavorite;
    /**
     * category of the poi
     */
    private String category;
    /**
     * description of the poi
     */
    private String description;
    /**
     * room number of the poi
     */
    private String roomNumber = null;
    /**
     * the creator of the poi
     */
    private String createdBy;

    /**
     * constructor method for creating a poi
     *
     * @param name name of the poi
     * @param posX x coordinate of the poi
     * @param posY y coordinate of the poi
     * @param building building of the poi
     * @param floor floor of the poi
     * @param category category of the poi
     * @param roomNumber room number of the poi
     * @param description description of the poi
     * @param fav users who favorited the poi
     * @param user creator of the poi
     */
    public POI(String name, int posX, int posY, String building, int floor, String category, String roomNumber, String description, String fav, String user) {
        poiName = name;
        this.building = building;
        this.floor = floor;
        poiPositionX = posX;
        poiPositionY = posY;
        this.category = category;
        poiFavorite = fav;
        this.description = description;
        this.roomNumber = roomNumber;
        if (category.equals("userCreated")) {
            createdBy = user;
        } else {
            createdBy = "Built-in";
        }

    }

    /**
     * getCreated method return the creator of the poi
     *
     * @return the creator of the poi
     */
    public String getCreated() {
        return createdBy;
    }

    /**
     * getIconPath method return the path of the icon image for the poi
     *
     * @return path of the icon image
     */
    public String getIconPath() {
        if (category.equals("userCreated")) {
            return "dataStorage/POIicons/POI.png";
        }
        return "dataStorage/POIicons/" + category + ".png";
    }

    /**
     * addFavorite method add the user to poi favorite
     *
     * @param user username favoriting the poi
     */
    public void addFavorite(String user) {
        poiFavorite = poiFavorite + "<" + user + ">";
    }

    /**
     * removeFavorite method remove the user from poi favorite
     *
     * @param user username unfavoriting the poi
     */
    public void removeFavorite(String user) {
        poiFavorite.replace("<" + user + ">", "");
    }

    /**
     * getBuilding method
     *
     * @return building name
     */
    public String getBuilding() {
        return building;
    }

    /**
     * setBuilding method
     *
     * @param building building name
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /**
     * getFloor method
     *
     * @return floor number
     */
    public int getFloor() {
        return floor;
    }

    /**
     * setFLoor method
     *
     * @param floor floor number
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * getPoiName method
     *
     * @return poi name
     */
    public String getPoiName() {
        return poiName;
    }

    /**
     * setPoiName method
     *
     * @param poiName poi name
     */
    public void setPoiName(String poiName) {
        this.poiName = poiName;
    }

    /**
     * getX method
     *
     * @return x coordinate
     */
    public int getX() {
        return poiPositionX;
    }

    /**
     * getY method
     *
     * @return y coordinate
     */
    public int getY() {
        return poiPositionY;
    }

    /**
     * getCategory method
     *
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * getDescription method
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * getFavorite method returning if the user favorited this poi
     *
     * @param user username
     * @return boolean
     */
    public boolean getFavorite(String user) {
        return poiFavorite.contains("<" + user + ">");
    }

    /**
     * getFavoriteString method retuning the String containing all users that
     * favorited the poi
     *
     * @return String containing all users that favorited
     */
    public String getFavoriteString() {
        return poiFavorite;
    }

    /**
     * setRoomNumber method
     *
     * @param roomNumber room number
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;

    }

    /**
     * getRoomNumber method
     *
     * @return room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * get the creator of the poi
     *
     * @return user name
     */
    public String getUser() {
        return createdBy;
    }

}
