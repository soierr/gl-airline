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
All the data are stored in txt file in JSON format. Filename is "gl-airline.txt" you can find it next to your jar application.  
Example of unit test and simple test are available in proper test folder.

### Application tested on:

OS's: Windows 7 (64-bit), Ubuntu

Target JDK: jdk1.8.0_161

Maven: apache-maven-3.3.9

### Potential problems

Below are the maven test output:

[INFO] Scanning for projects...  
[WARNING]  
[WARNING] Some problems were encountered while building the effective model for gl.airline:gl-airline:jar:1.0  
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-jar-plugin is missing. @ line 43, column 15  
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-install-plugin is missing. @ line 56, column 15  
[WARNING]  
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.  
[WARNING]  
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.  
[WARNING]  

so there is concern that it might be a problem with project building using a newer version maven.
If it happens try to comment this plugin exclusion in pom.xml, i.e:

      <plugin>
        <artifactId>maven-jar-plugin</artifactId>
        <executions>
          <execution>
            <id>default-jar</id>
            <phase>never</phase>
            <configuration>
              <finalName>unwanted</finalName>
              <classifier>unwanted</classifier>
            </configuration>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-install-plugin</artifactId>
        <executions>
          <execution>
            <id>default-install</id>
            <phase>never</phase>
            <configuration>
              <finalName>unwanted</finalName>
              <classifier>unwanted</classifier>
            </configuration>
          </execution>
        </executions>
      </plugin>


I added it to avoid extra jar creation and installation so that it would not confused which one to use as an application.

In case of any extra issues, please write here blackfin@ukr.net or create an issue.  
Any feedback is highly appreciated.
