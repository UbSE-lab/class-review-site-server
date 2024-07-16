package org.classreviewsite.lecture.service;

import lombok.RequiredArgsConstructor;
import org.classreviewsite.classlist.service.ClassListService;
import org.classreviewsite.data.Lecture;
import org.classreviewsite.auth.exception.LectureNotFoundException;
import org.classreviewsite.lecture.infrastructure.LectureDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureDataRepository lectureDataRepository;

    private final ClassListService classListService;

    @Transactional(readOnly = true)
    public List<Lecture> findAll(){
        return lectureDataRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<String> findDistinctDepartment(){
        return lectureDataRepository.findDistinctDepartment();
    }




    @Transactional(readOnly = true)
    public Lecture findBylectureName(String lectureName){
        return lectureDataRepository.findByLectureName(lectureName).orElseThrow(() -> new LectureNotFoundException("존재하지 않는 강의입니다."));
    }


    // 인기도
    @Transactional(readOnly = true)
    public Long countByLectureName(String lectureName){
        Lecture lecture = lectureDataRepository.findByLectureName(lectureName).orElseThrow(() -> new LectureNotFoundException("존재하지 않는 강의입니다."));
        return lecture.getReviewCount();
    }



    @Transactional(readOnly = true)
    public Lecture findById(Long id){
        return lectureDataRepository.findById(id).orElseThrow(() -> new LectureNotFoundException("존재하지 않는 강의입니다."));
    }

    @Transactional(readOnly = true)
    public List<Lecture> findByUniversity(String university){
        List<Lecture> list = lectureDataRepository.findByUniversity(university);
        if(list.isEmpty()){
            throw new LectureNotFoundException("해당 대학의 강의가 존재하지 않습니다.");
        }
        return list;
    }

    @Transactional
    public void updateReviewCount(Lecture updateLecture){
        updateLecture.updateReviewCount();
    }

    @Transactional
    public void updateTotalStarLating(Lecture updateLecture, Long plusLating){
        updateLecture.updateTotalStarLating(plusLating);
    }

    @Transactional
    public void updateAverageStarLating(Lecture updateLecture){
//        Long updateAverageLating = updateLecture.getAverageStarLating()/updateLecture.getReviewCount();
        Lecture lecture = lectureDataRepository.findByLectureName(updateLecture.getLectureName()).orElseThrow(() -> new LectureNotFoundException("강의가 존재하지 않습니다."));
        Long updateAverageLating = lecture.getAverageStarLating()/lecture.getReviewCount();
        updateLecture.updateAverageStarLating(updateAverageLating);
    }

    @Transactional
    public void cancelTotalStarLating(Lecture updateLecture, Long minusLating){
        updateLecture.cancelTotalStarLating(minusLating);
    }

    @Transactional
    public void cancelReviewCount(Lecture updateLecture){
        updateLecture.cancelReviewCount();
    }

}
