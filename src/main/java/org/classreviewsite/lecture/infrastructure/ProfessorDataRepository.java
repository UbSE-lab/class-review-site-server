package org.classreviewsite.lecture.infrastructure;

import org.classreviewsite.data.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorDataRepository extends JpaRepository<Professor, Long> {
}
