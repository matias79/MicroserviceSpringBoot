package com.microcervice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private String name;
    private String lastName;
    private String email;
    private Long courseId;  //pripiedad para cuando se crea relaciones


}
