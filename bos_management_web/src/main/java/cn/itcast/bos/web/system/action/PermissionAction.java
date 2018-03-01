package cn.itcast.bos.web.system.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.bos.domain.system.Permission;
import cn.itcast.bos.service.system.PermissionService;
import cn.itcast.bos.utils.action.BaseAction;

public class PermissionAction extends BaseAction<Permission>{
	
	@Autowired
	private PermissionService ps;
	
	@Action("permissionAction_list")
	public String list(){
		
		List<Permission>list = ps.findAll();
		list2Client(list, "roles");
		return null;
	}
	@Action("PermissionAction_list")
	public String list2(){
		
		List<Permission>list = ps.findAll();
		list2Client(list);
		return null;
	}
	@Action(value="permissionAction_add",results={@Result(name="success",type="redirect",location="/pages/system/permission.html")})
	public String add(){
		
		ps.save(model);
		
		return "success";
	}
	
}
