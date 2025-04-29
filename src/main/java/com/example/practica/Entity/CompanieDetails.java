package com.example.practica.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor

@Table(name = "CompanieDetails")

public class CompanieDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Description;

    private String FieldOfActivity;

    private String Jobs;

    private String Reviews;
    @ManyToMany
    @JoinTable(name="companieJoin",
            joinColumns = @JoinColumn(name="companieId"),
            inverseJoinColumns = @JoinColumn(name="companieDetailsId")
    )

    private Set<Companie> companie= new HashSet<>();

}
