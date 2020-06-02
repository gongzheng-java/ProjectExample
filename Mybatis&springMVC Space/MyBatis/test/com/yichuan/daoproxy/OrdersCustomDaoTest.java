
package com.yichuan.daoproxy;

import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.yichuan.entity.Item;
import com.yichuan.entity.OrderDatail;
import com.yichuan.entity.Orders;
import com.yichuan.entity.OrdersCustom;
import com.yichuan.entity.User;

/**
 * OrdersCustomDao接口的测试类
 * 
 * @Author gz
 * @CreateDate 2017年9月27日 下午2:12:30
 * @Description 使用代理接口的方法（推荐）
 */
public class OrdersCustomDaoTest {

	private SqlSessionFactory sessionFactory;

	// 此方法在执行测试方法之前执行
	@Before
	public void setUp() throws Exception {
		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		SqlSessionFactoryBuilder sFactoryBuilder = new SqlSessionFactoryBuilder();
		sessionFactory = sFactoryBuilder.build(reader);

	}

	// 使用拓展类映射，关联查询orders和user信息
	// 两表联合查询订单和用户信息
	@Test
	public void queryOrdersWithUserList() {
		SqlSession session = sessionFactory.openSession();
		// 创建代理对象(和原生的dao接口开发不同的是，没有使用session的selectList()之类的方法，通过输入参数映射文件的“命名空间.sql的ID”来获取数据)
		OrdersDao oCustomDao = session.getMapper(OrdersDao.class);
		List<OrdersCustom> ordersCustoms = oCustomDao.queryOrdersWithUserList();
		for (OrdersCustom ordersCustom : ordersCustoms) {
			System.out.println("获取的结果是：" + ordersCustom);
		}
		session.close();
	}

	// 在类内部创建需要关联查询的类对象，通过配置resultMap来映射关联查询结果集
	// 两表联合查询订单和用户信息
	@Test
	public void queryOrdersWithUsers() {
		SqlSession session = sessionFactory.openSession();
		// 创建代理对象(和原生的dao接口开发不同的是，没有使用session的selectList()之类的方法，通过输入参数映射文件的“命名空间.sql的ID”来获取数据)
		OrdersDao oCustomDao = session.getMapper(OrdersDao.class);
		List<Orders> ordersList = oCustomDao.queryOrdersWithUsers();
		for (Orders orders : ordersList) {
			System.out.println("获取的结果是：");
			System.out.println(orders);
			System.out.println(orders.getUser());
			System.out.println();

		}
		session.close();
	}

	// 在类内部创建需要关联查询的类对象，通过配置resultMap来映射关联查询结果集
	// 三表联合查询 订单、 用户和明细信息
	@Test
	public void OrdersWithUserWithOrderDatailTest() {
		SqlSession session = sessionFactory.openSession();
		// 创建代理对象(和原生的dao接口开发不同的是，没有使用session的selectList()之类的方法，通过输入参数映射文件的“命名空间.sql的ID”来获取数据)
		OrdersDao oCustomDao = session.getMapper(OrdersDao.class);
		List<Orders> ordersList = oCustomDao.OrdersWithUserWithOrderDatail();
		int num = 0;
		for (Orders orders : ordersList) {
			System.out.println(++num + "获取的结果是：");
			System.out.println(orders);
			System.out.println(orders.getUser());
			List<OrderDatail> orderDatails = orders.getOrderDatails();
			for (OrderDatail orderDatail : orderDatails) {
				System.out.println(orderDatail);
			}
			System.out.println();
		}
		session.close();
	}

	// 四表联合查询用户和其所购买的商品信息
	@Test
	public void findUserWithItemTest() {
		SqlSession session = sessionFactory.openSession();
		// 创建代理对象(和原生的dao接口开发不同的是，没有使用session的selectList()之类的方法，通过输入参数映射文件的“命名空间.sql的ID”来获取数据)
		OrdersDao oCustomDao = session.getMapper(OrdersDao.class);
		List<User> users = oCustomDao.findUserWithItem();
		int num = 0;
		for (User user : users) {

			System.out.println(++num + "===============获取的用户信息=====================");
			System.out.println(user);
			List<Orders> orders = user.getOrders();
			for (Orders orders2 : orders) {
				System.out.println("*************订单信息************");
				System.out.println(orders2);
				List<OrderDatail> oDatails = orders2.getOrderDatails();
				for (OrderDatail orderDatail : oDatails) {
					System.out.println("---------订单明细信息-------");
					System.out.println(orderDatail);
					Item item = orderDatail.getItem();
					System.out.println("商品信息：" + item);
				}
			}
			System.out.println();
		}

		session.close();
	}

	//缓存查询：查询订单信息，通过延迟加载关联查询出用户信息
	@Test
	public void findOrderWithUserLazyloading(){
		SqlSession session = sessionFactory.openSession();
		OrdersDao ordersDao = session.getMapper(OrdersDao.class);
		List<Orders> orders = ordersDao.findOrderWithUserLazyloading();//发出查询orders SQL语句
		for (Orders orders2 : orders) {
			User user = orders2.getUser();//发出查询user的SQL语句
			System.out.println(user);
		}
		session.close();
	}
	
	//测试一级缓存SqlSession级别缓存
	@Test
	public void findOrdersTestCache(){
		//一级缓存就是sqlsession缓存，中在同一个sqlsession
		SqlSession session = sessionFactory.openSession();
		OrdersDao ordersDao = session.getMapper(OrdersDao.class);
		Orders orders = ordersDao.findOrder(1002);//发出一条SQL语句
		//session.commit();//注意：如果执行了session的commit()、 insert()、update()、delete()方法 ,就会清空原来一级缓存数据，那么下面的代码就会发出sql语句
		Orders orders2 = ordersDao.findOrder(1002);//不发出SQL语句
		System.out.println(orders);
		System.out.println(orders2);
		session.close();
		
	}
	
	//二级缓存测试  mapper级别跨sqlsession的  需要在mybatis配置文件开启缓存，并在对应的映射文件配置缓存标签
	//测试跨sqlsession查询，没有执行commit(),insert(),update(),delete()方法
	@Test
	public void findOrdersTestCache2(){
		
		SqlSession session = sessionFactory.openSession();
		SqlSession session1 = sessionFactory.openSession();
		
		OrdersDao ordersDao = session.getMapper(OrdersDao.class);
		Orders orders = ordersDao.findOrder(1002);//发出sql语句
		System.out.println(orders);
		session.close();//注意：此处一定要关闭操作，不然sqlsession无法写入到二级缓存中
		
		OrdersDao ordersDao1 = session1.getMapper(OrdersDao.class);
		Orders orders1 = ordersDao1.findOrder(1002);//不发出sql语句
		System.out.println(orders1);
		session1.close();
		
		
		//结论：经过测试验证，如果不配置二级缓存，执行上面执行结果会根据各自的sqlsession对象分别发出一条查询SQL语句
		//     开启二级缓存后，只发出一条sql语句
		//  注意：整合ehcache缓存后，要判断mybatis是否使用了ehcache缓存而不是自己的mapper二级缓存
		//       如果是mybatis自己二级缓存，那么控制台会出现“Cache Hit Ratio [com.yichuan.daoproxy.OrdersDao]: 0.5”字样，即命中率。
		//       如果进入了ehcache缓存，那么就没有上面字样，并且ehcache配置文件ehcache.xml中path指定的目录中会出现缓存文件
		
	}
	
	
	// 测试日期转换结果
	@Test
	public void test01() throws ParseException {
		String str = "2017-05-16 15:12:12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(str);
		System.out.println(date);

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
