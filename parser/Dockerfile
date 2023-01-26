
# Use maven:3.6.3-jdk-17 as the base image for the build
FROM maven:3.6.3-jdk-17 AS build

# Copy the source code from the local directory to the image
COPY src /usr/src/parser/src

# Copy the pom.xml file from the local directory to the image
COPY pom.xml /usr/src/parser

# Run the maven command to clean and package the project
RUN mvn -f /usr/src/parser/pom.xml clean package

# Use openjdk:17-jdk-slim as the base image for the application
FROM openjdk:17-jdk-slim

# Copy the packaged jar file from the build image to the application image
COPY --from=build /usr/src/parser/target/parser-1.0-SNAPSHOT.jar /usr/app/parser-1.0-SNAPSHOT.jar

# Set the entrypoint for the application
ENTRYPOINT ["java","-jar","/usr/app/parser-1.0-SNAPSHOT.jar"]
