# Stage 1: Build
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Note: Adjust the source path for the specific service you want to run
COPY --from=build /app/course-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
