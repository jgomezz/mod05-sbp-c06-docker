```
┌─────────────────────────────────────┐
│         Aplicación A                │
│         Runtime/Libs                │
├─────────────────────────────────────┤
│       Guest OS (Ubuntu)             │
│         (~700MB - 1GB)              │
├─────────────────────────────────────┤
│         Hypervisor                  │
├─────────────────────────────────────┤
│       Host OS (Linux)               │
├─────────────────────────────────────┤
│    Hardware Físico (CPU, RAM)       │
└─────────────────────────────────────┘
```

**Contenedores:**
```
┌─────────────────────────────────────┐
│  App A  │  App B  │  App C          │
│  Libs   │  Libs   │  Libs           │
│         (~10-100MB cada uno)        │
├─────────────────────────────────────┤
│       Docker Engine                 │
├─────────────────────────────────────┤
│       Host OS (Linux)               │
├─────────────────────────────────────┤
│    Hardware Físico                  │
└─────────────────────────────────────┘
```

**Comparativa:**

| Característica | VM | Contenedor |
|----------------|----|-----------| 
| Tamaño | GBs (1-10 GB) | MBs (10-500 MB) |
| Tiempo de inicio | Minutos (1-5 min) | Segundos (1-5 seg) |
| Aislamiento | Completo (OS separado) | Proceso-nivel |
| Performance | Overhead mayor | Casi nativo |
| Portabilidad | Limitada | Excelente |
| Densidad | 10-20 VMs/host | 100+ contenedores/host |

#### **1.3 Arquitectura Docker**
```
┌──────────────────────────────────────────────────┐
│              Docker Client (CLI)                 │
│          docker build, run, push, pull           │
└────────────────┬─────────────────────────────────┘
                 │ REST API
┌────────────────▼─────────────────────────────────┐
│              Docker Daemon (dockerd)             │
│  ┌──────────┬──────────┬──────────┬───────────┐  │
│  │ Images   │Containers│ Volumes  │ Networks  │  │
│  └──────────┴──────────┴──────────┴───────────┘  │
└────────────────┬─────────────────────────────────┘
                 │
┌────────────────▼─────────────────────────────────┐
│            Container Runtime (containerd)        │
│                    ┌──────────┐                  │
│                    │   runc   │                  │
│                    └──────────┘                  │
└────────────────┬─────────────────────────────────┘
                 │
┌────────────────▼─────────────────────────────────┐
│              Linux Kernel                        │
│    (namespaces, cgroups, UnionFS)                │
└──────────────────────────────────────────────────┘
```

**Componentes clave:**
- **Docker Client**: Interfaz de usuario (CLI)
- **Docker Daemon**: Motor que gestiona contenedores
- **Images**: Plantillas read-only
- **Containers**: Instancias ejecutables de imágenes
- **Registry**: Almacén de imágenes (Docker Hub, ECR, etc.)

#### **1.4 Casos de Uso**

1. **Desarrollo Consistente**: "Works on my machine" → "Works everywhere"
2. **Microservicios**: Empaquetar servicios independientes
3. **CI/CD**: Build → Test → Deploy automatizado
4. **Escalabilidad**: Orquestar miles de contenedores (Kubernetes)
5. **Ambientes Aislados**: Separar dependencias conflictivas

---

### **HORA 2: Docker Básico**

#### **2.1 Imágenes vs Contenedores**

**Imagen Docker:**
- **Definición**: Plantilla read-only con el filesystem y configuración
- **Capas**: Sistema de archivos en capas (Union File System)
- **Inmutable**: No cambia después de creada
- **Analogía**: Clase en programación orientada a objetos
```
┌─────────────────────────────┐
│   Layer 5: App code         │ ← tu aplicación
├─────────────────────────────┤
│   Layer 4: Dependencies     │ ← libraries Java
├─────────────────────────────┤
│   Layer 3: JDK 17           │
├─────────────────────────────┤
│   Layer 2: OS utilities     │
├─────────────────────────────┤
│   Layer 1: Base OS (debian) │
└─────────────────────────────┘
```

### **1.3 Conceptos Clave**

#### **A. Imagen Docker**

**Definición:** Una plantilla read-only que contiene:
- Sistema operativo base
- Runtime (Java, Python, Node.js)
- Tu aplicación
- Dependencias

**Analogía:** Es como una "clase" en programación orientada a objetos.

**Estructura en capas:**
```
┌─────────────────────────────────┐
│  Layer 4: Tu aplicación (.jar)  │  ← 50 MB
├─────────────────────────────────┤
│  Layer 3: Java 17               │  ← 200 MB
├─────────────────────────────────┤
│  Layer 2: Utilidades OS         │  ← 50 MB
├─────────────────────────────────┤
│  Layer 1: Base OS (Debian Slim) │  ← 100 MB
└─────────────────────────────────┘
Total: ~400 MB

VENTAJA: Las capas se reutilizan entre imágenes
```

#### **B. Contenedor Docker**

**Definición:** Una instancia en ejecución de una imagen.

**Analogía:** Es como un "objeto" o "instancia" de una clase.
```
Imagen: user-service:1.0
    ↓
Contenedor 1: user-service-container-1 (puerto 8081)
Contenedor 2: user-service-container-2 (puerto 8082)
Contenedor 3: user-service-container-3 (puerto 8083)
```

#### **C. Dockerfile**
**Definición:** Archivo de texto con instrucciones para construir una imagen.
```
# Imagen base
FROM openjdk:17-slim

# Directorio de trabajo
WORKDIR /app

# Copiar JAR
COPY target/myapp.jar app.jar

# Puerto
EXPOSE 8080

# Comando de inicio
CMD ["java", "-jar", "app.jar"]
```