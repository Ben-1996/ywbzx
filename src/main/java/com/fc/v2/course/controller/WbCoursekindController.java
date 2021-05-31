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

import com.fc.v2.course.domain.WbCoursekindDO;
import com.fc.v2.course.service.WbCoursekindService;
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
@RequestMapping("/course/wbCoursekind")
public class WbCoursekindController {
	@Autowired
	private WbCoursekindService wbCoursekindService;
	
	@GetMapping()
	@RequiresPermissions("course:wbCoursekind:wbCoursekind")
	String WbCoursekind(){
	    return "course/wbCoursekind/wbCoursekind";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("course:wbCoursekind:wbCoursekind")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WbCoursekindDO> wbCoursekindList = wbCoursekindService.list(query);
		int total = wbCoursekindService.count(query);
		PageUtils pageUtils = new PageUtils(wbCoursekindList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("course:wbCoursekind:add")
	String add(){
	    return "course/wbCoursekind/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("course:wbCoursekind:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		WbCoursekindDO wbCoursekind = wbCoursekindService.get(id);
		model.addAttribute("wbCoursekind", wbCoursekind);
	    return "course/wbCoursekind/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("course:wbCoursekind:add")
	public R save( WbCoursekindDO wbCoursekind){
		if(wbCoursekindService.save(wbCoursekind)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("course:wbCoursekind:edit")
	public R update( WbCoursekindDO wbCoursekind){
		wbCoursekindService.update(wbCoursekind);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("course:wbCoursekind:remove")
	public R remove( Integer id){
		if(wbCoursekindService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("course:wbCoursekind:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		wbCoursekindService.batchRemove(ids);
		return R.ok();
	}
	
}
