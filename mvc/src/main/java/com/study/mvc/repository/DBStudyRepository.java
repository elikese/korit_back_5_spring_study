package com.study.mvc.repository;

import com.study.mvc.entity.Study;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DBStudyRepository{
    int save(Study study);
    Study findStudyById(int id);

    // name이 db에서 unique 값으로 설정되어있어서 가능
    Study findStudyByName(String name);
    List<Study> findStudyAll();

    int deleteById(int id);
    int pubById(Study study);
    int patchById(Study study);
}