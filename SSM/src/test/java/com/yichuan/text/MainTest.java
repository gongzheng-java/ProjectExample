package com.yichuan.text;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yichuan.dao.EmpDao;
import com.yichuan.entity.Emp;


/**
 * 
 * @autho gongzheng
 * @time 2019年3月3日 下午2:38:31
 * @Description 运行该类测试时，需要提前开启/SSM/src/main/resources/spring-mybatis.xml中的最后一个注释
 */
public class MainTest {
	public static void main(String[] args) {
		
		ApplicationContext aContext=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		EmpDao eDao=(EmpDao) aContext.getBean("EmpDao");
		List<Emp> emps=new ArrayList<Emp>();
		Emp emp=null;
		for (int i = 0; i <100; i++) {
			String uuid=UUID.randomUUID().toString().substring(0,2)+i;
			System.out.println(uuid);
			emp=new Emp("张三01", 22, uuid+"@163.com", 1001);
			emps.add(emp);
		}
		int num=eDao.addEmps(emps);
		System.out.println(num);
		System.out.println("新增成功！！！");
		
		/*Emp emp=eDao.queryEmp(1);
		System.out.println(emp.getName());
*/	}

}
