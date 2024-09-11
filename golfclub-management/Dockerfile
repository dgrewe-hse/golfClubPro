# Dockerfile for Spring Boot service
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /workspace

# Copy the Maven wrapper and project files into the container
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download Maven dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Package the application (assumes you are using Maven)
RUN ./mvnw clean package

# Expose port 8080
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/golfclub-management-0.0.1-SNAPSHOT.jar"]