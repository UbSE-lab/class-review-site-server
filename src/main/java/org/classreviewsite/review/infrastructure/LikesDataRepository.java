package org.classreviewsite.review.infrastructure;

import org.classreviewsite.data.LikesPostUserRelationShip;
import org.classreviewsite.data.ReviewPost;
import org.classreviewsite.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikesDataRepository extends JpaRepository<LikesPostUserRelationShip, Long> {

    void deleteAllByReviewPost(ReviewPost reviewPost);

    Optional<LikesPostUserRelationShip> findByUserAndReviewPost(User user ,ReviewPost reviewPost);

    void deleteByReviewPostAndUser(ReviewPost reviewPost , User user);


}
