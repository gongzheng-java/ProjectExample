
package com.yichuan.dao;

import java.util.List;

import com.yichuan.entity.User;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月18日 下午5:04:15 
  * @Description  
  */
public interface UserDao {
	
	/**
	 * 查询所有User信息
	 * @return List<User>
	 */
    public List<User> findUserList();

}
