package com.example.practica.Controller;

import com.example.practica.DTO.StudentDto;
import com.example.practica.DTO.StudentMapper;
import com.example.practica.Entity.Student;
import com.example.practica.Entity.StudentDetails;
import com.example.practica.Repo.StudentDetailsRepo;
import com.example.practica.Repo.StudentRepo;
import com.example.practica.Service.StudentDetailsService;
import com.example.practica.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;
    private final StudentService studentService;

    private final StudentDetailsRepo studentDetailsRepo;

    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepo.findAll());
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(studentRepo.findById(id));
    }

    @GetMapping("/studentDto/{id}")
    public ResponseEntity<StudentDto> getStudentDto(@PathVariable("id") Long id) {
      Student student = studentService.findById(id);
       return ResponseEntity.ok(studentMapper.toDto(student));
    }

   @PostMapping("/studentDetails")
    public ResponseEntity<StudentDetails> saveStudentDetails(@RequestBody StudentDetails studentDetails) {
      Student student=studentRepo.findById(studentDetails.getStudent().getId()).orElse(null);
        studentDetails.setStudent(student);
        return ResponseEntity.ok(studentDetailsRepo.save(studentDetails));

   }

}
