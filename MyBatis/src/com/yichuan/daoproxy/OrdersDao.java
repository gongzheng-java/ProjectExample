
package com.yichuan.daoproxy;

import java.util.List;

import com.yichuan.entity.Orders;
import com.yichuan.entity.OrdersCustom;
import com.yichuan.entity.User;

/** 
  *OrdersDao 接口
  * @Author  gz
  * @CreateDate  2017年9月27日 上午11:44:11 
  * @Description  
  */
public interface OrdersDao {
	

	/**
	 * 联合查询订单和用户信息
	 * 使用拓展类方法
	 * @return List<OrdersCustom>
	 */
	public List<OrdersCustom> queryOrdersWithUserList();
	
	
	/**
	 * 两表联合查询订单和用户信息
	 * 类内部对象关联查询方法
	 * @return List<Orders>
	 */
	public List<Orders> queryOrdersWithUsers();
	
	/**
	 * 三表联合查询 订单、 用户和明细信息
	 * 创建内部类对象关联查询
	 * @return List<Orders>
	 */
	public List<Orders> OrdersWithUserWithOrderDatail();
	
	/**
	 * 四表联合查询用户和其所购买的商品信息
	 * 创建内部类对象关联查询
	 * @return List<User>
	 */
	public List<User> findUserWithItem();
	
	/**
	 * 缓存查询：查询订单信息，通过延迟加载关联查询出用户信息
	 * @return List<Orders>
	 */
	public List<Orders> findOrderWithUserLazyloading();
	
	/**
	 * 根据id查询订单信息
	 * 用于测试一级缓存和二级缓存
	 * @param id
	 * @return Orders
	 */
	public Orders findOrder(int id);
	
	/**
	 * 新增订单
	 * @param orders
	 * @return int 
	 */
	public int saveOrders(Orders orders);

}
