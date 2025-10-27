# Base image
FROM openjdk:17
#FROM eclipse-temurin:17-jre-focal

# Set working directory
WORKDIR /app

# Copy source code
COPY HelloWorld.java /app/

# Compile the Java program
RUN javac HelloWorld.java

# Command to run the application
CMD ["java", "HelloWorld"]
