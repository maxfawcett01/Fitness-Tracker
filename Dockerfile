FROM openjdk:17

# Create a non-root user
RUN groupadd -r myuser && useradd -r -g myuser myuser

# Set the user
USER myuser

# Create a directory for your application
WORKDIR /app

# Copy only necessary files, excluding sensitive data
COPY src /app/src
COPY backend/pom.xml /app/

# Example: run your application
CMD ["java", "-jar", "your-application.jar"]



