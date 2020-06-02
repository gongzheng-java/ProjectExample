package com.yichuan.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yichuan.dao.UserDao;
import com.yichuan.entity.User;

/**
 * 使用原生dao接口模式开的 userdao实现类
 * @autho gz
 * @time 2017年10月13日 上午11:02:47
 * 注意：整合spring后，方法结束就自动释放资源，所以下面的方法中可以不需要关闭和提交操作
 */
public class UserDaoImpl implements UserDao{
	
	
	
	/**
	 *使用spring注入sqlSessionFactory
	 */
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	

	//原生dao接口开发和dao接口代理开发共用一个mapper映射文件，所以url要和代理接口开发的映射文件namespace一致
	private static final  String URL="com.yichuan.daoproxy.UserDao.";
	 
	//查询所有user信息
	@Override
	public List<User> findList() {
		System.out.println("执行daoimpl方法");
		SqlSession session = sqlSessionFactory.openSession();
		List<User>  users = session.selectList(URL+"findList");
		//session.close();
		return users;
	}

	//根据id查询user信息
	@Override
	public User findUser(int id) {
		SqlSession session=sqlSessionFactory.openSession();
		User user = session.selectOne(URL+"findUser", 1);
		//session.close();
		return user;
	}

	//根据用户名模糊查询user信息
	@Override
	public List<User> findName(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<User> users = session.selectList(URL+"findName", "%"+name+"%");
		//session.close();
		return users;
	}

	//新增user
	@Override
	public int saveUser(User user) {
		SqlSession session=sqlSessionFactory.openSession();
		int count = session.insert(URL+"saveUser", user);
		/*session.commit();
		session.close();*/
		return count;
	}

	//修改数据
	@Override
	public int updateUser(User user) {
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.update(URL+"updateUser", user);
		//session.commit();
		//session.close();
		return count;
	}

	//根据id删除用户
	@Override
	public int deleteUser(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		int count = session.delete(URL+"deleteUser", 4);
		//session.commit();
		//session.close();
		return count; 
	}

}
