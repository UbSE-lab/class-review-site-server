//package org.classreviewsite.data;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Getter
//@Entity
//@Table(name = "ReviewLectureList")
//public class ReviewPostLectureRelationShip {
//
//    // 해당 강의의
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long reviewId;
//
//    // 수강후기 글번호
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "postId")
//    private ReviewPost postId;
//
//
//
//}
