#FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD
#
## Build
#WORKDIR /build
#
#COPY pom.xml .
#RUN mvn dependency:go-offline
#
#COPY src ./src
#RUN mvn package


FROM gradle:5.4.1-jdk8-alpine AS GRADLE_BUILD
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

#FROM openjdk:8-jre-slim


# Package target image
FROM openjdk:8-jre-alpine3.9

COPY --from=GRADLE_BUILD /build/target/npc-data-manager-rest-1.0-SNAPSHOT.jar /npc-data-manager-rest.jar

ENV DB_NAME=the-quest \
    DB_HOST="10.10.10.6" \
    DB_PORT=27017 \
    DB_USER="root" \
    DB_PASS="pass"

CMD ["java", "-jar", "/npc-data-manager-rest.jar"]
