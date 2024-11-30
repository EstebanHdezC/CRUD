package com.ProyectoCRUD.CRUD.repositorio;

import com.ProyectoCRUD.CRUD.entity.Profes;  // Importa la entidad Profes, que representa los datos que se guardarán en la base de datos
import org.springframework.data.jpa.repository.JpaRepository;  // Importa JpaRepository para proporcionar métodos CRUD predefinidos
import org.springframework.stereotype.Repository;  // Importa la anotación Repository para marcar esta interfaz como un repositorio

@Repository  // Esta anotación indica que la interfaz es un repositorio, lo que permite a Spring Data JPA gestionar las interacciones con la base de datos
public interface ProfesRepositorio extends JpaRepository<Profes, Long> {
    // JpaRepository es una interfaz de Spring Data JPA que proporciona métodos CRUD automáticamente,
    // en este caso para la entidad Profes, donde 'Profes' es el tipo de entidad y 'Long' es el tipo del identificador (profeId)
    // No es necesario definir métodos adicionales, ya que JpaRepository proporciona:
    // - save() para crear o actualizar registros
    // - findById() para buscar un registro por su id
    // - findAll() para obtener todos los registros
    // - deleteById() para eliminar un registro por su id
}
