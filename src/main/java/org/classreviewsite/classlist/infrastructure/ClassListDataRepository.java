package org.classreviewsite.classlist.infrastructure;

import org.classreviewsite.data.ClassList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassListDataRepository extends JpaRepository<ClassList, Long> {
}
