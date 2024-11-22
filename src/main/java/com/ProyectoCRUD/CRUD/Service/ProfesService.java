package com.ProyectoCRUD.CRUD.Service;

import com.ProyectoCRUD.CRUD.entity.Profes;
import com.ProyectoCRUD.CRUD.repositorio.ProfesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProfesService {
    @Autowired
    ProfesRepositorio profesRepositorio;

    public List<Profes> getProfes() {
        return profesRepositorio.findAll();
    }
//Get
    public Optional<Profes> getProfe(long id) {
        return profesRepositorio.findById(id);
    }
//Guardar y actualizar
    public void saveOrUpdate(Profes profes) {
        profesRepositorio.save(profes);
    }
//Borrar
    public void delete(long id) {
        profesRepositorio.deleteById(id);
    }
}

