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
import cn.itcast.bos.dao.SubAreaDao;
import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.domain.SubArea;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.service.SubAreaService;

@Service
@Transactional
public class SubAreaServiceImpl implements SubAreaService{
	
	@Autowired
	private SubAreaDao subAreaDao;

	@Override
	public void save(SubArea model) {
		// TODO Auto-generated method stub
		subAreaDao.save(model);
	}

	@Override
	public Page<SubArea> findPage(Integer page, Integer rows) {
		
		return subAreaDao.findAll(new PageRequest(page-1, rows));
	}

	@Override
	public List<Object[]> findJustChartsData() {
		return subAreaDao.findJustChartsData();
	}

	@Override
	public List<SubArea> findSubAreasByFixedArea(String id) {
		// TODO Auto-generated method stub
		return subAreaDao.findSubAreasByFixedArea(id);
	}
}
