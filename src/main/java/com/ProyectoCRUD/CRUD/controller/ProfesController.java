package com.ProyectoCRUD.CRUD.controller;

import com.ProyectoCRUD.CRUD.Service.ProfesService;
import com.ProyectoCRUD.CRUD.entity.Profes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/profes")
public class ProfesController {
    @Autowired
    private ProfesService profesService;

    @GetMapping
    public List<Profes> getAll(){
        return profesService.getProfes();

    }

    @PostMapping
    public void saveUpdate(@RequestBody Profes profes){
        profesService.saveOrUpdate(profes);

    }
    @DeleteMapping("/{ProfeId}")
    public void deleteProfe(@PathVariable("profeId") Long profeId){
        profesService.delete(profeId);

    }
    @GetMapping("/{ProfeId}")
    public Optional<Profes> getBId(@PathVariable ("ProfeId") Long ProfeId){
        return profesService.getProfe(ProfeId);


    }




}
