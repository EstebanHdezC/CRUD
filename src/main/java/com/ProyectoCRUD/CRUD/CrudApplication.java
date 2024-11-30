package com.ProyectoCRUD.CRUD;  // Definimos el paquete en el que se encuentra la clase CrudApplication.

import org.springframework.boot.SpringApplication;  // Importa la clase SpringApplication, que permite arrancar la aplicación Spring Boot.
import org.springframework.boot.autoconfigure.SpringBootApplication;  // Importa la anotación @SpringBootApplication, que marca la clase principal de la aplicación.

@SpringBootApplication  // Esta anotación indica que esta clase es la aplicación Spring Boot y habilita varias configuraciones automáticas:
// - @Configuration: Marca la clase como configuración de Spring.
// - @EnableAutoConfiguration: Habilita la configuración automática.
// - @ComponentScan: Permite a Spring buscar otros componentes (como controladores y servicios) en el paquete actual y subpaquetes.
public class CrudApplication {

	public static void main(String[] args) {  // Método principal que se ejecuta cuando se arranca la aplicación.
		SpringApplication.run(CrudApplication.class, args);  // Arranca la aplicación Spring Boot, pasando la clase actual como argumento.
	}
}
