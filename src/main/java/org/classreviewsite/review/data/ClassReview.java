package org.classreviewsite.review.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.classreviewsite.auth.util.BaseTimeEntity;
import org.classreviewsite.lecture.data.Lecture;
import org.classreviewsite.user.data.User;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "ClassReview", uniqueConstraints = @UniqueConstraint(columnNames = {"lecId", "userNumber"}))
public class ClassReview extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecId", nullable = false, unique = false)
    private Lecture lecId;

    @Column(nullable = false, length = 45, unique = false)
    private String postTitle;

    @Column(nullable = false, unique = false)
    private Long starLating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNumber" , nullable = false, unique = false)
    private User userNumber;

    @Column(nullable = false, length = 255, unique = false)
    private String postContent;

    @Column(nullable = false, length = 45, unique = false)
    private Integer likes;



    /**
     * 좋아요
     */
    public void like(){
        this.likes += 1;
    }

    /**
     * 좋아요 취소
     *
     */
    public void cancelLike(){
        this.likes -= 1;
    }

    /**
     * 글 수정
     */
    public void updatePost(String postTitle, String postContent){
        this.postTitle = postTitle;
        this.postContent = postContent;
    }



}
