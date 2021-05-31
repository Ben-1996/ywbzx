package com.fc.v2.mapper.kcgl;

import com.fc.v2.model.kcgl.CoursePart;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CoursePartMapper {

    List<CoursePart> select(@Param("record") CoursePart record);

    CoursePart selectById(@Param("record")CoursePart record);

    int deleteById(Integer id);

    int insert(CoursePart record);

    int updateById(@Param("record") CoursePart record);

}