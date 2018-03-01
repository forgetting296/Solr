package cn.itcast.bos.service.take_delivery;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.itcast.bos.domain.take_delivery.Order;

public interface OrderService {
	
	void save(Order o);

	List<Order> findAll(Integer page, Integer rows);

	//Page<Order> findAll(int i, int maxValue);

}
