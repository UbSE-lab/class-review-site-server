package org.classreviewsite.review.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.classreviewsite.review.data.ClassReview;
import org.classreviewsite.user.data.User;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "Likes", uniqueConstraints = @UniqueConstraint(columnNames = {"reviewId", "userNumber"}))
public class Likes {

    // 좋아요를 한다
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;

    // 해당 수강 후기 글에
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewId", nullable = false, unique = false)
    private ClassReview classReview;

    // 해당 학생이
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNumber", nullable = false, unique = false)
    private User user;


}
