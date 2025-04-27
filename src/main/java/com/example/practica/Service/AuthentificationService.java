package com.example.practica.Service;

import com.example.practica.Auth.AuthentificationRequest;
import com.example.practica.Auth.AuthentificationResponse;
import com.example.practica.Auth.RegisterRequest;
import com.example.practica.Config.JwtService;
import com.example.practica.Entity.Role;
import com.example.practica.Entity.Student;
import com.example.practica.Repo.StudentRepo;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationService {
private final StudentRepo studentRepo;
private final PasswordEncoder passwordEncoder;
private final JwtService jwtService;
private final AuthenticationManager authenticationManager;

    public AuthentificationResponse register(RegisterRequest request) {

        var student = Student.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .facultate(request.getFaculty())
                .universitate(request.getUniversity())
                .role(Role.STUDENT)
                .build();

        studentRepo.save(student);

       var jwtToken = jwtService.generateToken(student);

    return  AuthentificationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthentificationResponse authentificate(AuthentificationRequest request) {

authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        )
);
var student = studentRepo.findByEmail(request.getEmail()).orElseThrow(null);


        var jwtToken = jwtService.generateToken(student);

        return  AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
