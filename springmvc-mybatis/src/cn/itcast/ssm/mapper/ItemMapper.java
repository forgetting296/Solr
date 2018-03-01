package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ItemMapper {
	
	List<Item> queryItemList();
	
	Item queryItemById(Integer id);
	
	void updateItem(Item item);
}
