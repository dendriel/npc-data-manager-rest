FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package


FROM openjdk:8-jre-alpine3.9

COPY --from=MAVEN_BUILD /target/npc-data-manager-rest-1.0-SNAPSHOT.jar /npc-data-manager-rest.jar

ENV DB_NAME=the-quest \
    DB_HOST="10.10.10.6" \
    DB_PORT=27017 \
    DB_USER="root" \
    DB_PASS="pass"

CMD ["java", "-jar", "/npc-data-manager-rest.jar"]
