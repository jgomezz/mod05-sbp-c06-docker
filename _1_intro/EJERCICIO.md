
-
## Ejercicio 1 : Publicar el siguiente site

### Estructura del site
```
site_docker/
└── web/
    ├── index.html
    ├── about.html
    └── img/
        └── docker-logo.png
```

### index.html
```
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi Sitio Docker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="index.html">Mi Sitio Docker</a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" href="index.html">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.html">Acerca de</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Contenido Principal -->
    <div class="container text-center mt-5">
        <h1 class="display-4">¡Hola desde Docker! 🐳</h1>
        <p class="lead mt-4">Esta página está siendo servida por NGINX en un contenedor Docker</p>
        
        <div class="my-5">
            <img src="img/docker-logo.png" alt="Docker Logo" class="img-fluid" style="max-width: 300px;">
        </div>
        
        <a href="about.html" class="btn btn-primary btn-lg">Conocer más →</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```
### about.html
```
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acerca de - Mi Sitio Docker</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="index.html">Mi Sitio Docker</a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="about.html">Acerca de</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Contenido -->
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-6">
                <img src="img/docker-logo.png" alt="Docker" class="img-fluid mb-4">
            </div>
            <div class="col-md-6">
                <h1>Acerca de Este Proyecto</h1>
                <p class="lead">Este es un ejercicio práctico de Docker.</p>
                
                <h3 class="mt-4">¿Qué aprendí?</h3>
                <ul>
                    <li>Crear y ejecutar contenedores Docker</li>
                    <li>Usar NGINX para servir páginas web</li>
                    <li>Montar volúmenes</li>
                    <li>Mapear puertos</li>
                </ul>

                <h3 class="mt-4">Tecnologías</h3>
                <p>
                    <span class="badge bg-primary">Docker</span>
                    <span class="badge bg-success">NGINX</span>
                    <span class="badge bg-info">HTML</span>
                    <span class="badge bg-warning text-dark">Bootstrap</span>
                </p>

                <a href="index.html" class="btn btn-primary mt-3">← Volver al Inicio</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

### docker-logo.png 
```
https://www.docker.com/wp-content/uploads/2022/03/Moby-logo.png
```

## Ejercicio 2 : 
- Publicar el site en el entorno de desarrollo , puerto 8010
- Publicar el site en el entorno de pruebas , puerto 8020
- Publicar el site en el entorno de producción , puerto 8030