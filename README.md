# gl-airline

Please make sure that the preliminary setup are done as following:

1. OS console screen width is no less than 115. Otherwise output might be wrapped
2. JAVA_HOME is set up to 1.8 jdk

Steps to launch the application

1. git clone https://github.com/soierr/gl-airline.git
2. cd gl-airline
3. mvn install
4. cd target
5. java -jar gl-airline-1.0.jar
6. Use "help" command to get more info of the commands available in the application

The gl-airline application is a simple demo-tool which allows users to view the list of airplanes, edit it and make some simple search.
The list of available commands with description are availabe by "help" command, once the application is launched.
All the data are stored in txt file in JSON format. Filename is "gl-airline.txt" you can find it next to your jar application

Application tested on:

OS's: Windows 7 (64-bit), Ubuntu

Target JDK: jdk1.8.0_161

Maven: apache-maven-3.3.9

In case of any problem, please write here blackfin@ukr.net or create an issue.
Any feedback is highly appreciated.
