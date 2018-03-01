package cn.itcast.bos.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.system.PermissionDao;
import cn.itcast.bos.domain.system.Permission;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDao pd;

	@Override
	public List<Permission> findAll() {
		
		return pd.findAll();
	}

	@Override
	public void save(Permission model) {
		pd.save(model);
	}

	/*@Override
	public List<Permission> findByUser(User user) {
		String username = user.getUsername();
		if(username.equals("admin")){
			
			return pd.findAll();
		}else{
			
			return pd.findByUser(user.getId());
		}
	}*/
	
	
}
