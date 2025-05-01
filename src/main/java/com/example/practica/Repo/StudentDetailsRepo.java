package com.example.practica.Repo;

import com.example.practica.Entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentDetailsRepo extends JpaRepository<StudentDetails, Integer> {
}
