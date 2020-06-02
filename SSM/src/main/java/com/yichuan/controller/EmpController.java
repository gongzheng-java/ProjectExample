package com.yichuan.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yichuan.entity.Emp;
import com.yichuan.entity.Msg;
import com.yichuan.service.impl.EmpServiceImpl;
/**
 * emp的controller类
 * @author gongZheng
 * @Date 2017年8月17日上午11:33:47
 * @version 1.0
 */
@Controller
@RequestMapping("/EMP")
public class EmpController {
	
	private static Logger logger = Logger.getLogger(EmpController.class);
	
	@Resource
	private EmpServiceImpl empService;
	
	//跳转showEmpJson页面
	@RequestMapping("/showEmpJson")
	public String getShowEmpJson(){
		return "showEmpJson";
	}
	
	
	
	/**
	 * 分页查询员工信息
	 * @ResponseBody注解可以将返回的对象自动转换成json字符串
	 * @ResponseBody要正常工作需要导入Jackson包
	 * @return PageInfo的json对象
	 */
	@RequestMapping(value = "/empsJson",method=RequestMethod.GET)
	@ResponseBody
	public Msg queryEmpsJson(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum){
		
		//引入Pagehelper分页插件，参数是当前页数和每页显示数据量
		PageHelper.startPage(pageNum, 8);
		//获取数据
		List<Emp> list=empService.queryEmpWithDepts();
		//将数据封装到PageInfo中,并设置连续显示的页数
		PageInfo pageInfo=new PageInfo(list,5);
		//return pageInfo;
		return Msg.success().add("pageInfo", pageInfo);
	}
	
	
	
	/**
	 * 分页查询员工信息
	 * @return 结果视图
	 */
	@RequestMapping("/emps")
	public String queryEmps(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
			Model model,HttpServletRequest request){
		//System.out.println("测试请求是否到达");
		//引入Pagehelper分页插件
		PageHelper.startPage(pageNum, 8);
		//获取数据
		List<Emp> list=empService.queryEmpWithDepts();
		//将数据封装到PageInfo中,并设置连续显示的页数
		PageInfo pageInfo=new PageInfo(list,5);
		//model.addAttribute("pageInfo", pageInfo);
		//logger.info("保存分页数据");
		request.setAttribute("pageInfo", pageInfo);
		return "showEmp";
	}
	
	@RequestMapping("/emps2")
	public String queryEmp(){
		System.out.println("emps2测试请求是否到达");
		Emp emp =empService.queryOneEmp(3);
		System.out.println(emp.getName());
		System.out.println(emp.getId());
		System.out.println(emp.getEmail());
		return "test";
	}
	
	/**
	 * 新增员工信息
	 * @param emp 员工对象
	 * @return Msg新增结果
	 */
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveEmp(Emp emp){
		int num = empService.saveEmp(emp);
		if (num > 0) {
			return Msg.success();//新增成功
		}
		return Msg.fail();//新增失败
	}
	
	/**
	 * 新增员工前， 判断员工是否已经存在
	 * @param name 待新增的员工名称
	 * @return  操作结果Msg
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/queryEmpCount",method=RequestMethod.GET)
	@ResponseBody
	public Msg countEmp(String name) throws UnsupportedEncodingException {
		String empName = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		boolean result =empService.countEmp(empName);
		if (result) {
			return Msg.success();
		}
		return Msg.fail();
	}
	
	/**
	 * 查询单个员工信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="/queryEmp",method = RequestMethod.GET)
	@ResponseBody
	public Msg queryEmp(int id){
		Emp emp = empService.queryEmp(id);
		if (emp != null) {
			return Msg.success().add("emp", emp);
		}
		return Msg.fail();
		
	}
	
	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateEmp(Emp emp){
		boolean result = empService.updateEmp(emp);
		if (result) {
			return Msg.success();
		}
		return Msg.fail();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
