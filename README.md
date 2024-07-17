# Foro hub

Challenge API de back-end realiza las actividades en un foro usando Spring Boot, MySQL y Security de Spring.

## Descripción del proyecto
Ofrece las opciones de CRUD para los tópicos del foro:

- Registro de tópicos y guardarlos en la base de datos topicos
- Listar los tópicos que están en la base de datos
- Mostrar los datos de un tópico seleccionado
- Modificar el tópico seleccionado
- Eliminar el tópico seleccionado de la base de datos

y todo esto únicamente con el acceso autorizado
- usando la forma STATELESS de autenticación con JWT (JSON Web Token)

## Cómo usar la aplicación
Para probar o usar la aplicación se requeiere seguir los siguientes pasos:

1. Descarga todos los archivos y carpetas en una carpeta en tu computadora.

2. Instala MySQL en tu computadora y crea la base de datos con el nombre forohub(Auque tambien puedes elegir el motor de bases de datos que te guste
y luego puedes configurar).

3. Abre el proyecto en IntelliJ 

4. Define las siguientes variables de entorno en tu sistema operativo, para evitar vulnerabilidades en la aplicación.
    - SQL_USERNAME --> tu username para entrar en MySQL
    - SQL_PASSWORD --> tu username para entrar en MySQL
    - JWT_SECRET --> tu password para la autorización con JWT

    Si el complilador no acepta las variables, defínelas también en IntelliJ (Run/Edit Configurations/Environment variables)

    El programa se ejecutará en localhost:8080(Debes asegurarte que este libre a la hora de correr este proyecto)

5. Run la clase DesafioLiteraluraApplication. 

6. Con primer run se te construyeron las dos tablas en la base de datos. Ingresa en la tabla usuarios, y allí registra un nombre (login) y una contraseña(password) que definiste en JWT_SECRET, encriptado. Lo encriptas con la encriptación Bcrypt en internet.

7. Descarga un cliente de API, te recomiendo Insomnia.

8. En Insomnia (aunque cualquier cliente que tengas la sintaxis va a ser muy similar) puedes realizar las actividades mencionadas:
    - POST http://localhost:8080/login (autenticación y autorización con el login y clave que incluiste en la base de datos en la tabla usuarios). Cópia el JWT que te lo regresa el sistema y pégalo a todas otras actividades en la parte Auth/Bearer token.
    - POST http://localhost:8080/topicos (Registro de un tópico)
    - GET http://localhost:8080/topicos Listar los tópicos que están en la base de datos.
    - GET http://localhost:8080/topicos/{id} Mostrar los datos de tópico con "id" (pones número)
    - PUT http://localhost:8080/topicos/{id} Modificar el tópico con "id" (pones número)
    - DEL http://localhost:8080/topicos/2 Eliminar el tópico con "id" (pones número) de la base de datos

## Licencia
GNU General Public License v3.0
