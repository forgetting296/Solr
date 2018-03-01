package cn.itcast.bos.web.action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.engine.spi.CascadingActions.BaseCascadingAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bos.domain.Area;
import cn.itcast.bos.domain.Courier;
import cn.itcast.bos.domain.FixedArea;
import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.AreaService;
import cn.itcast.bos.service.CourierService;
import cn.itcast.bos.service.FixedAreaService;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.utils.PinYin4jUtils;
import cn.itcast.bos.utils.action.BaseAction;
import net.sf.json.processors.JsonBeanProcessor;


public class FixedAreaAction extends BaseAction<FixedArea>{

	@Autowired
	private FixedAreaService fixedAreaService;
	
	@Action(value="FixedAreaAction_add",results={@Result(name="saveSuccess",type="redirect",location="/pages/base/fixed_area.html")})
	public String add(){
		
		fixedAreaService.save(model);
		
		return "saveSuccess";
	}
	
	@Action("FixedAreaAction_pageList")
	public String pageList(){
		
		Page<FixedArea>pageBean = fixedAreaService.findByPage(page,rows);
		page2Client(pageBean,"subareas","couriers");
		
		return null;
	}
	
	private Integer courierId;
	private Integer takeTimeId;
	
	@Action(value="FixedAreaAction_linkCourier",results={@Result(name="success",type="redirect",location="/pages/base/fixed_area.html")})
	
	public String linkCourier(){
		
		fixedAreaService.linkCourier(model.getId(),courierId,takeTimeId);
		
		return "success";
	}

	public Integer getCourierId() {
		return courierId;
	}

	public void setCourierId(Integer courierId) {
		this.courierId = courierId;
	}

	public Integer getTakeTimeId() {
		return takeTimeId;
	}

	public void setTakeTimeId(Integer takeTimeId) {
		this.takeTimeId = takeTimeId;
	}
	
}
