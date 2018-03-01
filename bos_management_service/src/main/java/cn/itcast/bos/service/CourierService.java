package cn.itcast.bos.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;

public interface CourierService {
	
	public void save(Courier courier);

	public Page<Courier> findByPage(Specification<Courier> spec,Integer page, Integer rows);

	public void updateDelTag(String ids);

	public void delete(Integer... idsArray);

	public void restore(Integer[] idsArray);

	public List<Courier> getLinkedCourier(int parseInt);
}
