package com.fc.v2.course.service;

import com.fc.v2.course.domain.WbTeacherDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:54
 */
public interface WbTeacherService {
	
	WbTeacherDO get(Integer id);
	
	List<WbTeacherDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WbTeacherDO wbTeacher);
	
	int update(WbTeacherDO wbTeacher);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
