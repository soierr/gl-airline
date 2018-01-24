# gl-airline

Please make sure that the preliminary setup are done as following:

1. OS console screen are no less than 115. Otherwise output might be wrapped
2. JAVA_HOME is set up to 1.8 jdk

Steps to launch the application

1. git clone https://github.com/soierr/gl-airline.git
2. cd gl-airline
3. mvn install
4. cd target
5. java -jar gl-airline-1.0.jar
6. Use "help" command to get more info of the commands available in application

The gl-airline application is a simple demo-tool which allows users to view the list of airplanes, edit it and make some simple search.
The list of available commands with description are availabe by "help" command, once the application is launched.
All the data are stored in txt file in JSON format. Filename is "gl-airline.txt" you can find it next to your jar application

Application tested on:

OS's: Windows 7, Ubuntu 
JDK: jdk1.8.0_161
Maven: apache-maven-3.3.9

Console output example:

******************************************************************************************

                                 MAU Airline Application

This application is meant to help you with managing of the airplanes which company possess

******************************************************************************************

list

------------------------------------------------------------------------------------------------------------------

| Code  | Total capacity, kg | Carrying capacity, kg | Flight range, km | Fuel consumption, lph | Airplane Class |

------------------------------------------------------------------------------------------------------------------
|   1   |        1000        |          800          |       150        |          600          |    ECONOMY     |
|   2   |        1000        |          800          |       160        |          600          |    BUSINESS    |
|   3   |        1000        |          800          |       700        |          170          |    PREMIUM     |
|   4   |        1260        |         1120          |      106050      |          450          |    PREMIUM     |
------------------------------------------------------------------------------------------------------------------

