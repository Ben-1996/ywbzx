package com.fc.v2.service.kcgl;

import com.fc.v2.mapper.kcgl.CourseMapper;
import com.fc.v2.mapper.kcgl.CoursePartMapper;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.model.kcgl.Course;
import com.fc.v2.model.kcgl.CoursePart;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CourseService {
	@Resource
	private CourseMapper courseMapper;

	/*
	* 章节查询列表
	* */
	 public PageInfo<Course> list(Tablepar tablepar, Course course){
		PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
		List<Course> list= courseMapper.select(course);
		PageInfo<Course> pageInfo = new PageInfo<Course>(list);
		return  pageInfo;
	 }

	public int add(Course record) {
		return courseMapper.insert(record);
	}
	public int update(Course recode){
		return courseMapper.updateById(recode);
	}
	public int del(Course record){
		return courseMapper.deleteById(record.getId());
	}
	public Course selectById(Course record){
		return courseMapper.selectById(record);
	}


}
