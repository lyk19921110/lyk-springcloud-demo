#FROM JAVA:8
FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE}.jar app.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar","/app.jar"]