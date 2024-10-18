FROM maven:3.9.5-openjdk-21 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B

COPY . .

ENV THREAD_COUNT=4

RUN mvn clean test -Dgroups="Regression"
