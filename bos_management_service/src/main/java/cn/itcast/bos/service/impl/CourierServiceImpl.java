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

import cn.itcast.bos.dao.CourierDao;
import cn.itcast.bos.dao.StandardDao;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.StandardService;

@Service
@Transactional
public class CourierServiceImpl implements CourierService{
	
	@Autowired
	private CourierDao courierDao;
	
	@Override
	public void save(Courier courier) {
		
		courierDao.save(courier);
	}

	@Override
	public Page<Courier> findByPage(Specification<Courier> spec,Integer page, Integer rows) {
		// 在jpa的封装好的分页中    page是从0开始的
		return courierDao.findAll(spec,new PageRequest(page-1, rows));
	}

	@Override
	public void updateDelTag(String ids) {
		
		String[] ss = ids.split(",");
		
		for (String s : ss) {
			courierDao.updateDelTag(Integer.parseInt(s));
		}
		
	}

	@Override
	public void delete(Integer... idsArray) {
		for (Integer i : idsArray) {
			courierDao.updateDelTag(i);
		}
		
	}

	/* (non-Javadoc)
	 * @see cn.itcast.bos.service.CourierService#restore(java.lang.Integer[])
	 */
	@Override
	public void restore(Integer[] idsArray) {
		for (Integer i : idsArray) {
			courierDao.updateRestore(i);
		}
	}
	
	
	
	/**
	 * 根据id 查询快递员
	 *
	 * @author renyapeng
	 * @param id
	 */
	public Courier findById(Integer id) {
	    return courierDao.findOne(id);
	}

	@Override
	public List<Courier> getLinkedCourier(int parseInt) {
		
		return courierDao.getLinkedCourier(parseInt);
	}

}
