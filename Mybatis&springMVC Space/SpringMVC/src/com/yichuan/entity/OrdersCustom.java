

package com.yichuan.entity;


 /** 
  * orders实体类的拓展类
  * @Author  gz
  * @CreateDate  2017年9月27日 上午10:51:16 
  * @Description  该类用于继承orders类，通过此类映射订单和用户的关联查询结果
  *               用于测试mybatis映射文件中返回值类型resultType所返回的结果集
  *               使用这种封装类，也可以用于联合查询时结果字段与实体类属性个数不匹配的结果集 
  */
public class OrdersCustom extends Orders{
	
	/**  */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 用户生日
	 */
	private String birthday;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 用户住址
	 */
	private String address;

	/** 
	 * 用户名
	 *  
	 * @return 用户名 
	 */
	public String getUserName() {
		return userName;
	}
	

	/** 
	 * 用户名
	 *  
	 * @param userName  用户名 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

	/** 
	 * 用户生日
	 *  
	 * @return 用户生日 
	 */
	public String getBirthday() {
		return birthday;
	}
	

	/** 
	 * 用户生日
	 *  
	 * @param birthday  用户生日 
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	

	/** 
	 * 性别
	 *  
	 * @return 性别 
	 */
	public String getSex() {
		return sex;
	}
	

	/** 
	 * 性别
	 *  
	 * @param sex  性别 
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	

	/** 
	 * 用户住址
	 *  
	 * @return 用户住址 
	 */
	public String getAddress() {
		return address;
	}
	

	/** 
	 * 用户住址
	 *  
	 * @param address  用户住址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @autho admin
	 * @time 2017年9月27日 上午11:16:40
	 */
	@Override
	public String toString() {
		return "OrdersCustom [userName=" + userName + ", birthday=" + birthday + ", sex=" + sex + ", address=" + address
				+ ", getId()=" + getId() + ", getUserId()=" + getUserId() + ", getNumber()=" + getNumber()
				+ ", getCreateTime()=" + getCreateTime() + ", getNote()=" + getNote() + "]";
	}
	
	
	
	
	
	

}
