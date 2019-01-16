#构建dockerfile
FROM openjdk:8-jre-alpine
#FROM openjdk:8-jdk-alpine
COPY target/spring-boot-docker.jar /
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/spring-boot-docker.jar"]