package cn.itcast.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.domain.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{

}
