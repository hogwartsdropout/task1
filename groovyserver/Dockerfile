FROM openjdk:8-jre-slim
EXPOSE 8090
COPY build/libs/groovyserver-1.0.jar server.jar
ENTRYPOINT ["java", "-jar", "server.jar"]