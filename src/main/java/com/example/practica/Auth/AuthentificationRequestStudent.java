package com.example.practica.Auth;

import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AuthentificationRequestStudent {

    private String email;
    private String password;
}
