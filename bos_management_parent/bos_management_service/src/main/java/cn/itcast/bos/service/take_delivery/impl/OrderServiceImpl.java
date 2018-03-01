package cn.itcast.bos.service.take_delivery.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.AreaDao;
import cn.itcast.bos.dao.FixedAreaDao;
import cn.itcast.bos.dao.OrderDao;
import cn.itcast.bos.dao.WorkBillDao;
import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.FixedArea;
import cn.itcast.bos.domain.SubArea;
import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.domain.take_delivery.WorkBill;
import cn.itcast.bos.service.take_delivery.OrderService;
import cn.itcast.crm.service.Customer;
import cn.itcast.crm.service.CustomerServiceImpl;

@Service("orderService")
@Transactional
@WebService
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDao od;
	@Autowired
	private AreaDao ad;
	@Autowired
	private CustomerServiceImpl cs;
	@Autowired
	private FixedAreaDao fad;
	@Autowired
	private WorkBillDao wbd;
	//保存订单add(Order o)根据区域信息 查询出分区  
	@Override
	public void save(Order o) {
		o.setOrderType("自动分单");
		//根据省市区信息查出区域信息
		Area sendArea = ad.findByProvinceAndCityAndDistrict(o.getSendArea().getProvince(),o.getSendArea().getCity(),o.getSendArea().getDistrict());
		Area recArea = ad.findByProvinceAndCityAndDistrict(o.getRecArea().getProvince(),o.getRecArea().getCity(),o.getRecArea().getDistrict());
		//
		o.setRecArea(recArea);
		o.setSendArea(sendArea);
		od.save(o);
		//自动生成工单
		//自动生成工单有两种方式
		//1、客户=》快递员=》分区=》工单    
		Customer customer = cs.findByAddress(o.getSendAddress());
		if(customer!=null){
			FixedArea fixedArea = fad.findOne(customer.getFixedAreaId());
			//获取快递员
			autoCreateWorkBill(o, fixedArea);
		}else{
			//2、区域=》分区=》定区=》快递员
			//根据寄件地址查询分区
			Set<SubArea> subareas = sendArea.getSubareas();
			SubArea sa = null;
			for (SubArea subArea : subareas) {
				if(o.getSendAddress().contains(subArea.getKeyWords())||o.getSendAddress().contains(subArea.getAssistKeyWords())){
					//如果寄件人地址包含关键字  就自动对应
					sa=subArea;
					break;
				}
			}
			if(sa!=null){
				FixedArea fixedArea = sa.getFixedArea();
				autoCreateWorkBill(o, fixedArea);
			}else{
				//实在不行就人工分单
				o.setOrderType("人工分单");
			}
		}
	}
	
	//自动生成工单
	private void autoCreateWorkBill(Order o, FixedArea fixedArea) {
		Set<Courier> couriers = fixedArea.getCouriers();
		Courier courier = couriers.iterator().next();
		WorkBill wb = new WorkBill();
		wb.setOrder(o);
		wb.setType("新单");
		wb.setBuildtime(new Date());
		wb.setRemark("贵重物品，轻拿轻放");
		wb.setCourier(courier);
		wb.setPickstate("新单");
		wb.setAttachbilltimes(0);
		//保存工单
		wbd.save(wb);
	}

	@Override
	public List<Order> findAll(Integer page, Integer rows) {
		
		return od.findAll(new PageRequest(page-1, rows)).getContent();
	}

	/*@Override
	public Page<Order> findAll(int i, int maxValue) {
		
		return od.findAll(new PageRequest(i-1, maxValue));
	}*/

}
