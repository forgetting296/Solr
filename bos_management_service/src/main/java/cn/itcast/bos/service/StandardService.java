package cn.itcast.bos.service;

import org.springframework.data.domain.Page;

import cn.itcast.bos.domain.Standard;

public interface StandardService {
	
	public void save(Standard standard);

	public Page<Standard> findByPage(Integer page, Integer rows);
}
