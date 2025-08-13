FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/*.jar hp-1.1.0.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "hp-1.1.0.jar"]