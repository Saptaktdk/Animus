#FROM docker.oaplatform.org/oap-jvm:jdk-17-35-debian-buster-slim-36
FROM openjdk:17-jdk-slim

WORKDIR /app

ARG JAR_FILE=target/animus-*.jar

COPY ${JAR_FILE} /app/animus.jar

ENTRYPOINT ["java", "-jar","/app/animus.jar"]

EXPOSE 8080