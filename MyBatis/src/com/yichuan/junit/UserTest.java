package com.yichuan.junit;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yichuan.dao.UserDao;
import com.yichuan.entity.User;

/**
 * 
 *  注意：该测试类不要需要dao接口支持，只要在映射文件中写好sql就可以直接测试
 * @author gz
 *
 */
public class UserTest {

	// 根据id查询user信息
	@Test
	public void findID() throws IOException {
		// 读取配置文件
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		// 创建SqlSessionFactory会话工厂
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = sFactoryBuilder.build(reader);

		SqlSession session = sessionFactory.openSession();
		User user = session.selectOne("com.yichuan.dao.UserDao.findUser", 1);
		System.out.println("查询结果是：");
		System.out.println("User:" + user.getUserName() + "  " + user.getSex() + "  " + user.getBirthday() + "  "
				+ user.getAddress());
		System.out.println(user.toString());
	
		session.commit();
		// 释放资源
		if (session != null) {
			session.close();
		}

	}
 
	//根据用户名模糊查询
	@Test
	public void findName() throws IOException{
		//读取配置文件
		Reader reader =Resources.getResourceAsReader("mybatis-config.xml");
		//创建sqlsessionfactorybuilder工厂，用于生产sqlsessionfactory对象
		SqlSessionFactoryBuilder sFactoryBuilder=new SqlSessionFactoryBuilder();
		SqlSessionFactory sFactory = sFactoryBuilder.build(reader);
		//打开session
	     SqlSession session =	sFactory.openSession();
	     
	    List<User> list = session.selectList("com.yichuan.dao.UserDao.findName", "三");
	    User user = list.get(0);
		System.out.println("获取的数据是："+user);
		//释放资源
		session.close();
	}
	
	//查询所有user信息
	@Test
	public void findList() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sFactory = sFactoryBuilder.build(reader);
		SqlSession session = sFactory.openSession();
		List<User> users = session.selectList("com.yichuan.dao.UserDao.findList");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	//查询所有user信息
	@Test
	public void findList2() throws IOException{
		System.out.println("使用mapper代理的方法");
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sFactory = sFactoryBuilder.build(reader);
		SqlSession session = sFactory.openSession();
		UserDao uDao= session.getMapper(UserDao.class);
		List<User> users = uDao.findList();
		//List<User> users = session.selectList("com.yichuan.dao.UserDao.findList");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	
	//新增user
	@Test
	public void saveUser() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactory sFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=sFactory.openSession();//sqlsession是线程不安全的
		
		User user=new User();
		user.setAddress("浙江省杭州市萧山区民和路联合中心");
		user.setBirthday("2017-05-16");
		user.setSex("女");
		user.setUserName("李小明");
		int count = session.insert("com.yichuan.dao.UserDao.saveUser", user);
		if (count != 0) {
			System.out.println("新增成功！！！");
		}
		
		//提交
		session.commit();
		//获取自增主键值（注意映射文件中的配置）
		System.out.println("得到的主键值："+user.getId());
		//释放资源
		session.close();
		
	}

	// 删除用户
	@Test
	public void deleteUser() throws IOException {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sFactory = sFactoryBuilder.build(reader);
		SqlSession session = sFactory.openSession();
		int count = session.delete("com.yichuan.dao.UserDao.deleteUser", 8);
		if (count != 0) {
			System.out.println("删除成功！！！！");
		}
		session.commit();
		session.close();
	}
	
	    //更新user信息
		@Test
		public void updateUser() throws IOException {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
			SqlSessionFactory sFactory = sFactoryBuilder.build(reader);
			SqlSession session = sFactory.openSession();
			User user = new User();
			user.setId(9);
			user.setUserName("李晓明");
			user.setSex("女");
			int count = session.delete("com.yichuan.dao.UserDao.updateUser2", user);
			if (count != 0) {
				System.out.println("更新成功！！！！");
			}
			session.commit();
			session.close();
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
