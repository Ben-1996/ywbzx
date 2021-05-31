package com.fc.v2.course.dao;

import com.fc.v2.course.domain.WbCourseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:53
 */
@Mapper
public interface WbCourseDao {

	WbCourseDO get(Integer id);
	
	List<WbCourseDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WbCourseDO wbCourse);
	
	int update(WbCourseDO wbCourse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
