package org.classreviewsite.classlist.infrastructure;

import org.classreviewsite.data.ClassList;
import org.classreviewsite.data.Lecture;
import org.classreviewsite.data.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassListDataRepository extends JpaRepository<ClassList, Long> {


    @Query("select m from ClassList m join fetch m.lecture")
    List<ClassList> findByClassListWithProfessorName();



    @Query("select m from ClassList m join fetch m.lecture where m.lecture.lectureId = :lectureId")
    Optional<ClassList> findByLectureIdWithProfessorName(@Param("lectureId") Long lectureId);

}
