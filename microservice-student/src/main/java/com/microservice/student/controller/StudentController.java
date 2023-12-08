package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/craeted")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }

    @GetMapping("/all")
    public ResponseEntity<?> finAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    /*
    metodo para realizar peticion http entre microservicios
    para el ejemplo entre student y course
     */
    @GetMapping("/search-my-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse){
        return ResponseEntity.ok(studentService.findByIdCourse(idCourse));

    }

}
