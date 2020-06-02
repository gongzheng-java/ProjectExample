
package com.yichuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yichuan.dao.ItemDao;
import com.yichuan.entity.ItemCustom;
import com.yichuan.entity.ItemVo;
import com.yichuan.service.ItemService;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月20日 下午3:01:22 
  * @Description  
  */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<ItemCustom> findItems(ItemVo itemVo) {
		
		return itemDao.findItems(itemVo);
	}

}
