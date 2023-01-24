# Use the official openjdk image as the base image
FROM openjdk:17-jdk-slim

# Set environment variables
ENV JAVA_OPTS=""

# Create the working directory
RUN mkdir /app
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Expose the port for the application
EXPOSE 8080

# Start the application
CMD java ${JAVA_OPTS} -jar app.jar
