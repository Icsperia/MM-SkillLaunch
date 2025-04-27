package com.example.practica.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String facultate;
    private String universitate;
    private List<String> roles; // Presupunem că vrei doar numele rolurilor

    public StudentDTO(String firstName, String lastName, String email, Object o) {
    }
}
