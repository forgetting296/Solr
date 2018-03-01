package cn.itcast.crm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.crm.domain.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	List<Customer> findByFixedAreaIdIsNull();

	List<Customer> findByFixedAreaId(String fixedAreaId);
	
	@Modifying
	@Query("update Customer set fixedAreaId = null where fixedAreaId=?")
	void removeFixedAreaId(String fixedAreaId);
	@Modifying
	@Query("update Customer set fixedAreaId = ? where id = ?")
	void linkFixedArea(String fixedAreaId,Integer id);

	Customer findByTelephone(String telephone);
	
	@Modifying
	@Query("update Customer set type = 1 where telephone = ?")
	void updateType(String telephone);

	Customer findByEmail(String email);

	Customer findByAddress(String address);
	
}
