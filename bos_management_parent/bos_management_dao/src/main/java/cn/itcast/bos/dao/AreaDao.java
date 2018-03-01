package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.Standard;

public interface AreaDao extends JpaRepository<Area, String>{
	
	@Modifying
	@Query("from Area where citycode like ?2 or shortcode like ?1")
	List<Area> find(String q1, String q2);

	Area findByProvinceAndCityAndDistrict(String province, String city, String district);
	
	@Query(value="select a.c_province,count(sa.c_id) from t_area a inner join t_sub_area sa on a.c_id = sa.c_area_id group by a.c_province",nativeQuery=true)
	List<Object[]> findHighChartsData();

}
