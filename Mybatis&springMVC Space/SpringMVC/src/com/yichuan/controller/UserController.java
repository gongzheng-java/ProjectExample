
package com.yichuan.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yichuan.entity.User;
import com.yichuan.service.UserService;


/** 
  *usercontroller 类
  * @Author  gz
  * @CreateDate  2017年10月17日 下午3:42:01 
  * @Description  
  */
@Controller
@RequestMapping(value="/User")
public class UserController {
	
	private static Logger logger=Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	//请求test
	@RequestMapping("/findUserList")
	public String findUserList(HttpServletRequest request){
		System.out.println("请求被springMVC框架拦截！！！！");
		List<User> uList =new ArrayList<User>();
		//List<User> users = userService.findUserList();
		User user = new User(1,"张三","2017-01-12","男","湖北省武汉市洪山区八一路东湖新村");
		User user1 = new User(1,"张三","2017-01-12","男","湖北省武汉市洪山区八一路东湖新村");
		User user2 = new User(1,"张三","2017-01-12","男","湖北省武汉市洪山区八一路东湖新村");
		User user3= new User(1,"张三","2017-01-12","男","湖北省武汉市洪山区八一路东湖新村");
		User user4 = new User(1,"张三","2017-01-12","男","湖北省武汉市洪山区八一路东湖新村");
		User user5 = new User(1,"张三","2017-01-12","男","湖北省武汉市洪山区八一路东湖新村");
		
		uList.add(user5);
		uList.add(user4);
		uList.add(user3);
		uList.add(user2);
		uList.add(user1);
		uList.add(user);
		
		
		request.setAttribute("uList", uList);
		
		return "showUser";//跳转的页面
	}
	
	

}
