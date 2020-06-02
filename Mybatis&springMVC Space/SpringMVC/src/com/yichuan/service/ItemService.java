
package com.yichuan.service;

import java.util.List;

import com.yichuan.entity.ItemCustom;
import com.yichuan.entity.ItemVo;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月20日 下午3:00:11 
  * @Description  
  */
public interface ItemService {
	
	/**
	 * 根据条件查询商品信息
	 * @param itemVo 包装类
	 * @return List<ItemCustom>
	 */
	public List<ItemCustom> findItems(ItemVo itemVo);

}
