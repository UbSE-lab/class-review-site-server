package org.classreviewsite.classlist.service;

import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.classreviewsite.classlist.infrastructure.ClassListDataRepository;
import org.classreviewsite.data.ClassList;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClassListService {


    private final ClassListDataRepository classListDataRepository;

    @Transactional(readOnly = true)
    public ClassList findById(Long id){
        return classListDataRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 클래스가 존재하지 않습니다."));
    }

}
