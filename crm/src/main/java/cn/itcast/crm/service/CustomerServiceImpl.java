package cn.itcast.crm.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;

@Service("customerService")
@Transactional
@WebService
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> getUnLinkedCustomer() {
		
		return customerDao.findByFixedAreaIdIsNull();
	}

	@Override
	public List<Customer> getLinkedCustomer(String fixedAreaId) {
		
		return customerDao.findByFixedAreaId(fixedAreaId);
	}

	@Override
	public void LinkFixedAreaAndCustomer(String fixedAreaId, Integer[] ids) {
		//有两步  先要清除关联定区的用户、重新添加关联定区的用户
		customerDao.removeFixedAreaId(fixedAreaId);
		
		if(ids!=null&&ids.length>0){
			for (Integer id : ids) {
				
				customerDao.linkFixedArea(fixedAreaId,id);
			}
		}
	}

	@Override
	public Customer findByTelephone(String Telephone) {
		
		return customerDao.findByTelephone(Telephone);
	}

	@Override
	public void regist(Customer model) {
		customerDao.save(model);
	}

	@Override
	public void updateType(String telephone) {
		
		customerDao.updateType(telephone);
	}

	@Override
	public Customer findByEmail(String email) {
		
		return customerDao.findByEmail(email);
	}

	@Override
	public Customer findByAddress(String address) {
		
		return customerDao.findByAddress(address);
	}

	@Override
	public List<Customer> findAll() {
		
		return customerDao.findAll();
	}

}
