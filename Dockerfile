FROM openjdk:8-jdk-alpine
MAINTAINER karin.stemmet@gmail.com
COPY target/demo-0.0.1-SNAPSHOT.jar demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]