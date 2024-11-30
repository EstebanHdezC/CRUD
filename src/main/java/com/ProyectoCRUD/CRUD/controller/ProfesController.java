package com.ProyectoCRUD.CRUD.controller;

import com.ProyectoCRUD.CRUD.Service.ProfesService;
import com.ProyectoCRUD.CRUD.entity.Profes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/profes")
public class ProfesController {
    @Autowired
    private ProfesService profesService;

    @GetMapping
    public List<Profes> getAll() {
        return profesService.getProfes();
    }

    @PostMapping
    public void save(@RequestBody Profes profes) {
        profesService.saveOrUpdate(profes);
    }

    @PutMapping("/{profeId}") // Cambiar de POST a PUT para actualizaciones
    public void update(@PathVariable("profeId") Long profeId, @RequestBody Profes profes) {
        profes.setProfeId(profeId); // Establecer el profeId para actualizar correctamente
        profesService.saveOrUpdate(profes);
    }

    @DeleteMapping("/{profeId}")
    public void deleteProfe(@PathVariable("profeId") Long profeId) {
        profesService.delete(profeId);
    }

    @GetMapping("/{profeId}")
    public Optional<Profes> getById(@PathVariable("profeId") Long profeId) {
        return profesService.getProfe(profeId);
    }
}
