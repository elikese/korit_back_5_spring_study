package com.study.mvc.service;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.dto.DBStudyInsertRespDto;
import com.study.mvc.dto.DBStudySelectRespDto;
import com.study.mvc.entity.Study;
import com.study.mvc.repository.DBStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBStudyService {
    @Autowired
    private DBStudyRepository dbStudyRepository;
    public DBStudyInsertRespDto crateStudy(DBStudyReqDto reqDto) {

        if(dbStudyRepository.findStudyByName(reqDto.getName()) != null) {
            return DBStudyInsertRespDto.builder()
                    .successStatus(false)
                    .build();
        }

        Study study = Study.builder()
                .name(reqDto.getName())
                .age(reqDto.getAge())
                .build();

        int successCount = dbStudyRepository.save(study);

        return DBStudyInsertRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successCount(successCount)
                .successStatus(successCount > 0)
                .build();
    }

    public DBStudySelectRespDto findStudyById(int id) {
        Study study = dbStudyRepository.findStudyById(id);
        System.out.println(study);
        return study == null ? null : study.toDto();
    }

    public DBStudySelectRespDto findStudyByName(String name) {
        Study study = dbStudyRepository.findStudyByName(name);
        System.out.println(study);
        return study == null ? null : study.toDto();
    }

    public List<DBStudySelectRespDto> findStudyAll() {
        return dbStudyRepository.findStudyAll()
                .stream()
                .map(Study::toDto)
                .collect(Collectors.toList());
    }

    public int deleteStudyById(int id) {
        return dbStudyRepository.deleteById(id);
    }

    public int putById(int id, DBStudyReqDto reqDto) {
        return dbStudyRepository.putById(reqDto.toEntity(id));
    }

    public int patchById(int id, DBStudyReqDto reqDto) {
        return dbStudyRepository.patchById((reqDto.toEntity(id)));
    }

}