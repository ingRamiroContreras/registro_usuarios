## Instalación de la aplicación:

 - Descargar el proyecto y abrir la carpeta users en el editor de preferencia para la parte java.
 - Ejecutar el comando **./mvnw clean install** para que se ejecuten los test y se genere el JAR.
 - validar que el puerto 8080 no esté ocupado ya que el JAR se despliega en el puerto 8080.
 - Ejecutar el JAR creado en la Carpeta target con el comando java -jar <nombre del jar>
 - url de la base de datos **http://localhost:8080/h2-console** para ingresar no necesita ninguna contraseña.

 ## Abrir app:

 - Abrir la carpeta frontEnd que se encuentra en la ruta del proyecyo **usuers/src/main/resources/app/FrontEnd** y abrir el archivo index.html en cualquier navegador.

## Consumo servicios 

Creación de usuarios

```json
Method = POST
Url = http://localhost:8080/users
Content-Type = application/json
Body = 
{
    "name":"Andrea",
    "last_name":"alvarez"
}

```

Listar usuarios

```json
Method = GET
Url = http://localhost:8080/users
Content-Type = application/json

```

Procesar usuarios

```json
Method = POST
Url = http://localhost:8080/users/process
Content-Type = application/json
Body = 
{
    "user_ids":[
        "bcbe0da1-e705-4588-87b2-66b8fc7a74c1",
        "bcbe0da1-e705-4588-87b2-66b8fc7a74c1"
    ]
}

```

## Patrones y buenas practicas

-   Inyección de dependencias e inversion de control provisto por spring.
-   Aproach arquitectura Hexagonal segmentacion de carpetas.
-   Principios SOLID.
-   UUID para los identificadores de las entidades.




## Descripcion de los servicios

-   **User create:** Componente que me permite crear un usuario, por defecto lo crea con un estado Procces: False.
-   **User List:** Componente que lista los usuarios creados con su respectivo estado en procces.
-   **Update Procces State user**: Componente que actualiza el estado de los usuarios mediante su id.
-   **Events Bus:** para el procesamiento y el cambio de estado de los usuarios, se implementó un componente de eventos con spring Boot, el controller me permite crear un evento con los ids que se tienen que procesar y posteriormente un listener ejecutara el evento llama.

