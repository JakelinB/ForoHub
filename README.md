# 💬 ForoHub — REST API con autenticación JWT

> **ES** | [EN below](#en---forohub-rest-api-with-jwt-auth)

API REST backend para la gestión de tópicos en un foro, construida con Spring Boot. Implementa autenticación y autorización stateless con **JWT (JSON Web Token)** y operaciones CRUD completas sobre tópicos.

Challenge del programa **Oracle Next Education (ONE)** — Alura LATAM.

## Endpoints

| Método | Ruta | Descripción | Auth |
|---|---|---|---|
| POST | `/login` | Autenticación — devuelve JWT | ❌ |
| POST | `/topicos` | Crear nuevo tópico | ✅ |
| GET | `/topicos` | Listar todos los tópicos | ✅ |
| GET | `/topicos/{id}` | Obtener tópico por ID | ✅ |
| PUT | `/topicos/{id}` | Actualizar tópico | ✅ |
| DELETE | `/topicos/{id}` | Eliminar tópico | ✅ |

## Tecnologías

| Tecnología | Uso |
|---|---|
| Java 17 | Lenguaje principal |
| Spring Boot | Framework backend |
| Spring Security | Control de acceso |
| JWT (Auth0) | Autenticación stateless |
| MySQL | Base de datos relacional |
| Maven | Gestión de dependencias |

## Requisitos

- Java 17+
- MySQL instalado y corriendo
- IntelliJ IDEA o similar
- Cliente API: Insomnia o Postman

## Cómo ejecutarlo

```bash
# 1. Clona el repositorio
git clone https://github.com/JakelinB/ForoHub.git
cd ForoHub

# 2. Crea la base de datos en MySQL
CREATE DATABASE forohub;

# 3. Define las variables de entorno (o en Run > Edit Configurations en IntelliJ)
SQL_USERNAME=tu_usuario
SQL_PASSWORD=tu_contraseña
JWT_SECRET=tu_secreto_jwt

# 4. Ejecuta el proyecto
./mvnw spring-boot:run
# La app corre en http://localhost:8080
```

## Primer uso

Después del primer run, inserta un usuario en la tabla `usuarios` con la contraseña encriptada en **BCrypt** (puedes hacerlo en [bcrypt.online](https://bcrypt.online)). Luego autentica con `POST /login` para obtener el JWT y úsalo como Bearer token en el resto de endpoints.

## Lo que aprendí

- Implementación de autenticación stateless con JWT
- Spring Security: filtros, cadena de seguridad y control de acceso
- Buenas prácticas de seguridad: variables de entorno para credenciales
- Diseño de APIs REST con Spring Boot

---

## EN — ForoHub REST API with JWT Auth

Backend REST API for forum topic management, built with Spring Boot. Implements stateless JWT authentication and full CRUD operations on topics. Part of the **Oracle Next Education (ONE)** challenge.

### Stack
`Java 17` · `Spring Boot` · `Spring Security` · `JWT` · `MySQL` · `Maven`

### Quick start

```bash
git clone https://github.com/JakelinB/ForoHub.git
cd ForoHub
# Set environment variables: SQL_USERNAME, SQL_PASSWORD, JWT_SECRET
./mvnw spring-boot:run
```

---
*Desarrollado por [Jakelin Bedoya](https://www.linkedin.com/in/jakelin-bedoya-becerra) · Oracle ONE Challenge*
