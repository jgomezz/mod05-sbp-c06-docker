
## Microservices con Docker


# 1ra Parte

## Paso 1: Descargar y ejecutar NGINX

### Listar imagenes
```
docker images
```
### Descargar imagen
```
docker pull nginx:latest
```

### Inspeccionar imagen
```
docker image inspect nginx
```
###  Ejecutar NGINX en background, mapeando puerto 8080 de tu PC al puerto 80 del contenedor
```
docker run -d -p 8080:80 --name web nginx
```
Explicación del comando:
- -d               = detached (background)
- -p 8080:80       = puerto_host:puerto_contenedor
- --name web  = nombre del contenedor
- nginx            = imagen a usar

## Paso 2: Verificar que funciona


### Ver que el contenedor está corriendo
```
docker ps

curl http://localhost:8080
```


## Paso 3: Ver los logs

### Ver logs
```
docker logs -f web
docker logs web
```
## Paso 4: Explorar el contenedor

### Entrar al contenedor
```
docker exec -it web /bin/bash
cd /usr/share/nginx/html
exit
```

## Paso 5: Detener y limpiar

### Detener el contenedor
```
docker stop web
docker start web
```

### Eliminar el contenedor
```
docker rm web
```

### Verificar que se eliminó
```
docker ps -a
```

# 2da Parte

## Paso 1

### Crear index.html
```
├── docker
│   ├── _1_intro
│   │     └── www
│   │          └── index.html

```

contenido de index.html
```
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi Sitio con Docker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="docker-logo">🐳</div>
        <h1>¡Hola desde Docker!</h1>
        <p>Esta página está siendo servida por NGINX en un contenedor Docker</p>
        <p>Clase: Docker Fundamentals</p>
    </div>
</body>
</html>
```
### Ejecutar NGINX (desde la carpeta www)
```
docker run -d -p 8080:80 --name web -v $(pwd):/usr/share/nginx/html:ro nginx
```

```
curl http://localhost:8080
```
### Detener NGINX 
```
docker stop web
docker rm web
```

