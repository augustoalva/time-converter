# Time Converter

Aplicación que convierte la hora en formato UTC

## Consideraciones de la implementación

Para el desarrollo del presente proyecto, se considera la conversión de la hora y zona horaria ingresada en el input a la hora con zona horaria local.

### Prerequisitos

Se requiere la instalación del siguiente software

* [Java 11](https://www.oracle.com/technetwork/java/javase/downloads) - Programming Language.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework to microservices.

### Instalación

Para la compilación, empaquetamiento e instalación del artefacto se ejecutan los siguientes comandos.
```
mvn clean
mvn install
```

## Ejecución

Para la ejecución del microservicio ejecutamos el siguiente comando.
```
mvn spring-boot:run
```

Para invocar el endpoint de pruebas se puede utilizar el comando curl.

```
curl -d "hour=10:00:00&timezone=-3" -X POST http://localhost:8080/timeconverter/v1/hours
```

## Ejecución de los tests

Para la ejecución de los test ejecutamos el siguiente comando.
```
mvn test
```

## Autor

* **Augusto Fernando Alva Campos**