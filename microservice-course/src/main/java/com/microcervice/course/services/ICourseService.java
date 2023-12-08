package com.microcervice.course.services;

import com.microcervice.course.entities.Course;
import com.microcervice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {
    List<Course> findAll();
    Course findById(Long id);
    void save(Course course);

    //este metodo corresponde a la configuracion de la respuesta
    StudentByCourseResponse findStudentByIdCourse(Long idCourse);

}
