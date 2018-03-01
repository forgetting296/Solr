package cn.itcast.bos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.domain.SubArea;

public interface SubAreaService {

	void save(SubArea model);

	Page<SubArea> findPage(Integer page, Integer rows);
	
	List<Object[]> findJustChartsData();

	List<SubArea> findSubAreasByFixedArea(String id);
}
