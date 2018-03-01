package cn.itcast.bos.web.system.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import cn.itcast.bos.domain.system.Menu;
import cn.itcast.bos.domain.system.Permission;
import cn.itcast.bos.domain.system.Role;
import cn.itcast.bos.domain.take_delivery.Order;
import cn.itcast.bos.service.system.MenuService;
import cn.itcast.bos.service.system.RoleService;
import cn.itcast.bos.utils.action.BaseAction;

@Results({@Result(name="toList",type="redirect",location="/pages/system/role.html")})
public class RoleAction extends BaseAction<Role>{
	
	@Autowired
	private RoleService rs;
	
	@Action("RoleAction_list")
	public String findToList() throws IOException{
		
		List<Role>list = rs.findAll();
		list2Client(list, "users","permissions","menus");
		return null;
	}
	
	@Action("RoleAction_findByPage")
	public String findByPage(){
		
		Page<Role> pageBean = rs.findByPage(page,rows);
		page2Client(pageBean, "users","permissions","menus");
		
		return null;
	}
	
	private List<Integer>permissionIds;
	private String menuIds;
	
	@Action("MenuAction_add")
	public String add(){
		//获得拼接的字符串  将其转为Integer类型的集合
		List<Integer> menuIdsInteger = new ArrayList<Integer>();
		String[] idsString = menuIds.split(",");
		for (String s : idsString) {
			menuIdsInteger.add(Integer.parseInt(s));
		}
		//调用service执行保存操作
		rs.save(model,permissionIds,menuIdsInteger);
		return "toList";  
	}
	
	@Action("RoleAction_findById")
	public String findById() throws Exception{
		//System.out.println(Integer.valueOf(id));
		//Role role= rs.findById(model.getId());
		//System.out.println(role.toString());
		List<Permission> list = rs.findByRId(model.getId());
		//SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		
		list2Client(list, "roles");
		//String json = JSON.toJSONString(role);
		
		//ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		//ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	@Action("roleAction_findMenuByRoleId")
	public String findMenuByRoleId(){
		
		List<Menu>list = rs.findMenuByRoleId(model.getId());
		
		list2Client(list,"roles","parentMenu","childrenMenus","children");
		return null;
	}
	
	@Action("RoleAction_getCurrentRole")
	public String getCurrentRole() throws Exception{
		
		//List<Role>list = rs.getCurrentRole(model.getId());
		Role role= rs.findById(model.getId());
				//System.out.println(role.toString());
		//list2Client(list, "users","permissions","menus");
		String json = JSON.toJSONString(role);
		
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}
	
	public List<Integer> getPermissionIds() {
		return permissionIds;
	}
	public void setPermissionIds(List<Integer> permissionIds) {
		this.permissionIds = permissionIds;
	}
	public String getMenuIds() {
		return menuIds;
	}
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
	
	
}
