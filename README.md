# 


# Android Application
### Preview from Application
![image](https://user-images.githubusercontent.com/72921611/122181129-bfe57d80-ce91-11eb-98de-e317eafdbf4e.png)

Our app is made especially for pilots and flight researchers that want to practice flying. 
At first the user enters the ip and port to connect to the simulator flight server
Users can control the plane with the joystick and seek bar simulation, 
Each touch on the screen causes the app to send new flight values to the server.
After the server runs the plane start to fly. 
## Directory hierarchy

**Model**:
 - **Connect**- Opening a connection with the server in a separate thread, the IP and port arguments are given by the user.
 - **Task** - Puts a new task in the Thread tasks queue, the task contains a command with a new value to one of the flight values, according to the movement of the joystick.
 - **FGModel** - Creates a Single-Thread pool that is responsible for running tasks that are in the queue. In addition the model puts the various tasks in the queue.
 
 **viewModel**:
- **Viewmodel** - Manages the requests received from the view and sends to the functions in the model. 

**Views**:
- **Jostick** - Contains functions that create and draw the Jostick. 
- **MainActivity** - Creates the display surface for the app. 
- **ativity_main.xml** - The XML file of the view, contains the various features that will be on the screen. 

![image](https://user-images.githubusercontent.com/72921611/122181632-35e9e480-ce92-11eb-90f8-0bfabee577e1.png)
## Installation and Running the application
 - **For Developers** - install a proper IDE for android Application (we used intellij but you can use any other software). You migth need to install JDK- 
 - [ ] **JDK** - If the JDK is installed on your computer, but not defined in the IDE, select Add JDK and specify the path to the JDK home directory.
  else - if you don't have the necessary JDK on your computer, select Download JDK.
  - [ ] **Android device** - you can choose to run the app from your Android device or to download Android device simulator to your computer. 
 
 - **For Users** -
 Run the app and make sure that FG server is running - 
 - [ ] insert the next line to FG settings :
  --telnet=socket,in,10,127.0.0.1,6400,tcp
 - [ ] In the app insert port 6400, and your computer ip and press connect button.
 - [ ] to start the engine press cessna C172P in tool bar | Autostart and start flying.
 
 
## Documentation
Here you can find a Link to UML that contains partial information of the central classes. UML represents the various connections between the classes and the most important information found in each class. UML can be found [here](https://lucid.app/lucidchart/ba91fbd1-3cd6-4dde-a4a0-7f6e889ce981/view). 
If you are a developer you can find full documentation of functions, variables, and more in the code.
## Video
Here you can find a link to our demo video - [link](https://youtu.be/BbjbQuLcp-E).
