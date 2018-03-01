package cn.itcast.bos.service.system;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.Permission;
import cn.itcast.bos.domain.system.Role;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.domain.take_delivery.Order;

public interface RoleService {

	List<Role> findAll();

	void save(Role model, List<Integer> permissionIds, List<Integer> menuIdsInteger);

	Page<Role> findByPage(Integer page, Integer rows);

	Role findById(Integer result);
	
	List<Permission> findByRId(Integer result);
	
	List<Menu> findMenuByRoleId(Integer id);

	List<Role> getCurrentRole(Integer id);

	//List<Role> findByUser(User user);

	

}
