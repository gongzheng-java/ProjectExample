
package com.yichuan.dao;

import java.util.List;

import com.yichuan.entity.Item;
import com.yichuan.entity.ItemCustom;
import com.yichuan.entity.ItemVo;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月19日 下午4:06:53 
  * @Description  
  */
public interface ItemDao {
	
	/**
	 * 根据条件查询商品信息
	 * @param itemVo 包装类
	 * @return List<ItemCustom>
	 */
	public List<ItemCustom> findItems(ItemVo itemVo);
	
	/**
	 * 测试时间类型数据查询时和数据库具体时间匹配问题
	 * @param item
	 * @return Item
	 */
	public Item testTime(Item item);

}
