FROM openjdk:17-alpine

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# wait-for-it.sh
RUN apk update && apk add bash

COPY wait-for-it.sh wait-for-it.sh
RUN chmod +x wait-for-it.sh