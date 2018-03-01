package cn.itcast.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.StandardService;

@Service
@Transactional
public class StandardServiceImpl implements StandardService{
	
	@Autowired
	private StandardDao standardDao;//如果框架内部是基于子类的动态代理  那么产生的代理对象和父类是一样的
									//但是该类的父类是baseDao的实现类   生成的动态代理对象类型和dao不太一样   可以注入？
	
	@Override
	public void save(Standard standard) {
		
		standardDao.save(standard);
	}

	@Override
	public Page<Standard> findByPage(Integer page, Integer rows) {
		// 在jpa的封装好的分页中    page是从0开始的
		return standardDao.findAll(new PageRequest(page-1, rows));
	}

}
