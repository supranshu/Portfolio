FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar portfolio.jar
ENTRYPOINT [ "java","-jar","/portfolio.jar" ]
EXPOSE 8080
