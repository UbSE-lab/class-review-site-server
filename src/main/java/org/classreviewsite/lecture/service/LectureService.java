package org.classreviewsite.lecture.service;

import lombok.RequiredArgsConstructor;
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


    @Transactional(readOnly = true)
    public List<String> findDistinctDepartment(){
        return lectureDataRepository.findDistinctDepartment();
    }



    @Transactional(readOnly = true)
    public Lecture findBylectureName(String lectureName){
        return lectureDataRepository.findByLectureName(lectureName).orElseThrow(() -> new LectureNotFoundException("존재하지 않는 강의입니다."));
    }



    @Transactional(readOnly = true)
    public Lecture findById(Long id){
        return lectureDataRepository.findById(id).orElseThrow(() -> new LectureNotFoundException("존재하지 않는 강의입니다."));
    }

}
