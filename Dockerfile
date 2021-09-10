FROM maven:3.8.2-jdk-11-slim AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:11-slim
COPY --from=build /usr/src/app/target/school-application-0.0.1-SNAPSHOT.jar /usr/app/school-application.jar
EXPOSE 8080
CMD "java" "-jar" "/usr/app/school-application.jar"
