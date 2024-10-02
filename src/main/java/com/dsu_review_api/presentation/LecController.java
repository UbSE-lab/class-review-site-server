package com.dsu_review_api.presentation;

import com.dsu_review_api.application.LecService;
import com.dsu_review_api.infrastructure.config.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "강의 API", description = "강의와 관련된 요청 API 입니다.")
public class LecController {

    private final LecService lecService;

    @GetMapping("/department")  // 학과 조회
    @Operation(summary = "학과 전체 조회", description = "학과 전체 조회 입니다.")
    public Api selectDepartment(){
        Api api = new Api();

        List<String> lecList = lecService.selectDepartment();

//        log.info("lec:", lecList);

        api.setStatus("200");
        api.setData(lecList);
        api.setServer("학과 목록 조회입니다." );

        log.info("api: {}", api);

        return api;

    }


}

