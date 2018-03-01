package cn.itcast.bos.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;


import cn.itcast.bos.service.take_delivery.impl.Area;
import cn.itcast.bos.service.take_delivery.impl.Order;
import cn.itcast.bos.service.take_delivery.impl.OrderServiceImpl;
import cn.itcast.bos.utils.action.BaseAction;

@Results({@Result(name="addSuccess",type="redirect",location="/index.html")})
public class OrderAction extends BaseAction<Order>{
	
	@Autowired
	private OrderServiceImpl os;
	
	//收件人省市信息
	private String recAreaStr;
	//寄件人省市信息
	private String sendAreaStr;
	
	@Action("OrderAction_add")
	public String add(){
		//System.out.println(sendAreaStr);北京市/北京市/朝阳区
		//System.out.println(recAreaStr);河北省/承德市/平泉县
		String[] sendAreas = sendAreaStr.split("/");
		Area sendArea = new Area();
		sendArea.setCity(sendAreas[0]);
		sendArea.setProvince(sendAreas[1]);
		sendArea.setDistrict(sendAreas[2]);
		model.setSendArea(sendArea);
		
		String[] recAreas = recAreaStr.split("/");
		Area recArea = new Area();
		recArea.setCity(recAreas[0]);
		recArea.setProvince(recAreas[1]);
		recArea.setDistrict(recAreas[2]);
		model.setRecArea(recArea);
		
		//获取当前登录用户
		/*Customer customer = (Customer) ActionContext.getContext().getSession().get("loginCustomer");
		if(customer!=null){
			
			model.setCustomer_id(customer.getId());
			os.save(model);
		}*/
		os.save(model);
		return "addSuccess";
	}

	public String getRecAreaStr() {
		return recAreaStr;
	}
	public void setRecAreaStr(String recAreaStr) {
		this.recAreaStr = recAreaStr;
	}
	public String getSendAreaStr() {
		return sendAreaStr;
	}
	public void setSendAreaStr(String sendAreaStr) {
		this.sendAreaStr = sendAreaStr;
	}
}
