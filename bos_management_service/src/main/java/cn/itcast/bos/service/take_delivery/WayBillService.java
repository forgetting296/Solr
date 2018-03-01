package cn.itcast.bos.service.take_delivery;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.itcast.bos.domain.take_delivery.WayBill;

public interface WayBillService {

	Page<WayBill> findByPage(Integer page, Integer rows);

	Integer save(WayBill model);
	
	void saveAll(List<WayBill> list);
}
