package org.classreviewsite.lecture.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.classreviewsite.data.Lecture;

import java.util.List;

@Data
public class LectureResponse {

    private int status;

    private Lecture data;

    private String message;

    @Data
    @AllArgsConstructor
    public static class lectureResponseByUniversity{
        private int status;
        private List<Lecture> data;
        private String message;
    }

    @Data
    @AllArgsConstructor
    public static class lectureAll{
        private int status;
        private List<Lecture> data;
        private String message;

    }


}
