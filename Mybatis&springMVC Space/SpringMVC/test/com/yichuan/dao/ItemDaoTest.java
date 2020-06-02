
package com.yichuan.dao;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yichuan.entity.Item;
import com.yichuan.entity.ItemCustom;
import com.yichuan.entity.ItemVo;

/** 
  *
  * @Author  gz
  * @CreateDate  2017年10月19日 下午4:11:49 
  * @Description  
  */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class ItemDaoTest {
	
	@Resource
	private ItemDao itemDao;

	@Test
	public void findItemsTest() throws ParseException {
		ItemVo itemVo =new ItemVo();
		ItemCustom itemCustom1 =new ItemCustom();
		//itemCustom1.setName("标");
		itemCustom1.setPrice(21.5f);
		itemVo.setItemCustom(itemCustom1);
		System.out.println(itemVo.getItemCustom().getPrice());
		System.out.println("sdddddddddddddddddddddddddddddddddd");
		List<ItemCustom> itemCustoms = itemDao.findItems(itemVo);
		System.out.println("获取的数据如下：");
		for (ItemCustom itemCustom : itemCustoms) {
		 System.out.println(itemCustom.toString());
		 SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String strDate = sFormat.format(itemCustom.getCreateTime());
		 System.out.println(strDate);
		}
	}
	
	
	@Test
	public void findItemsTest1() throws ParseException {
	    String strDate ="2018-08-08 08:08:08";
		 SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = sFormat.parse(strDate);
		 System.out.println(date);
		 
		 System.out.println("-----------------------------");
		 Item item =new Item();
		 item.setCreateTime(date);
		 item = itemDao.testTime(item);
         System.out.println(item);
		
		 //qq.setUpdateTime(maps.get("updateTime") == null ? null: format.parse(maps.get("updateTime").toString()));
		 											
		 													
		}
	
	


}
