FROM docker.oaplatform.org/oap-jvm:jdk-17-35-debian-buster-slim-36

WORKDIR /app

ARG JAR_FILE=target/animus-*.jar

COPY ${JAR_FILE} /app/animus/app.jar

ENTRYPOINT ["java", "-jar","/app/limebrew/app.jar"]

EXPOSE 8080