FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} juicy-lime-0.0.1.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]