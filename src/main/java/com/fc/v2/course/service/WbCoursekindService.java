package com.fc.v2.course.service;

import com.fc.v2.course.domain.WbCoursekindDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:54
 */
public interface WbCoursekindService {
	
	WbCoursekindDO get(Integer id);
	
	List<WbCoursekindDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WbCoursekindDO wbCoursekind);
	
	int update(WbCoursekindDO wbCoursekind);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
