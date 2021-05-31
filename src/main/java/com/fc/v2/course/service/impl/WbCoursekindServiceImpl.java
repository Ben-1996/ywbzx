package com.fc.v2.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.v2.course.dao.WbCoursekindDao;
import com.fc.v2.course.domain.WbCoursekindDO;
import com.fc.v2.course.service.WbCoursekindService;



@Service
public class WbCoursekindServiceImpl implements WbCoursekindService {
	@Autowired
	private WbCoursekindDao wbCoursekindDao;
	
	@Override
	public WbCoursekindDO get(Integer id){
		return wbCoursekindDao.get(id);
	}
	
	@Override
	public List<WbCoursekindDO> list(Map<String, Object> map){
		return wbCoursekindDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wbCoursekindDao.count(map);
	}
	
	@Override
	public int save(WbCoursekindDO wbCoursekind){
		return wbCoursekindDao.save(wbCoursekind);
	}
	
	@Override
	public int update(WbCoursekindDO wbCoursekind){
		return wbCoursekindDao.update(wbCoursekind);
	}
	
	@Override
	public int remove(Integer id){
		return wbCoursekindDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wbCoursekindDao.batchRemove(ids);
	}
	
}
