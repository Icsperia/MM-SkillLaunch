package com.example.practica.Entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter

@RequiredArgsConstructor
@AllArgsConstructor

@Entity
public class Opportunities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String type;
    private String description;
    private String location;
    private String skills;
    private String status;
    private String ROH;
    @ManyToOne
    @JoinColumn(name="companie_id")
    private Companie companie;

}
