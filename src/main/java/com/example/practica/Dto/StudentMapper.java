package com.example.practica.DTO;

import com.example.practica.Entity.Student;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentMapper {
public StudentDto toDto(Student student) {
    StudentDto studentDto = new StudentDto();

    studentDto.setFirstName(student.getFirstName());
    studentDto.setLastName(student.getLastName());
    studentDto.setEmail(student.getEmail());
    studentDto.setId(student.getId());
return studentDto;
}

public Student toEntity(StudentDto studentDto) {
    Student student = new Student();
    student.setFirstName(studentDto.getFirstName());
    student.setLastName(studentDto.getLastName());
    student.setEmail(studentDto.getEmail());
    student.setId(studentDto.getId());
    return student;
}


}
