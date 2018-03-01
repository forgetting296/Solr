package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.pojo.Item;

public interface ItemService {
	
	public List<Item> queryItemList();
	
	public Item queryItemById(Integer Id);
	
	public void updateItem(Item item);
}
