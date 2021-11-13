FROM openjdk
MAINTAINER belenyammal@gmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spotify.jar
ENTRYPOINT {"java", "-jar", "/spotify.jar"}

