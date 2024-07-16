package org.classreviewsite.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lectureId" , nullable = false)
    private Long lectureId;

    @Column(nullable = false, length = 45 , unique = false)
    private String lectureName;

    @Column(nullable = true, unique = false)
    private Long averageStarLating;

    @Column(nullable = true, unique = false)
    private Long totalStarLating;

    @Column(nullable = true, unique = false)
    private Long reviewCount;

    @Column(nullable = false, length = 45, unique = false)
    private String department;

    @Column(nullable = false, length = 45, unique = false)
    private String university;

    @Enumerated(EnumType.STRING)
    private LectureType lectureType;


    public void updateAverageStarLating(Long updateLating){
        this.averageStarLating = updateLating;
    }

    public void updateTotalStarLating(Long plusLating){
        this.totalStarLating = totalStarLating + plusLating;
    }

    public void updateReviewCount(){
        this.reviewCount = reviewCount+1;
    }

    public void cancelTotalStarLating(Long minusLating){
        this.totalStarLating = totalStarLating - minusLating;
    }

    public void cancelReviewCount(){
        this.reviewCount = reviewCount - 1;
    }


}
