package org.classreviewsite.review.service;

import lombok.RequiredArgsConstructor;
import org.classreviewsite.auth.exception.AlreadyLikeException;
import org.classreviewsite.auth.exception.AlreadyWritePostException;
import org.classreviewsite.auth.exception.ReviewNotFoundException;
import org.classreviewsite.auth.exception.UserNotFoundException;
import org.classreviewsite.data.Lecture;
import org.classreviewsite.data.LikesPostUserRelationShip;
import org.classreviewsite.data.ReviewPost;
import org.classreviewsite.data.User;
import org.classreviewsite.lecture.service.LectureService;
import org.classreviewsite.review.dto.LikeRequest;
import org.classreviewsite.review.dto.ReviewPostRequest;
import org.classreviewsite.review.dto.UpdatePostRequest;
import org.classreviewsite.review.infrastructure.LikesDataRepository;
import org.classreviewsite.review.infrastructure.ReviewPostDataRepository;
import org.classreviewsite.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewPostDataRepository reviewPostDataRepository;

    private final LikesDataRepository likesDataRepository;

    private final LectureService lectureService;

    private final UserService userService;

    @Transactional(readOnly = true)
    public List<ReviewPost> findAll(){

        return reviewPostDataRepository.findAll();

    }

    @Transactional
    public void addReviewPost(ReviewPostRequest request){

        Lecture foundLecture = lectureService.findBylectureName(request.getLecName());

        User foundUser = userService.findById(request.getUserNumber()).orElseThrow(() -> new UserNotFoundException("존재하지 않는 학생입니다."));

        ReviewPost reviewPost = ReviewPost.builder()
                .lecId(foundLecture)
                .userNumber(foundUser)
                .starLating(request.getStarLating())
                .likes(0)
                .postTitle(request.getPostTitle())
                .postContent(request.getPostContent())
                .build();

        validateAddReviewPost(foundUser, foundLecture);

        reviewPostDataRepository.save(reviewPost);

    }


    @Transactional(readOnly = true)
    public void validateAddReviewPost(User user, Lecture lecture){

       reviewPostDataRepository.findByUserNumberAndLecId(user, lecture)
               .ifPresent(m -> {
                   throw new AlreadyWritePostException("이미 작성한 강의입니다.");
               });
    }

    @Transactional
    public void updateReviewPost(UpdatePostRequest request){
        ReviewPost post = new ReviewPost();
        post.updatePost(request.getPostTitle(), request.getPostContent());

    }

    @Transactional
    public void deleteReviewPost(Long postId){
        ReviewPost deletedReviewPost = reviewPostDataRepository.findById(postId).orElseThrow(() -> new NullPointerException("해당 강의가 존재하지 않습니다."));

        reviewPostDataRepository.deleteById(postId);

        likesDataRepository.deleteAllByReviewPost(deletedReviewPost);

    }

    @Transactional
    public void addLikeReviewPost(LikeRequest request){
        // userNumber , reviewId
        User user = userService.findById(request.getUserNumber()).orElseThrow(() -> new UserNotFoundException("해당 학생이 존재하지 않습니다."));

        ReviewPost reviewPost = reviewPostDataRepository.findById(request.getReviewId()).orElseThrow(() -> new NullPointerException("해당 수강후기가 존재하지 않습니다."));

        // 좋아요 중복 검사
        validateLikeReviewPost(user, reviewPost);

        ReviewPost likedPost = new ReviewPost();

        likedPost.like();
        LikesPostUserRelationShip likeUser = LikesPostUserRelationShip.builder()
                .reviewPost(reviewPost)
                .user(user)
                .build();

        likesDataRepository.save(likeUser);

    }

    @Transactional(readOnly = true)
    public void validateLikeReviewPost(User user , ReviewPost reviewPost){
        likesDataRepository.findByUserAndReviewPost(user, reviewPost)
                .ifPresent(m -> {
                    cancelLikeReviewPost(user, reviewPost);
                }
                );
    }


    @Transactional
    public void cancelLikeReviewPost(User user , ReviewPost reviewPost){
        reviewPost.cancelLike();
        likesDataRepository.deleteByReviewPostAndUser(reviewPost, user);

    }


    @Transactional(readOnly = true)
    public List<ReviewPost> findByLecIdOrderByLikes(Long lecId){
        return reviewPostDataRepository.findByLecIdOrderByLikes(lecId);
    }


    @Transactional(readOnly = true)
    public List<ReviewPost> findMyReview(Long userNumber){
        return reviewPostDataRepository.findByUserNumber(userNumber);
    }


//    @Transactional(readOnly = true)
//    public List<ReviewPost> findByPostDetail(){
//
//    }

    // classList의 평균 평점 갱신
    @Transactional
    public void updateAverageLating(){



    }

}
