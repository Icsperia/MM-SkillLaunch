package com.example.practica.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Entity
@Table(name="Companie", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"CUI"}),
        @UniqueConstraint(columnNames = {"email_companie"}),
        @UniqueConstraint(columnNames = {"parola"}),
        @UniqueConstraint(columnNames = {"nume_companie"})
})
public class Companie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_companie", unique = true)
    private Integer id;
    @Column(name="nume_companie")
    private String nume_companie;
    @Column(name="email_companie")
    private String email;
    @Column(name="parola")
    private String parola;
    @Column(name="CUI")
    private Integer CUI;





}



