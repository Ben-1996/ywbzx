package com.fc.v2.course.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.v2.course.domain.WbTeacherDO;
import com.fc.v2.course.service.WbTeacherService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:54
 */
 
@Controller
@RequestMapping("/course/wbTeacher")
public class WbTeacherController {
	@Autowired
	private WbTeacherService wbTeacherService;
	
	@GetMapping()
	@RequiresPermissions("course:wbTeacher:wbTeacher")
	String WbTeacher(){
	    return "course/wbTeacher/wbTeacher";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("course:wbTeacher:wbTeacher")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WbTeacherDO> wbTeacherList = wbTeacherService.list(query);
		int total = wbTeacherService.count(query);
		PageUtils pageUtils = new PageUtils(wbTeacherList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("course:wbTeacher:add")
	String add(){
	    return "course/wbTeacher/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("course:wbTeacher:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WbTeacherDO wbTeacher = wbTeacherService.get(id);
		model.addAttribute("wbTeacher", wbTeacher);
	    return "course/wbTeacher/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("course:wbTeacher:add")
	public R save( WbTeacherDO wbTeacher){
		if(wbTeacherService.save(wbTeacher)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("course:wbTeacher:edit")
	public R update( WbTeacherDO wbTeacher){
		wbTeacherService.update(wbTeacher);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("course:wbTeacher:remove")
	public R remove( Integer id){
		if(wbTeacherService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("course:wbTeacher:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wbTeacherService.batchRemove(ids);
		return R.ok();
	}
	
}
