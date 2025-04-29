package com.example.practica.Service;

import com.example.practica.Auth.AuthentificationRequestCompanie;
import com.example.practica.Auth.AuthentificationResponse;
import com.example.practica.Auth.RegisterRequestCompanie;
import com.example.practica.Config.JwtService;
import com.example.practica.Entity.Companie;
import com.example.practica.Entity.Role;
import com.example.practica.Repo.CompanieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthentificationServiceCompanie {

    private final CompanieRepo companieRepo;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public AuthentificationResponse register(RegisterRequestCompanie request) {

        var companie = Companie.builder()
                .name(request.getName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.COMPANIE)
                .build();
        if (companieRepo.existsByEmail(request.getEmail())) {
            return new AuthentificationResponse("NiceTry");
        } else {
            companieRepo.save(companie);
        }


        var jwtToken = jwtService.generateToken(companie);

        return  AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthentificationResponse authenticate(AuthentificationRequestCompanie request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var companie= companieRepo.findByEmail(request.getEmail()).orElseThrow(null);


        var jwtToken = jwtService.generateToken(companie);

        return  AuthentificationResponse.builder()
                .token(jwtToken)
                .build();
    }
}




