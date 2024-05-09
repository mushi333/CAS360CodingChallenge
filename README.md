# Java Based Bike Simulation Software
The application simulates a bike navigating a 7 x 7 grid with commands executed via file input or STDIN. Commands 
include PLACE, FORWARD, TURN_LEFT, TURN_RIGHT, and GPS_REPORT. The bike must remain within the grid, enforced by 
preventing any movement that would cause it to exit. After the initial PLACE command, any valid sequence of commands, 
including additional PLACE commands, is accepted. Commands before a valid PLACE are ignored. PLACE initializes the 
bike's position and direction. FORWARD moves the bike one unit in its current direction. TURN_LEFT and TURN_RIGHT rotate
the bike without changing its position. GPS_REPORT outputs the bike's current position and facing direction.

## How to Install
### Requirements
This application was made with the following:
* Java 21 
* Intellij 2024.1.1 Community Edition

This application uses the following Maven dependencies and plugins:
* JUnit Jupiter Engine: org.junit.jupiter:junit-jupiter-engine:5.11.0-M1
* JUnit Platform Runner: org.junit.platform:junit-platform-runner:1.11.0-M1
* JUnit Jupiter: org.junit.jupiter:junit-jupiter:5.11.0-M1
* JaCoCo Maven Plugin: org.jacoco:jacoco-maven-plugin:0.8.12
* Maven Surefire Plugin: org.apache.maven.plugins:maven-surefire-plugin:2.22.0
* Spotless Maven Plugin: com.diffplug.spotless:spotless-maven-plugin:2.42.0

### Installation
These are the following steps to easily run the application:
* Install Java JDK version 21 - [Download](https://www.oracle.com/au/java/technologies/downloads/)
* Install Intellij version 2024.1.1 Community Edition - [Download](https://www.jetbrains.com/idea/download/?section=windows)
* Clone this repository
* Run the following command to initialize the application:
```
mvn clean install
```

## How to Run
To run the application without a file, simply click on the green run button next to the main method located in the 
Engine.GameEngine.java file.

To run the application with a file, locate the top right section of the Intellij IDE, and click on the three vertical
dots. Click on the "Edit..." button. In the program arguments text box, add the file path of your commands.txt file.
It is best to add the full path, so that the application can find your list of commands.

## Design
Here is the PDF file containing the design decisions.