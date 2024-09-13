# Use Maven base image to build the Spring Boot app
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the JAVA_HOME environment variable explicitly
ENV JAVA_HOME=/usr/local/openjdk-17
ENV PATH=$JAVA_HOME/bin:$PATH

# Set the working directory
WORKDIR /workspace

# Copy the pom.xml and download dependencies
COPY pom.xml .
# RUN mvn dependency:go-offline

# Copy the source code to the container
COPY src /app/src
COPY pom.xml /app

# Build the application (without running tests)
RUN mvn -f /app/pom.xml clean package -DskipTests 

# Inspect the contents of the target directory to confirm the JAR was built
RUN ls -l /app/target/

# Use a smaller OpenJDK image for the runtime
FROM openjdk:17-jdk-slim
WORKDIR /app-service

# Copy the built JAR file from the Maven build stage
COPY --from=build /app/target/golfclub-management-0.1-SNAPSHOT.jar /app-service/golfclub-management.jar

# Ensure the JAR file has the correct permissions
RUN chmod 644 /app-service/golfclub-management.jar

# Copy wait-for-it script
COPY wait-for-it.sh /usr/local/bin/wait-for-it.sh

# Ensure the script has execute permission
RUN chmod +x /usr/local/bin/wait-for-it.sh

# Inspect the contents of the target directory to confirm the JAR was built
RUN ls -l /app-service

# Expose the port used by the Spring Boot application
EXPOSE 8080

# Run Spring Boot, but wait for MySQL first
# Use ENTRYPOINT to ensure the application always starts the JAR file
ENTRYPOINT ["wait-for-it.sh", "mysql-db:3306", "--", "java", "-jar", "golfclub-management.jar"]
CMD ["-start"]