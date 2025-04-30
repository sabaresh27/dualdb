# Use the official OpenJDK image as the base image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/dualdatabase-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8087
EXPOSE 8087

# Define the command to run the application
CMD ["java", "-jar", "app.jar"]
