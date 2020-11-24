FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9091
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/citiesClient-1.0.0.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]