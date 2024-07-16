package org.classreviewsite.classlist.service;

import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.classreviewsite.auth.exception.LectureNotFoundException;
import org.classreviewsite.classlist.dto.response.ClassListWithProfessorName;
import org.classreviewsite.classlist.infrastructure.ClassListDataRepository;
import org.classreviewsite.data.ClassList;
import org.classreviewsite.data.Lecture;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassListService {


    private final ClassListDataRepository classListDataRepository;

    @Transactional(readOnly = true)
    public ClassList findById(Long id){
        return classListDataRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 클래스가 존재하지 않습니다."));
    }


    @Transactional(readOnly = true)
    public List<ClassListWithProfessorName> findByClassListWithProfessorName(){

        List<ClassList> list = classListDataRepository.findByClassListWithProfessorName();

        List<ClassListWithProfessorName> result = new ArrayList<>();

        for(int i=0; i< list.size();i++){

        result.add(
                ClassListWithProfessorName.builder()
                        .professor(list.get(i).getProfessor().getProfessorName())
                        .averageStarLating(list.get(i).getLecture().getAverageStarLating())
                        .lectureName(list.get(i).getLecture().getLectureName())
                        .department(list.get(i).getLecture().getDepartment())
                        .lectureType(list.get(i).getLecture().getLectureType())
                        .reviewCount(list.get(i).getLecture().getReviewCount())
                        .university(list.get(i).getLecture().getUniversity())
                        .lectureId(list.get(i).getLecture().getLectureId())
                        .totalStarLating(list.get(i).getLecture().getTotalStarLating())
                        .build()
        );
        }

        return result;
    }

    @Transactional(readOnly = true)
    public ClassListWithProfessorName.ClassListWithProfessorNameInDetail findByClassListWithProfessorNameInDetail(Long lectureId){
        ClassList classList = classListDataRepository.findByLectureIdWithProfessorName(lectureId).orElseThrow(() -> new LectureNotFoundException("해당 강의가 없습니다."));
        return ClassListWithProfessorName.ClassListWithProfessorNameInDetail.builder()
                .averageStarLating(classList.getLecture().getAverageStarLating())
                .professor(classList.getProfessor().getProfessorName())
                .lectureId(classList.getLecture().getLectureId())
                .lectureName(classList.getLecture().getLectureName())
                .lectureType(classList.getLecture().getLectureType())
                .department(classList.getLecture().getDepartment())
                .reviewCount(classList.getLecture().getReviewCount())
                .totalStarLating(classList.getLecture().getTotalStarLating())
                .university(classList.getLecture().getUniversity())
                .introduction(classList.getClassIntroduction())
                .imageUrl(classList.getCaptainImage().getImageUrl())
                .classNumber(classList.getClassNumber())
                .build();
    }





}
