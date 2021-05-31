package com.fc.v2.service.kcgl;

import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.SysNoticeMapper;
import com.fc.v2.mapper.auto.SysNoticeUserMapper;
import com.fc.v2.mapper.kcgl.CoursePartMapper;
import com.fc.v2.model.auto.*;
import com.fc.v2.model.auto.SysNoticeUserExample.Criteria;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.model.kcgl.CoursePart;
import com.fc.v2.service.auto.SysNoticeUserService;
import com.fc.v2.service.auto.SysUserService;
import com.fc.v2.shiro.util.ShiroUtils;
import com.fc.v2.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CoursePartService {
	@Resource
	private CoursePartMapper coursePartMapper;

	/*
	* 章节查询列表
	* */
	 public PageInfo<CoursePart> list(Tablepar tablepar, CoursePart coursePart){
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<CoursePart> list= coursePartMapper.select(coursePart);
		PageInfo<CoursePart> pageInfo = new PageInfo<CoursePart>(list);
		return  pageInfo;
	 }

	public int add(CoursePart record) {
		return coursePartMapper.insert(record);
	}
	public int update(CoursePart recode){
		return coursePartMapper.updateById(recode);
	}
	public int del(CoursePart record){
		return coursePartMapper.deleteById(record.getId());
	}
	public CoursePart selectById(CoursePart record){
		return coursePartMapper.selectById(record);
	}


}
