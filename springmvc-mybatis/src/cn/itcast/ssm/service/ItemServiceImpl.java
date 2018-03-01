package cn.itcast.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.mapper.ItemMapper;
import cn.itcast.ssm.pojo.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<Item> queryItemList() {
		// TODO Auto-generated method stub
		return itemMapper.queryItemList();
	}

	@Override
	public Item queryItemById(Integer Id) {
		// TODO Auto-generated method stub
		return itemMapper.queryItemById(Id);
	}

	@Override
	public void updateItem(Item item) {
		
		itemMapper.updateItem(item);
	}

}
