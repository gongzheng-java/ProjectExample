package com.yichuan.junit;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.yichuan.entity.OrdersCustom;


/**
 * orders 测试类
 *  注意：该测试类不要需要dao接口支持，只要在映射文件中写好sql就可以直接测试
 * @author gz
 *
 */
public class OrdersTest {

	//使用拓展类OrdersCustom映射,联合查询所有订单和用户信息
	@Test
	public void queryOrdersWithUser() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		 SqlSessionFactory sFactory = sFactoryBuilder.build(reader);
		 SqlSession session = sFactory.openSession();
		 
		 List<OrdersCustom> ordersCustoms = session.selectList("com.yichuan.daoproxy.OrdersDao.queryOrdersWithUserList");
		 
		 for (OrdersCustom ordersCustom : ordersCustoms) {
			System.out.println(ordersCustom);
		}
		 session.close();
	}
	
	
	
	
}
