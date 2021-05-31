package com.fc.v2.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.v2.course.dao.WbTeacherDao;
import com.fc.v2.course.domain.WbTeacherDO;
import com.fc.v2.course.service.WbTeacherService;



@Service
public class WbTeacherServiceImpl implements WbTeacherService {
	@Autowired
	private WbTeacherDao wbTeacherDao;
	
	@Override
	public WbTeacherDO get(Integer id){
		return wbTeacherDao.get(id);
	}
	
	@Override
	public List<WbTeacherDO> list(Map<String, Object> map){
		return wbTeacherDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wbTeacherDao.count(map);
	}
	
	@Override
	public int save(WbTeacherDO wbTeacher){
		return wbTeacherDao.save(wbTeacher);
	}
	
	@Override
	public int update(WbTeacherDO wbTeacher){
		return wbTeacherDao.update(wbTeacher);
	}
	
	@Override
	public int remove(Integer id){
		return wbTeacherDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wbTeacherDao.batchRemove(ids);
	}
	
}
