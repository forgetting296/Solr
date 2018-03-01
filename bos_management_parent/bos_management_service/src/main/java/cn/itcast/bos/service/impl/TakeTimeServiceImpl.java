package cn.itcast.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.TakeTimeDao;
import cn.itcast.bos.domain.TakeTime;
import cn.itcast.bos.service.TakeTimeService;

@Service
@Transactional
public class TakeTimeServiceImpl implements TakeTimeService{
	
	@Autowired
	private TakeTimeDao ttd;
	
	@Override
	public Page<TakeTime> findAll(int page, int rows) {
		
		return ttd.findAll(new PageRequest(page-1, rows));
	}

}
