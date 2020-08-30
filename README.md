# Mars Rover Challenge
This is my proposal for the Mars Rover technical Challenge.

The program sets a plateau in which a squad of robotic rovers will be deployed and move through command input.

The program checks the correct coordinates input for the plateau and the rovers´ landing, and it will send an exception if command lines are erroneous.

It will also notify of possible collisions, rover movements out of boundaries, or a failed landing. Rovers won't move if an error of this kind occurs.

The result will be an initial and final analysis of the rovers positions and possible error notifications.
## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 
### Prerequisites
These are the requisites used to build this project:

- JDK 1.8
- IDE Eclipse
- [Maven](https://maven.apache.org/) 

The application can be run with any other IDEs like Netbeans and IntelliJ

### Initialize

Clone this repo or simply download and extract the master [zip file](https://github.com/audronFS/MarsRoverChallenge.git), then follow the instructions below for Eclipse IDE.
#### Eclipse
You can import the project from "Import" => "Maven" => "Existing Maven Projects". Select "MarsRoverChallenge-master" directory as root directory and make sure to change project compliance and JRE to 1.7.
```
Project-> Properties-> Java Compiler-> Compiler Compliance Level = 1.7
```

## Running application
```
/MarsRoverChallenge/src/main/java-> MarsRoverMain.java-> Run as-> Java application
```
## Running Tests
#### Unit testing framework
- JUnit4

#### Running Test
Following the path /MarsRoverChallenge/src/test/java, you can find two packages with JUnit tests each one. Select one and run as a JUnit Test.
```
/MarsRoverChallenge/src/test/java-> /modelTest-> Navigation-> Run as-> JUnit Test
```




 **AudronFS** 
