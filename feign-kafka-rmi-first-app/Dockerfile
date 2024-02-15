FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/feign-kafka-rmi-first-app-1.0-SNAPSHOT.jar
WORKDIR /app
COPY ${JAR_FILE} feign-kafka-rmi-first-app-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","feign-kafka-rmi-first-app-1.0-SNAPSHOT.jar"]
EXPOSE 8484