package com.yichuan.dao;


import java.util.List;

import com.yichuan.entity.User;
/**
 * 原生dao接口
 * @autho gz
 * @time 2017年10月13日 下午2:48:51
 * @Description
 */
public interface UserDao {
	
	/**
	 * 查询所有user信息
	 * @return
	 */
	public List<User> findList();
	
	/**
	 * 根据id查询用户信息
	 * @param id 用户id
	 * @return user 对象
	 */
	public User findUser(int id);
	
	/**
	 * 根据用户名模糊查询用户信息
	 * @param name 用户名
	 * @return list对象
	 */
	public List<User> findName(String name);
	
	/**
	 * 新增user
	 * @param user
	 * @return 
	 */
	public int saveUser(User user);
	
	/**
	 * 更新user信息
	 * @param user
	 * @return
	 */
	public int updateUser(User user);

	/**
	 * 根据主键id删除user
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);
	
	
	
	
	
	
	
	
	
}
