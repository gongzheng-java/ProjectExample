
package com.yichuan.daoproxy;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yichuan.entity.User;

/** 
  *该测试类是为使用代理模式开锁定义的
  *注意原生dao接口开发和daio接口代理模式开的本质不同，留心原生dao接口的实现类impl和spring配置
  * @Author  gz
  * @CreateDate  2017年10月13日 上午11:09:53 
  * @Description  
  */
public class UserDaoProxyTest {

	private ApplicationContext applicationContext;

	/**
	 * 使用该方法构建spring容器
	 * 该方法在其他方法执行之前执行
	 */
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	
	@Test
	public void testFindList() {
		//getBean("UserDaoProxy")中的UserDaoProxy是spring配置文件中没有使用扫描器，是配置单个接口的bean的id，测试该方法需要取消对应的注释
		UserDao userDao = (UserDao) applicationContext.getBean("UserDaoProxy");
		List<User> users = userDao.findList();
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testFindUser() {
		//此处的getBean("userDao")中的userDao的根据扫面器扫描接口的包名后根据包里面对应的接口名自动生成的，首字母一定要小写！！！
		UserDao userDao =  (UserDao) applicationContext.getBean("userDao");
		User user = userDao.findUser(8);
		System.out.println(user);
	}

	@Test
	public void testFindName() {
		//此处的getBean("userDao")中的userDao的根据扫面器扫描接口的包名后根据包里面对应的接口名自动生成的，首字母一定要小写！！！
		UserDao userDao =  (UserDao) applicationContext.getBean("userDao");
		List<User> users = userDao.findName("%张%");
		
	}

	@Test
	public void testSaveUser() {
		
	}

	@Test
	public void testUpdateUser() {
		
	}

	@Test
	public void testDeleteUser() {
		
	}

}
