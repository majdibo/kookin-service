FROM maven:3.6-jdk-8-slim as builder

COPY src /home/app/src
COPY pom.xml /home/app

WORKDIR /home/app

RUN mvn clean package

FROM openjdk:8-jre-alpine

ENV APPLICATION_USER appadmin
RUN adduser -D -g '' $APPLICATION_USER

RUN mkdir /app
RUN chown -R $APPLICATION_USER /app

USER $APPLICATION_USER

COPY --from=builder /home/app/target/*.jar /app/

WORKDIR /app

RUN mv *.jar service.jar

CMD  ["java", "-jar", "service.jar"]