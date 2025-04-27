package com.example.practica.Auth;

import com.example.practica.Entity.Student;
import com.example.practica.Service.AuthentificationService;
import com.nimbusds.openid.connect.sdk.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthentificationController {

private final AuthentificationService authentificationService;



    @PostMapping("/register")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authentificationService.register(request));
}

@PostMapping("/login")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody AuthentificationRequest request) {
    return ResponseEntity.ok(authentificationService.authentificate(request));
}

}
