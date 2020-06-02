package com.yichuan.text;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.yichuan.entity.Emp;



/**
 * 使用spring提供的测试模块，模拟web发送请求，测试获取分页数据
 * spring4.0以上的版本需要serlvet3.0以上版本
 * @author gongZheng
 * @Date 2017年8月15日下午2:13:23
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration //该注解用于拿到web ioc容器
@ContextConfiguration(locations={"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class PageHelperTest {
	
	//传入springmvc的ioc，即拿到web容器
	@Autowired
	WebApplicationContext context;
	//虚拟mvc请求，获取处理结果
	MockMvc mockMvc;
	
	//该注解表示每次初始化
	@Before
	public void initMockMvc(){
		System.out.println("测试");
		//创建mockMvc
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testPage() throws Exception {
		// 模拟请求拿到返回值 perform()方法用于模拟发送请求
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pageNum", "1")).andReturn();
		// 请求成功后请求域中会有分页信息的pageInfo对象，取出pageInfo进行验证
		MockHttpServletRequest request = result.getRequest();
		PageInfo pe=(PageInfo) request.getAttribute("pageInfo");
		System.out.println(pe);
		System.out.println("当前页码："+pe.getPageNum());
		System.out.println("总页数："+pe.getPages());
		System.out.println("总记录："+pe.getTotal());
		System.out.println("页面显示的连续的页码：");
		int[] nums=pe.getNavigatepageNums();
		for (int i : nums) {
			System.out.print("\t"+i);
		}
		System.out.println();
		System.out.println("员工信息如下：");
		//获取员工数据
		List<Emp> emps=pe.getList();
		for (Emp emp : emps) {
			System.out.println(emp.getId()+"\t"+emp.getName()+"\t");
			
		}

	}
	
	
	

}
