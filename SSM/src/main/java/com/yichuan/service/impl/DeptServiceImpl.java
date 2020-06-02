package com.yichuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yichuan.dao.DeptDao;
import com.yichuan.entity.Dept;

/**
 * DeptServiceImpl
 * @author gongZheng
 * @Date 2017年9月12日上午11:53:34
 * @version 1.0
 */
@Service
public class DeptServiceImpl  {
	
	@Autowired
	private DeptDao deptDao;

	public List<Dept> queryDept() {
		
		return deptDao.queryDept();
	}

}
