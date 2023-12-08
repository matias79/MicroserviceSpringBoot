package com.microcervice.course.services;

import com.microcervice.course.client.StudentClient;
import com.microcervice.course.dto.StudentDTO;
import com.microcervice.course.entities.Course;
import com.microcervice.course.http.response.StudentByCourseResponse;
import com.microcervice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseImplemService implements ICourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    private StudentClient studentClient;
    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }
    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentByIdCourse(Long idCourse) {
        //primero consultar el course
        Course course = courseRepository.findById(idCourse).orElse(new Course());
        //obtener los studieantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);
        //esta lista se logra traer con la comunicacion haci student, pero se hace con el client para ellos se hace autowaried a cliente

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
