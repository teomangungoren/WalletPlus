FROM openjdk:17-jdk-slim AS build
WORKDIR /app

COPY build/libs/wallet-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
