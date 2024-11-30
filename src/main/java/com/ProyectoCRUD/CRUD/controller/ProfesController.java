package com.ProyectoCRUD.CRUD.controller;

import com.ProyectoCRUD.CRUD.Service.ProfesService;  // Importa el servicio que interactúa con la base de datos
import com.ProyectoCRUD.CRUD.entity.Profes;  // Importa la entidad Profes
import org.springframework.beans.factory.annotation.Autowired;  // Importa la anotación para inyectar dependencias
import org.springframework.web.bind.annotation.*;  // Importa las anotaciones para los controladores REST

import java.util.List;  // Importa la clase List para manejar listas de objetos
import java.util.Optional;  // Importa Optional para manejar valores que pueden ser nulos

@RestController  // Marca esta clase como un controlador REST, lo que significa que maneja las peticiones HTTP
@RequestMapping(path = "api/v1/profes")  // Define la ruta base para las peticiones a este controlador
public class ProfesController {

    @Autowired  // Inyecta la dependencia del servicio ProfesService automáticamente
    private ProfesService profesService;  // Declara el servicio que se utilizará para las operaciones CRUD

    // Método para obtener todos los profesores
    @GetMapping  // Anotación para manejar solicitudes GET a la ruta "/api/v1/profes"
    public List<Profes> getAll() {
        return profesService.getProfes();  // Llama al servicio para obtener la lista de todos los profesores
    }

    // Método para crear un nuevo profesor
    @PostMapping  // Anotación para manejar solicitudes POST a la ruta "/api/v1/profes"
    public void save(@RequestBody Profes profes) {
        profesService.saveOrUpdate(profes);  // Llama al servicio para guardar el nuevo profesor
    }

    // Método para actualizar un profesor existente
    @PutMapping("/{profeId}")  // Anotación para manejar solicitudes PUT a la ruta "/api/v1/profes/{profeId}"
    public void update(@PathVariable("profeId") Long profeId, @RequestBody Profes profes) {
        profes.setProfeId(profeId);  // Establece el profeId en el objeto profes para asegurarse de que se actualiza el correcto
        profesService.saveOrUpdate(profes);  // Llama al servicio para guardar los cambios (actualización) del profesor
    }

    // Método para eliminar un profesor por su ID
    @DeleteMapping("/{profeId}")  // Anotación para manejar solicitudes DELETE a la ruta "/api/v1/profes/{profeId}"
    public void deleteProfe(@PathVariable("profeId") Long profeId) {
        profesService.delete(profeId);  // Llama al servicio para eliminar el profesor por su ID
    }

    // Método para obtener un profesor por su ID
    @GetMapping("/{profeId}")  // Anotación para manejar solicitudes GET a la ruta "/api/v1/profes/{profeId}"
    public Optional<Profes> getById(@PathVariable("profeId") Long profeId) {
        return profesService.getProfe(profeId);  // Llama al servicio para obtener un profesor por su ID
    }
}
