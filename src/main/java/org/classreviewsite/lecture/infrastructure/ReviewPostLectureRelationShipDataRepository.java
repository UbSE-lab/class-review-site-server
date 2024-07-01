package org.classreviewsite.lecture.infrastructure;

import org.classreviewsite.data.ReviewPostLectureRelationShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewPostLectureRelationShipDataRepository extends JpaRepository<ReviewPostLectureRelationShip, Long> {
}
