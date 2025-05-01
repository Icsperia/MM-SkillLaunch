package com.example.practica.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "StudentDetails")
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String Skills;
    private String Experience;
    private String JobTitles;

    @JsonManagedReference
@OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}

