FROM eclipse-temurin:21-jammy

WORKDIR /app
# Copie le jar compilé localement
COPY target/api-0.0.1-SNAPSHOT.jar ./app.jar

# Lancer l'application
CMD ["java", "-jar", "app.jar"]
