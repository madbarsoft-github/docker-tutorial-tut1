# Use a base image with Java and a minimal Linux distribution
FROM openjdk:17

#Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
COPY spring-boot-webapp/target/spring-boot-webapp-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]