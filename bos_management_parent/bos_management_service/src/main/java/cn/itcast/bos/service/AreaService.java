package cn.itcast.bos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;

public interface AreaService {

	void saveAll(List<Area> list);

	Page<Area> findPageBean(Integer page, Integer rows);

	List<Area> find(String q);

	void save(Area model);

	List<Area> findAll();

	List<Object[]> findHighChartsData();
	
}
