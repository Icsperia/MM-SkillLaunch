package com.example.practica.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "StudentDetails")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String description;

    private String Skills;

    private String Experience;

    private String JobTitles;

    @ManyToMany
    @JoinTable(name="studentJoin",
            joinColumns = @JoinColumn(name="studentId"),
            inverseJoinColumns = @JoinColumn(name="studentDetailsId")
    )

private Set<Student> student= new HashSet<>();}

