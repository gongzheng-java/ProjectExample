
package com.yichuan.entity;


 /** 
  *订单明细 实体类
  * @Author  gz
  * @CreateDate  2017年10月9日 上午10:29:50 
  * @Description  与数据库中订单明细表ordersDatail对应
  */
public class OrderDatail {
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 订单id
	 */
	private Integer orderId;
	
	
	/**
	 * 商品id
	 */
	private Integer itemsID;
	
	/**
	 * 商品购买量
	 */
	private Integer itemsNum;
	
	/**
	 * 商品对象item
	 */
	private Item item;

	/** 
	 * 主键id
	 * @return 主键id 
	 */
	public Integer getId() {
		return id;
	}
	

	/** 
	 * 主键id
	 * @param id  主键id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

	/** 
	 * 订单id
	 * @return 订单id 
	 */
	public Integer getOrderId() {
		return orderId;
	}
	

	/** 
	 * 订单id
	 * @param orderId  订单id 
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	

	/** 
	 * 商品id
	 * @return 商品id 
	 */
	public Integer getItemsID() {
		return itemsID;
	}
	

	/** 
	 * 商品id
	 * @param itemsID  商品id 
	 */
	public void setItemsID(Integer itemsID) {
		this.itemsID = itemsID;
	}
	

	/** 
	 * 商品购买量
	 * @return 商品购买量 
	 */
	public Integer getItemsNum() {
		return itemsNum;
	}
	

	/** 
	 * 商品购买量
	 * @param itemsNum  商品购买量 
	 */
	public void setItemsNum(Integer itemsNum) {
		this.itemsNum = itemsNum;
	}


	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @autho admin
	 * @time 2017年10月9日 上午11:55:33
	 */
	@Override
	public String toString() {
		return "OrderDatail [id=" + id + ", orderId=" + orderId + ", itemsID=" + itemsID + ", itemsNum=" + itemsNum
				+ "]";
	}


	/** 
	 * 商品对象item
	 * @return   商品对象item 
	 */
	public Item getItem() {
		return item;
	}
	


	/** 
	 * 商品对象item
	 * @param item    商品对象item 
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	
	
	
	
	
	

}
