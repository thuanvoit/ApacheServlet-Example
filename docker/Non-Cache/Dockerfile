FROM openjdk:23-jdk

COPY . /myapp

WORKDIR /myapp/SimpleApp

RUN ../apache-maven-3.9.6/bin/mvn clean package

RUN cp target/SimpleApp-1.0-SNAPSHOT.war ../apache-tomcat-10.1.19/webapps/SimpleApp.war

RUN cp -R target/SimpleApp-1.0-SNAPSHOT ../apache-tomcat-10.1.19/webapps/SimpleApp

WORKDIR /myapp/apache-tomcat-10.1.19/bin

RUN chmod +x *.sh

EXPOSE 8080

CMD ["./catalina.sh", "run"]