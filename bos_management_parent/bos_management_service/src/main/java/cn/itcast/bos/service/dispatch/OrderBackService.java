package cn.itcast.bos.service.dispatch;

import cn.itcast.bos.domain.take_delivery.Order;
import org.springframework.data.domain.Page;

/**
 * @author renyapeng
 */
public interface OrderBackService {

    /**
     * 分页查询订单列表
     *
     * @param page
     * @param rows
     * @return
     */
    Page<Order> findPageBean(Integer page, Integer rows);

    /**
     * 人工调度
     *
     * @param model
     */
    void save(Order model);
}
