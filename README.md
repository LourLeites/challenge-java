# Challenge Java 
Autor.Leites Lourdes

Este proyecto consiste en crear una serie de endpoints relacionados con empresas y transferencias. Está basado en **Spring Boot** y utiliza una arquitectura **hexagonal**.

## Características del Proyecto

- Arquitectura Hexagonal: Se implentó una arquitectura que separa las diferentes capas de la aplicación (dominio, servicio, infraestructura).
- **Endpoints RESTful**: Se han creado endpoints para gestionar empresas y realizar transferencias entre ellas.
- **Base de datos SQL**: El proyecto utiliza **JPA** con una base de datos **SQL Server** para almacenar la información de las empresas y transferencias,
decidí utilizar base de datos relacionales ya que las búsquedas requerían una relación entre empresa y transferencia, a su vez, utilicé anotaciones como
@ManyToOne() para simplificar la búdqueda y ahorrar la clase ITransferenciaRepository.
- **Manejo de Excepciones**: Excepciones en caso de errores, que podrían refinarse según el código de estado hrrp.
- **Pruebas unitarias**: Se incluyen pruebas unitarias  utilizando **JUnit** y **Mockito**.


Para su instalación es necesario configurar la base de datos en application-local.properties
