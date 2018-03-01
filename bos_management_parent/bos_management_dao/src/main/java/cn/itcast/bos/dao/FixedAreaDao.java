package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.FixedArea;
import cn.itcast.bos.domain.Standard;

public interface FixedAreaDao extends JpaRepository<FixedArea, String>{
	
}
