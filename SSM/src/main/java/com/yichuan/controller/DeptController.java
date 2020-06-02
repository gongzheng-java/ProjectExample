package com.yichuan.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yichuan.entity.Msg;
import com.yichuan.service.impl.DeptServiceImpl;

/**
 * Dept的controller类
 * @author gongZheng
 * @Date 2017年9月12日上午11:43:04
 * @version 1.0
 */
@Controller
@RequestMapping("/DEPT")
public class DeptController {
	private static Logger logger = Logger.getLogger(EmpController.class);
	
	@Resource
	private DeptServiceImpl dService;
	
	@RequestMapping("/queryDept")
	@ResponseBody
	public Msg queryDept(){
		return Msg.success().add("deptList", dService.queryDept());
		
	}
	
	

}
