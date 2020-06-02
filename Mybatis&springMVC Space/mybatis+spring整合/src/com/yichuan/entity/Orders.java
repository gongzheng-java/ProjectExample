
package com.yichuan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/** 
  *订单表 实体类
  * @Author  gz
  * @CreateDate  2017年9月27日 上午10:36:02 
  * @Description  使用二级缓存的pojo类需要实现序列化接口
  */
public class Orders implements Serializable{
	
	/**  */
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	private Integer id;
	
	/**
	 * 下单用户ID
	 */
	private Integer userId;
	
	/**
	 * 订单编号
	 */
	private String number;
	
    /**
	 * 创建订单时间
	 */
	private Date createTime;
	
	/**
	 * 备注
	 */
	private String note;
	
	/**
	 * 用户user对象
	 *建立orders对象和user对象之间的多对一关系
	 *（一个用户可以下多个订单；在多方定义一方对象）
	 */
	private User user;
	
	/**
	 * 订单明细orderDatail的list集合
	 * 建立订单orders和订单明细orderDatail之间的一对多关系
	 * （一个订单对有多个商品，一个商品对应一个明细信息；在一方定义多方对象）
	 */
	private List<OrderDatail> orderDatails;
	
	


	/** 
	 * 订单明细orderDatail的list集合 
	 * @return  List<OrderDatail>
	 */
	public List<OrderDatail> getOrderDatails() {
		return orderDatails;
	}
	

	/** 
	 * 订单明细orderDatail的list集合 
	 * @param orderDatails  
	 */
	public void setOrderDatails(List<OrderDatail> orderDatails) {
		this.orderDatails = orderDatails;
	}
	

	/** 
	 * 用户user对象
	 * @return 用户user对象 
	 */
	public User getUser() {
		return user;
	}
	
	/** 
	 * 用户user对象
	 * @param user  用户user对象 
	 */
	public void setUser(User user) {
		this.user = user;
	}
	


	/** 
	 * 订单id
	 *  
	 * @return 订单id 
	 */
	public Integer getId() {
		return id;
	}
	

	/** 
	 * 订单id
	 *  
	 * @param id  订单id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

	/** 
	 * 下单用户ID
	 *  
	 * @return 下单用户ID 
	 */
	public Integer getUserId() {
		return userId;
	}
	

	/** 
	 * 下单用户ID
	 *  
	 * @param userId  下单用户ID 
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

	/** 
	 * 订单编号
	 *  
	 * @return 订单编号 
	 */
	public String getNumber() {
		return number;
	}
	

	/** 
	 * 订单编号
	 *  
	 * @param number  订单编号 
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	

	/** 
	 * 创建订单时间
	 *  
	 * @return 创建订单时间 
	 */
	public Date getCreateTime() {
		
		return createTime;
	}
	

	/** 
	 * 创建订单时间
	 *  
	 * @param createTime  创建订单时间 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

	/** 
	 * 备注
	 *  
	 * @return 备注 
	 */
	public String getNote() {
		return note;
	}
	

	/** 
	 * 备注
	 *  
	 * @param note  备注 
	 */
	public void setNote(String note) {
		this.note = note;
	}


	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @autho admin
	 * @time 2017年9月27日 上午11:15:27
	 */
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", createTime=" + createTime
				+ ", note=" + note + "]";
	}
	

	
	
	
	
	

}
