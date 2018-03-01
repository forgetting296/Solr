package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;

public interface CourierDao extends JpaRepository<Courier, Integer>,JpaSpecificationExecutor<Courier>{
	//内部是基于JDK的动态代理  调用的是 大接口的实现类的方法
	
	//自定义作废快递员的方法
	@Modifying
	@Query("update Courier set deltag = 1 where id = ?")
	void updateDelTag(Integer id);
	@Modifying
	@Query("update Courier set deltag = 0 where id = ?")
	void updateRestore(Integer i);
	
	@Query("select c from Courier c inner join c.fixedAreas f where f.id = ?")
	List<Courier> getLinkedCourier(int parseInt);
}
