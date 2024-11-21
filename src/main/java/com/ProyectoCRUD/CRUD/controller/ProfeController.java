package com.ProyectoCRUD.CRUD.controller;

import com.ProyectoCRUD.CRUD.Service.ProfesService;
import com.ProyectoCRUD.CRUD.entity.Profes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/profes")


public class ProfeController {
    @Autowired
    private ProfesService profesService;
    public List<Profes> getAll(){
        return ProfesService.getProfes();
    }
}
