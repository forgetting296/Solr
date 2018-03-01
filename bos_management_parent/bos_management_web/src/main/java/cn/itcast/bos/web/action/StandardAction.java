package cn.itcast.bos.web.action;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.bos.domain.Standard;
import cn.itcast.bos.service.StandardService;
import cn.itcast.bos.utils.action.BaseAction;
import net.sf.json.processors.JsonBeanProcessor;

public class StandardAction extends BaseAction<Standard>{

	@Autowired
	private StandardService standardService;
	
	@Action(value="StandardAction_add",results={@Result(name="saveSuccess",type="redirect",location="/pages/base/standard.html")})
	public String add(){
		standardService.save(model);
		return "saveSuccess";
	}
	
	@Action(value="StandardAction_pageList")
	public String pageList() throws IOException{
		
		Page<Standard> pageBean = standardService.findByPage(page,rows);
		page2Client(pageBean);
		//将pageBean的rows和total存到map集合中
		/*Map map = new HashMap();
		
		map.put("rows", pageBean.getContent());
		map.put("total", pageBean.getTotalElements());
		
		String json = JSON.toJSONString(map);
		//设置格式和编码
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);*/
		return null;
	}
	
	
	@Action(value="StandardAction_findAll")
	public String findAll() throws IOException{
		Page<Standard> pageBean = standardService.findByPage(1,Integer.MAX_VALUE);
		list2Client(pageBean.getContent());
		/*Page<Standard> pageBean = standardService.findByPage(1,Integer.MAX_VALUE);
		//将pageBean的rows和total存到map集合中
		String json = JSON.toJSONString(pageBean.getContent());
		//设置格式和编码
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);*/
		return null;
	}
	
}
