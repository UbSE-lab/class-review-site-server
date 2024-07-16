package org.classreviewsite.lecture.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.classreviewsite.data.Lecture;
import org.classreviewsite.lecture.dto.LectureResponse;
import org.classreviewsite.lecture.service.LectureService;
import org.classreviewsite.lecture.dto.DepartmentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "강의 정보 API", description = "강의 정보 관련 요청입니다.")
public class LectureController {

    private final LectureService lectureService;


    @GetMapping("/department")
    @Operation(description = "학과 전체조회, 기존 강의 목록에서 학과들을 추려 중복을 제거하고 출력하고있습니다.")
    @ApiResponse(responseCode = "200", description = "학과 전체조회입니다.")
    public Result findDepartmentRequest(){
        List<String> departmentList =  lectureService.findDistinctDepartment();
        DepartmentResponse response = new DepartmentResponse(200, departmentList, "학과 전체조회입니다.");
        return new Result<>(response);
    }

    @GetMapping("/lecture/school")
    public Result findByUniversity(@RequestParam("university") String university){
        List<Lecture> list = lectureService.findByUniversity(university);
        LectureResponse.lectureResponseByUniversity response = new LectureResponse.lectureResponseByUniversity(200, list, "해당 대학의 강의 목록입니다.");
        return new Result<>(response);
    }

    @GetMapping("/test")
    public Result test(){
        List<Lecture> list = lectureService.findAll();
        LectureResponse.lectureAll lectureResponse = new LectureResponse.lectureAll(200, list, "조회");

        return new Result<>(lectureResponse);
    }




    @Data
    @AllArgsConstructor
    class Result<T>{
        private T data;
    }
}
