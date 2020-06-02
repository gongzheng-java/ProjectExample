
package com.yichuan.entity;


 /** 
  *商品类的包装类 ItemVo
  * @Author  gz
  * @CreateDate  2017年10月19日 下午4:01:28 
  * @Description  
  */
public class ItemVo {
	
	//商品类对象
	private Item item;
	
	//商品拓展类对象
	private ItemCustom itemCustom;

	public Item getItem() {
		return item;
	}
	

	public void setItem(Item item) {
		this.item = item;
	}
	

	public ItemCustom getItemCustom() {
		return itemCustom;
	}
	

	public void setItemCustom(ItemCustom itemCustom) {
		this.itemCustom = itemCustom;
	}
	


	

	
	
	

}
