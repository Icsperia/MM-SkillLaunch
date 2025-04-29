package com.example.practica.Auth;

import com.example.practica.Service.AuthentificationServiceCompanie;
import com.example.practica.Service.AuthentificationServiceStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthentificationController {

private final AuthentificationServiceStudent authentificationServiceStudent;

private final AuthentificationServiceCompanie authentificationServiceCompanie;

    @PostMapping("/register/student")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody RegisterRequestStudent request) {
        return ResponseEntity.ok(authentificationServiceStudent.register(request));
}

@PostMapping("/login/student")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody AuthentificationRequestStudent request) {
    return ResponseEntity.ok(authentificationServiceStudent.authenticate(request));
}


    @PostMapping("/register/companie")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody RegisterRequestCompanie request) {
        return ResponseEntity.ok(authentificationServiceCompanie.register(request));
    }

    @PostMapping("/login/companie")
    public ResponseEntity<AuthentificationResponse> register(@RequestBody AuthentificationRequestCompanie request) {

        return ResponseEntity.ok(authentificationServiceCompanie.authenticate(request));
    }

}
