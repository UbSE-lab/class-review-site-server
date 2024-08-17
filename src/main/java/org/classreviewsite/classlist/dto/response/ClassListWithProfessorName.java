package org.classreviewsite.classlist.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.classreviewsite.classlist.data.ClassList;
import org.classreviewsite.classlist.dto.request.ClassListInfo;
import org.classreviewsite.lecture.data.LectureType;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ClassListWithProfessorName {


    private Long AverageStarLating;
    private String LectureName;
    private String department;
    private LectureType LectureType;
    private Long ReviewCount;
    private String university;
    private Long lectureId;
    private Long TotalStarLating;
    private String professorName;


    public static List<ClassListWithProfessorName> from(List<ClassList> classList){
        List<ClassListWithProfessorName> list = new ArrayList<>();
        for(ClassList Class : classList){
            list.add(ClassListWithProfessorName.builder()
                    .professorName(Class.getProfessor().getProfessorName())
                    .LectureName(Class.getLecture().getLectureName())
                    .LectureType(Class.getLecture().getLectureType())
                    .AverageStarLating(Class.getLecture().getAverageStarLating())
                    .department(Class.getLecture().getDepartment())
                    .lectureId(Class.getLecture().getLectureId())
                    .ReviewCount(Class.getLecture().getReviewCount())
                    .TotalStarLating(Class.getLecture().getTotalStarLating())
                    .university(Class.getLecture().getUniversity())
                    .build()
            );
        }

        return list;
    }


    @Data
    @AllArgsConstructor
    @Builder
    public static class ClassListWithProfessorNameInDetail{
        private Long lectureId;
        private String lectureName;
        private Long averageStarLating;
        private Long totalStarLating;
        private Long reviewCount;
        private String department;
        private String university;
        private LectureType lectureType;
        private String professor;
        private String introduction;
        private String imageUrl;
        private Long classNumber;
    }
}