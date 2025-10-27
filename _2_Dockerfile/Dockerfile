# Base image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy source code
COPY HelloWorld.java /app/

# Compile the Java program
RUN javac HelloWorld.java

# Command to run the application
CMD ["java", "HelloWorld"]
