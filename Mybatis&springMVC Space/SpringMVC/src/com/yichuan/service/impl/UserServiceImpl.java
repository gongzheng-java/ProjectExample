
package com.yichuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yichuan.dao.UserDao;
import com.yichuan.entity.User;
import com.yichuan.service.UserService;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月20日 下午3:04:16 
  * @Description  
  */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findUserList() {
		System.out.println("12310");
		return userDao.findUserList() ;
	}

}
