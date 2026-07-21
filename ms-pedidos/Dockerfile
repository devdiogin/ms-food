FROM eclipse-temurin:21-alpine
RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

USER spring:spring

ENTRYPOINT ["java","-jar","app.jar"]