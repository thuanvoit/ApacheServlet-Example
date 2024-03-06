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