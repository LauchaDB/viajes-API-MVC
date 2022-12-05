FROM maven:3.8.3-openjdk-8-slim as build
WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean install

FROM openjdk:8-alpine
WORKDIR /app
COPY --from=build /app/target/proyectoViajes-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "proyectoViajes-0.0.1-SNAPSHOT.jar"]