package com.fc.v2.course.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:53
 */
public class WbCourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private Date addTime;
	//
	private Date updateTime;
	//
	private String status;
	//
	private Integer courseId;
	//
	private Integer teacherId;
	//
	private String title;
	//
	private String info;
	//
	private String videourl;
	//
	private String imgurl;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：
	 */
	public Date getAddTime() {
		return addTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：
	 */
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * 获取：
	 */
	public Integer getTeacherId() {
		return teacherId;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * 获取：
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * 设置：
	 */
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	/**
	 * 获取：
	 */
	public String getVideourl() {
		return videourl;
	}
	/**
	 * 设置：
	 */
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	/**
	 * 获取：
	 */
	public String getImgurl() {
		return imgurl;
	}
}
