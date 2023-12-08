package com.microservice.student.persistence;

import com.microservice.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //List<Student> findAllByCourseId(Long idCourse);
    @Query("select s from Student s where s.courseId= :idCourse")
    List<Student> findAllStudent(Long idCourse);
}
