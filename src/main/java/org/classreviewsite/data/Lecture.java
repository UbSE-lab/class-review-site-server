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

    @Column(nullable = false, length = 45, unique = false)
    private String department;

    @Enumerated(EnumType.STRING)
    private LectureType lectureType;

}
