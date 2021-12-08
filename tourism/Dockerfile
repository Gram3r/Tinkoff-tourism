FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/tourism-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} tourism.jar
ENTRYPOINT ["java","-jar","tourism.jar"]