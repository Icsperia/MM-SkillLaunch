package com.example.practica.Controller;

import com.example.practica.DTO.CompanieDto;
import com.example.practica.DTO.CompanieMapper;
import com.example.practica.Entity.Companie;
import com.example.practica.Service.CompanieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class CompanieController {
private final CompanieService companieService;
private final CompanieMapper companieMapper;


    @GetMapping("/companie/{id}")
    public ResponseEntity<CompanieDto> findCompanieById(@PathVariable("id") Long id) {
       Companie companie = companieService.findById(id);
   return ResponseEntity.ok(companieMapper.toDto(companie));
    }



}
