FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080