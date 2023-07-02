FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# FROM openjdk:17
# EXPOSE 8080
# ARG JAR_FILE=target/*.jar
# ADD ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]

FROM gcr.io/distroless/java17
WORKDIR /app
EXPOSE 8080
COPY --from=build /app/target/*.jar app.jar
CMD ["app.jar"]
