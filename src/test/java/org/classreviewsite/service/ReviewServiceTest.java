package org.classreviewsite.service;

import org.classreviewsite.review.dto.ReviewPostRequest;
import org.classreviewsite.review.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ReviewServiceTest {

    @Autowired
    ReviewService reviewService;

    @Test
    @Transactional
    void addPostTest(){
        ReviewPostRequest request = ReviewPostRequest.builder()
                .lecName("소프트웨어공학")
                .postTitle("훌륭한 강의입니다.")
                .postContent("훌륭한 강의에요.")
                .userNumber(20191585L)
                .build();

        reviewService.addReviewPost(request);

    }

    @Test
    @Transactional
    void validateAddPostTest(){
        ReviewPostRequest request = ReviewPostRequest.builder()
                .lecName("소프트웨어공학")
                .postTitle("훌륭한 강의입니다.")
                .postContent("훌륭한 강의에요.")
                .userNumber(20191585L)
                .build();

        reviewService.addReviewPost(request);
        // 예상 예외 지점
        reviewService.addReviewPost(request);
    }


    // 존재하지 않는 강의 예외를 터트리는 테스트

    // 존재하지 않는 학생 예외를 터트리는 테스트


}
