package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.pojo.Item;
import cn.itcast.ssm.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/itemList.action")
	public ModelAndView queryItemList(){
		
		List<Item> list = itemService.queryItemList();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemList", list);
		
		modelAndView.setViewName("itemList");
		
		return modelAndView;
	}
	
	@RequestMapping("/itemEdit.action")
	public ModelAndView updateItem(Integer id){
		
		Item item = itemService.queryItemById(id);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("item", item);
		
		mav.setViewName("editItem");
		
		return mav;
	}
	
	@RequestMapping("/updateitem.action")
	public ModelAndView updateitem(Item item){
		
		itemService.updateItem(item);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("success");
		
		return modelAndView;
	}
	
}
