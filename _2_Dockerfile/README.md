
## Docker

### Crear Dockerfile

```
├── docker
│   ├── _1_intro
│   │   ├── README.md
│   │   └── www
│   │       └── index.html
│   ├── _2_Dockerfile
│   │   ├── Dockerfile. ******
│   │   └── README.md
```
Contenido del Dockefile
```
# Base image
FROM openjdk:17
```
### Construir imagen (debe estar dentro de la carpeta _2_Dockerfile)
```
docker build -t myapp:1.0 .
```

### Inspeccionar imagen
```
docker image inspect myapp:1.0
```

## Ejecutar Container
```
docker run -d --name myapp01 myapp:1.0
```
## Ver Container
```
docker ps
docker ps -a 
```

## Ver logs
```
docker logs myapp01 
```

## Detener Container
```
docker stop myapp01 
```

## Eliminar Container
```
docker rm myapp01 
```

### Eliminar imagen
```
docker rmi myapp:1.0
```

