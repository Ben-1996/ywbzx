package com.fc.v2.mapper.kcgl;

import com.fc.v2.model.kcgl.Course;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {

    List<Course> select(Course record);

    Course selectById(Course record);

    int deleteById(Integer id);

    int insert(Course record);

    int updateById(@Param("record") Course record);

}