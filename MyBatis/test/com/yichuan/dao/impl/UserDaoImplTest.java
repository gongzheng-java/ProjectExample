package com.yichuan.dao.impl;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import org.junit.Test;

import com.yichuan.dao.UserDao;
import com.yichuan.entity.User;

/**
 * 测试类
 * 该测试类是测试使用原始的dao开发方法
 * 需要编写dao接口和daoimpl实现类
 * @author gz
 *
 */
public class UserDaoImplTest {
	
	private SqlSessionFactory sessionFactory;

	//此方法在执行测试方法之前执行
	@Before
	public void setUp() throws Exception{
		
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder =new SqlSessionFactoryBuilder();
		sessionFactory = sFactoryBuilder.build(reader);
		
	}

	@Test
	public void testFindUser() {
		UserDao uDao = new UserDaoImpl(sessionFactory);
		List<User> users = uDao.findList();
		for (User user : users) {
			System.out.println(user);
		}
	}

	
	@Test
	public void updateUser(){
		UserDao uDao = new UserDaoImpl(sessionFactory);
		User user = new User();
		user.setId(4);
		user.setUserName("李元芳");
		int count = uDao.updateUser(user);
		if (count != 0) {
			System.out.println("修改成功！！！！！");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
