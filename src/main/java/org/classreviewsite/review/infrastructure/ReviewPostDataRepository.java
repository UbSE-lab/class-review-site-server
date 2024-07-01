package org.classreviewsite.review.infrastructure;

import org.antlr.v4.runtime.atn.LexerCustomAction;
import org.classreviewsite.data.Lecture;
import org.classreviewsite.data.ReviewPost;
import org.classreviewsite.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewPostDataRepository extends JpaRepository<ReviewPost, Long> {


    Optional<ReviewPost> findByUserNumberAndLecId(User userNumber, Lecture lecId);

    List<ReviewPost> findByLecIdOrderByLikes(Long lecId);

    List<ReviewPost> findByUserNumber(Long userNumber);

}
