package cn.itcast.bos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.FixedArea;
import cn.itcast.bos.domain.Standard;

public interface FixedAreaService {

	void save(FixedArea model);

	Page<FixedArea> findByPage(Integer page, Integer rows);

	void linkCourier(String id, Integer courierId, Integer takeTimeId);

	
}