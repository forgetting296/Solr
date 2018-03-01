package cn.itcast.bos.service.system.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.system.MenuDao;
import cn.itcast.bos.dao.system.PermissionDao;
import cn.itcast.bos.dao.system.RoleDao;
import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.Permission;
import cn.itcast.bos.domain.system.Role;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.service.system.MenuService;
import cn.itcast.bos.service.system.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDao rd;
	
	@Autowired
	private MenuDao md;
	
	@Autowired
	private PermissionDao pd;
	
	@Override
	public List<Role> findAll() {
		
		return rd.findAll();
	}

	@Override
	public void save(Role model, List<Integer> permissionIds, List<Integer> menuIdsInteger) {
		List<Permission> permissions = pd.findAll(permissionIds);
		List<Menu> menus = md.findAll(menuIdsInteger);
		model.getPermissions().addAll(permissions);
		model.getMenus().addAll(menus);
		rd.save(model);
	}

	@Override
	public Page<Role> findByPage(Integer page, Integer rows) {
		
		return rd.findAll(new PageRequest(page-1, rows));
	}

	@Override
	public Role findById(Integer result) {
		
		return rd.findById(result);
	}

	@Override
	public List<Menu> findMenuByRoleId(Integer id) {
		
		return md.findMenuByRoleId(id);
	}

	@Override
	public List<Permission> findByRId(Integer result) {
		
		return pd.findByRId(result);
	}

	@Override
	public List<Role> getCurrentRole(Integer id) {
		
		return rd.getCurrentRole(id);
	}

	/*@Override
	public List<Role> findByUser(User user) {
		String username = user.getUsername();
		if(username.equals("admin")){
			return rd.findAll();
		}else{
			
			return rd.findByUser(user.getId());
		}
	}*/

}
