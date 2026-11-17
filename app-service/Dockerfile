# ---------- Stage 1: build the jar using Gradle (no pom.xml / Maven needed) ----------
FROM gradle:8.10-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar --no-daemon

# ---------- Stage 2: lightweight runtime image ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
