package com.example.practica.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController("/api/demo_controller")
public class DemoController {


@GetMapping
    public ResponseEntity<String> demoController() {
    return ResponseEntity.ok("Hello World");
}

}
