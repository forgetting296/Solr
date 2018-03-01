package cn.itcast.bos.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.bos.utils.action.BaseAction;
import cn.itcast.crm.service.Customer;
import cn.itcast.crm.service.CustomerServiceImpl;

public class CustomerAction extends BaseAction<Customer>{
	
	@Autowired
	private CustomerServiceImpl cs;
	//名字  开始时间
	
	
	
	
	//名字  结束时间
	@Action("CustomerAction_getLinkedCustomer")
	public String getLinkedCustomer(){
		List<Customer> list = cs.getLinkedCustomer(model.getFixedAreaId());
		list2Client(list);
		return null;
	}
	@Action("CustomerAction_getUnLinkedCustomer")
	public String getUnLinkedCustomer(){
		List<Customer> list = cs.getUnLinkedCustomer();
		list2Client(list);
		return null;
	}
	
	private List<Integer> customerIds;
	
	@Action(value="CustomerAction_linkCustomers",results={@Result(name="success",type="redirect",location="/pages/base/fixed_area.html")})
	public String getLinkCustomers(){
		if(customerIds !=null){
			
			for (Integer id : customerIds) {
				System.out.println(id);
			}
		}
		cs.linkFixedAreaAndCustomer(model.getFixedAreaId(), customerIds);
		return "success";
	}
	
	@Action("CustomerAction_findAll")
	public String findAll(){
		
		List<Customer>list =  cs.findAll();
		
		list2Client(list);
		
		return null;
	}
	
	
	public List<Integer> getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(List<Integer> customerIds) {
		this.customerIds = customerIds;
	}
	
}
