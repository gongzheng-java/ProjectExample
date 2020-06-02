
package com.yichuan.service;

import java.util.List;

import com.yichuan.entity.User;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月20日 下午3:03:48 
  * @Description  
  */
public interface UserService {
	
	/**
	 * 查询所有User信息
	 * @return List<User>
	 */
    public List<User> findUserList();

}
