
## Docker

### Crear Dockerfile
```
# Base image
FROM openjdk:17

# Set working directory
WORKDIR /app

# Copy the JAR file from target directory and rename it to app.jar
COPY target/app.jar app.jar

# Expose the port your application uses (change 8080 if needed)
# EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
```
### Construir imagen
```
docker build -t myappjava:1.0 .
```

### Inspeccionar imagen
```
docker image inspect myappjava:1.0
```

## Ejecutar Container
```
docker run -d --name myappjava01 myappjava:1.0
```
## Ver Container
```
docker ps
docker ps -a 
```

## Ver logs
```
docker logs myappjava01 
```

## Detener Container
```
docker stop myappjava01
```

## Eliminar Container
```
docker rm myappjava01 
```

### Eliminar imagen
```
docker rmi myappjava:1.0
```

