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
import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.StandardService;

@Service
@Transactional
public class AreaServiceImpl implements AreaService{
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public void saveAll(List<Area> list) {
		areaDao.save(list);
	}

	@Override
	public Page<Area> findPageBean(Integer page, Integer rows) {
		return areaDao.findAll(new PageRequest(page-1, rows));
	}

	@Override
	public List<Area> find(String q) {
		
		return areaDao.find("%"+q.toLowerCase()+"%","%"+q.toUpperCase()+"%");
	}

	@Override
	public void save(Area model) {
		// TODO Auto-generated method stub
		areaDao.save(model);
	}

	@Override
	public List<Area> findAll() {
		
		return areaDao.findAll();
	}

	@Override
	public List<Object[]> findHighChartsData() {
		
		return areaDao.findHighChartsData();
	}
	

}
