
package com.yichuan.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yichuan.entity.User;


/**
 * 该测试类是使用原生dao接口模式操作数据的，对应的接口和实现类在com.yichuan.dao包中
 * 注意原生dao接口开发和daio接口代理模式开的不同，留心原生dao接口的实现类impl和spring配置
 * @autho admin
 * @time 2017年10月12日 下午5:25:21
*/
public class UserDaoTest {
	
	private ApplicationContext applicationContext;

	/**
	 * 该方法在其他方法执行之前执行
	 * 使用该方法构建spring容器
	 */
	@Before
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	/**
	 * 查询所有user信息
	 */
	@Test
	public void testFindList() {
		UserDao userDao = (UserDao) applicationContext.getBean("UserDao");
		List<User> users = userDao.findList();
		for (User user : users) {
			System.out.println(user);
		}
		
	}

	/**
	 * Test method for {@link com.yichuan.dao.UserDao#findUser(int)}.
	 */
	@Test
	public void testFindUser() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.yichuan.dao.UserDao#findName(java.lang.String)}.
	 */
	@Test
	public void testFindName() {
		fail("Not yet implemented");
	}

	/**
	 *新增user信息
	 *测试 将impl类中释放资源部分注释掉后，能否自动提交数据，成功新增user信息
	 */
	@Test
	public void testSaveUser() {
	     UserDao userDao =  (UserDao) applicationContext.getBean("UserDao");
	     User user = new User();
	     user.setAddress("浙江省舟山市嵊泗县枸杞镇枸杞岛");
	     user.setBirthday("2017-02-12");
	     user.setSex("女");
	     user.setUserName("李丽丽");
	    int num = userDao.saveUser(user);
	    System.out.println("新增返回值："+num);
	    if (num >= 1) {
			System.out.println("新增成功！！！");
		}
	    System.out.println("获取的主键id："+user.getId());
	}

	/**
	 * Test method for {@link com.yichuan.dao.UserDao#updateUser(com.yichuan.entity.User)}.
	 */
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}

	/**
	 * 
	 */
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}

}
