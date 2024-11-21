package com.ProyectoCRUD.CRUD.Service;

import com.ProyectoCRUD.CRUD.entity.Profes;
import com.ProyectoCRUD.CRUD.repositorio.ProfesRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProfesService {
    @Autowired
    ProfesRepositorio profesRepositorio;
    public static List<Profes> getProfes(){
        return profesRepositorio.findAll();

    }

    public List<Profes> getProfes(long id){
        return profesRepositorio.findById(id);

    }
    public void saveOrUpdate(Profes profes){
        profesRepositorio.save(profes);
    }
    public void delete(long id){
        profesRepositorio.deleteById(id);
    }
}
