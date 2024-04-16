FROM openjdk:17-alpine as builder

MAINTAINER MABROUKI

LABEL authors="MABROUKI"

ARG JAR_FILE

COPY ${JAR_FILE} tondeuse.jar

RUN java -Djarmode=layertools -jar ./tondeuse.jar extract
#
FROM openjdk:17-alpine
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

#COPY src/main/resources/application.yml ./application.yml
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]