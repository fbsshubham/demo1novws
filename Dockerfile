# Use Java 17 (recommended for Spring Boot)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render uses $PORT internally)
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/*.jar"]

# Copy Maven wrapper
COPY mvnw .
COPY .mvn .mvn

# Make it executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline
