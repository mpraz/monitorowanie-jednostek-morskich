FROM openjdk:8u191-jdk-alpine3.9
ADD target/monitorowanie-jednostek-morskich-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar monitorowanie-jednostek-morskich-0.0.1-SNAPSHOT.jar