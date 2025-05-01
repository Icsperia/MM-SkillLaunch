package com.example.practica.Service;

import com.example.practica.Entity.Student;
import com.example.practica.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

   private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    private StudentRepo studentRepo;



    public List<Student> findAll() {
        return studentRepo.findAll();
    }


    public Student findById(Long id) {
      return studentRepo.findById(id).get()  ;
    }


}

