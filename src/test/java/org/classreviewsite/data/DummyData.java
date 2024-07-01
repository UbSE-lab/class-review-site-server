package org.classreviewsite.data;

import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.classreviewsite.lecture.infrastructure.ImageUrlDataRepository;
import org.classreviewsite.lecture.infrastructure.LectureDataRepository;
import org.classreviewsite.lecture.infrastructure.ProfessorDataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class DummyData {

    @Autowired
    LectureDataRepository lectureDataRepository;

    @Autowired
    ImageUrlDataRepository imageUrlDataRepository;

    @Autowired
    ProfessorDataRepository professorDataRepository;

    @Test
    void imageUrlInput(){
        ImageUrl imageUrl = ImageUrl.builder()
                .imageName("익명")
                .imageUrl("https://cdn.aitimes.com/news/photo/201904/47568_2031_1732.jpg")
                .build();

        imageUrlDataRepository.save(imageUrl);
    }


    @Test
    void lectureInput(){

        List<String> lecListName = new ArrayList<>(List.of("소프트웨어공학", "데이터베이스 개론", "운영체제"));
        List<LectureType> lecListType = new ArrayList<>(List.of(LectureType.전공선택, LectureType.전공선택, LectureType.전공선택));
        List<String> lecListDepartment = new ArrayList<>(List.of("소프트웨어학과", "소프트웨어학과", "소프트웨어학과"));

        for(int i=0; i< lecListName.size(); i++){
            Lecture lecture = Lecture.builder()
                    .lectureName(lecListName.get(i))
                    .lectureType(lecListType.get(i))
                    .department(lecListDepartment.get(i))
                    .build();

            lectureDataRepository.save(lecture);
        }

    }

    @Test
    void professorInput(){
        List<String> professorNameList = new ArrayList<>(List.of("문미경", "조대수", "박준석"));
        List<String> departmentList = new ArrayList<>(List.of("소프트웨어학과", "소프트웨어학과", "소프트웨어학과"));

        for(int i=0; i< professorNameList.size();i++){

        Professor professor = Professor.builder()
                .professorName(professorNameList.get(i))
                .department(departmentList.get(i))
                .build();

        professorDataRepository.save(professor);
        }

    }

    @Test
    void classListInput(){

        ImageUrl imageUrl = imageUrlDataRepository.findById(0L).get();
        Lecture lecture = lectureDataRepository.findByLectureName("소프트웨어공학").get();
        Professor professor = professorDataRepository.findById(1L).get();

        ClassList classList = ClassList.builder()
                .averageStarLating(0L)
                .captainImage(imageUrl)
                .classIntroduction("소프트웨어 공학(-工學, 영어: software engineering)은 소프트웨어의 개발, 운용, 유지보수 등의 생명 주기 전반을 체계적이고 서술적이며 정량적으로 다루는 학문이다; 즉, 공학을 소프트웨어에 적용하는 것이다.")
                .lecture(lecture)
                .professor(professor)
                .build();

        /**
         * 내일의 강민이를 위해서 작성한 편지
         *
         * classList 쪽 다시 한번더 구성하고 post 작성할때는 lecture 참고하는데
         * classList 활용하는 부분이 어디인지 체크해보고
         * classList 더미데이터 어떻게 지정할지 한번더 체크해보자
         *
         * ReviewService에서 classList의 평균 평점 갱신 작성하다가 말았음
         * 수강후기 상세페이지 조회쪽 작성하다가 말았음
         *
         */

    }




    @Test
    @Transactional(readOnly = true)
    void findDistinctDepartmentInLectureTest(){

        List<String> departmentList =  lectureDataRepository.findDistinctDepartment();

        Assertions.assertNotNull(departmentList.get(0));

    }


}
