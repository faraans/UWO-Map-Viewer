# UWO Map Viewer
## Description
#### The program displays the floor maps for thee buildings of Western University (Middlesex COllege, Alumni Staduim and Alumni Hall). Each map contains a list of built-in POIs(point of interest). User is able to create their own POIS on the map and favorite any POI they want to.

## Required environment: JDK 19

## Building the software
#### To build the software, simply right click the project in the project tab of Netbeans and click "Build with dependencies"

## Run the software
#### Navigate to "Executable" folder, and double click on UwoMapViewer.jar
## User guide
#### after running the software, the first screen is a login screen. This is a multi-user system and the username and password for the system will be given below. After logging in, you will see a window for selecting building with real time temperature showing at the bottom. Select a building you want to view and you will be brought to the window of the first floor of the building you selected. On the bottom left corner there's check boxes for POI layers. Checking them off will remove the category of POI from the map and the Current POI list. On the left side there are three side bars. First one is for searching, enter any keyword you want to search and the result will pop up. The second one is for current floor's pois that the type of poi layer is turned on. The third side bar has a drop down menu to switch between favorited pois and user created pois. For any of the side bars, you can double click on them to navigate to the position of that poi, and the info box of the poi will also pop up. clicking on the button of the poi on the map will also display the info box of that poi. you can view the info, favorite the poi. You can also edit and delete the poi if it is created by you. You can also click on the floor tab on top side to switch between floors.To add a user created POI, click on Add Poi tab on top left, and click on anywhere on the map, a window will pop up for inputing the info of the POI. To enter editor mode, click on the editor mode tab on top right, after entering the password you will enter editor mode and be granted access to create, delete and edit built-in POIs. Click again to exit editor mode. To change building, you can click back and go back to select building window to select another building. There is also a help tab on top right corner, clicking on it will display information about how to use the app.
## User Name and Passwords
#### two users: {username: user, password: pass1234}, {username: Jerry, password: test} password for editor mode: 1234


## Additional info
#### We included two extra features: weather api and multiuser system, javadoc could be found in the javadoc folder, test files could be found in src/test folder