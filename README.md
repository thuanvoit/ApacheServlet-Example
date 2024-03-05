# Apache Tomcat 10

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

### Cache Config

## Create Servlet App

## Testing

## Performance Testing

## Cache Setup

## Performance Testing with Cache

## Discussion
