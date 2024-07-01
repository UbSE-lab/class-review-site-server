package org.classreviewsite.lecture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DepartmentResponse {

    private int status;

    private List<String> data;

    private String message;
}
