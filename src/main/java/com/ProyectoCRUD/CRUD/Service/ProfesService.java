package com.ProyectoCRUD.CRUD.Service;

import com.ProyectoCRUD.CRUD.entity.Profes;  // Importa la entidad Profes, que representa los datos de los profesores
import com.ProyectoCRUD.CRUD.repositorio.ProfesRepositorio;  // Importa el repositorio para interactuar con la base de datos
import org.springframework.beans.factory.annotation.Autowired;  // Importa la anotación para inyectar dependencias automáticamente
import org.springframework.stereotype.Service;  // Marca esta clase como un servicio de Spring

import java.util.List;  // Importa las colecciones necesarias para manejar listas de objetos
import java.util.Optional;  // Importa Optional, utilizado para manejar valores que pueden ser nulos

@Service  // Esta anotación indica que la clase es un servicio, que es una capa intermedia entre el controlador y el repositorio
public class ProfesService {

    @Autowired  // Inyecta la dependencia del repositorio ProfesRepositorio en el servicio automáticamente
    ProfesRepositorio profesRepositorio;

    // Método para obtener todos los profesores
    public List<Profes> getProfes() {
        return profesRepositorio.findAll();  // Llama al método findAll() del repositorio para obtener todos los registros de profesores
    }

    // Método para obtener un profesor por su ID
    public Optional<Profes> getProfe(long id) {
        return profesRepositorio.findById(id);  // Llama al método findById() del repositorio, que devuelve un Optional
    }

    // Método para guardar o actualizar un profesor
    public void saveOrUpdate(Profes profes) {
        profesRepositorio.save(profes);  // Llama al método save() del repositorio para guardar un nuevo profesor o actualizar uno existente
    }

    // Método para eliminar un profesor por su ID
    public void delete(long id) {
        profesRepositorio.deleteById(id);  // Llama al método deleteById() del repositorio para eliminar un profesor por su ID
    }
}
