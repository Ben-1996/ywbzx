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

import com.fc.v2.course.domain.WbCourseDO;
import com.fc.v2.course.service.WbCourseService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 *
 *
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:53
 */

@Controller
@RequestMapping("/course/wbCourse")
public class WbCourseController {
	@Autowired
	private WbCourseService wbCourseService;

	@GetMapping()
	@RequiresPermissions("course:wbCourse:wbCourse")
	String WbCourse(){
	    return "course/wbCourse/wbCourse";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WbCourseDO> wbCourseList = wbCourseService.list(query);
		int total = wbCourseService.count(query);
		PageUtils pageUtils = new PageUtils(wbCourseList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("course:wbCourse:add")
	String add(){
	    return "course/wbCourse/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("course:wbCourse:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WbCourseDO wbCourse = wbCourseService.get(id);
		model.addAttribute("wbCourse", wbCourse);
	    return "course/wbCourse/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("course:wbCourse:add")
	public R save( WbCourseDO wbCourse){
		if(wbCourseService.save(wbCourse)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("course:wbCourse:edit")
	public R update( WbCourseDO wbCourse){
		wbCourseService.update(wbCourse);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("course:wbCourse:remove")
	public R remove( Integer id){
		if(wbCourseService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("course:wbCourse:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wbCourseService.batchRemove(ids);
		return R.ok();
	}

}
