package com.microcervice.course.http.response;

import com.microcervice.course.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//esta clase seria la respuesta que tendra el cliente
public class StudentByCourseResponse {
    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;
}
