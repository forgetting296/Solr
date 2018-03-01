package cn.itcast.bos.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.Standard;

public interface StandardDao extends JpaRepository<Standard, Integer>{
	//根据name模糊查询
	List<Standard> findByNameLike(String name);
	//更新操作
	@Modifying//任何涉及到修改的操作都需要加该注解
	@Query("update Standard set name = ? where id = ?")
	void abc(String name,Integer id);
	
	@Modifying //涉及到任何修改操作都需要加该注解
	@Query("update Standard set name = ?2 where id = ?1 ")
	void bcd(Integer id,String name);
	//如果想使用  原生的sql语句  @Query注解的括号中sql语句必须加value=   必须加nativeQuery=true  它的属性默认是false  
	@Modifying
	@Query(value="update T_STANDARD set C_NAME = ? where C_ID = ?",nativeQuery=true)
	void cde(String name,Integer id);
	
	@Query(value="SELECT * FROM T_STANDARD",nativeQuery=true)
	List<Standard> def();
	
	
}
