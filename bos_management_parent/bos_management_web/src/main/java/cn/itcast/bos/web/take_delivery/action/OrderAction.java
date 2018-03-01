package cn.itcast.bos.web.take_delivery.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.service.take_delivery.OrderService;
import cn.itcast.bos.utils.action.BaseAction;

public class OrderAction extends BaseAction<Order>{
	
	@Autowired
	private OrderService os;
	
	@Action("OrderAction_findAll")
	public String findAll(){
		
		//Page<Order>pageBean = os.findAll(1,rows.MAX_VALUE);
		//page2Client(pageBean, "courier","workBills","wayBill");
		
		List<Order> list = os.findAll(page,rows);
		
		list2Client(list, "courier","workBills","wayBill");
		
		return null;
	}
}
