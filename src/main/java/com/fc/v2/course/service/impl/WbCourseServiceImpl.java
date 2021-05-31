package com.fc.v2.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.v2.course.dao.WbCourseDao;
import com.fc.v2.course.domain.WbCourseDO;
import com.fc.v2.course.service.WbCourseService;



@Service
public class WbCourseServiceImpl implements WbCourseService {
	@Autowired
	private WbCourseDao wbCourseDao;
	
	@Override
	public WbCourseDO get(Integer id){
		return wbCourseDao.get(id);
	}
	
	@Override
	public List<WbCourseDO> list(Map<String, Object> map){
		return wbCourseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wbCourseDao.count(map);
	}
	
	@Override
	public int save(WbCourseDO wbCourse){
		return wbCourseDao.save(wbCourse);
	}
	
	@Override
	public int update(WbCourseDO wbCourse){
		return wbCourseDao.update(wbCourse);
	}
	
	@Override
	public int remove(Integer id){
		return wbCourseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wbCourseDao.batchRemove(ids);
	}
	
}
