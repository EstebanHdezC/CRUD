package com.ProyectoCRUD.CRUD.entity;  // Paquete donde se encuentra la clase, en este caso es 'entity'

import jakarta.persistence.GeneratedValue; // Importa la anotación que indica cómo se generarán los valores de los identificadores.
import jakarta.persistence.Id; // Importa la anotación que indica que un campo es la clave primaria de la entidad.
import jakarta.persistence.Table; // Importa la anotación que especifica el nombre de la tabla en la base de datos.
import jakarta.persistence.Entity; // Importa la anotación que marca la clase como una entidad JPA.
import jakarta.persistence.*; // Importa otras anotaciones necesarias de JPA.
import lombok.Data; // Importa la anotación de Lombok para generar automáticamente getters, setters y otros métodos como toString.

@Data  // Anotación de Lombok que genera getters, setters, toString, equals y hashCode para esta clase automáticamente.
@Entity // Marca la clase como una entidad JPA, lo que significa que se mapeará a una tabla en la base de datos.
@Table(name= "tbl_Profes") // Especifica el nombre de la tabla que representará esta clase en la base de datos.
public class Profes {

    @Id // Marca este campo como la clave primaria de la entidad.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de 'profeId' se generará automáticamente, típicamente autoincrementado en la base de datos.
    private Long profeId;  // Campo que almacenará el identificador único del profesor.

    private String FirstName; // Campo para almacenar el primer nombre del profesor.

    private String LastName; // Campo para almacenar el apellido del profesor.

    @Column(name = "Email_address", unique = true, nullable = false) // Anotación que mapea el campo a una columna con nombre "Email_address" en la base de datos.
    // También asegura que los valores en esta columna sean únicos (no se repitan) y no puedan ser nulos.
    private String Email; // Campo para almacenar el correo electrónico del profesor.
}
