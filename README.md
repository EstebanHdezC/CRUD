# Proyecto CRUD - Gestión de Profesores

Este proyecto es una aplicación CRUD (Crear, Leer, Actualizar, Eliminar) desarrollada con **Spring Boot** como backend y tecnologías web como **HTML, CSS, JavaScript (con DataTables)** como frontend. Su propósito es gestionar información de profesores, incluyendo su nombre, apellido y correo electrónico.

---

## Tabla de Contenidos

- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Requisitos Previos](#requisitos-previos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Ejecución](#ejecución)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Endpoints del API](#endpoints-del-api)


---

## Características

- Registro, edición, eliminación y visualización de profesores.
- Validación básica en los formularios.
- Diseño responsivo y estilizado con **Bootstrap**.
- Listado interactivo de profesores con **DataTables**.
- Backend conectado a una base de datos MySQL para persistencia de datos.

---

## Tecnologías Utilizadas

### Backend:
- **Java** (Spring Boot)
- **Spring Data JPA** (para la interacción con la base de datos)
- **Hibernate** (ORM para manejo de entidades)
- **MySQL** (Base de datos)

### Frontend:
- **HTML5**
- **CSS3** (con Bootstrap para diseño)
- **JavaScript** (uso de DataTables y fetch API)

---

## Requisitos Previos

1. **Java Development Kit (JDK)** 8 o superior.
2. **Maven** para la gestión de dependencias.
3. **MySQL** para la base de datos.
4. Un IDE como **IntelliJ IDEA**, **Eclipse** o cualquier editor de texto avanzado.

---

## Configuración del Proyecto

1. **Clonar el repositorio:**
   
   git clone https://github.com/EstebanHdezC/CRUD
Configurar la base de datos:

2. **Crear una base de datos en MySQL llamada profes:**

CREATE DATABASE profes;

3. **Configurar las credenciales de MySQL en el archivo application.properties:**
properties

spring.datasource.url=jdbc:mysql://localhost:3306/profes
spring.datasource.username=tu-usuario
spring.datasource.password=tu-contraseña
spring.jpa.hibernate.ddl-auto=create-drop

4. **Instalar las dependencias del proyecto:**

mvn install

## Ejecución

1. **Iniciar la aplicación Spring Boot:**

mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.


## Estructura del Proyecto

ProyectoCRUD/
├── src/
│   ├── main/
│   │   ├── java/com/ProyectoCRUD/CRUD/
│   │   │   ├── controller/          # Controladores REST
│   │   │   ├── entity/              # Entidades (modelos de datos)
│   │   │   ├── repositorio/         # Repositorios JPA
│   │   │   ├── service/             # Lógica de negocio
│   │   │   └── CrudApplication      # Punto de entrada del proyecto
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuración de la aplicación
│   │   │   └── static/                 # Archivos frontend (HTML, CSS, JS)
│   └── test/                           # Pruebas (si las implementas)
├── pom.xml                              # Dependencias de Maven
└── README.md                            # Este archivo


## Endpoints del API

**GET**	/api/v1/profes	Obtener todos los profesores.

**POST**	/api/v1/profes	Crear un nuevo profesor.

**PUT**	/api/v1/profes/{id}	Actualizar un profesor por ID.

**DELETE**	/api/v1/profes/{id}	Eliminar un profesor por ID.

**GET**	/api/v1/profes/{id}	Obtener un profesor específico por su ID.


