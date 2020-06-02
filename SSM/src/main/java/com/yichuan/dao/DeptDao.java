package com.yichuan.dao;

import java.util.List;

import com.yichuan.entity.Dept;

/**
 * DETP dao接口
 * @author gongZheng
 * @Date 2017年9月12日上午11:45:01
 * @version 1.0
 */
public interface DeptDao {
	
	/**
	 * 获取所有部门信息 
	 * @return list集合数据
	 */
	public List<Dept> queryDept();
	
	

}
