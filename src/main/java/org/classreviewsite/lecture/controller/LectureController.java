package org.classreviewsite.lecture.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.classreviewsite.lecture.service.LectureService;
import org.classreviewsite.lecture.dto.DepartmentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;


    @GetMapping("/department")
    public Result findDepartmentRequest(){

        List<String> departmentList =  lectureService.findDistinctDepartment();
        DepartmentResponse response = new DepartmentResponse(200, departmentList, "학과 전체조회입니다.");
        return new Result<>(response);

    }


    @Data
    @AllArgsConstructor
    class Result<T>{
        private T data;
    }
}
