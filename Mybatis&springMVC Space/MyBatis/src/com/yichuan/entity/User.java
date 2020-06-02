package com.yichuan.entity;

import java.util.List;

/**
 * user 实体类
 * @author gz
 *
 */
public class User {
	//实体类属性名需要和数据库对应表的字段名一致
	private Integer id;
	
	
	private String userName;
	
	private String  birthday;
	
	private String sex;
	
	private String address;
	
	/**
	 * 订单orders集合对象
	 */
	private List<Orders> orders;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/*public Date getBirthday() {
		
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}*/
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", birthday=" + birthday + ", sex=" + sex + ", address="
				+ address + "]";
	}
	
	/** 
	 * 订单orders集合对象
	 * @return 订单orders集合对象 
	 */
	public List<Orders> getOrders() {
		return orders;
	}
	
	/** 
	 * 订单orders集合对象
	 * @param orders  订单orders集合对象 
	 */
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
	
	
	
	

}
