package cn.itcast.bos.dao.dispatch;

import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.domain.take_delivery.WorkBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBackDao extends JpaRepository<Order, Integer> {

    void save(WorkBill wb);
}
