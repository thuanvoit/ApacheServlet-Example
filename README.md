# Apache Tomcat 10

<img src="./img/tomcat.png" width=100 />

This project belongs to CS4675 SP24 Homework 4 Problem 2.

## Requirements

### General Requirements

-   Docker

    -   Docker Desktop can be found [here](https://www.docker.com/products/docker-desktop/)

-   JDK 8+
    -   Tested with Zulu21.30
    -   [Download Compatible Version with your Machine](https://www.azul.com/downloads/?package=jdk#zulu)
-   Maven
    -   Tested with version 3.9.6
    -   [Download Binary .tar.gz or .zip](https://maven.apache.org/download.cgi)

### Requirements for Hosting

-   Apache Tomcat 10+
    -   Tested with 10.1.19
    -   [Download Core .tar.gz or .zip](https://tomcat.apache.org/download-10.cgi)

### Requirements for Benchmark

-   Apache JMeter
    -   Tested with 5.6.3
    -   [Download Binaries .tgz or .zip](https://jmeter.apache.org/download_jmeter.cgi)

## Installation

In this project, to eliminate the complication of different OS. I have picked Docker to build and run the Tomcat server.

In the Project Root, there are 2 folders, both are able to build alone with Docker:

-   **/Non-Cache**: is the Tomcat server and the application without Cache implementation.
-   **/Cache**: is the Tomcat server and the application with Cache implementation.

Direct to the preferred version of Tomcat server and application, with Docker running, run the following command:

```bash
docker build -t <IMAGE_NAME> .
```

For example, I would like to build Tomcat with Caching, I would direct to Cache folder and run:

```bash
docker build -t apache-server-cache .
```

Build successful message look like:
<img src="./img/built.png" width=700 />

Run the server and the application, run the following:

## Dockerfile

Build the application and process everything inside the Docker container:

```dockerfile
# Use the official OpenJDK image as the base image
FROM openjdk:23-jdk
# Copy the current directory contents into the container at /myapp
COPY . /myapp
# Set the working directory to /myapp
WORKDIR /myapp/SimpleApp
# Use Maven to build the application, produce a .WAR file
RUN ../apache-maven-3.9.6/bin/mvn clean package
# Copy the .WAR file to the Tomcat webapps directory
RUN cp target/SimpleApp-1.0-SNAPSHOT.war ../apache-tomcat-10.1.19/webapps/SimpleApp.war
RUN cp -R target/SimpleApp-1.0-SNAPSHOT ../apache-tomcat-10.1.19/webapps/SimpleApp
# Change the working directory to the Tomcat bin directory
WORKDIR /myapp/apache-tomcat-10.1.19/bin
# Make the shell scripts executable
RUN chmod +x *.sh
# Make port 8080 available to the world outside this container
EXPOSE 8080
# Run catalina.sh to start the Tomcat server
CMD ["./catalina.sh", "run"]
```

## Configuration

### Port Config

To configurate PORT, direct to `apache-tomcat-10.1.19` > `conf`. Open `server.xml` file, edit the port attribute on these lines:

```xml
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443"
               maxParameterCount="1000"
               />
```

The port is set to `8080` by default. I can alter this port to 8081, 3000, etc. Save the file and keep it in the current directory. For an example, I can change to 3000 since I know port 3000 is currently free.

### Manager Config

We need this step to be able to view information or perform actions on our server.

To configurate MANAGER account, direct to `apache-tomcat-10.1.19` > `conf`. Open `tomcat-users.xml` file, add the following lines:

```xml
<tomcat-users>
...
<role rolename="manager-gui"/>
<user username="admin" password="admin" roles="manager-gui"/>
...
</tomcat-users>
```

You can change the `username` and `password` to your preferred ones. I personally set them both to admin.

## Create Servlet App

Since we will build the app with Maven, we need to follow some specific folder structure:

<img src="./img/project-structure.png" width=500 />

More on how to create a Servlet App on [JAVATUTORIAL.NET](https://javatutorial.net/java-servlet-example/)

In my project, I create a `GetObject.java` to read the data in the /webapp/WEB-INF directory. This class can get file types (JPG, PNG, GIF, TXT, CSS) only. To use this feature, when building the servlet, to display an image in images folder:

```java
String filePath = request.getContextPath() + "/getObject?name=image1.png";
out.println("<img src='" + filePath + "/>");
```

-   `GetObject` will take in a parameter "name" is the filename with extension. With compatible extension, it will map to the right folder of that type and return if exists.
-   The purpose of `request.getContextPath()` is to get the full path of your server URL. Without it the browser would not know where the `/getObject` belongs to.
-   At the end of GetObject, I print out in console "return object" for the purpose of testing Cache.

## Testing on iPhone Device

Imagine your laptop is a server, it will available to all devices in the same network.

Find your server's IP address within the network by [many methods](https://www.avast.com/c-how-to-find-ip-address)

For me, my laptop IP address is `128.61.32.180`, to access from other devices:

    http://128.61.32.180:8080/SimpleApp

### In this particular project, I have 6 pages:

### Homepage: includes links to pages + a GIF image

<img src="./img/mobile/homepage.png" width=300 />

### Page 1: load all the images in images folder

<img src="./img/mobile/page1.png" width=300 />

### Page 2: load only 4 images from the images folder

<img src="./img/mobile/page2.png" width=300 />

### Page 3: display a random image from images folder

<img src="./img/mobile/page3.png" width=300 />

### Page 4: load a txt file from text folder

<img src="./img/mobile/page4.png" width=300 />

### Page 5: randomize 1,000 integers and display them

<img src="./img/mobile/page5.png" width=300 />

## Performance Testing

## Cache Setup

## Performance Testing with Cache

## Discussion

1. Cache

2. URL

3. Convert to Base64
