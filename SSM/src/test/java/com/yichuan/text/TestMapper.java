package com.yichuan.text;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yichuan.dao.EmpDao;
import com.yichuan.entity.Emp;
/**
 * 测试mybatis配置是否能成功操作数据库数据
 * 
 * @author gongZheng
 * @Date 2017年8月15日下午2:16:31
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMapper {

	// private static Logger logger = Logger.getLogger(TestMapper.class);

	@Resource
	private EmpDao empDao;

	// 查询单个带有部门信息的员工
	@Test
	public void queryEmpWithDept() {
		Emp emp = empDao.queryWithDept(2);
		System.out.println(emp.getDept().getDname());
	}

	// 查询员工人数
	@Test
	public void countEmp() {
		int num = empDao.countEmp("张三");
		System.out.println("查询的人数是："+num);
	}
	
	// 查询员工人数
		@Test
		public void queryEmp() {
			Emp emp = empDao.queryEmp(5);
			System.out.println(emp.getEmail());
		}
	
	// 查询单个带有部门信息的员工
	@Test
	public void queryEmpWithDepts() {
		List<Emp> emp = empDao.queryEmpWithDept();
		for (Emp emp2 : emp) {
			System.out.println(emp2.getName() + "\t" + emp2.getDept().getDname());
		}
	}
	
	

	// 批量新增员工信息
	@Test
	public void addEmpList() {
		List<Emp> emps = new ArrayList<Emp>();
		Emp emp = null;
		// logger.info("开始创建对象");
		for (int i = 0; i < 100; i++) {
			emp = new Emp("张三04", 18, "87961111@163.com", 1005);
			emps.add(emp);
		}
		// logger.info("执行新增addemps方法");
		int num = empDao.addEmps(emps);
		System.out.println(num);
		System.out.println("新增成功！！！");
	}
	
	

}
