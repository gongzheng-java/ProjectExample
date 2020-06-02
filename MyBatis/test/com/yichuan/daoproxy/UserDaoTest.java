
package com.yichuan.daoproxy;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yichuan.dao.UserDao;
import com.yichuan.entity.User;

/** 
  *UserDao 测试类
  * @Author  gz
  * @CreateDate  2017年10月11日 下午3:16:24 
  * @Description 该测试类是使用代理模式  只需要编写接口，不需要impl实现类，要保证对应的映射文件命名空间值、sqlID和接口全局限定名、接口方法一致
  */
public class UserDaoTest {
	
	private SqlSessionFactory sessionFactory;

	// 此方法在执行测试方法之前执行
	@Before
	public void setUp() throws Exception {

		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		sessionFactory = sFactoryBuilder.build(reader);

	}

	//查询所有用户信息
	@Test
	public void findListTest() {
		SqlSession session = sessionFactory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		List<User> users = userDao.findList();
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}

}
