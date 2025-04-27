package com.example.practica.Service;

import com.example.practica.DTO.StudentDTO;
import com.example.practica.Entity.Student;


import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

void saveStudent(StudentDTO studentDTO) ;
Student findStudentByEmail(String email);
List<StudentDTO> findAllStudents();



}