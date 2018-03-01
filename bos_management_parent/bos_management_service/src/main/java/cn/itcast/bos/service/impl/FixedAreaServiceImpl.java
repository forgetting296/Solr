package cn.itcast.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.AreaDao;
import cn.itcast.bos.dao.CourierDao;
import cn.itcast.bos.dao.FixedAreaDao;
import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.dao.TakeTimeDao;
import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.FixedArea;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.domain.TakeTime;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.FixedAreaService;
import cn.itcast.bos.service.StandardService;

@Service
@Transactional
public class FixedAreaServiceImpl implements FixedAreaService{
	
	@Autowired
	private FixedAreaDao fixAreaDao;

	@Override
	public void save(FixedArea model) {
		
		fixAreaDao.save(model);
	}

	@Override
	public Page<FixedArea> findByPage(Integer page, Integer rows) {
		return fixAreaDao.findAll(new PageRequest(page-1, rows));
	}
	
	@Autowired
	private CourierDao cd;
	@Autowired
	private TakeTimeDao ttd;
	
	@Override
	public void linkCourier(String id, Integer courierId, Integer takeTimeId) {
		
		FixedArea fa = fixAreaDao.findOne(id);
		Courier c = cd.findOne(courierId);
		TakeTime tt = ttd.findOne(takeTimeId);
		
		fa.getCouriers().add(c);
		c.setTakeTime(tt);
	}


}
