package cn.itcast.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Order;
import cn.itcast.service.OrderService;

@Service("orderService")
@Transactional
@WebService
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void save(Order model) {
		
		orderDao.save(model);
	}

}
