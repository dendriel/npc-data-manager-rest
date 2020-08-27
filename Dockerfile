# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./ ./

# package our application code
RUN mvn clean package


# the second stage of our build will use open jdk 8 on alpine 3.9
FROM openjdk:8-jre-alpine3.9

# copy only the artifacts we need from the first stage and discard the rest
COPY --from=MAVEN_BUILD /target/npc-data-manager-rest-1.0-SNAPSHOT.jar /npc-data-manager-rest.jar

ENV DB_SCHEMA=the-quest \
    DB_HOST="10.10.10.6" \
    DB_PORT=27017

# set the startup command to execute the jar
CMD ["java", "-jar", "/npc-data-manager-rest.jar"]