package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.domain.SubArea;

public interface SubAreaDao extends JpaRepository<SubArea, Integer>{
	
	@Query(value="select a.c_province, count(sa.c_id)"+
			"	  from t_area a              "+
			"	 inner join t_sub_area sa    "+
			"	    on a.c_id = sa.c_area_id "+
			"	 group by a.c_province       ",nativeQuery=true)

	List<Object[]> findJustChartsData();
	
	/**
	 * 通过定区编号查找关联分区
	 * @author 任宇强
	 * @param id
	 * @return
	 */
	@Query("select s from SubArea s where s.fixedArea.id = ?")
	List<SubArea> findSubAreasByFixedArea(String id);
	
}
