package com.example.practica.Repo;

import com.example.practica.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Optional;
@Component
@Repository
public  interface StudentRepo extends JpaRepository<Student, String> {

//Student findByEmail(String email);
Optional<Student> findByEmail( String email);

}