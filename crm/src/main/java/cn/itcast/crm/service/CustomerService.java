package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.domain.Customer;

public interface CustomerService {
	//定义三个方法 获取未与定区关联的客户、获取指定定区关联的客户、将指定的定区和指定的客户关联
	
	//获取未关联任何定区的客户
	List<Customer> getUnLinkedCustomer();
	//获取指定定区关联的客户
	List<Customer> getLinkedCustomer(String fixedAreaId);
	//将指定的定区和指定的客户关联
	void LinkFixedAreaAndCustomer(String fixedAreaId,Integer[] ids);
	
	//根据手机号查询客户
	Customer findByTelephone(String Telephone);
	Customer findByEmail(String email);
	
	void regist(Customer model);
	void updateType(String telephone);
	
	Customer findByAddress(String address);
	
	List<Customer> findAll();
}
