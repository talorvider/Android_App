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

**View**:
- **index.html** - this is the client-side view of the server.Using HTML and JavaScript to change and create elemnts in client-side. 
![image](https://user-images.githubusercontent.com/72921611/122181632-35e9e480-ce92-11eb-90f8-0bfabee577e1.png)
## Installation and Running the application
 - **For Developers** - install a proper IDE for Web Application (we used WebStorm but you can use any other software). You will need to install few programs and modules- 
 - [ ] **Node.js** - we worked with 14.17.0 version which you can download here - [Download | Node.js (nodejs.org)](https://nodejs.org/en/download/)
 - [ ] **npm** - install npm from here - [npm | get npm (npmjs.com)](https://www.npmjs.com/get-npm)
 - [ ] **express module** - in the command line (after installed npm) enter - \
  `$ npm install express --save` \
 for more information enter [here](https://expressjs.com/en/starter/installing.html).
 - [ ]  **express-fileupload module** - in the command line (after installed npm) enter  -\
  `$ npm i express-fileupload`\
  for more information enter [here](https://www.npmjs.com/package/express-fileupload).
 - [ ]  **Working Directory** - Make sure your working directory is set to -\
` ~\webapplication\Controller`\
if it is not, please change it for all things to run smoothly.
 - **For Users** -
 Make sure that server is running and browse  to - 
 >  http://localhost:8080/
 
 upload files and wait until the result get back. Then click on the button that showed up, the result will be displayed in a table. 
## Documentation
Here you can find a Link to UML that contains partial information of the central classes. UML represents the various connections between the classes and the most important information found in each class. UML can be found [here](https://lucid.app/lucidchart/ba91fbd1-3cd6-4dde-a4a0-7f6e889ce981/view). 
If you are a developer you can find full documentation of functions, variables, and more in the code.
## Video
Here you can find a link to our demo video - [link](https://youtu.be/BbjbQuLcp-E).
