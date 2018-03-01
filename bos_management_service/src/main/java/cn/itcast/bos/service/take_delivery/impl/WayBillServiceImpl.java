package cn.itcast.bos.service.take_delivery.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.WayBillDao;
import cn.itcast.bos.domain.take_delivery.WayBill;
import cn.itcast.bos.service.take_delivery.WayBillService;

@Service
@Transactional
public class WayBillServiceImpl implements WayBillService{
	
	@Autowired
	private WayBillDao wbd;

	@Override
	public Page<WayBill> findByPage(Integer page, Integer rows) {
		Page<WayBill> pageBean = wbd.findAll(new PageRequest(page-1, rows));
		return pageBean;
	}

	@Override
	public Integer save(WayBill model) {
		
		//记住  hibernate在执行保存之后是有返回值的   返回的是保存后的对象
		WayBill wayBill = wbd.save(model);
		return wayBill.getId();
	}

	@Override
	public void saveAll(List<WayBill> list) {
		wbd.save(list);
	}
	
	
}
