FROM openjdk:11-slim
WORKDIR /app
COPY ./target/school-application-0.0.1-SNAPSHOT.jar school-application.jar
CMD "java" "-jar" "school-application.jar"
