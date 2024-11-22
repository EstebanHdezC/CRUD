package com.ProyectoCRUD.CRUD.repositorio;

import com.ProyectoCRUD.CRUD.entity.Profes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesRepositorio extends JpaRepository<Profes, Long> {
}
