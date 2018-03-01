package cn.itcast.bos.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.itcast.bos.domain.system.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
