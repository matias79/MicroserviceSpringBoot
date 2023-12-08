package com.microcervice.course.client;

import com.microcervice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/*
esta anotacion sirve para referenciar al micro donde se comunica
para el caso el el nombre asignado en .yml al iigual que el puerto, seguido
del enpoint del controller
 */
@FeignClient(name = "msvc-student", url="localhost:8080/api/student")
public interface StudentClient {
    @GetMapping("/search-my-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);
}
