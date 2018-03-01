package cn.itcast.bos.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.system.RoleDao;
import cn.itcast.bos.dao.system.UserDao;
import cn.itcast.bos.domain.system.Role;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao ud;
	@Autowired
	private RoleDao rd;
	
	@Override
	public List<User> findAll() {
		
		return ud.findAll();
	}

	@Override
	public void save(User model, List<Integer> roleIds) {
		List<Role> roles = rd.findAll(roleIds);
		model.getRoles().addAll(roles);
		ud.save(model);
	}

}
