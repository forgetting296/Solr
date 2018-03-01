package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.domain.TakeTime;

public interface TakeTimeDao extends JpaRepository<TakeTime, Integer>{
	//内部是基于JDK的动态代理  调用的是 大接口的实现类的方法
	
}
