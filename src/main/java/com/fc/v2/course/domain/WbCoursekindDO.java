package com.fc.v2.course.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author whw
 * @email 1992lcg@163.com
 * @date 2021-06-01 01:02:54
 */
public class WbCoursekindDO implements Serializable {
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
	private String name;
	//
	private Integer parentId;
	//
	private String kindname;

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
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：
	 */
	public Integer getParentId() {
		return parentId;
	}
	/**
	 * 设置：
	 */
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	/**
	 * 获取：
	 */
	public String getKindname() {
		return kindname;
	}
}
