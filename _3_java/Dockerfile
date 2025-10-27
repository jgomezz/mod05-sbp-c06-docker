# Base image
FROM eclipse-temurin:17-jre-focal

# Set working directory
WORKDIR /app

# Copy the JAR file from target directory and rename it to app.jar
COPY target/*.jar app.jar

# Expose the port your application uses (change 8080 if needed)
# EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
