package com.yichuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yichuan.dao.EmpDao;
import com.yichuan.entity.Emp;

/**
 * EmpServiceImpl
 * @author gongZheng
 * @Date 2017年8月15日上午11:24:03
 * @version 1.0
 */
@Service
public class EmpServiceImpl {
	
	@Autowired
	private EmpDao eDao;

	//分页查询员工信息
	public List<Emp> queryEmpWithDepts() {
		return eDao.queryEmpWithDept();
	}
	
	//根据id查询单个员工信息
	public Emp queryOneEmp(int id){
		return eDao.queryWithDept(id);
	}

	//新增员工信息
	public int saveEmp(Emp emp) {
		return eDao.saveEmp(emp);
	}

	//查询指定姓名的员工人数
	public boolean countEmp(String name) {
		int count = eDao.countEmp(name);
		return count == 0;
	}

	//查询单个员工信息
	public Emp queryEmp(int id) {
		// TODO Auto-generated method stub
		return eDao.queryEmp(id);
	}

	//修改员工信息
	public boolean updateEmp(Emp emp) {
		int result = eDao.updateEmp(emp);
		if (result > 0) {
			return true;
		}
		return false;
	}

}
