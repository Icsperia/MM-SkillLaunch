package com.example.practica.Service;

import com.example.practica.Entity.StudentDetails;
import com.example.practica.Repo.StudentDetailsRepo;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
@AllArgsConstructor

@Service
public class StudentDetailsService {

    private final StudentDetailsRepo studentDetailsRepo;

    public StudentDetails save(StudentDetails studentDetails) {
        return studentDetailsRepo.save(studentDetails);
    }

}
