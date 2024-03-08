package com.study.mvc.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DBStudyRepository{
    public int save();
}
