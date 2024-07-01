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
@Table(name = "ClassList")
public class ClassList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classNumber;


    @Column(columnDefinition = "TEXT", nullable = true, length = 255, unique = false)
    private String classIntroduction;

    @Column(nullable = true, length = 45, unique = false)
    private Long averageStarLating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecId")
    private Lecture lecture;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professorId")
    private Professor professor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imageNumber", unique = false)
    private ImageUrl captainImage;

    public void updateAverageStarLating(){
        this.averageStarLating = averageStarLating;
    }


}
