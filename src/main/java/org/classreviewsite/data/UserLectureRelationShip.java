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
@Table(name = "UserLectureList")
public class UserLectureRelationShip {

    // 해당 학생이
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNumber")
    private User userNumber;

    // 강의를 들었다.
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecId")
    private Lecture lectureId;



}
