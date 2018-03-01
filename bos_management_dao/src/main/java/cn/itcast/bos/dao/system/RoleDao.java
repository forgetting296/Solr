package cn.itcast.bos.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.Role;
import cn.itcast.bos.domain.take_delivery.Order;

public interface RoleDao extends JpaRepository<Role, Integer>{
	
	@Query(value="select r from Role r inner join r.users u where u.id = ?")
	List<Role> findByUser(Integer id);
	
	@Query("select r from Role r where r.id = ?")
	Role findById(Integer result);
	
	@Query("select r from Role r where r.id = ?")
	List<Role> getCurrentRole(Integer id);

}
