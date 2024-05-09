# Java-Based Bike Simulation Software
The application simulates a bike navigating a 7 x 7 grid with commands executed via file input or STDIN. Commands include PLACE, FORWARD, TURN_LEFT, TURN_RIGHT, and GPS_REPORT. The bike must remain within the grid, enforced by preventing any movement that would cause it to exit. After the initial PLACE command, any valid sequence of commands, including additional PLACE commands, is accepted. Commands before a valid PLACE are ignored. PLACE initializes the bike's position and direction. FORWARD moves the bike one unit in its current direction. TURN_LEFT and TURN_RIGHT rotate the bike without changing its position. GPS_REPORT outputs the bike's current position and facing direction.

## How to Install
### Requirements
This application was made with the following:
* Java JDK version 21
* IntelliJ version 2024.1.1 Community Edition

This application uses the following Maven dependencies and plugins:

Testing -
* JUnit Jupiter Engine: org.junit.jupiter:junit-jupiter-engine:5.11.0-M1
* JUnit Platform Runner: org.junit.platform:junit-platform-runner:1.11.0-M1
* JUnit Jupiter: org.junit.jupiter:junit-jupiter:5.11.0-M1
* Maven Surefire Plugin: org.apache.maven.plugins:maven-surefire-plugin:2.22.0

Coverage -
* JaCoCo Maven Plugin: org.jacoco:jacoco-maven-plugin:0.8.12

Code Formatter -
* Spotless Maven Plugin: com.diffplug.spotless:spotless-maven-plugin:2.42.0

### Installation
These are the steps to easily run the application:
1. Install Java JDK version 21 - [Download](https://www.oracle.com/au/java/technologies/downloads/)
2. Install IntelliJ version 2024.1.1 Community Edition - [Download](https://www.jetbrains.com/idea/download/?section=windows)
3. Clone this repository.
4. Right-click on the "pom.xml" file in the folder navigation panel (to the left) and click on the "Add as Maven project" button.
5. On the right side corner of the IntelliJ IDE, there is an "M" icon for Maven, click on that to bring the Maven control panel.
6. Click on the "CAS360CodingChallenge" button to bring the dropdown menu, then click on the "Lifecycle" and then the "Install" button. This will install the necessary dependencies for this application.

## How to Run
To run the application without a file, simply click on the green run button next to the class name in the Engine.GameEngine.java file.

To run the application with a file, locate the top right section of the IntelliJ IDE, and click on the three vertical dots. Click on the "Edit..." button. In the program arguments text box, add the file path of your commands.txt file. It is best to add the full path so that the application can find your list of commands.

You can use the accompanying "input.txt" file located in "src/main/resources/" folder for testing.

## Design
Here is the [PDF file](CAS360CodingChallenge_Design_Documentation.pdf) containing the design decisions.

Here is the live [Javadoc](https://mushi333.github.io/CAS360CodingChallenge/) site for this application.