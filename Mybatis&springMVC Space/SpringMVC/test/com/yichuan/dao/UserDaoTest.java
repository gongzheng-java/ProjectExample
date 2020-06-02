
package com.yichuan.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yichuan.entity.User;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月19日 下午2:21:56 
  * @Description  
  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class UserDaoTest {
	
	private static Logger logger= Logger.getLogger(UserDaoTest.class);
	
	//注意该类使用两种测试方法，一种的使用注解，另一种的使用原始的方法创建spring容器（被注释的部分）
	
	@Resource
	private UserDao userDao;
	
	//private ApplicationContext applicationContext;

	/**
	 * 使用该方法构建spring容器
	 * 该方法在其他方法执行之前执行
	 */
	/*@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	}*/

	
	@Test
	public void testFindList() {
		logger.info("测试中文输出11！！！！！！！！！！！！！！！！！");
		//getBean("UserDaoProxy")中的UserDaoProxy是spring配置文件中没有使用扫描器，是配置单个接口的bean的id，测试该方法需要取消对应的注释
		//UserDao userDao = (UserDao) applicationContext.getBean("userDao");
		List<User> users = userDao.findUserList();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
