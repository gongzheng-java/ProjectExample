package com.yichuan.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yichuan.dao.UserDao;
import com.yichuan.entity.User;

public class UserDaoImpl implements UserDao{
	
	/**
	 * 注意，每个方法中都有重复代码如下：
	 * SqlSession session = sqlSessionFactory.openSession();
	 * 原因是SqlSession是线程不安全的，所有要在每个方法体内通定义局部变量来使用
	 */
	private SqlSessionFactory sqlSessionFactory;
	
	 public UserDaoImpl(SqlSessionFactory sessionFactory) {
		this.sqlSessionFactory=sessionFactory;
	}

	 private static final  String URL="com.yichuan.dao.UserDao.";
	 
	//查询所有user信息
	@Override
	public List<User> findList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<User>  users = session.selectList("com.yichuan.dao.UserDao.findList");
		session.close();
		return users;
	}

	//根据id查询user信息
	@Override
	public User findUser(int id) {
		SqlSession session=sqlSessionFactory.openSession();
		User user = session.selectOne("com.yichuan.dao.UserDao.findUser", 1);
		session.close();
		return user;
	}

	//根据用户名模糊查询user信息
	@Override
	public List<User> findName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList("com.yichuan.dao.UserDao.findName", "%"+name+"%");
		session.close();
		return users;
	}

	//新增user
	@Override
	public int saveUser(User user) {
		SqlSession session=sqlSessionFactory.openSession();
		int count = session.insert(URL+"saveUser", user);
		session.commit();
		session.close();
		return count;
	}

	//修改数据
	@Override
	public int updateUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.update(URL+"updateUser", user);
		session.commit();
		session.close();
		return count;
	}

	//根据id删除用户
	@Override
	public int deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.delete(URL+"deleteUser", 4);
		session.commit();
		session.close();
		return count; 
	}

}
