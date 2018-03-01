package cn.itcast.bos.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.system.MenuDao;
import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.User;
import cn.itcast.bos.service.system.MenuService;

@Service
@Transactional
public class MenuServiceImpl implements MenuService{
	
	@Autowired
	private MenuDao md;

	@Override
	public List<Menu> findAll() {
		
		return md.findByParentMenuIsNull();
	}

	@Override
	public void save(Menu model) {
		if(model.getParentMenu()!=null&&model.getParentMenu().getId()==null){
			model.setParentMenu(null);
		}
		md.save(model);
	}

	@Override
	public List<Menu> findByUser(User user) {
		String username = user.getUsername();
		if(username.equals("admin")){
			
			return md.findAll();
		}else{
			
			return md.findByUser(user.getId());
		}
	}
}
