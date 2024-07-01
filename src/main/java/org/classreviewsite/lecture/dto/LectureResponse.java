package org.classreviewsite.lecture.dto;

import lombok.Data;
import org.classreviewsite.data.Lecture;

@Data
public class LectureResponse {

    private int status;

    private Lecture data;

    private String message;


}
