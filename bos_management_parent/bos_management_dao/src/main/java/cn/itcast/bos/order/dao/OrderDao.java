package cn.itcast.bos.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.bos.domain.take_delivery.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
