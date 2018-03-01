package cn.itcast.bos.service.system;

import java.util.List;

import cn.itcast.bos.domain.system.User;

public interface UserService {

	List<User> findAll();

	void save(User model, List<Integer> roleIds);

}
