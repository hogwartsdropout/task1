FROM openjdk:8-jre-slim
EXPOSE 8080
COPY build/libs/MovilizerTask-1.0.jar server.jar
ENTRYPOINT ["java", "-jar", "server.jar"]