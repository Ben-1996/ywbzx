 package com.fc.v2.controller.kcgl;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.model.kcgl.CoursePart;
import com.fc.v2.service.kcgl.CoursePartService;
import com.fc.v2.service.kcgl.CourseService;
import com.fc.v2.shiro.util.ShiroUtils;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

 /**
  * 公告Controller
  * @ClassName: SysNoticeController
  * @author fuce
  * @date 2019-11-20 22:31
  */
 @Api(value = "课程管理")
 @Controller
 @RequestMapping("/KcglController")
 public class KcglController extends BaseController{

     private final String prefix = "kcgl";
     @Autowired
     private CoursePartService coursePartService;
     @Autowired
     private CourseService courseService;

     @ApiOperation(value = "分页跳转", notes = "分页跳转")
     @GetMapping("/view")
     /*@RequiresPermissions("gen:sysNotice:view")*/
     public String view(ModelMap model)
     {
         return prefix + "/list";
     }

     //@Log(title = "公告集合查询", action = "111")
     @ApiOperation(value = "分页查询", notes = "分页查询")
     @GetMapping("/list")
     //@RequiresPermissions("gen:sysNotice:list")
     @ResponseBody
     public ResultTable list(Tablepar tablepar, CoursePart coursePart){
         PageInfo<CoursePart> page=coursePartService.list(tablepar,coursePart) ;
         return pageTable(page.getList(),page.getTotal());
     }

     /**
      * 新增跳转
      * @param modelMap
      * @return
      */
     @ApiOperation(value = "新增跳转", notes = "新增跳转")
     @GetMapping("/coursePartAdd")
     public String add(ModelMap modelMap)
     {
         return prefix + "/add";
     }
     /**
      * 新增保存
      * @param sysNotice
      * @return
      * @author fuce
      * @Date 2019年11月11日 下午4:07:09
      */
     //@Log(title = "公告新增", action = "111")
     @ApiOperation(value = "新增", notes = "新增")
     @PostMapping("/coursePartAdd")
     @RequiresPermissions("gen:sysNotice:add")
     @ResponseBody
     public AjaxResult add(CoursePart coursePart){
         int b=coursePartService.add(coursePart);
         if(b>0){
             return success();
         }else{
             return error();
         }
     }

     /**
      * 删除
      * @param ids
      * @return
      **/
     //@Log(title = "公告删除", action = "111")
     @ApiOperation(value = "删除", notes = "删除")
     @DeleteMapping("/coursePartRemove")
     @RequiresPermissions("gen:sysNotice:remove")
     @ResponseBody
     public AjaxResult remove(CoursePart coursePart){
         int b=coursePartService.del(coursePart);
         if(b>0){
             return success();
         }else{
             return error();
         }
     }

     /**
      * 修改跳转
      * @param id
      * @param mmap
      * @return
      */
     @ApiOperation(value = "修改跳转", notes = "修改跳转")
     @GetMapping("/coursePartEdit/{id}")
     public String edit(@PathVariable("id") String id, ModelMap mmap)
     {
         mmap.put("SysNotice", sysNoticeService.selectByPrimaryKey(id));

         return prefix + "/edit";
     }

     /**
      * 修改保存
      */
     //@Log(title = "公告修改", action = "111")
     @ApiOperation(value = "修改保存", notes = "修改保存")
     @RequiresPermissions("gen:sysNotice:edit")
     @PostMapping("/coursePartEdit")
     @ResponseBody
     public AjaxResult editSave(CoursePart coursePart)
     {
         return toAjax(coursePartService.update(coursePart));
     }





 }
