package com.ProyectoCRUD.CRUD.entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "tbl_Profes")
public class Profes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ProfeID;

    private String FirstName;

    private String LastName;

    @Column(name = "Email_address", unique = true, nullable = false)
    private String Email;

}
