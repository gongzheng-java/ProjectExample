
package com.yichuan.entity;

import java.util.Date;

/** 
  *商品实体类
  * @Author  gz
  * @CreateDate  2017年10月9日 上午10:23:51 
  * @Description  与数据库中商品表items对应
  */
public class Item {
	/**
	 * 商品id
	 */
	private Integer id;
	
	/**
	 * 商品名称
	 */
	private String name;
	
	/**
	 * 商品价格
	 */
	private float price;
	
	/**
	 * 商品图片
	 */
	private String pic;
	
	/**
	 * 生产日期
	 */
	private Date createTime;

	/** 
	 * 商品id
	 * @return 商品id 
	 */
	public Integer getId() {
		return id;
	}
	

	/** 
	 * 商品id
	 * @param id  商品id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

	/** 
	 * 商品名称
	 * @return 商品名称 
	 */
	public String getName() {
		return name;
	}
	

	/** 
	 * 商品名称
	 * @param name  商品名称 
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/** 
	 * 商品价格
	 * @return 商品价格 
	 */
	public float getPrice() {
		return price;
	}
	

	/** 
	 * 商品价格
	 * @param price  商品价格 
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/** 
	 * 商品图片
	 * @return 商品图片 
	 */
	public String getPic() {
		return pic;
	}
	

	/** 
	 * 商品图片
	 * @param pic  商品图片 
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	

	/** 
	 * 生产日期
	 * @return 生产日期 
	 */
	public Date getCreateTime() {
		return createTime;
	}
	

	/** 
	 * 生产日期
	 * @param createTime  生产日期 
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @autho admin
	 * @time 2017年10月9日 上午11:56:19
	 */
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", pic=" + pic
				+ ", createTime=" + createTime + "]";
	}
	
	
	

}
